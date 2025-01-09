package com.devbeans.io.chat.utils.events;

import android.net.Uri;

import androidx.annotation.NonNull;

public final class PartProgressEvent {

    public final Uri attachment;
    public final Type       type;
    public final long       total;
    public final long       progress;

    public enum Type {
        COMPRESSION,
        NETWORK
    }

    public PartProgressEvent(@NonNull Uri attachment, @NonNull Type type, long total, long progress) {
        this.attachment = attachment;
        this.type       = type;
        this.total      = total;
        this.progress   = progress;
    }
}
