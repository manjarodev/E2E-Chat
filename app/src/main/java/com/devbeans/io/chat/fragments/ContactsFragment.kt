package com.devbeans.io.chat.fragments


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ContactDetailActivity
import com.devbeans.io.chat.activities.QRScannerActivity
import com.devbeans.io.chat.adapters.ContactFragmentAdapter
import com.devbeans.io.chat.adapters.viewholders.ContactViewHolder
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ContactsCallback
import com.devbeans.io.chat.databinding.FragmentContactsBinding
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.User
import com.devbeans.io.chat.network.ApiHelper.Companion.with
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.RequestCodes
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.Utills.colors
import com.devbeans.io.chat.utils.Utills.rnd
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.viewmodels.ContactFragmentViewModel
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response
import java.util.*

//************************************************************
class ContactsFragment  //************************************************************
    : Fragment(), OnNetworkResponse,
    ContactsCallback //************************************************************
{
    private var addedByQr: Boolean = false
    private var mBinding: FragmentContactsBinding? = null
    private var mViewModel: ContactFragmentViewModel? = null
    private var mAdapter: ContactFragmentAdapter? = null
    var userIdEdit: TextInputEditText? = null
    var nameEdit: TextInputEditText? = null
    private val mCancel: AppCompatButton? = null
    private val mAddContact: AppCompatButton? = null
    private var mDialog: AlertDialog? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mViewModel = ViewModelProvider(requireActivity()).get(
            ContactFragmentViewModel::class.java
        )
    }

    //************************************************************
    override fun onCreate(savedInstanceState: Bundle?) //************************************************************
    {
        super.onCreate(savedInstanceState)
    }

    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? //************************************************************
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, container, false)
        populateRecyclerView()
        observers()
        initDialog()
        listeners()
        setSearchContacts()
        return mBinding?.getRoot()
    }

    //************************************************************
    private fun listeners() {
        mBinding!!.addContactLayout.setOnClickListener {
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            showLoadingDialog()
        }
    }



    /**
     * Initializes a custom dialog for adding a new contact.
     * The dialog contains input fields for the user id and name, and options to cancel,
     * add contact, and scan QR code.
     * It also includes error checks to prevent adding an empty or self user id.
     */
    private fun initDialog() {
        try {
            // Inflate custom dialog layout
            val alertCustomdialog = LayoutInflater.from(requireActivity()).inflate(R.layout.custom_dailog_new_contact, null)

            // Initialize alert dialog builder and set custom layout to it
            val alert = AlertDialog.Builder(requireActivity()).setView(alertCustomdialog)

            // Create alert dialog
            mDialog = alert.create()

            // Initialize UI elements
            val mCancel = alertCustomdialog.findViewById<AppCompatButton>(R.id.btn_cancel_one)
            val mAddContact = alertCustomdialog.findViewById<AppCompatButton>(R.id.btn_add_contact_one)
            userIdEdit = alertCustomdialog.findViewById(R.id.user_id_edit)
            nameEdit = alertCustomdialog.findViewById(R.id.nick_name_edit)
            val scanQr = alertCustomdialog.findViewById<ImageView>(R.id.layout_scan_qr_one)

            // Set up text change listener for user id input field
            userIdEdit?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                // Reset the QR code flag whenever the user id field is changed
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    addedByQr = false
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            // Set up click listener for 'Add Contact' button
            mAddContact.setOnClickListener {
                val userId = userIdEdit?.text.toString().trim()
                val name = nameEdit?.text.toString().trim()

                when {
                    userId.isEmpty() -> Notify.Toast("Please add user id")
                    userId.equals(AppSession.getUser().chatUserId, ignoreCase = true) -> Notify.Toast("Can not add Yourself")
                    name.isEmpty() -> Notify.Toast("Please add name to continue")
                    else -> verifyUser(userId)
                }
            }

            // Set up click listener for 'Cancel' button
            mCancel.setOnClickListener { mDialog?.dismiss() }

            // Set up click listener for 'Scan QR' button
            scanQr.setOnClickListener {
                startActivityForResult(
                    Intent(activity, QRScannerActivity::class.java),
                    RequestCodes.SCAN_QR
                )
            }
        } catch (e: Exception) {
            // Log the exception or show a user-friendly error message
            Log.e(TAG, "Failed to initialize dialog", e)
        }
    }



    protected fun showLoadingDialog() {

        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        if (!userIdEdit?.getText().isNullOrEmpty()) {
            userIdEdit!!.setText("")
        }

        if (!nameEdit?.getText().isNullOrEmpty()) {
            nameEdit!!.setText("")
        }
        //finally show the dialog box in android all
        mDialog!!.show()
    }

    //************************************************************
    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun observers() //************************************************************
    {
        MainApp.database!!.contactsDao()!!.liveContacts.observe(requireActivity()) { list: List<Contact> ->
            mAdapter!!.setContactList(
                list
            )
        }
    }


    private fun populateRecyclerView() {
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvContacts.layoutManager = layoutManager
        (mBinding!!.rvContacts.itemAnimator as SimpleItemAnimator?)!!.supportsChangeAnimations =
            false
        mAdapter = ContactFragmentAdapter(requireActivity(), this)
        mBinding!!.rvContacts.adapter = mAdapter
    }

    override fun onContactClick(contact: Contact, viewHolder: ContactViewHolder?, position: Int) {
        startActivity(
            Intent(
                requireActivity(), ContactDetailActivity::class.java
            ).putExtra("contact", contact)
        )


    }

    override fun onCheckBoxClick(
        contact: Contact,
        viewHolder: ContactViewHolder,
        position: Int,
        isFromGroupAdapter: Boolean,
        isChecked: Boolean
    ) {
        // not being used in this activity
    }


    private fun setSearchContacts() {
        mBinding!!.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // essential for over ride
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // essential for over ride
            }

            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = ArrayList<Contact>()
        if (MainApp.database!!.contactsDao()!!.allContacts != null && !MainApp.database!!.contactsDao()!!.allContacts.isEmpty()) {
            for (item in MainApp.database!!.contactsDao()!!.allContacts) {
                if (item.name!!.lowercase(Locale.getDefault())
                        .contains(text.lowercase(Locale.getDefault())) || item.chatUserId!!.lowercase(
                        Locale.getDefault()
                    ).contains(text.lowercase(Locale.getDefault()))
                ) {
                    filteredList.add(item)
                }
            }
            mAdapter!!.filteredList(filteredList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == RequestCodes.SCAN_QR && data!!.extras != null) {
            val userId = data.getStringExtra("userId")
            userIdEdit!!.setText(userId)
            addedByQr = true
        }

    }

    private fun verifyUser(userId: String) {
        Log.d(
            TAG,
            "Contacts Fragment verifyUser: " + Constants.END_POINT + RequestCodes.API_END_POINTS.VERIFY_USER + " Request: " + "chat_user_id=" + userId
        )
        with()?.verifyUser(userId, activity, this)

    }

    //************************************************************
    private fun profileData(userChatId: String) //************************************************************
    {
        Log.d(
            TAG,
            "getProfileData: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE + " Request: " + "chat_user_id= " + userChatId
        )
        with()?.profileData(AppSession.getUser().chatUserId, userChatId, this)

    }

    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.VERIFY_USER) {
            if (response.code() == 200) {
                val res = response.body() as BaseResponse?
                handleVerifyResponse(res)
            }
        } else if (tag == RequestCodes.API.GET_PROFILE && response.code() == 200) {

            val res = (response.body() as GetProfileResponse?)!!
            handleGetProfile(res)

        }
    }

    private fun handleGetProfile(res: GetProfileResponse?) {
        res?.let {
            res.user?.let {
                Log.d(
                    TAG,
                    "getprofile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE + " Response: " + res.toString()
                )
                var user: User? = User()
                user = res.user
                val contact = Contact()
                contact.chatUserId = userIdEdit!!.text.toString()
                contact.name = nameEdit!!.text.toString()
                contact.color = colors[rnd.nextInt(colors.size)]
                contact.avatarColor = AvatarColor.random()
                contact.isQrAdded = addedByQr

                user!!.chatNickName?.let {
                    if (!user.chatNickName!!.trim { it <= ' ' }.isEmpty()) {
                        contact.alias = user.chatNickName
                    }
                }

                handleAndAddInDb(user, contact)
                nameEdit!!.setText("")
                userIdEdit!!.setText("")
                mDialog!!.dismiss()
            }
        } ?: Notify.Toast("No data found")
    }

    private fun handleAndAddInDb(user: User, contact: Contact) {
        val contacts = MainApp.database!!.contactsDao()!!.allContacts as List<Contact>
        var hasContact = false
        var existedContact = Contact()

        if (!contacts.isNullOrEmpty()) {
            val contact1 = contacts.find { contact1 ->
                contact1.chatUserId.equals(
                    contact.chatUserId, ignoreCase = true
                )
            }
            contact1?.let {
                hasContact = true
                existedContact = contact1
            } ?: run { hasContact = false }

            if (hasContact) {
                existedContact.name = nameEdit!!.text.toString()
                user.chatNickName?.let {
                    if (!user.chatNickName!!.trim { it <= ' ' }.isEmpty()) {
                        existedContact.alias = user.chatNickName
                    }
                }
                MainApp.database!!.contactsDao()!!.insert(existedContact)
                Notify.Toast("Contact updated")
            } else {
                MainApp.database!!.contactsDao()!!.insert(contact)
                Notify.Toast("New contact added")
            }
        } else {
            MainApp.database!!.contactsDao()!!.insert(contact)
            Notify.Toast("New contact added")
        }
    }

    private fun handleVerifyResponse(res: BaseResponse?) {
        if (res != null) {
            Log.d(
                TAG,
                "Contacts Fragment verifyUser: " + Constants.END_POINT + RequestCodes.API_END_POINTS.VERIFY_USER + " Response: " + res.toString()
            )

            //Checking if the user is valid user of chat app
            if (res.status.equals("Success", ignoreCase = true) && res.isUser) {
                profileData(userIdEdit!!.text.toString())
            } else {
                nameEdit!!.setText("")
                userIdEdit!!.setText("")
                Notify.Toast("No user found")
            }
        } else Notify.Toast("No data found")
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        Notify.Toast(response.message)
    }

    companion object {
        val TAG = Log.tag(ContactsFragment::class.java)

        //************************************************************
        fun newInstance(): ContactsFragment //************************************************************
        {
            return ContactsFragment()
        }
    }
}