package com.devbeans.io.chat.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.R
import com.devbeans.io.chat.adapters.MediaDetailsAdapter
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.ActivityMediaDetailsBinding
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.fragments.DocsFragment
import com.devbeans.io.chat.fragments.LinksFragment
import com.devbeans.io.chat.fragments.MediaFragment
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.repositories.RepositoryMedia
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.WindowUtil
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator
import java.io.File
import java.util.*

//************************************************************
class MediaDetailsActivity :
    BaseActivity(), OnMediaSelectCallback, ExpiryCallback
//************************************************************
{
    var mBinding: ActivityMediaDetailsBinding? = null
    private var mAdapter: MediaDetailsAdapter? = null
    private var mConversation: Conversation? = null
    private var mCreateDialog: AlertDialog? = null
    private var count: Int = 0
    private var touchableList: ArrayList<View>? = ArrayList()
    private var mediaList = mutableListOf<Payload>()
    private var selectionMode = false


    // tab titles
    private val titles = arrayOf(
        AndroidUtil.getString(R.string.media),
        AndroidUtil.getString(R.string.docs),
        AndroidUtil.getString(R.string.links)
    )

    //************************************************************
    override fun onCreate(savedInstanceState: Bundle?)
    //************************************************************
    {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_media_details)
        setToolBar(mBinding!!.toolbar)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.deep_black))
        mBinding?.apply {

            touchableList = tabLayout.touchables
        }
        getRoomData
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        initializeMedia()

    }

    private fun initializeMedia() {
        mediaList.clear()
        observers()
        setupViewPager(mBinding!!.viewpager)
        initViews()
        listeners()
    }

    private fun listeners() {
        mBinding?.apply {
            ivDelete.setOnClickListener {
                showCustomDialog(0)
            }
            ivShare.setOnClickListener {
                if (mediaList.size == 1 && !Utills.isSubscriptionExpired())
                    shareSingleMediaPayload(mediaList[0]);
            }
        }
    }

    /**
     * This function is used to share a single media payload. It first determines the type of the media.
     * Then, it checks if the corresponding file exists. If it does, an intent is created to share the media.
     * @param payload: The media payload to be shared
     */
    private fun shareSingleMediaPayload(payload: Payload) {

        // Extract media type from payload
        val mediaType = getMediaType(payload.type)

        // Check if filePath is not null and file exists
        payload.filePath?.let { filePath ->
            val file = File(filePath)
            if (file.exists()) {
                // Create a shareable Uri
                val shareableUri = FileProvider.getUriForFile(
                    this, BuildConfig.APPLICATION_ID + ".provider",
                    file
                )

                // Create and start share intent
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_STREAM, shareableUri)
                    type = "$mediaType/*"
                }
                startActivity(Intent.createChooser(shareIntent, null))
            } else {
                Log.e(TAG, "File does not exist")
            }
        } ?: Log.e(TAG, "Filepath is null")
    }

    /**
     * This function determines the media type of a payload.
     * If the payload type is not one of the known types (image, video, audio, file),
     * it defaults to "file".
     * @param type: The type of the payload
     * @return The determined media type
     */
    private fun getMediaType(type: String?): String {
        return when {
            type.equals("image", ignoreCase = true) -> "image"
            type.equals("video", ignoreCase = true) -> "video"
            type.equals("audio", ignoreCase = true) -> "audio"
            type.equals("file", ignoreCase = true) -> "file"
            else -> {
                Log.e(TAG, "Unknown media type, defaulting to 'file'")
                "file"
            }
        }
    }


    override fun onBackPressed() {
        if (selectionMode) {
            selectionMode = false
            initializeMedia()
        } else {
            super.onBackPressed()
        }
    }

    //************************************************************
    private fun showCustomDialog(i: Int)
    //************************************************************
    {
        val alertCustomdialog =
            LayoutInflater.from(this).inflate(R.layout.custom_block_dailog, null)
        //initialize alert builder
        val dialogBinding = CustomBlockDailogBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(this)
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(dialogBinding.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        when (i) {
            0 -> {
                dialogBinding.tvTitle.text =
                    if (this@MediaDetailsActivity.count == 0) AndroidUtil.getString(R.string.delete_message) else String.format(
                        Locale.getDefault(),
                        "%s %d %s",
                        AndroidUtil.getString(R.string.delete),
                        this@MediaDetailsActivity.count + 1,
                        AndroidUtil.getString(R.string.messages)
                    )

                dialogBinding.tvDeleteNotification.text =
                    if (this@MediaDetailsActivity.count == 0)
                        AndroidUtil.getString(R.string.message_delete_note) else AndroidUtil.getString(
                        R.string.delete_messages_note
                    )

                dialogBinding.btnBlock.text = AndroidUtil.getString(R.string.delete_for_me)
            }
        }
        mCreateDialog!!.show()
        dialogBinding.btnBlock.setOnClickListener {
            when (i) {
                0 -> {
                    deleteSelectedMedia()
                    mCreateDialog!!.dismiss()
                    RepositoryMedia.getInstance().getLiveProgress().value = true
                }
            }
        }
        dialogBinding.btnCancel.setOnClickListener { mCreateDialog!!.dismiss() }
    }

    /**
     * This function is used to delete the selected media messages from a conversation.
     * It deletes both the message record from the database and the associated media file if it exists.
     */
    private fun deleteSelectedMedia() {


        // Iterate through all media payloads
        for (payload: Payload in mediaList) {
            // messageId is required for deletion, if it's null, skip to the next payload
            val messageId = payload.messageId ?: continue



            if (!payload.type.equals("text", ignoreCase = true) && payload.filePath != null) {
                val file = File(payload.filePath!!)
                // If the file exists, delete it from the file path
                if (file.exists()) {
                    file.delete()
                    messagesDao.deleteByMessageId(messageId)
                }

            } else if (payload.type.equals("text", ignoreCase = true)) {
                messagesDao.deleteByMessageId(messageId)
            }

            // Check if the deleted message was the last message of the conversation and handle accordingly
            deleteLastMessageIfMatches(messageId)

            //delete the message from chat Activity
            deleteMessageChatActivity(messageId)
        }

        selectionMode = false
        initViews()
    }

    private fun deleteMessageChatActivity(messageId: String) {
        // Get instance of ChatActivity
        val chatActivity = ChatActivity.getInstance() ?: return
        // Delete the message from the chat
        chatActivity.deleteById(messageId)
    }

    /**
     * If the last message of the conversation matches with the provided messageId,
     * it updates the conversation to not have a last message.
     * @param messageId: The messageId to compare with the last message of the conversation
     */
    private fun deleteLastMessageIfMatches(messageId: String) {
        try {
            val conversation = mConversation ?: return

            if (conversation.lastMessage?.messageId.equals(messageId, ignoreCase = true)) {
                conversation.lastMessage = null
                conversationsDao.update(conversation)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun observers() {

        // was essential to over ride

    }

    //************************************************************
    private val getRoomData: Unit
        get() {
            if (intent.extras != null) {
                if (intent.hasExtra(Constants.KEYS.INTENT_CONVERSATION)) {
                    mConversation =
                        intent.getSerializableExtra(Constants.KEYS.INTENT_CONVERSATION) as Conversation
                }

            }

        }


    /**
     * Function to initialize the views used in this activity.
     * Sets up the tab layout with custom text views and defines behavior on tab selection.
     * If a conversation is present, updates the toolbar name accordingly.
     * Also manages the visibility of share and delete icons.
     */
    private fun initViews() {
        mBinding?.apply {
            val selectedColor = AndroidUtil.getColor(R.color.blue) // Place your selected tab color here
            val nonSelectedColor = AndroidUtil.getColor(R.color.gray_variant_40) // Place your non-selected tab color here
            val fontFile = "fonts/astronomus_regular.ttf" // Replace with your actual font file

            // Attaching TabLayoutMediator to synchronize TabLayout and ViewPager2
            TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                val textView = TextView(this@MediaDetailsActivity).apply {
                    text = titles[position]
                    gravity = Gravity.CENTER
                    typeface = Typeface.createFromAsset(this@MediaDetailsActivity.assets, fontFile)
                }
                tab.customView = textView
            }.attach()

            // Updating toolbar name if conversation is not null
            mConversation?.let {
                toolbarName.text = it.name
            }

            // Setting visibility for share and delete icons
            ivShare.visibility = GONE
            ivDelete.visibility = GONE

            // Registering callback for page change in ViewPager2
            viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    // Changing color of selected and non-selected tabs
                    for (i in 0 until tabLayout.tabCount) {
                        val color = if (i == position) selectedColor else nonSelectedColor
                        (tabLayout.getTabAt(i)?.customView as? TextView)?.setTextColor(color)
                    }
                }
            })

            // Enabling user touch input
            touchableList?.forEach { it.isEnabled = true }
            viewpager.isUserInputEnabled = true
        }
    }





    override fun onResume() {
        appContext!!.currentActivity = this
        appContext?.setNotifyExpiry(this)
        super.onResume()
    }

    //************************************************************
    private fun setToolBar(toolbar: Toolbar)
    //************************************************************
    {
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    //************************************************************
    private fun setupViewPager(viewPager2: ViewPager2)
    //************************************************************
    {
        mAdapter = MediaDetailsAdapter(supportFragmentManager, lifecycle)
        mAdapter!!.addFragment(MediaFragment.newInstance(mConversation!!, this))
        mAdapter!!.addFragment(DocsFragment.newInstance(mConversation!!, this))
        mAdapter!!.addFragment(LinksFragment.newInstance(mConversation!!, this))
        viewPager2.adapter = mAdapter
    }

    //****************************************************************
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    //****************************************************************
    {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    override fun addMedia(payload: Payload) {
        mediaList.add(payload)
        if (mediaList.any {
                it.type.equals("text", ignoreCase = true)
            })
            mBinding!!.ivShare.visibility = GONE
        Log.e(TAG, mediaList.toString())
    }

    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    override fun removeMedia(payload: Payload) {
        mediaList.removeAll {
            it.messageId.equals(payload.messageId, ignoreCase = true)
        }
        Log.e(TAG, mediaList.toString())
    }

    override fun addDoc(payload: Payload) {

        // was essential to over ride

    }

    override fun removeDoc(payload: Payload) {

        // was essential to over ride

    }

    override fun addLink(payload: Payload) {

        // was essential to over ride

    }

    override fun removeLink(payload: Payload) {

        // was essential to over ride

    }

    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    override fun stopPager(selection: Boolean) {

        // was essential to over ride

    }

    override fun getCount(count: Int) {
        mBinding?.apply {
            this@MediaDetailsActivity.count = count
            toolbarName.text = if (count < 0) mConversation!!.name else "${count + 1}"
            viewpager.isUserInputEnabled = count < 0

            ivShare.visibility =
                if (count == 0 && !Utills.isSubscriptionExpired()) VISIBLE else GONE

            ivDelete.visibility = if (count < 0) GONE else VISIBLE
        }
        touchableList!!.forEach { it.isEnabled = count < 0 }
        selectionMode = count >= 0


    }

    override fun notifyExpiry() {
        mBinding?.let {
            Utills.showSubscriptionBanner(mBinding?.tvSubs)
        }
    }

}