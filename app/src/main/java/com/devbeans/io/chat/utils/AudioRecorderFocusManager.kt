package com.devbeans.io.chat.utils

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import androidx.annotation.RequiresApi


abstract class AudioRecorderFocusManager(val context: Context) {
    protected val audioManager: AudioManager = ServiceUtil.getAudioManager(context)

    abstract fun requestAudioFocus(): Int
    abstract fun abandonAudioFocus(): Int

    companion object {
        @JvmStatic
        fun create(context: Context, changeListener: AudioManager.OnAudioFocusChangeListener): AudioRecorderFocusManager {
            return if (Build.VERSION.SDK_INT >= 26) {
                AudioRecorderFocusManager26(context, changeListener)
            } else {
                AudioRecorderFocusManagerLegacy(context, changeListener)
            }
        }
    }
}

@RequiresApi(26)
private class AudioRecorderFocusManager26(context: Context, changeListener: AudioManager.OnAudioFocusChangeListener) : AudioRecorderFocusManager(context) {
    val audioFocusRequest: AudioFocusRequest

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        audioFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE)
            .setAudioAttributes(audioAttributes)
            .setOnAudioFocusChangeListener(changeListener)
            .build()
    }

    override fun requestAudioFocus(): Int {
        return audioManager.requestAudioFocus(audioFocusRequest)
    }

    override fun abandonAudioFocus(): Int {
        return audioManager.abandonAudioFocusRequest(audioFocusRequest)
    }
}

private class AudioRecorderFocusManagerLegacy(context: Context, val changeListener: AudioManager.OnAudioFocusChangeListener) : AudioRecorderFocusManager(context) {
    override fun requestAudioFocus(): Int {
        return audioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE)
    }

    override fun abandonAudioFocus(): Int {
        return audioManager.abandonAudioFocus(changeListener)
    }
}
