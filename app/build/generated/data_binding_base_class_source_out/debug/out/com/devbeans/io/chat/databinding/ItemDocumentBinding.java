// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemDocumentBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivFile;

  @NonNull
  public final Space space;

  @NonNull
  public final TextView tvFileName;

  @NonNull
  public final TextView tvFileSizeType;

  @NonNull
  public final TextView tvFileTime;

  @NonNull
  public final TextView tvLabel;

  @NonNull
  public final View viewSelection;

  protected ItemDocumentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivFile, Space space, TextView tvFileName, TextView tvFileSizeType,
      TextView tvFileTime, TextView tvLabel, View viewSelection) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivFile = ivFile;
    this.space = space;
    this.tvFileName = tvFileName;
    this.tvFileSizeType = tvFileSizeType;
    this.tvFileTime = tvFileTime;
    this.tvLabel = tvLabel;
    this.viewSelection = viewSelection;
  }

  @NonNull
  public static ItemDocumentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_document, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemDocumentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemDocumentBinding>inflateInternal(inflater, R.layout.item_document, root, attachToRoot, component);
  }

  @NonNull
  public static ItemDocumentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_document, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemDocumentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemDocumentBinding>inflateInternal(inflater, R.layout.item_document, null, false, component);
  }

  public static ItemDocumentBinding bind(@NonNull View view) {
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
  public static ItemDocumentBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemDocumentBinding)bind(component, view, R.layout.item_document);
  }
}
