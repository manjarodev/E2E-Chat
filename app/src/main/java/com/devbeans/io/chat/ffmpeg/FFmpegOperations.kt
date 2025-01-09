package com.devbeans.io.chat.ffmpeg

import android.media.MediaMetadataRetriever
import android.net.Uri
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.PathUtil
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.metadata.ExifTool
import java.io.File

object FFmpegOperations {
    private val tag = FFmpegOperations::class.java.simpleName

    fun cutVideoWithCompress(
        inputPath: String,
        startTime: String,
        endTime: String,
        outputPath: String,
        uri: Uri,
        callback: FFmpegOperationsCallback
    ) {

        try {
            val outputPathCompress =
                File(
                    MainApp.appContext!!.filesDir.path + "/" + "OutputFileCompress" + "." + AndroidUtil.getMimeType(
                        MainApp.appContext,
                        uri
                    )
                )

            if (outputPathCompress.exists()) {
                outputPathCompress.delete()
            }

            val sourceFile = File(inputPath)

            val mediaPath: String = PathUtil.getMediaPath(sourceFile.name)

            val mediaType = PathUtil.getMediaType(sourceFile.name)

            //extract metadata
            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(inputPath)
            val bit = retriever.frameAtTime
            val width = bit!!.width
            val height = bit.height

            //compress video

            //compress video

            val videoQuery: Array<String> = if (height <= 1920 && width <= 1080) {
                FFmpegQueryExtension().compressor(
                    inputPath,
                    width,
                    height,
                    outputPathCompress.toString()
                )
            } else {
                FFmpegQueryExtension().compressor(
                    inputPath,
                    1080,
                    1920,
                    outputPathCompress.toString()
                )
            }

            compressFile(
                query = videoQuery,
                inputPath = outputPathCompress.toString(),
                outputPath = outputPath,
                mediaType = mediaType,
                startTime = startTime,
                endTime = endTime,
                callback = callback
            )
        } catch (e: Exception) {
            Log.e(tag, "Error ${e.printStackTrace()}")
        }
//        val compression = FFmpegQueryExtension().(inputPath, "")
//        CallBackOfQuery().callQuery(compression, object :com.devbeans.io.chat.ffmpeg.FFmpegCallBack{
//
//            override fun statisticsProcess(statistics: com.devbeans.io.chat.ffmpeg.Statistics) {
//                super.statisticsProcess(statistics)
//            }
//
//            override fun success() {
//                super.success()
//            }
//
//            override fun cancel() {
//                super.cancel()
//            }
//
//            override fun failed() {
//                super.failed()
//            }
//        })
    }

    private fun compressFile(
        query: Array<String>,
        inputPath: String,
        outputPath: String,
        startTime: String,
        endTime: String,
        mediaType: String,
        callback: FFmpegOperationsCallback
    ) {


        try {
            CallBackOfQuery().callQuery(query = query, object : FFmpegCallBack {

                override fun process(logMessage: LogMessage) {
                    super.process(logMessage)
                }

                override fun statisticsProcess(statistics: Statistics) {
                    super.statisticsProcess(statistics)
                }

                override fun success() {
                    Log.e(tag, "File Succeeded compress")
                    val cutVideoQuery = FFmpegQueryExtension().cutVideo(
                        inputPath,
                        startTime,
                        endTime,
                        outputPath
                    )
                    CallBackOfQuery().callQuery(cutVideoQuery, object : FFmpegCallBack {
                        override fun cancel() {
                            super.cancel()
                        }

                        override fun failed() {
                            super.failed()
                        }

                        override fun process(logMessage: LogMessage) {
                            super.process(logMessage)
                        }

                        override fun statisticsProcess(statistics: Statistics) {
                            super.statisticsProcess(statistics)
                        }

                        override fun success() {
                            Log.e(tag, "File Succeeded cut video")

                            if (metaDataRemoved(outputPath))
                                callback.onSuccessCompress()
                            super.success()

                        }
                    })
                    //                callback.onSuccessCompress()
                    super.success()
                }

                override fun cancel() {
                    super.cancel()
                }

                override fun failed() {
                    super.failed()
                }
            })
        } catch (e: Exception) {
            Log.e(tag, "Error ${e.printStackTrace()}")
        }

    }

    fun compressImage(
        inputPath: String,
        outputPath: String,
        callback: FFmpegOperationsCallback
    ) {

        try {//compress image
            val imageQuery = FFmpegQueryExtension().compressImage(inputPath, outputPath, tag = "")
            CallBackOfQuery().callQuery(query = imageQuery, object : FFmpegCallBack {

                override fun process(logMessage: LogMessage) {
                    super.process(logMessage)
                }

                override fun statisticsProcess(statistics: Statistics) {
                    super.statisticsProcess(statistics)
                }

                override fun success() {
                    Log.e(tag, "Image Succeeded compress")
                    if (metaDataRemoved(outputPath))
                        callback.onSuccessCompress()
                    super.success()
                }

                override fun cancel() {
                    super.cancel()
                }

                override fun failed() {
                    super.failed()
                }
            })
        } catch (e: Exception) {
            Log.e(tag, "Error ${e.printStackTrace()}")
        }

    }

    fun compressImageWithRotate(
        inputPath: String,
        outputPath: String,
        callback: FFmpegOperationsCallback
    ) {

        try {//compress image
            val imageQuery = FFmpegQueryExtension().compressImage(inputPath, outputPath)
            CallBackOfQuery().callQuery(query = imageQuery, object : FFmpegCallBack {

                override fun process(logMessage: LogMessage) {
                    super.process(logMessage)
                }

                override fun statisticsProcess(statistics: Statistics) {
                    super.statisticsProcess(statistics)
                }

                override fun success() {
                    Log.e(tag, "Image Succeeded compress")
                    if (metaDataRemoved(outputPath))
                        callback.onSuccessCompress()
                    super.success()
                }

                override fun cancel() {
                    super.cancel()
                }

                override fun failed() {
                    super.failed()
                }
            })
        } catch (e: Exception) {
            Log.e(tag, "Error ${e.printStackTrace()}")
        }

    }

    fun compressAudio(
        inputPath: String,
        outputPath: String,
        callback: FFmpegOperationsCallback
    ) {


        try {//compress audio
            val audioQuery = FFmpegQueryExtension().compressAudio(inputPath, "128", outputPath)
            CallBackOfQuery().callQuery(query = audioQuery, object : FFmpegCallBack {

                override fun process(logMessage: LogMessage) {
                    super.process(logMessage)
                }

                override fun statisticsProcess(statistics: Statistics) {
                    super.statisticsProcess(statistics)
                }

                override fun success() {
                    Log.e(tag, "Audio Succeeded compress")
                    if (metaDataRemoved(outputPath))
                        callback.onSuccessCompress()
                    super.success()
                }

                override fun cancel() {
                    super.cancel()
                }

                override fun failed() {
                    super.failed()
                }
            })
        } catch (e: Exception) {
            Log.e(tag, "Error ${e.printStackTrace()}")
        }
    }

    private fun metaDataRemoved(filePath: String): Boolean {
        return try {
            if (ExifTool.with().removeTags(filePath)) true else {
                Log.e(tag, "Exception in Exif")
                true
            }
//            true
        } catch (e: Exception) {
            Log.e(tag, "Exception in meta Data Removed ${e.printStackTrace()}")
            true
        }
    }


    interface FFmpegOperationsCallback {
        fun onSuccessCompress()
    }

}

