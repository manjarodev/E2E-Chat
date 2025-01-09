package com.devbeans.io.chat.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.PrivacyActivity
import com.devbeans.io.chat.adapters.BlockListAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.BlockListCallback
import com.devbeans.io.chat.databinding.BlockedContactFragmentBinding
import com.devbeans.io.chat.databinding.CustomBlockDailogBinding
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.User
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.RequestCodes
import com.devbeans.io.chat.utils.Utills
import retrofit2.Call
import retrofit2.Response
import java.text.ParseException
import java.util.*

class BlockedContactsFragment : Fragment(), BlockListCallback, OnNetworkResponse {
    var mBinding: BlockedContactFragmentBinding? = null
    private var mAdapter: BlockListAdapter? = null
    private var blockList: MutableList<Contact> = ArrayList()
    private var mCreateDialog: AlertDialog? = null
    private val UNBLOCK = "Unblock"

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = BlockedContactFragmentBinding.inflate(inflater, viewGroup, false)
        (activity as PrivacyActivity).supportActionBar?.title =
            AndroidUtil.getString(R.string.blocked_contacts)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBlockList()
        populateRecyclerView()
        setSearchBlockList()
    }


    private fun setBlockList() {
        blockList.clear()
        if (AppSession.getUser() != null && AppSession.getUser().blockUsers!!.isNotEmpty()) {
            AppSession.getUser().blockUsers?.forEach { blockedId ->
                var contact = MainApp.database!!.contactsDao()!!.getContact(blockedId)
                val isContact = contact != null
                if (isContact) {
                    blockList.add(contact)
                } else {
                    contact = Contact()
                    contact.chatUserId = blockedId
                    contact.name = blockedId
                    blockList.add(contact)
                }
            }
        }
    }


    private fun populateRecyclerView() {
        try {
            val layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            mBinding!!.rlBlocklist.layoutManager = layoutManager
            mAdapter = BlockListAdapter(requireContext(), this)
            mBinding!!.rlBlocklist.adapter = mAdapter
            if (blockList.size > 0) mAdapter?.setBlockList(blockList)
        } catch (e: Exception) {
//            Log.e(TAG, "populateRecyclerView: ", e)
        }
    }


    private fun setSearchBlockList() {
        mBinding!!.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = ArrayList<Contact>()
        if (blockList.size > 0) {
            blockList.forEach { item ->
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


    private fun showCustomDialog(i: Int, contact: Contact) {
        val alertCustomdialog =
            LayoutInflater.from(requireContext()).inflate(R.layout.custom_block_dailog, null)
        //initialize alert builder
        val dialogBinding: CustomBlockDailogBinding =
            CustomBlockDailogBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(requireContext())
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(dialogBinding.getRoot())
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog?.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        when (i) {
            2 -> {
                dialogBinding.tvTitle.setText(String.format("Unblock %s ?", contact.name))
                dialogBinding.tvDeleteNotification.setText(AndroidUtil.getString(R.string.unblock_alert))
                dialogBinding.btnBlock.setText(UNBLOCK)
            }
        }
        mCreateDialog?.show()
        dialogBinding.btnBlock.setOnClickListener { view ->
            when (i) {
                2 -> {
                    mCreateDialog?.dismiss()
                    unblock(contact)
                }
            }
        }
        dialogBinding.btnCancel.setOnClickListener { view -> mCreateDialog?.dismiss() }
    }

    private fun unblock(contact: Contact) {
        runOnUiThread {
            ApiHelper.with()?.unBlockUser(contact.chatUserId, this, requireActivity())
        }
//        Log.d(
//            TAG,
//            "BlockedContactActivity unblockUser: " + "End Point: " + RequestCodes.API_END_POINTS.UNBLOCK_USER +
//                    " Requset: " + "chatUserid= " + AppSession.getUser().chatUserId + " " + "block id=" + contact.chatUserId
//        )
    }

    override fun onBlockClick(contact: Contact) {
        if (Utills.isSubscriptionExpired()) {
            Utills.showSubscriptionEnd()
        } else {
            showCustomDialog(2, contact)
        }
    }


    @Throws(ParseException::class)
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.UNBLOCK_USER) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                if (res?.user != null) {
//                    Log.d(
//                        TAG,
//                        "BlockedContactActivity unBlock: " + "End Point: " + RequestCodes.API_END_POINTS.UNBLOCK_USER +
//                                " Response: " +
//                                res.toString()
//                    )
                    var mUser: User? = User()
                    mUser = res.user
                    AppSession.saveUser(mUser)
                    mBinding!!.searchBar.setText("")
                    mBinding!!.searchBar.clearFocus()
                    setBlockList()
                    populateRecyclerView()
                } else Notify.Toast("No data found")
            }
        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse?, tag: Any?) {}

}