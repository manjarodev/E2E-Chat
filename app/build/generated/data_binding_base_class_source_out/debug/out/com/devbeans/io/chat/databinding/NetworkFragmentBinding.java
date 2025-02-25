// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class NetworkFragmentBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnCancel;

  @NonNull
  public final AppCompatButton btnDeleteForEveryone;

  @NonNull
  public final ImageView ivAlert;

  @NonNull
  public final TextView tvAlertText;

  protected NetworkFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnCancel, AppCompatButton btnDeleteForEveryone, ImageView ivAlert,
      TextView tvAlertText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnDeleteForEveryone = btnDeleteForEveryone;
    this.ivAlert = ivAlert;
    this.tvAlertText = tvAlertText;
  }

  @NonNull
  public static NetworkFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.network_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static NetworkFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<NetworkFragmentBinding>inflateInternal(inflater, R.layout.network_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static NetworkFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.network_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static NetworkFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<NetworkFragmentBinding>inflateInternal(inflater, R.layout.network_fragment, null, false, component);
  }

  public static NetworkFragmentBinding bind(@NonNull View view) {
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
  public static NetworkFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (NetworkFragmentBinding)bind(component, view, R.layout.network_fragment);
  }
}
