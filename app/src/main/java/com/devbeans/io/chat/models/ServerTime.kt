package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




 class ServerTime{
     @SerializedName("code")
     @Expose
     private var code: Int? = null

     @SerializedName("time")
     @Expose
     private var time: Long? = null

     fun getCode(): Int? {
         return code
     }

     fun setCode(code: Int?) {
         this.code = code
     }

     fun getTime(): Long? {
         return time
     }

     fun setTime(time: Long?) {
         this.time = time
     }
}
