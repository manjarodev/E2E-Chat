package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.adapters.LinksAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.LinksCallback
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.FragmentLinksBinding
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.fragments.LinksFragment
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.logging.Log
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL


//************************************************************
class LinksFragment
    : Fragment(), LinksCallback
//************************************************************
{
    var mBinding: FragmentLinksBinding? = null
    private var mAdapter: LinksAdapter? = null
    private var mConversation: Conversation? = null
    private val TAG = Log.tag(LinksFragment::class.java)
    private var list: MutableList<Payload>? = null
    private var list2 = mutableListOf<Payload>()
    private var onMediaSelectCallback: OnMediaSelectCallback? = null

    /**
     * Observer for changes in the Room database.
     * Each time data changes, the observer filters out the payloads with data that isn't a URL,
     * updates the adapter with the new list of payloads, and sets the appropriate visibility for the text notification.
     */
    private val observer = Observer<MutableList<Payload>> { incomingPayloads ->
        incomingPayloads?.let { payloads ->
            // Filter out all Payloads where the data isn't a URL
            payloads.removeIf { !isURL(it.data!!) }

            // If list is null (first time) or the size of incomingPayloads has changed, then update the adapter and list
            if (list.isNullOrEmpty() || list?.size != payloads.size) {
                Log.e(TAG, "observerValues: ${payloads.size}")
                mAdapter?.submitMedia(payloads)
                list = payloads

                // Set the visibility of text notification based on whether the list is empty
                mBinding?.tvTextNotification?.visibility = if (payloads.isEmpty()) View.VISIBLE else View.GONE
            }
            // No else clause needed, if no changes then we don't need to do anything
        }
    }



    //************************************************************
    override fun onCreate(savedInstanceState: Bundle?)
    //************************************************************
    {
        super.onCreate(savedInstanceState)
    }

    //************************************************************
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    //************************************************************
    {
        // Inflate the layout for this fragment
        mBinding = FragmentLinksBinding.inflate(inflater, container, false)
        populateRecyclerView()
        mConversation = requireConversation()
        return mBinding!!.root
    }


    //************************************************************
    private fun populateRecyclerView()
    //************************************************************
    {
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvLinks.layoutManager = layoutManager
        mAdapter = LinksAdapter(this, onMediaSelectCallback)
        mBinding!!.rvLinks.adapter = mAdapter
    }

    private fun requireConversation(): Conversation = requireNotNull(
        requireArguments().getSerializable(
            ARG_CONVERSATION
        ) as Conversation
    )

    private fun setCallback(onMediaSelectCallback: OnMediaSelectCallback) {
        this@LinksFragment.onMediaSelectCallback = onMediaSelectCallback
    }

    override fun onResume() {
        super.onResume()
        if (mConversation != null) {
            val id = mConversation!!.conversationId
            MainApp.appContext?.messagesDao!!.getLinksData(id).observe(
                viewLifecycleOwner, observer
            )
        }

    }

    override fun onStop() {
        super.onStop()
        if (mConversation != null) {
            MainApp.appContext?.messagesDao!!.getLinksData(mConversation!!.conversationId)
                .removeObserver(observer)
        }
    }

    //************************************************************
    override fun onLinkClick(link: String)
    //************************************************************
    {

//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.parse("http://www.yourvideo.mp4"), "video/mp4");

//        Uri uri = Uri.parse(link); // missing 'http://' will cause crashed
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);

//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
//        intent.setComponent(new ComponentName("org.mozilla.firefox","org.mozilla.firefox.App"));
//        this.startActivity(intent);
    }

    /**
     * Validates if the given string is a URL.
     * If the string doesn't start with "http", it appends "https://" to the start.
     * It then tries to create a URL from the string and checks if it matches Android's WEB_URL pattern.
     *
     * @param text the string to validate as URL.
     * @return true if the string is a valid URL, false otherwise.
     */
    fun isURL(text: String): Boolean {
        val tempString = if (!text.startsWith("http")) "https://$text" else text
        return try {
            URL(tempString).toURI()
            Patterns.WEB_URL.matcher(tempString).matches()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            false
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            false
        }
    }



    companion object {
        private const val ARG_CONVERSATION = "arg.conversation"

        //************************************************************
        fun newInstance(): LinksFragment
        //************************************************************
        {
            return LinksFragment()
        }

        fun newInstance(uri: Conversation, onMediaSelectCallBack: OnMediaSelectCallback): Fragment {
            return LinksFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CONVERSATION, uri)
                }
                setCallback(onMediaSelectCallBack)
            }
        }
    }
}