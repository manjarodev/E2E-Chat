package com.devbeans.io.chat.callBacks

interface OnDataPass {
    fun onDataPass(
        isDurationEdited: Boolean,
        totalDurationUs: Long,
        startTimeUs: Long,
        endTimeUs: Long,
        viewOnce:Boolean
    )
}