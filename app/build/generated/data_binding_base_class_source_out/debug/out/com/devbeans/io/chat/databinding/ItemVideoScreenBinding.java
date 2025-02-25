// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.utils.VideoPlayer;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemVideoScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout mediaPreviewPlaybackControlsContainer;

  @NonNull
  public final VideoPlayer videoPlayer;

  @NonNull
  public final VideoView vvScreen;

  private ItemVideoScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull FrameLayout mediaPreviewPlaybackControlsContainer, @NonNull VideoPlayer videoPlayer,
      @NonNull VideoView vvScreen) {
    this.rootView = rootView;
    this.mediaPreviewPlaybackControlsContainer = mediaPreviewPlaybackControlsContainer;
    this.videoPlayer = videoPlayer;
    this.vvScreen = vvScreen;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemVideoScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemVideoScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_video_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemVideoScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.media_preview_playback_controls_container;
      FrameLayout mediaPreviewPlaybackControlsContainer = ViewBindings.findChildViewById(rootView, id);
      if (mediaPreviewPlaybackControlsContainer == null) {
        break missingId;
      }

      id = R.id.video_player;
      VideoPlayer videoPlayer = ViewBindings.findChildViewById(rootView, id);
      if (videoPlayer == null) {
        break missingId;
      }

      id = R.id.vv_screen;
      VideoView vvScreen = ViewBindings.findChildViewById(rootView, id);
      if (vvScreen == null) {
        break missingId;
      }

      return new ItemVideoScreenBinding((ConstraintLayout) rootView,
          mediaPreviewPlaybackControlsContainer, videoPlayer, vvScreen);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
