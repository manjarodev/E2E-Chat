package com.devbeans.io.chat.utils.views

import android.view.View

var View.visible: Boolean
    get() {
        return this.visibility == View.VISIBLE
    }

    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
    }
