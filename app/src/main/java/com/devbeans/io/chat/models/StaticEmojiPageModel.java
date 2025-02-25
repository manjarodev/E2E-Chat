package com.devbeans.io.chat.models;


import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devbeans.io.chat.utils.EmojiCategory;
import com.devbeans.io.chat.utils.avatar.EmojiPageModel;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticEmojiPageModel implements EmojiPageModel {
    @SerializedName("category")
    private final @NonNull
    EmojiCategory category;

    @SerializedName("emoji")
    private final @NonNull
    List<Emoji> emoji;

    @SerializedName("sprite")
    private final @Nullable
    Uri sprite;

    public StaticEmojiPageModel(@NonNull EmojiCategory category, @NonNull String[] strings, @Nullable Uri sprite) {
        this(category, Arrays.stream(strings).map(s -> new Emoji(Collections.singletonList(s))).collect(Collectors.toList()), sprite);
    }

    public StaticEmojiPageModel(@NonNull EmojiCategory category, @NonNull List<Emoji> emoji, @Nullable Uri sprite) {
        this.category = category;
        this.emoji = Collections.unmodifiableList(emoji);
        this.sprite = sprite;
    }

    @Override
    public String getKey() {
        return category.getKey();
    }

    public int getIconAttr() {
        return category.getIcon();
    }

    @Override
    public @NonNull
    List<String> getEmoji() {
        List<String> emojis = new LinkedList<>();
        for (Emoji e : emoji) {
            emojis.addAll(e.getVariations());
        }
        return emojis;
    }

    @Override
    public @NonNull
    List<Emoji> getDisplayEmoji() {
        return emoji;
    }

    @Override
    public @Nullable
    Uri getSpriteUri() {
        return sprite;
    }

    @Override
    public boolean isDynamic() {
        return false;
    }
}
