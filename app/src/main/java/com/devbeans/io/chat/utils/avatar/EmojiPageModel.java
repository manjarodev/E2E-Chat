package com.devbeans.io.chat.utils.avatar;

import android.net.Uri;

import androidx.annotation.Nullable;

import com.devbeans.io.chat.models.Emoji;

import java.util.List;

public interface EmojiPageModel {
    String getKey();
    int getIconAttr();
    List<String> getEmoji();
    List<Emoji> getDisplayEmoji();
    @Nullable
    Uri getSpriteUri();
    boolean isDynamic();
}
