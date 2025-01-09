package com.devbeans.io.chat.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.lifecycle.ViewModelStoreOwner
import com.devbeans.io.chat.R
import com.devbeans.io.chat.models.ChatColor
import com.devbeans.io.chat.models.ChatWallpaper
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.viewmodels.ChatSettingsViewModel
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.*

class ChatSettingsViewModel : ViewModel() {
    private var mKeepChatOptions = AndroidUtil.getStringArray(R.array.keep_chat)
    private val threadId: BehaviorSubject<Long>
    private val chatColors = listOf(
        ChatColor(R.color.conversation_crimson),
        ChatColor(R.color.conversation_violet),
        ChatColor(R.color.conversation_teal),
        ChatColor(R.color.conversation_steel),
        ChatColor(R.color.conversation_vermillion),
        ChatColor(R.color.conversation_plumb),
        ChatColor(R.color.conversation_taupe),
    )

    private val wallpapers = listOf(
        ChatWallpaper(R.drawable.gradient_shades_of_grey),
        ChatWallpaper(R.drawable.gradient_sha_la_la),
        ChatWallpaper(R.drawable.gradient_green_beach),
        ChatWallpaper(R.drawable.gradient_pinky),
        ChatWallpaper(R.drawable.gradient_piglet),
        ChatWallpaper(R.drawable.gradient_blue)
    )
    val settingsLiveData = MutableLiveData<List<String>>()
    val chatColorsLiveData = MutableLiveData<List<ChatColor>>()
    val chatWallpaperLiveData = MutableLiveData<List<ChatWallpaper>>()

    init {
        threadId = BehaviorSubject.create()
//        chatColors = appContext?.resources?.getIntArray(R.array.chat_chat_colors)!!
        initSettingsData()
    }

    private fun initSettingsData() {
        val settingsList: List<String> = ArrayList(Arrays.asList(*mKeepChatOptions))
        setSettingsLiveData(settingsList)
        setChatColorsLiveData()
        setChatWallpapersLiveData()
    }

    private fun setChatWallpapersLiveData() {
        chatWallpaperLiveData.value = wallpapers
    }

    private fun setChatColorsLiveData() {
//        Log.e(
//            ChatSettingsViewModel::class.java.simpleName,
//            "Colors ${chatColors.contentToString()}"
//        )
        chatColorsLiveData.value = chatColors
    }

    private fun setSettingsLiveData(settingsList: List<String>) {
        settingsLiveData.value = settingsList
    }

    class Factory : NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.cast(ChatSettingsViewModel())
        }
    }

    companion object {
        private var instance: ChatSettingsViewModel? = null
        fun with(context: Context?): ChatSettingsViewModel? {
            if (instance == null) {
                instance = ViewModelProvider((context as ViewModelStoreOwner?)!!).get(
                    ChatSettingsViewModel::class.java
                )
            }
            return instance
        }
    }
}