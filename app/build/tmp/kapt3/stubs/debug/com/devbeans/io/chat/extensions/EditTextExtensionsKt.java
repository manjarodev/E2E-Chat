package com.devbeans.io.chat.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"INCOGNITO_KEYBOARD", "", "setIncognitoKeyboardEnabled", "", "Landroid/widget/EditText;", "isIncognitoKeyboardEnabled", "", "app_debug"})
public final class EditTextExtensionsKt {
    
    /**
     * Since this value is only supported on API26+ we hard-code it here
     * to avoid issues with older versions. This mirrors the approach
     * taken by [com.devbeans.io.chat].
     */
    private static final int INCOGNITO_KEYBOARD = 16777216;
    
    /**
     * Enables or disables incognito-mode for the keyboard. Note that this might not
     * be respected by all IMEs.
     */
    public static final void setIncognitoKeyboardEnabled(@org.jetbrains.annotations.NotNull
    android.widget.EditText $this$setIncognitoKeyboardEnabled, boolean isIncognitoKeyboardEnabled) {
    }
}