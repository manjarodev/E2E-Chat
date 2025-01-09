// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMessageReceiveAudioBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView audioDisappearReceive;

  @NonNull
  public final CardView cvFileReceive;

  @NonNull
  public final ConstraintLayout dataLayout;

  @NonNull
  public final ImageView ivDownloadReceiveAudio;

  @NonNull
  public final ImageView ivFilePlayPauseReceive;

  @NonNull
  public final ImageView ivForwarded;

  @NonNull
  public final LinearLayout layoutForwardedReceiveAudio;

  @NonNull
  public final ProgressBar loadingReceive;

  @NonNull
  public final ConstraintLayout outgoingLayoutBubble;

  @NonNull
  public final SeekBar seekBarAudioReceive;

  @NonNull
  public final RelativeLayout sendingTextMessageLayout;

  @NonNull
  public final TextView textviewTimeSent;

  @NonNull
  public final LinearLayout timeAndTickLayout;

  @NonNull
  public final TextView tvAudioTimeReceive;

  @NonNull
  public final TextView tvForwarded;

  @NonNull
  public final TextView tvGroupMemberName;

  private ItemMessageReceiveAudioBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView audioDisappearReceive, @NonNull CardView cvFileReceive,
      @NonNull ConstraintLayout dataLayout, @NonNull ImageView ivDownloadReceiveAudio,
      @NonNull ImageView ivFilePlayPauseReceive, @NonNull ImageView ivForwarded,
      @NonNull LinearLayout layoutForwardedReceiveAudio, @NonNull ProgressBar loadingReceive,
      @NonNull ConstraintLayout outgoingLayoutBubble, @NonNull SeekBar seekBarAudioReceive,
      @NonNull RelativeLayout sendingTextMessageLayout, @NonNull TextView textviewTimeSent,
      @NonNull LinearLayout timeAndTickLayout, @NonNull TextView tvAudioTimeReceive,
      @NonNull TextView tvForwarded, @NonNull TextView tvGroupMemberName) {
    this.rootView = rootView;
    this.audioDisappearReceive = audioDisappearReceive;
    this.cvFileReceive = cvFileReceive;
    this.dataLayout = dataLayout;
    this.ivDownloadReceiveAudio = ivDownloadReceiveAudio;
    this.ivFilePlayPauseReceive = ivFilePlayPauseReceive;
    this.ivForwarded = ivForwarded;
    this.layoutForwardedReceiveAudio = layoutForwardedReceiveAudio;
    this.loadingReceive = loadingReceive;
    this.outgoingLayoutBubble = outgoingLayoutBubble;
    this.seekBarAudioReceive = seekBarAudioReceive;
    this.sendingTextMessageLayout = sendingTextMessageLayout;
    this.textviewTimeSent = textviewTimeSent;
    this.timeAndTickLayout = timeAndTickLayout;
    this.tvAudioTimeReceive = tvAudioTimeReceive;
    this.tvForwarded = tvForwarded;
    this.tvGroupMemberName = tvGroupMemberName;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMessageReceiveAudioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMessageReceiveAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_message_receive_audio, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMessageReceiveAudioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_disappear_receive;
      ImageView audioDisappearReceive = ViewBindings.findChildViewById(rootView, id);
      if (audioDisappearReceive == null) {
        break missingId;
      }

      id = R.id.cv_file_receive;
      CardView cvFileReceive = ViewBindings.findChildViewById(rootView, id);
      if (cvFileReceive == null) {
        break missingId;
      }

      id = R.id.data_layout;
      ConstraintLayout dataLayout = ViewBindings.findChildViewById(rootView, id);
      if (dataLayout == null) {
        break missingId;
      }

      id = R.id.iv_download_receive_audio;
      ImageView ivDownloadReceiveAudio = ViewBindings.findChildViewById(rootView, id);
      if (ivDownloadReceiveAudio == null) {
        break missingId;
      }

      id = R.id.iv_file_play_pause_receive;
      ImageView ivFilePlayPauseReceive = ViewBindings.findChildViewById(rootView, id);
      if (ivFilePlayPauseReceive == null) {
        break missingId;
      }

      id = R.id.iv_forwarded;
      ImageView ivForwarded = ViewBindings.findChildViewById(rootView, id);
      if (ivForwarded == null) {
        break missingId;
      }

      id = R.id.layout_forwarded_receive_audio;
      LinearLayout layoutForwardedReceiveAudio = ViewBindings.findChildViewById(rootView, id);
      if (layoutForwardedReceiveAudio == null) {
        break missingId;
      }

      id = R.id.loading_receive;
      ProgressBar loadingReceive = ViewBindings.findChildViewById(rootView, id);
      if (loadingReceive == null) {
        break missingId;
      }

      id = R.id.outgoing_layout_bubble;
      ConstraintLayout outgoingLayoutBubble = ViewBindings.findChildViewById(rootView, id);
      if (outgoingLayoutBubble == null) {
        break missingId;
      }

      id = R.id.seekBar_audio_receive;
      SeekBar seekBarAudioReceive = ViewBindings.findChildViewById(rootView, id);
      if (seekBarAudioReceive == null) {
        break missingId;
      }

      id = R.id.sendingTextMessageLayout;
      RelativeLayout sendingTextMessageLayout = ViewBindings.findChildViewById(rootView, id);
      if (sendingTextMessageLayout == null) {
        break missingId;
      }

      id = R.id.textview_time_sent;
      TextView textviewTimeSent = ViewBindings.findChildViewById(rootView, id);
      if (textviewTimeSent == null) {
        break missingId;
      }

      id = R.id.time_and_tick_layout;
      LinearLayout timeAndTickLayout = ViewBindings.findChildViewById(rootView, id);
      if (timeAndTickLayout == null) {
        break missingId;
      }

      id = R.id.tv_audio_time_receive;
      TextView tvAudioTimeReceive = ViewBindings.findChildViewById(rootView, id);
      if (tvAudioTimeReceive == null) {
        break missingId;
      }

      id = R.id.tv_forwarded;
      TextView tvForwarded = ViewBindings.findChildViewById(rootView, id);
      if (tvForwarded == null) {
        break missingId;
      }

      id = R.id.tv_group_member_name;
      TextView tvGroupMemberName = ViewBindings.findChildViewById(rootView, id);
      if (tvGroupMemberName == null) {
        break missingId;
      }

      return new ItemMessageReceiveAudioBinding((RelativeLayout) rootView, audioDisappearReceive,
          cvFileReceive, dataLayout, ivDownloadReceiveAudio, ivFilePlayPauseReceive, ivForwarded,
          layoutForwardedReceiveAudio, loadingReceive, outgoingLayoutBubble, seekBarAudioReceive,
          sendingTextMessageLayout, textviewTimeSent, timeAndTickLayout, tvAudioTimeReceive,
          tvForwarded, tvGroupMemberName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
