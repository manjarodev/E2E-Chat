// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MediaPreviewExoplayerLayoutBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AspectRatioFrameLayout exoContentFrame;

  private MediaPreviewExoplayerLayoutBinding(@NonNull FrameLayout rootView,
      @NonNull AspectRatioFrameLayout exoContentFrame) {
    this.rootView = rootView;
    this.exoContentFrame = exoContentFrame;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MediaPreviewExoplayerLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MediaPreviewExoplayerLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.media_preview_exoplayer_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MediaPreviewExoplayerLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.exo_content_frame;
      AspectRatioFrameLayout exoContentFrame = ViewBindings.findChildViewById(rootView, id);
      if (exoContentFrame == null) {
        break missingId;
      }

      return new MediaPreviewExoplayerLayoutBinding((FrameLayout) rootView, exoContentFrame);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
