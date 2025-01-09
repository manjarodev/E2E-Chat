package com.devbeans.io.chat.utils.views

import android.net.Uri
import com.devbeans.io.chat.utils.VideoPlayer
import com.google.gson.annotations.SerializedName

/**
 * Class to manage video playback in preview screen.
 */
class VideoControlsDelegate {

    private val playWhenReady: MutableMap<Uri, Boolean> = mutableMapOf()
    private var player: Player? = null

    fun getPlayerState(uri: Uri): PlayerState? {
        val player: Player? = this.player
        return if (player?.uri == uri && player.videoPlayer != null) {
            PlayerState(
                uri,
                player.videoPlayer.playbackPosition,
                player.videoPlayer.duration,
                player.isGif,
                player.loopCount
            )
        } else {
            null
        }
    }

    fun pause() = player?.videoPlayer?.pause()

    fun resume(uri: Uri) {
        if (player?.uri == uri) {
            player?.videoPlayer?.play()
        } else {
            playWhenReady[uri] = true
        }
    }

    fun restart() {
        player?.videoPlayer?.playbackPosition = 0L
    }

    fun onPlayerPositionDiscontinuity(reason: Int) {
        val player = this.player
        if (player != null && player.isGif) {
            this.player = player.copy(loopCount = if (reason == 0) player.loopCount + 1 else 0)
        }
    }

    fun attachPlayer(uri: Uri, videoPlayer: VideoPlayer?, isGif: Boolean) {
        player = Player(uri, videoPlayer, isGif)

        if (playWhenReady[uri] == true) {
            playWhenReady[uri] = false
            videoPlayer?.play()
        }
    }

    fun detachPlayer() {
        player = Player()
    }

    private data class Player(
        @SerializedName("uri")
        val uri: Uri = Uri.EMPTY,
        @SerializedName("videoPlayer")
        val videoPlayer: VideoPlayer? = null,
        @SerializedName("isGif")
        val isGif: Boolean = false,
        @SerializedName("loopCount")
        val loopCount: Int = 0
    )

    data class PlayerState(
        @SerializedName("mediaUri")
        val mediaUri: Uri,
        @SerializedName("position")
        val position: Long,
        @SerializedName("duration")
        val duration: Long,
        @SerializedName("isGif")
        val isGif: Boolean,
        @SerializedName("loopCount")
        val loopCount: Int
    )
}
