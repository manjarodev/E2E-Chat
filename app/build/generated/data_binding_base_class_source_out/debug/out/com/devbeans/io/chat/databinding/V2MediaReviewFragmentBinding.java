// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.utils.TouchInterceptingFrameLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class V2MediaReviewFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ConstraintLayout controls;

  @NonNull
  public final View controlsShade;

  @NonNull
  public final AppCompatImageView cropAndRotateTool;

  @NonNull
  public final AppCompatImageView drawTool;

  @NonNull
  public final ImageView editedImage;

  @NonNull
  public final ConstraintLayout layoutCon;

  @NonNull
  public final ViewPager2 mediaPager;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TouchInterceptingFrameLayout progressWrapper;

  @NonNull
  public final AppCompatImageView qualitySelector;

  @NonNull
  public final TextView recipient;

  @NonNull
  public final AppCompatImageView saveToMedia;

  @NonNull
  public final AppCompatImageView send;

  @NonNull
  public final AppCompatImageView viewLimitless;

  @NonNull
  public final AppCompatImageView viewOnce;

  @NonNull
  public final ViewSwitcher viewOnceToggle;

  private V2MediaReviewFragmentBinding(@NonNull FrameLayout rootView,
      @NonNull ConstraintLayout controls, @NonNull View controlsShade,
      @NonNull AppCompatImageView cropAndRotateTool, @NonNull AppCompatImageView drawTool,
      @NonNull ImageView editedImage, @NonNull ConstraintLayout layoutCon,
      @NonNull ViewPager2 mediaPager, @NonNull ProgressBar progress,
      @NonNull TouchInterceptingFrameLayout progressWrapper,
      @NonNull AppCompatImageView qualitySelector, @NonNull TextView recipient,
      @NonNull AppCompatImageView saveToMedia, @NonNull AppCompatImageView send,
      @NonNull AppCompatImageView viewLimitless, @NonNull AppCompatImageView viewOnce,
      @NonNull ViewSwitcher viewOnceToggle) {
    this.rootView = rootView;
    this.controls = controls;
    this.controlsShade = controlsShade;
    this.cropAndRotateTool = cropAndRotateTool;
    this.drawTool = drawTool;
    this.editedImage = editedImage;
    this.layoutCon = layoutCon;
    this.mediaPager = mediaPager;
    this.progress = progress;
    this.progressWrapper = progressWrapper;
    this.qualitySelector = qualitySelector;
    this.recipient = recipient;
    this.saveToMedia = saveToMedia;
    this.send = send;
    this.viewLimitless = viewLimitless;
    this.viewOnce = viewOnce;
    this.viewOnceToggle = viewOnceToggle;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static V2MediaReviewFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static V2MediaReviewFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.v2_media_review_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static V2MediaReviewFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.controls;
      ConstraintLayout controls = ViewBindings.findChildViewById(rootView, id);
      if (controls == null) {
        break missingId;
      }

      id = R.id.controls_shade;
      View controlsShade = ViewBindings.findChildViewById(rootView, id);
      if (controlsShade == null) {
        break missingId;
      }

      id = R.id.crop_and_rotate_tool;
      AppCompatImageView cropAndRotateTool = ViewBindings.findChildViewById(rootView, id);
      if (cropAndRotateTool == null) {
        break missingId;
      }

      id = R.id.draw_tool;
      AppCompatImageView drawTool = ViewBindings.findChildViewById(rootView, id);
      if (drawTool == null) {
        break missingId;
      }

      id = R.id.editedImage;
      ImageView editedImage = ViewBindings.findChildViewById(rootView, id);
      if (editedImage == null) {
        break missingId;
      }

      id = R.id.layout_con;
      ConstraintLayout layoutCon = ViewBindings.findChildViewById(rootView, id);
      if (layoutCon == null) {
        break missingId;
      }

      id = R.id.media_pager;
      ViewPager2 mediaPager = ViewBindings.findChildViewById(rootView, id);
      if (mediaPager == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = ViewBindings.findChildViewById(rootView, id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.progress_wrapper;
      TouchInterceptingFrameLayout progressWrapper = ViewBindings.findChildViewById(rootView, id);
      if (progressWrapper == null) {
        break missingId;
      }

      id = R.id.quality_selector;
      AppCompatImageView qualitySelector = ViewBindings.findChildViewById(rootView, id);
      if (qualitySelector == null) {
        break missingId;
      }

      id = R.id.recipient;
      TextView recipient = ViewBindings.findChildViewById(rootView, id);
      if (recipient == null) {
        break missingId;
      }

      id = R.id.save_to_media;
      AppCompatImageView saveToMedia = ViewBindings.findChildViewById(rootView, id);
      if (saveToMedia == null) {
        break missingId;
      }

      id = R.id.send;
      AppCompatImageView send = ViewBindings.findChildViewById(rootView, id);
      if (send == null) {
        break missingId;
      }

      id = R.id.view_limitless;
      AppCompatImageView viewLimitless = ViewBindings.findChildViewById(rootView, id);
      if (viewLimitless == null) {
        break missingId;
      }

      id = R.id.view_once;
      AppCompatImageView viewOnce = ViewBindings.findChildViewById(rootView, id);
      if (viewOnce == null) {
        break missingId;
      }

      id = R.id.view_once_toggle;
      ViewSwitcher viewOnceToggle = ViewBindings.findChildViewById(rootView, id);
      if (viewOnceToggle == null) {
        break missingId;
      }

      return new V2MediaReviewFragmentBinding((FrameLayout) rootView, controls, controlsShade,
          cropAndRotateTool, drawTool, editedImage, layoutCon, mediaPager, progress,
          progressWrapper, qualitySelector, recipient, saveToMedia, send, viewLimitless, viewOnce,
          viewOnceToggle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
