package com.devbeans.io.chat.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devbeans.io.chat.utils.views.HiddenEditText;

public class RemoveEmojiTextFilter implements HiddenEditText.TextFilter {
    private static final String EMOJI_REGEX = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";

    @Override
    public String filter(@NonNull String text) {
        return stripEmoji(text);
    }

    public static String stripEmoji(@Nullable String text) {
        if (text == null) {
            return text;
        }

        return text.replaceAll(EMOJI_REGEX, "");
    }


}
