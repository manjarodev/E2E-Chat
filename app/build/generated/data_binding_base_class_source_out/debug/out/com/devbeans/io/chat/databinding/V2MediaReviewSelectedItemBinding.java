// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class V2MediaReviewSelectedItemBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView mediaReviewPlayOverlay;

  @NonNull
  public final ShapeableImageView mediaReviewSelectedImage;

  @NonNull
  public final ImageView mediaReviewSelectedOverlay;

  private V2MediaReviewSelectedItemBinding(@NonNull FrameLayout rootView,
      @NonNull ImageView mediaReviewPlayOverlay,
      @NonNull ShapeableImageView mediaReviewSelectedImage,
      @NonNull ImageView mediaReviewSelectedOverlay) {
    this.rootView = rootView;
    this.mediaReviewPlayOverlay = mediaReviewPlayOverlay;
    this.mediaReviewSelectedImage = mediaReviewSelectedImage;
    this.mediaReviewSelectedOverlay = mediaReviewSelectedOverlay;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static V2MediaReviewSelectedItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static V2MediaReviewSelectedItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.v2_media_review_selected_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static V2MediaReviewSelectedItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.media_review_play_overlay;
      ImageView mediaReviewPlayOverlay = ViewBindings.findChildViewById(rootView, id);
      if (mediaReviewPlayOverlay == null) {
        break missingId;
      }

      id = R.id.media_review_selected_image;
      ShapeableImageView mediaReviewSelectedImage = ViewBindings.findChildViewById(rootView, id);
      if (mediaReviewSelectedImage == null) {
        break missingId;
      }

      id = R.id.media_review_selected_overlay;
      ImageView mediaReviewSelectedOverlay = ViewBindings.findChildViewById(rootView, id);
      if (mediaReviewSelectedOverlay == null) {
        break missingId;
      }

      return new V2MediaReviewSelectedItemBinding((FrameLayout) rootView, mediaReviewPlayOverlay,
          mediaReviewSelectedImage, mediaReviewSelectedOverlay);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
