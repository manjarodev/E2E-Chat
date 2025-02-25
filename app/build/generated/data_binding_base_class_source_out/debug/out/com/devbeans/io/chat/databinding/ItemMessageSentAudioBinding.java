// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public final class ItemMessageSentAudioBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView audioDisappearSent;

  @NonNull
  public final CardView cvFile;

  @NonNull
  public final ImageView ivFilePlayPause;

  @NonNull
  public final ImageView ivForwarded;

  @NonNull
  public final LinearLayout layoutForwardedSentAudio;

  @NonNull
  public final ConstraintLayout outgoingLayoutBubble;

  @NonNull
  public final SeekBar seekBarAudio;

  @NonNull
  public final RelativeLayout sendingTextMessageLayout;

  @NonNull
  public final ImageView textSendTick;

  @NonNull
  public final TextView textviewTimeSent;

  @NonNull
  public final LinearLayout timeAndTickLayout;

  @NonNull
  public final TextView tvAudioTime;

  @NonNull
  public final TextView tvForwarded;

  private ItemMessageSentAudioBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView audioDisappearSent, @NonNull CardView cvFile,
      @NonNull ImageView ivFilePlayPause, @NonNull ImageView ivForwarded,
      @NonNull LinearLayout layoutForwardedSentAudio,
      @NonNull ConstraintLayout outgoingLayoutBubble, @NonNull SeekBar seekBarAudio,
      @NonNull RelativeLayout sendingTextMessageLayout, @NonNull ImageView textSendTick,
      @NonNull TextView textviewTimeSent, @NonNull LinearLayout timeAndTickLayout,
      @NonNull TextView tvAudioTime, @NonNull TextView tvForwarded) {
    this.rootView = rootView;
    this.audioDisappearSent = audioDisappearSent;
    this.cvFile = cvFile;
    this.ivFilePlayPause = ivFilePlayPause;
    this.ivForwarded = ivForwarded;
    this.layoutForwardedSentAudio = layoutForwardedSentAudio;
    this.outgoingLayoutBubble = outgoingLayoutBubble;
    this.seekBarAudio = seekBarAudio;
    this.sendingTextMessageLayout = sendingTextMessageLayout;
    this.textSendTick = textSendTick;
    this.textviewTimeSent = textviewTimeSent;
    this.timeAndTickLayout = timeAndTickLayout;
    this.tvAudioTime = tvAudioTime;
    this.tvForwarded = tvForwarded;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMessageSentAudioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMessageSentAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_message_sent_audio, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMessageSentAudioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_disappear_sent;
      ImageView audioDisappearSent = ViewBindings.findChildViewById(rootView, id);
      if (audioDisappearSent == null) {
        break missingId;
      }

      id = R.id.cv_file;
      CardView cvFile = ViewBindings.findChildViewById(rootView, id);
      if (cvFile == null) {
        break missingId;
      }

      id = R.id.iv_file_play_pause;
      ImageView ivFilePlayPause = ViewBindings.findChildViewById(rootView, id);
      if (ivFilePlayPause == null) {
        break missingId;
      }

      id = R.id.iv_forwarded;
      ImageView ivForwarded = ViewBindings.findChildViewById(rootView, id);
      if (ivForwarded == null) {
        break missingId;
      }

      id = R.id.layout_forwarded_sent_audio;
      LinearLayout layoutForwardedSentAudio = ViewBindings.findChildViewById(rootView, id);
      if (layoutForwardedSentAudio == null) {
        break missingId;
      }

      id = R.id.outgoing_layout_bubble;
      ConstraintLayout outgoingLayoutBubble = ViewBindings.findChildViewById(rootView, id);
      if (outgoingLayoutBubble == null) {
        break missingId;
      }

      id = R.id.seekBar_audio;
      SeekBar seekBarAudio = ViewBindings.findChildViewById(rootView, id);
      if (seekBarAudio == null) {
        break missingId;
      }

      id = R.id.sendingTextMessageLayout;
      RelativeLayout sendingTextMessageLayout = ViewBindings.findChildViewById(rootView, id);
      if (sendingTextMessageLayout == null) {
        break missingId;
      }

      id = R.id.text_sendTick;
      ImageView textSendTick = ViewBindings.findChildViewById(rootView, id);
      if (textSendTick == null) {
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

      id = R.id.tv_audio_time;
      TextView tvAudioTime = ViewBindings.findChildViewById(rootView, id);
      if (tvAudioTime == null) {
        break missingId;
      }

      id = R.id.tv_forwarded;
      TextView tvForwarded = ViewBindings.findChildViewById(rootView, id);
      if (tvForwarded == null) {
        break missingId;
      }

      return new ItemMessageSentAudioBinding((RelativeLayout) rootView, audioDisappearSent, cvFile,
          ivFilePlayPause, ivForwarded, layoutForwardedSentAudio, outgoingLayoutBubble,
          seekBarAudio, sendingTextMessageLayout, textSendTick, textviewTimeSent, timeAndTickLayout,
          tvAudioTime, tvForwarded);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
