package com.devbeans.io.chat.callBacks

import com.devbeans.io.chat.fragments.DocsFragment
import com.devbeans.io.chat.fragments.LinksFragment
import com.devbeans.io.chat.fragments.MediaFragment
import com.devbeans.io.chat.models.Payload

/**
 * Callback methods which are to be used when longClick is initiated
 * in [MediaFragment] , [DocsFragment] , [LinksFragment]
 */
interface OnMediaSelectCallback {
    fun addMedia(payload: Payload)
    fun removeMedia(payload: Payload)
    fun addDoc(payload: Payload)
    fun removeDoc(payload: Payload)
    fun addLink(payload: Payload)
    fun removeLink(payload: Payload)
    fun stopPager(selection: Boolean)
    fun getCount(count:Int)
}