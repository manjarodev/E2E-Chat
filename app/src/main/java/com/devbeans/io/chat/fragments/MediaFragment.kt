package com.devbeans.io.chat.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devbeans.io.chat.activities.ScreenShowingActivity
import com.devbeans.io.chat.adapters.MediaAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnMediaClickCallBack
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.FragmentMediaBinding
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.repositories.RepositoryMedia
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log

//************************************************************
class MediaFragment
    : Fragment(),
    OnMediaClickCallBack
//************************************************************
{
    private val TAG = Log.tag(MediaFragment::class.java)
    private var mBinding: FragmentMediaBinding? = null
    private var mAdapter: MediaAdapter? = null
    private var mConversation: Conversation? = null
    private var onMediaSelectCallback: OnMediaSelectCallback? = null
    private var list: MutableList<Payload>? = null
    /**
     * Observer that monitors changes in the database. Whenever the data changes, it updates the UI accordingly.
     * This observer is used to update the UI in real time as data changes in the Room database.
     */
    private val observer = Observer<MutableList<Payload>> { incomingPayloads ->
        incomingPayloads?.let { payloads ->
            // Log the incoming payloads size
            if (list == null) Log.e(TAG, "observerValues: ${payloads.size}")

            // Filter out all the Payloads with null filePath or are confidential or viewOnce
            payloads.removeIf { it.filePath == null || it.isConfidential || it.isViewOnce }

            // If the size of the incomingPayloads has changed, then update the adapter and the list
            // or if the list is null (first time), update the adapter and the list
            if (list.isNullOrEmpty() || list?.size != payloads.size) {
                mAdapter?.submitMedia(payloads)
                list = payloads

                // Set the notification visibility based on whether the list is empty
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
        mBinding = FragmentMediaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
//        mViewModel = MediaViewModel.with(requireActivity())
        mConversation = requireConversation()
        populateRecyclerView()
        RepositoryMedia.getInstance().getLiveProgress()
            .observe(viewLifecycleOwner, Observer<Boolean> {

            })
        return mBinding!!.root
    }


    //************************************************************
    private fun populateRecyclerView()
    //************************************************************
    {
        val layoutManager: RecyclerView.LayoutManager =
            GridLayoutManager(requireActivity(), calculateNoOfColumns(requireContext(), 127f))
        mBinding!!.rvMedia.layoutManager = layoutManager
        mAdapter = MediaAdapter(this, requireActivity(), onMediaSelectCallback)
        mBinding!!.rvMedia.adapter = mAdapter
    }

    override fun onMediaClick(paylod: Payload) {
        startActivity(
            Intent(
                requireContext(),
                ScreenShowingActivity::class.java
            ).putExtra(Constants.KEYS.INTENT_PAYLOAD, paylod)
                .putExtra(Constants.KEYS.INTENT_CONVERSATION, mConversation)
        )
    }

    private fun setCallback(onMediaSelectCallback: OnMediaSelectCallback) {
        this@MediaFragment.onMediaSelectCallback = onMediaSelectCallback
    }

    override fun onResume() {

        super.onResume()


        if (mConversation != null) {
            val id = mConversation!!.conversationId
            MainApp.appContext?.messagesDao!!.getMediaData(id).observe(
                viewLifecycleOwner, observer
            )
        }


    }


    private fun requireConversation(): Conversation = requireNotNull(
        requireArguments().getSerializable(
            ARG_CONVERSATION
        ) as Conversation
    )

    override fun onStop() {
        if (mConversation != null) {
            MainApp.appContext?.messagesDao!!.getMediaData(mConversation!!.conversationId)
                .removeObserver(observer)
        }
        super.onStop()
    }

    companion object {

        private const val ARG_CONVERSATION = "arg.conversation"

        //************************************************************
        fun newInstance(): MediaFragment
        //************************************************************
        {
            return MediaFragment()
        }

        fun calculateNoOfColumns(
            context: Context,
            columnWidthDp: Float
        ): Int { // For example columnWidthdp=137
            val displayMetrics = context.resources.displayMetrics
            val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
            return (screenWidthDp / columnWidthDp + 0.5).toInt()
        }

        fun newInstance(uri: Conversation, onMediaSelectCallback: OnMediaSelectCallback): Fragment {
            return MediaFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CONVERSATION, uri)
                }
                setCallback(onMediaSelectCallback)
            }
        }
    }
}