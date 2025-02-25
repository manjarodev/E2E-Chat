// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityNotificationBinding extends ViewDataBinding {
  @NonNull
  public final SwitchCompat checkAllowNotification;

  @NonNull
  public final SwitchCompat checkNewGroup;

  @NonNull
  public final SwitchCompat checkNewMessage;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final View separator;

  @NonNull
  public final View separator1;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvAddsInGroup;

  @NonNull
  public final TextView tvAllowAllNotification;

  @NonNull
  public final TextView tvNewGroup;

  @NonNull
  public final TextView tvNewMessage;

  @NonNull
  public final TextView tvStartNewMessage;

  @NonNull
  public final TextView tvSubs;

  protected ActivityNotificationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      SwitchCompat checkAllowNotification, SwitchCompat checkNewGroup, SwitchCompat checkNewMessage,
      ScrollView scrollView, View separator, View separator1, Toolbar toolbar,
      TextView tvAddsInGroup, TextView tvAllowAllNotification, TextView tvNewGroup,
      TextView tvNewMessage, TextView tvStartNewMessage, TextView tvSubs) {
    super(_bindingComponent, _root, _localFieldCount);
    this.checkAllowNotification = checkAllowNotification;
    this.checkNewGroup = checkNewGroup;
    this.checkNewMessage = checkNewMessage;
    this.scrollView = scrollView;
    this.separator = separator;
    this.separator1 = separator1;
    this.toolbar = toolbar;
    this.tvAddsInGroup = tvAddsInGroup;
    this.tvAllowAllNotification = tvAllowAllNotification;
    this.tvNewGroup = tvNewGroup;
    this.tvNewMessage = tvNewMessage;
    this.tvStartNewMessage = tvStartNewMessage;
    this.tvSubs = tvSubs;
  }

  @NonNull
  public static ActivityNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_notification, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityNotificationBinding>inflateInternal(inflater, R.layout.activity_notification, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_notification, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityNotificationBinding>inflateInternal(inflater, R.layout.activity_notification, null, false, component);
  }

  public static ActivityNotificationBinding bind(@NonNull View view) {
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
  public static ActivityNotificationBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityNotificationBinding)bind(component, view, R.layout.activity_notification);
  }
}
