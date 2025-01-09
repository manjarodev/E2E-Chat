package com.devbeans.io.chat.utils;

import androidx.annotation.StyleRes;

import com.devbeans.io.chat.R;

public class DynamicNoActionBarTheme extends DynamicTheme {

    protected @StyleRes
    int getTheme() {
        return R.style.Theme_Chat;
    }
}