package com.devbeans.io.chat.fragments

//import com.rajat.pdfviewer.PdfViewerActivity
//import com.rajat.pdfviewer.PdfViewerActivity.Companion.launchPdfFromUrl
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.activities.PdfViewerActivity
import com.devbeans.io.chat.adapters.DocumentAdapter
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.OnDocsCallback
import com.devbeans.io.chat.callBacks.OnMediaSelectCallback
import com.devbeans.io.chat.databinding.FragmentDocsBinding
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.Conversation
import com.devbeans.io.chat.models.MetaData
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import java.io.File

//************************************************************
class DocsFragment :
    Fragment(), OnDocsCallback
//************************************************************
{
    var mBinding: FragmentDocsBinding? = null
    private var mAdapter: DocumentAdapter? = null
    private var mConversation: Conversation? = null
    private val TAG = Log.tag(DocsFragment::class.java)
    private var list: MutableList<Payload>? = null
    private var onMediaSelectCallback: OnMediaSelectCallback? = null


    /**
     * Observer for monitoring the changes in the database. Whenever data changes, this updates the UI.
     * This observer is responsible for updating the UI in real time as the data changes in Room database.
     */
    private val observer = Observer<MutableList<Payload>> { incomingPayloads ->
        incomingPayloads?.let { payloads ->
            // Filter out all Payloads with null filePath
            payloads.removeIf { it.filePath == null }

            // If the list is null (first time) or size of incomingPayloads has changed, then update the adapter and the list
            if (list.isNullOrEmpty() || list?.size != payloads.size) {
                Log.e(TAG, "observerValues: ${payloads.size}")
                mAdapter?.submitMedia(payloads)
                list = payloads

                // Set notification visibility based on whether the list is empty
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
        mBinding = FragmentDocsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        populateRecyclerView()
        mConversation = requireConversation()
        return mBinding!!.root
    }

    override fun onResume() {
        super.onResume()

        if (mConversation != null) {
            val id = mConversation!!.conversationId
            MainApp.appContext?.messagesDao!!.getDocsData(id).observe(
                viewLifecycleOwner, observer
            )
        }
    }

    override fun onStop() {
        super.onStop()
        if (mConversation != null) {
            MainApp.appContext?.messagesDao!!.getDocsData(mConversation!!.conversationId)
                .removeObserver(observer)
        }
    }

    //************************************************************
    private fun populateRecyclerView()
    //************************************************************
    {
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvDocuments.layoutManager = layoutManager
        mAdapter = DocumentAdapter(this, onMediaSelectCallback)
        mBinding!!.rvDocuments.adapter = mAdapter
    }

    private fun requireConversation(): Conversation = requireNotNull(
        requireArguments().getSerializable(
            ARG_CONVERSATION
        ) as Conversation
    )

    private fun setCallback(onMediaSelectCallback: OnMediaSelectCallback) {
        this@DocsFragment.onMediaSelectCallback = onMediaSelectCallback
    }


    companion object {
        private const val ARG_CONVERSATION = "arg.conversation"

        fun newInstance(): DocsFragment
        {
            return DocsFragment()
        }

        fun newInstance(uri: Conversation, onMediaSelectCallback: OnMediaSelectCallback): Fragment {
            return DocsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CONVERSATION, uri)
                }
                setCallback(onMediaSelectCallback)
            }
        }
    }

    override fun onDocsCallback(payload: Payload?) {

        val separated = payload!!.data!!.split("@@".toRegex()).toTypedArray()
        val data = separated[0] // this will contain "Fruit"
        val gson = Gson()
        val metaData = gson.fromJson(separated[1], MetaData::class.java)
        val file = File(payload.filePath)
//        PdfViewerActivity.isPDFFromPath = true
//        Log.d("TAG",file.path)

        startActivity(
//
//            PdfViewerActivity.launchPdfFromUrl(           //PdfViewerActivity.Companion.launchPdfFromUrl(..   :: incase of JAVA
//                MainApp.appContext,
//                file.path,                                // PDF URL in String format
//                file.name,                        // PDF Name/Title in String format
//                "assets",                  // If nothing specific, Put "" it will save to Downloads
//                enableDownload = false
//            )

            Intent(
                requireContext(),
                PdfViewerActivity::class.java
            ).putExtra(Constants.KEYS.INTENT_PAYLOAD, payload)
                .putExtra(Constants.KEYS.INTENT_CONVERSATION, mConversation)
        )
    }
}