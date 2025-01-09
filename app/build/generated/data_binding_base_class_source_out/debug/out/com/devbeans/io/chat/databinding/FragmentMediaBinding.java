// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMediaBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvMedia;

  @NonNull
  public final TextView tvTextNotification;

  protected FragmentMediaBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView rvMedia, TextView tvTextNotification) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvMedia = rvMedia;
    this.tvTextNotification = tvTextNotification;
  }

  @NonNull
  public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_media, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMediaBinding>inflateInternal(inflater, R.layout.fragment_media, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_media, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMediaBinding>inflateInternal(inflater, R.layout.fragment_media, null, false, component);
  }

  public static FragmentMediaBinding bind(@NonNull View view) {
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
  public static FragmentMediaBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMediaBinding)bind(component, view, R.layout.fragment_media);
  }
}
