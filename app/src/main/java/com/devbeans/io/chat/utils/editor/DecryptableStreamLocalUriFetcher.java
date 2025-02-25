package com.devbeans.io.chat.utils.editor;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.devbeans.io.chat.utils.MediaUtil;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class DecryptableStreamLocalUriFetcher extends StreamLocalUriFetcher {

    private static final String TAG = Log.tag(DecryptableStreamLocalUriFetcher.class);

    private Context context;

    DecryptableStreamLocalUriFetcher(Context context, Uri uri) {
        super(context.getContentResolver(), uri);
        this.context = context;
    }

    @Override
    protected InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        if (MediaUtil.hasVideoThumbnail(context, uri)) {
            Bitmap thumbnail = MediaUtil.getVideoThumbnail(context, uri, 1000);

            if (thumbnail != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                ByteArrayInputStream thumbnailStream = new ByteArrayInputStream(baos.toByteArray());
                thumbnail.recycle();
                return thumbnailStream;
            }
        }

        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            throw new FileNotFoundException("PartAuthority couldn't load Uri resource.");
        }
    }
}
