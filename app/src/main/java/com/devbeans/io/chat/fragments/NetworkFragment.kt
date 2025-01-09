package com.devbeans.io.chat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.callBacks.NetworkCallback
import com.devbeans.io.chat.databinding.NetworkFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Loading
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.Utills

class NetworkFragment : Fragment() {
    lateinit var mBinding: NetworkFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        mBinding = NetworkFragmentBinding.inflate(inflater, viewGroup, false)


        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()


    }

    private fun listeners() {
        mBinding.apply {
            btnCancel.setOnClickListener {
                activity?.finish()
            }

            btnDeleteForEveryone.setOnClickListener {
                activity?.let {
                    val loader = Loading.make(activity)
                    loader.setMessage(AndroidUtil.getString(R.string.retrying))
                    loader.show()
                    Utills.checkKDSServerConnected(object : NetworkCallback {
                        override fun onResponse(network: Boolean) {
                            loader.cancel()
                            if (network) {
                                activity?.findNavController(R.id.fragment_container_settings)
                                    ?.navigateUp()
                            } else {
                                Notify.Toast(AndroidUtil.getString(R.string.network_connection_not_found_n_please_check_your_internet))
                            }
                        }
                    })
                }

            }

        }
    }
}