package com.devbeans.io.chat.repositories

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

/**
 * Data Class Live Data
 */
class RepositoryMedia private constructor() {

    @SerializedName("currentProgress")
    private var currentProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun getLiveProgress(): MutableLiveData<Boolean> {
        return currentProgress
    }

    companion object {

        private val mInstance: RepositoryMedia =
            RepositoryMedia()

        @Synchronized
        fun getInstance(): RepositoryMedia {
            return mInstance
        }
    }
}