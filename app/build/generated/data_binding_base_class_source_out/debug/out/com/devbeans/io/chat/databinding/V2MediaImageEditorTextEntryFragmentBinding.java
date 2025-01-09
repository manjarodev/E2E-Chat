// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.utils.views.InputAwareLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class V2MediaImageEditorTextEntryFragmentBinding implements ViewBinding {
  @NonNull
  private final InputAwareLayout rootView;

  @NonNull
  public final ImageView imageEditorHudColorIndicator;

  @NonNull
  public final AppCompatSeekBar imageEditorHudDrawColorBar;

  @NonNull
  public final ImageView imageEditorHudTextStyleButton;

  private V2MediaImageEditorTextEntryFragmentBinding(@NonNull InputAwareLayout rootView,
      @NonNull ImageView imageEditorHudColorIndicator,
      @NonNull AppCompatSeekBar imageEditorHudDrawColorBar,
      @NonNull ImageView imageEditorHudTextStyleButton) {
    this.rootView = rootView;
    this.imageEditorHudColorIndicator = imageEditorHudColorIndicator;
    this.imageEditorHudDrawColorBar = imageEditorHudDrawColorBar;
    this.imageEditorHudTextStyleButton = imageEditorHudTextStyleButton;
  }

  @Override
  @NonNull
  public InputAwareLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static V2MediaImageEditorTextEntryFragmentBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static V2MediaImageEditorTextEntryFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.v2_media_image_editor_text_entry_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static V2MediaImageEditorTextEntryFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_editor_hud_color_indicator;
      ImageView imageEditorHudColorIndicator = ViewBindings.findChildViewById(rootView, id);
      if (imageEditorHudColorIndicator == null) {
        break missingId;
      }

      id = R.id.image_editor_hud_draw_color_bar;
      AppCompatSeekBar imageEditorHudDrawColorBar = ViewBindings.findChildViewById(rootView, id);
      if (imageEditorHudDrawColorBar == null) {
        break missingId;
      }

      id = R.id.image_editor_hud_text_style_button;
      ImageView imageEditorHudTextStyleButton = ViewBindings.findChildViewById(rootView, id);
      if (imageEditorHudTextStyleButton == null) {
        break missingId;
      }

      return new V2MediaImageEditorTextEntryFragmentBinding((InputAwareLayout) rootView,
          imageEditorHudColorIndicator, imageEditorHudDrawColorBar, imageEditorHudTextStyleButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
