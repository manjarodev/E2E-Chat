// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.devbeans.io.chat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentContactsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout addContactLayout;

  @NonNull
  public final ImageView ivContact;

  @NonNull
  public final ImageView ivQr;

  @NonNull
  public final RecyclerView rvContacts;

  @NonNull
  public final EditText searchBar;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvNewContact;

  @NonNull
  public final TextView tvTitleToolbar;

  protected FragmentContactsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout addContactLayout, ImageView ivContact, ImageView ivQr,
      RecyclerView rvContacts, EditText searchBar, Toolbar toolbar, TextView tvNewContact,
      TextView tvTitleToolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addContactLayout = addContactLayout;
    this.ivContact = ivContact;
    this.ivQr = ivQr;
    this.rvContacts = rvContacts;
    this.searchBar = searchBar;
    this.toolbar = toolbar;
    this.tvNewContact = tvNewContact;
    this.tvTitleToolbar = tvTitleToolbar;
  }

  @NonNull
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentContactsBinding>inflateInternal(inflater, R.layout.fragment_contacts, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentContactsBinding>inflateInternal(inflater, R.layout.fragment_contacts, null, false, component);
  }

  public static FragmentContactsBinding bind(@NonNull View view) {
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
  public static FragmentContactsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentContactsBinding)bind(component, view, R.layout.fragment_contacts);
  }
}
