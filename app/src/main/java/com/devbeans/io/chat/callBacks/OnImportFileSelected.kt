package com.devbeans.io.chat.callBacks

import java.io.File

interface OnImportFileSelected {
    fun onFileSelected(file: File, position:Int)
}