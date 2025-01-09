// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentChatWallpaperBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final RecyclerView recyclerWallpaper;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView tvSelectFromDevice;

  @NonNull
  public final TextView tvWallpaper;

  @NonNull
  public final TextView tvWallpaperChat;

  protected FragmentChatWallpaperBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView recycler, RecyclerView recyclerWallpaper, ScrollView scrollView,
      TextView tvSelectFromDevice, TextView tvWallpaper, TextView tvWallpaperChat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recycler = recycler;
    this.recyclerWallpaper = recyclerWallpaper;
    this.scrollView = scrollView;
    this.tvSelectFromDevice = tvSelectFromDevice;
    this.tvWallpaper = tvWallpaper;
    this.tvWallpaperChat = tvWallpaperChat;
  }

  @NonNull
  public static FragmentChatWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_chat_wallpaper, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentChatWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentChatWallpaperBinding>inflateInternal(inflater, R.layout.fragment_chat_wallpaper, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChatWallpaperBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_chat_wallpaper, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentChatWallpaperBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentChatWallpaperBinding>inflateInternal(inflater, R.layout.fragment_chat_wallpaper, null, false, component);
  }

  public static FragmentChatWallpaperBinding bind(@NonNull View view) {
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
  public static FragmentChatWallpaperBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentChatWallpaperBinding)bind(component, view, R.layout.fragment_chat_wallpaper);
  }
}
