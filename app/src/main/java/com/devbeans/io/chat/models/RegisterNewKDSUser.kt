package com.devbeans.io.chat.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

 class RegisterNewKDSUser {
     @SerializedName("status")
     @Expose
     private var status: String? = null

     @SerializedName("user")
     @Expose
     private var user: User? = null

     @SerializedName("message")
     @Expose
     private var message: String? = null

     fun getMessage(): String? {
         return message
     }

     fun setMessage(message: String?) {
         this.message = message
     }
     fun getStatus(): String? {
         return status
     }

     fun setStatus(status: String?) {
         this.status = status
     }

     fun getUser(): User? {
         return user
     }

     fun setUser(user: User?) {
         this.user = user
     }


     class User {
         @SerializedName("deviceId")
         @Expose
         private var deviceId: String? = null

         @SerializedName("createdAt")
         @Expose
         private var createdAt: String? = null

         @SerializedName("name")
         @Expose
         private var name: String? = null

         @SerializedName("chatAppId")
         @Expose
         private var chatAppId: String? = null

         fun getDeviceId(): String? {
             return deviceId
         }

         fun setDeviceId(deviceId: String?) {
             this.deviceId = deviceId
         }

         fun getCreatedAt(): String? {
             return createdAt
         }

         fun setCreatedAt(createdAt: String?) {
             this.createdAt = createdAt
         }

         fun getName(): String? {
             return name
         }

         fun setName(name: String?) {
             this.name = name
         }

         fun getChatAppId(): String? {
             return chatAppId
         }

         fun setChatAppId(chatAppId: String?) {
             this.chatAppId = chatAppId
         }

     }
 }
