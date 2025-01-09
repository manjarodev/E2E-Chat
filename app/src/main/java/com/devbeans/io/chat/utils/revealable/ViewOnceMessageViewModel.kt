package com.devbeans.io.chat.utils.revealable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.ThreadUtil
import com.devbeans.io.chat.utils.logging.Log
import java.util.*

internal class ViewOnceMessageViewModel private constructor(
    val messageId: String,
    val repository: ViewOnceMessageRepository
) : ViewModel() {
    private val message: MutableLiveData<Optional<Payload>> = MutableLiveData()

    init {
        repository.getMessage(messageId,
            object :
                ViewOnceMessageRepository.Callback<Optional<Payload>> {
                override fun onComplete(result: Optional<Payload>) {
                    onMessageRetrieved(result)
                }
            })
    }

    fun getMessage(): LiveData<Optional<Payload>> {
        return message
    }

    override fun onCleared() {
    }

    private fun onMessageRetrieved(optionalMessage: Optional<Payload>) {
        ThreadUtil.runOnMain {
            val current = if (message.value != null) message.value!!.orElse(null) else null
            val proposed = optionalMessage.orElse(null)
            if (current != null && proposed != null && current.messageId == proposed.messageId) {
                Log.d(TAG, "Same ID -- skipping update")
            } else {
                message.setValue(optionalMessage)
            }
        }
    }

    fun sendOpenedAck() {

        EncryptionUtils.sendOpenedAck(
            repository.getMessageToSendAck(messageId),
            repository.getConversation()
        )


    }

    fun deleteMessageData() {
        repository.deleteMessageData(messageId)

    }

    internal class Factory(
        private val messageId: String,
        private val repository: ViewOnceMessageRepository
    ) : NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.cast(ViewOnceMessageViewModel(messageId, repository))!!
        }
    }

    companion object {
        private val TAG = Log.tag(
            ViewOnceMessageViewModel::class.java
        )
    }
}