// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMessageReceiveViewOnceBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout download;

  @NonNull
  public final LinearLayout downloadLinear;

  @NonNull
  public final TextView editedText;

  @NonNull
  public final ProgressBar loading;

  @NonNull
  public final RelativeLayout mainlayout;

  @NonNull
  public final TextView messageText1;

  @NonNull
  public final ImageView textDisappearReceive;

  @NonNull
  public final ConstraintLayout textIncomingLayoutBubbleReceive;

  @NonNull
  public final RelativeLayout textTextMessageLayout;

  @NonNull
  public final TextView textTextviewTimeReceived;

  @NonNull
  public final LinearLayout textTimeAndTickLayout;

  @NonNull
  public final TextView textTvGroupMemberName;

  private ItemMessageReceiveViewOnceBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout download, @NonNull LinearLayout downloadLinear,
      @NonNull TextView editedText, @NonNull ProgressBar loading,
      @NonNull RelativeLayout mainlayout, @NonNull TextView messageText1,
      @NonNull ImageView textDisappearReceive,
      @NonNull ConstraintLayout textIncomingLayoutBubbleReceive,
      @NonNull RelativeLayout textTextMessageLayout, @NonNull TextView textTextviewTimeReceived,
      @NonNull LinearLayout textTimeAndTickLayout, @NonNull TextView textTvGroupMemberName) {
    this.rootView = rootView;
    this.download = download;
    this.downloadLinear = downloadLinear;
    this.editedText = editedText;
    this.loading = loading;
    this.mainlayout = mainlayout;
    this.messageText1 = messageText1;
    this.textDisappearReceive = textDisappearReceive;
    this.textIncomingLayoutBubbleReceive = textIncomingLayoutBubbleReceive;
    this.textTextMessageLayout = textTextMessageLayout;
    this.textTextviewTimeReceived = textTextviewTimeReceived;
    this.textTimeAndTickLayout = textTimeAndTickLayout;
    this.textTvGroupMemberName = textTvGroupMemberName;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMessageReceiveViewOnceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMessageReceiveViewOnceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_message_receive_view_once, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMessageReceiveViewOnceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.download;
      LinearLayout download = ViewBindings.findChildViewById(rootView, id);
      if (download == null) {
        break missingId;
      }

      id = R.id.downloadLinear;
      LinearLayout downloadLinear = ViewBindings.findChildViewById(rootView, id);
      if (downloadLinear == null) {
        break missingId;
      }

      id = R.id.editedText;
      TextView editedText = ViewBindings.findChildViewById(rootView, id);
      if (editedText == null) {
        break missingId;
      }

      id = R.id.loading;
      ProgressBar loading = ViewBindings.findChildViewById(rootView, id);
      if (loading == null) {
        break missingId;
      }

      id = R.id.mainlayout;
      RelativeLayout mainlayout = ViewBindings.findChildViewById(rootView, id);
      if (mainlayout == null) {
        break missingId;
      }

      id = R.id.messageText1;
      TextView messageText1 = ViewBindings.findChildViewById(rootView, id);
      if (messageText1 == null) {
        break missingId;
      }

      id = R.id.text_disappear_receive;
      ImageView textDisappearReceive = ViewBindings.findChildViewById(rootView, id);
      if (textDisappearReceive == null) {
        break missingId;
      }

      id = R.id.text_incoming_layout_bubble_receive;
      ConstraintLayout textIncomingLayoutBubbleReceive = ViewBindings.findChildViewById(rootView, id);
      if (textIncomingLayoutBubbleReceive == null) {
        break missingId;
      }

      id = R.id.text_textMessageLayout;
      RelativeLayout textTextMessageLayout = ViewBindings.findChildViewById(rootView, id);
      if (textTextMessageLayout == null) {
        break missingId;
      }

      id = R.id.text_textview_time_received;
      TextView textTextviewTimeReceived = ViewBindings.findChildViewById(rootView, id);
      if (textTextviewTimeReceived == null) {
        break missingId;
      }

      id = R.id.text_time_and_tick_layout;
      LinearLayout textTimeAndTickLayout = ViewBindings.findChildViewById(rootView, id);
      if (textTimeAndTickLayout == null) {
        break missingId;
      }

      id = R.id.text_tv_group_member_name;
      TextView textTvGroupMemberName = ViewBindings.findChildViewById(rootView, id);
      if (textTvGroupMemberName == null) {
        break missingId;
      }

      return new ItemMessageReceiveViewOnceBinding((RelativeLayout) rootView, download,
          downloadLinear, editedText, loading, mainlayout, messageText1, textDisappearReceive,
          textIncomingLayoutBubbleReceive, textTextMessageLayout, textTextviewTimeReceived,
          textTimeAndTickLayout, textTvGroupMemberName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
