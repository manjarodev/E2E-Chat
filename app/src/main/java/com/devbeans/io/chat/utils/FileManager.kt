package com.devbeans.io.chat.utils

class FileManager {
//    public fun makeFileCopyInCacheDir(contentUri : Uri) : String? {
//        try {
//            val filePathColumn = arrayOf(
//                //Base File
//                MediaStore.Files.FileColumns._ID,
//                MediaStore.Files.FileColumns.TITLE,
//                MediaStore.Files.FileColumns.DATA,
//                MediaStore.Files.FileColumns.SIZE,
//                MediaStore.Files.FileColumns.DATE_ADDED,
//                MediaStore.Files.FileColumns.DISPLAY_NAME,
//                //Normal File
//                MediaStore.MediaColumns.DATA,
//                MediaStore.MediaColumns.MIME_TYPE,
//                MediaStore.MediaColumns.DISPLAY_NAME
//            )
//            //val contentUri = FileProvider.getUriForFile(context, "${BuildConfig.APPLICATION_ID}.provider", File(mediaUrl))
//            val returnCursor = contentUri.let { contentResolver.query(it, filePathColumn, null, null, null) }
//            if (returnCursor!=null) {
//                returnCursor.moveToFirst()
//                val nameIndex = returnCursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME)
//                val name = returnCursor.getString(nameIndex)
//                val file = File(cacheDir, name)
//                val inputStream = contentResolver.openInputStream(contentUri)
//                val outputStream = FileOutputStream(file)
//                var read = 0
//                val maxBufferSize = 1 * 1024 * 1024
//                val bytesAvailable = inputStream!!.available()
//
//                //int bufferSize = 1024;
//                val bufferSize = Math.min(bytesAvailable, maxBufferSize)
//                val buffers = ByteArray(bufferSize)
//                while (inputStream.read(buffers).also { read = it } != -1) {
//                    outputStream.write(buffers, 0, read)
//                }
//                inputStream.close()
//                outputStream.close()
//                Log.e("File Path", "Path " + file.path)
//                Log.e("File Size", "Size " + file.length())
//                return file.absolutePath
//            }
//        } catch (ex: Exception) {
//            Log.e("Exception", ex.message!!)
//        }
//        return contentUri.let { UriPathUtils().getRealPathFromURI(this, it).toString() }
//    }
}