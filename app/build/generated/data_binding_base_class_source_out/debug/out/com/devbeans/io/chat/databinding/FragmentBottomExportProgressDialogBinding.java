// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBottomExportProgressDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final LinearLayout llProgress;

  @NonNull
  public final ProgressBar setupProgress;

  @NonNull
  public final ImageView top;

  @NonNull
  public final TextView tvExportNote;

  @NonNull
  public final TextView tvProgress;

  @NonNull
  public final TextView tvTitle;

  private FragmentBottomExportProgressDialogBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView ivImage, @NonNull LinearLayout llProgress,
      @NonNull ProgressBar setupProgress, @NonNull ImageView top, @NonNull TextView tvExportNote,
      @NonNull TextView tvProgress, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.ivImage = ivImage;
    this.llProgress = llProgress;
    this.setupProgress = setupProgress;
    this.top = top;
    this.tvExportNote = tvExportNote;
    this.tvProgress = tvProgress;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBottomExportProgressDialogBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBottomExportProgressDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_bottom_export_progress_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBottomExportProgressDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_image;
      ImageView ivImage = ViewBindings.findChildViewById(rootView, id);
      if (ivImage == null) {
        break missingId;
      }

      id = R.id.llProgress;
      LinearLayout llProgress = ViewBindings.findChildViewById(rootView, id);
      if (llProgress == null) {
        break missingId;
      }

      id = R.id.setup_progress;
      ProgressBar setupProgress = ViewBindings.findChildViewById(rootView, id);
      if (setupProgress == null) {
        break missingId;
      }

      id = R.id.top;
      ImageView top = ViewBindings.findChildViewById(rootView, id);
      if (top == null) {
        break missingId;
      }

      id = R.id.tv_export_note;
      TextView tvExportNote = ViewBindings.findChildViewById(rootView, id);
      if (tvExportNote == null) {
        break missingId;
      }

      id = R.id.tv_progress;
      TextView tvProgress = ViewBindings.findChildViewById(rootView, id);
      if (tvProgress == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new FragmentBottomExportProgressDialogBinding((LinearLayout) rootView, ivImage,
          llProgress, setupProgress, top, tvExportNote, tvProgress, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
