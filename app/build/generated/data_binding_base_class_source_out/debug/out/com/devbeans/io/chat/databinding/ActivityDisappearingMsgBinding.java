// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityDisappearingMsgBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout appBar;

  @NonNull
  public final RadioButton dis1Day;

  @NonNull
  public final RadioButton dis1Hour;

  @NonNull
  public final RadioButton dis1Week;

  @NonNull
  public final RadioButton dis30Seconds;

  @NonNull
  public final RadioButton dis5Min;

  @NonNull
  public final RadioButton disCustom;

  @NonNull
  public final RadioButton disOff;

  @NonNull
  public final RadioButton disView;

  @NonNull
  public final FragmentContainerView fragmentContainerSettings;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final RadioGroup radioOptions;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView tvSubs;

  protected ActivityDisappearingMsgBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout appBar, RadioButton dis1Day, RadioButton dis1Hour,
      RadioButton dis1Week, RadioButton dis30Seconds, RadioButton dis5Min, RadioButton disCustom,
      RadioButton disOff, RadioButton disView, FragmentContainerView fragmentContainerSettings,
      ImageView ivBack, RadioGroup radioOptions, TextView title, TextView tvSubs) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    this.dis1Day = dis1Day;
    this.dis1Hour = dis1Hour;
    this.dis1Week = dis1Week;
    this.dis30Seconds = dis30Seconds;
    this.dis5Min = dis5Min;
    this.disCustom = disCustom;
    this.disOff = disOff;
    this.disView = disView;
    this.fragmentContainerSettings = fragmentContainerSettings;
    this.ivBack = ivBack;
    this.radioOptions = radioOptions;
    this.title = title;
    this.tvSubs = tvSubs;
  }

  @NonNull
  public static ActivityDisappearingMsgBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_disappearing_msg, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDisappearingMsgBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityDisappearingMsgBinding>inflateInternal(inflater, R.layout.activity_disappearing_msg, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDisappearingMsgBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_disappearing_msg, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDisappearingMsgBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityDisappearingMsgBinding>inflateInternal(inflater, R.layout.activity_disappearing_msg, null, false, component);
  }

  public static ActivityDisappearingMsgBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityDisappearingMsgBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityDisappearingMsgBinding)bind(component, view, R.layout.activity_disappearing_msg);
  }
}
