// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemGroupSettingsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout lvGroupDisappearing;

  @NonNull
  public final LinearLayout lvGroupMain;

  @NonNull
  public final LinearLayout lvMediaRestrict;

  @NonNull
  public final LinearLayout lvTapToReveal;

  @NonNull
  public final TextView tvGroupDisappearing;

  @NonNull
  public final TextView tvGroupSettingTitle;

  @NonNull
  public final TextView tvMediaRestrict;

  @NonNull
  public final TextView tvTapToReveal;

  private ItemGroupSettingsBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout lvGroupDisappearing, @NonNull LinearLayout lvGroupMain,
      @NonNull LinearLayout lvMediaRestrict, @NonNull LinearLayout lvTapToReveal,
      @NonNull TextView tvGroupDisappearing, @NonNull TextView tvGroupSettingTitle,
      @NonNull TextView tvMediaRestrict, @NonNull TextView tvTapToReveal) {
    this.rootView = rootView;
    this.lvGroupDisappearing = lvGroupDisappearing;
    this.lvGroupMain = lvGroupMain;
    this.lvMediaRestrict = lvMediaRestrict;
    this.lvTapToReveal = lvTapToReveal;
    this.tvGroupDisappearing = tvGroupDisappearing;
    this.tvGroupSettingTitle = tvGroupSettingTitle;
    this.tvMediaRestrict = tvMediaRestrict;
    this.tvTapToReveal = tvTapToReveal;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemGroupSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemGroupSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_group_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemGroupSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lv_group_disappearing;
      LinearLayout lvGroupDisappearing = ViewBindings.findChildViewById(rootView, id);
      if (lvGroupDisappearing == null) {
        break missingId;
      }

      id = R.id.lv_group_main;
      LinearLayout lvGroupMain = ViewBindings.findChildViewById(rootView, id);
      if (lvGroupMain == null) {
        break missingId;
      }

      id = R.id.lv_media_restrict;
      LinearLayout lvMediaRestrict = ViewBindings.findChildViewById(rootView, id);
      if (lvMediaRestrict == null) {
        break missingId;
      }

      id = R.id.lv_tap_to_reveal;
      LinearLayout lvTapToReveal = ViewBindings.findChildViewById(rootView, id);
      if (lvTapToReveal == null) {
        break missingId;
      }

      id = R.id.tv_group_disappearing;
      TextView tvGroupDisappearing = ViewBindings.findChildViewById(rootView, id);
      if (tvGroupDisappearing == null) {
        break missingId;
      }

      id = R.id.tv_group_setting_title;
      TextView tvGroupSettingTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvGroupSettingTitle == null) {
        break missingId;
      }

      id = R.id.tv_media_restrict;
      TextView tvMediaRestrict = ViewBindings.findChildViewById(rootView, id);
      if (tvMediaRestrict == null) {
        break missingId;
      }

      id = R.id.tv_tap_to_reveal;
      TextView tvTapToReveal = ViewBindings.findChildViewById(rootView, id);
      if (tvTapToReveal == null) {
        break missingId;
      }

      return new ItemGroupSettingsBinding((LinearLayout) rootView, lvGroupDisappearing, lvGroupMain,
          lvMediaRestrict, lvTapToReveal, tvGroupDisappearing, tvGroupSettingTitle, tvMediaRestrict,
          tvTapToReveal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
