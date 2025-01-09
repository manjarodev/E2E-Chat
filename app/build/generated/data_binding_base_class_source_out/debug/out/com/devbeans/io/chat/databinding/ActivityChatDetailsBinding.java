// Generated by data binding compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.devbeans.io.chat.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityChatDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout MediaDocsLinksLayout;

  @NonNull
  public final ConstraintLayout addMembersLayout;

  @NonNull
  public final SwitchCompat checkAutoSave;

  @NonNull
  public final SwitchCompat checkMediaSharing;

  @NonNull
  public final SwitchCompat checkMediaVisibility;

  @NonNull
  public final SwitchCompat checkMessageConfidential;

  @NonNull
  public final SwitchCompat checkReadReceipts;

  @NonNull
  public final TextView disappearOption;

  @NonNull
  public final FloatingActionButton ivAdd;

  @NonNull
  public final CircleImageView ivChatImage;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final ImageView ivDisappear;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final ImageView ivEditNickName;

  @NonNull
  public final ImageView ivForward;

  @NonNull
  public final ImageView ivMediaSharing;

  @NonNull
  public final ImageView ivMediaVisibility;

  @NonNull
  public final ImageView ivMessageConfidential;

  @NonNull
  public final ImageView ivReadReceipts;

  @NonNull
  public final ImageView ivVaultSave;

  @NonNull
  public final LinearLayout layoutChatName;

  @NonNull
  public final LinearLayout layoutChatNameEdit;

  @NonNull
  public final ConstraintLayout layoutGroupMembers;

  @NonNull
  public final LinearLayout layoutSettings;

  @NonNull
  public final RecyclerView rvImages;

  @NonNull
  public final RecyclerView rvMembers;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final View separator;

  @NonNull
  public final View separator1;

  @NonNull
  public final View separator2;

  @NonNull
  public final View separatorDis;

  @NonNull
  public final View seperator10;

  @NonNull
  public final View seperator11;

  @NonNull
  public final View seperator12;

  @NonNull
  public final View seperator13;

  @NonNull
  public final View seperator9;

  @NonNull
  public final View space;

  @NonNull
  public final TextView titleDisappear;

  @NonNull
  public final TextView titleGroupMembers;

  @NonNull
  public final TextView titleMediaDocsLinks;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvAutoSaveVault;

  @NonNull
  public final TextView tvAutoSaveVaultNote;

  @NonNull
  public final TextView tvChatColorWallpaper;

  @NonNull
  public final TextView tvChatId;

  @NonNull
  public final TextView tvChatName;

  @NonNull
  public final AppCompatButton tvClearChat;

  @NonNull
  public final LinearLayout tvClearChatLayout;

  @NonNull
  public final AppCompatButton tvClearGroup;

  @NonNull
  public final LinearLayout tvClearGroupLayout;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvDestroyGroup;

  @NonNull
  public final TextView tvGroupCreatedAt;

  @NonNull
  public final TextView tvLeaveGroup;

  @NonNull
  public final TextView tvMediaCount;

  @NonNull
  public final TextView tvMediaSharing;

  @NonNull
  public final TextView tvMediaSharingNote;

  @NonNull
  public final TextView tvMediaVisibility;

  @NonNull
  public final TextView tvMediaVisibilityNote;

  @NonNull
  public final TextView tvMessageConfidential;

  @NonNull
  public final TextView tvMessageConfidentialNote;

  @NonNull
  public final TextView tvNewContact;

  @NonNull
  public final TextView tvNotificationSettings;

  @NonNull
  public final TextView tvReadReceipts;

  @NonNull
  public final TextView tvReadReceiptsNote;

  @NonNull
  public final TextView tvSubs;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvTotalCount;

  protected ActivityChatDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout MediaDocsLinksLayout, ConstraintLayout addMembersLayout,
      SwitchCompat checkAutoSave, SwitchCompat checkMediaSharing, SwitchCompat checkMediaVisibility,
      SwitchCompat checkMessageConfidential, SwitchCompat checkReadReceipts,
      TextView disappearOption, FloatingActionButton ivAdd, CircleImageView ivChatImage,
      ImageView ivDelete, ImageView ivDisappear, ImageView ivEdit, ImageView ivEditNickName,
      ImageView ivForward, ImageView ivMediaSharing, ImageView ivMediaVisibility,
      ImageView ivMessageConfidential, ImageView ivReadReceipts, ImageView ivVaultSave,
      LinearLayout layoutChatName, LinearLayout layoutChatNameEdit,
      ConstraintLayout layoutGroupMembers, LinearLayout layoutSettings, RecyclerView rvImages,
      RecyclerView rvMembers, ScrollView scrollView, View separator, View separator1,
      View separator2, View separatorDis, View seperator10, View seperator11, View seperator12,
      View seperator13, View seperator9, View space, TextView titleDisappear,
      TextView titleGroupMembers, TextView titleMediaDocsLinks, Toolbar toolbar,
      TextView tvAutoSaveVault, TextView tvAutoSaveVaultNote, TextView tvChatColorWallpaper,
      TextView tvChatId, TextView tvChatName, AppCompatButton tvClearChat,
      LinearLayout tvClearChatLayout, AppCompatButton tvClearGroup, LinearLayout tvClearGroupLayout,
      TextView tvDescription, TextView tvDestroyGroup, TextView tvGroupCreatedAt,
      TextView tvLeaveGroup, TextView tvMediaCount, TextView tvMediaSharing,
      TextView tvMediaSharingNote, TextView tvMediaVisibility, TextView tvMediaVisibilityNote,
      TextView tvMessageConfidential, TextView tvMessageConfidentialNote, TextView tvNewContact,
      TextView tvNotificationSettings, TextView tvReadReceipts, TextView tvReadReceiptsNote,
      TextView tvSubs, TextView tvTotal, TextView tvTotalCount) {
    super(_bindingComponent, _root, _localFieldCount);
    this.MediaDocsLinksLayout = MediaDocsLinksLayout;
    this.addMembersLayout = addMembersLayout;
    this.checkAutoSave = checkAutoSave;
    this.checkMediaSharing = checkMediaSharing;
    this.checkMediaVisibility = checkMediaVisibility;
    this.checkMessageConfidential = checkMessageConfidential;
    this.checkReadReceipts = checkReadReceipts;
    this.disappearOption = disappearOption;
    this.ivAdd = ivAdd;
    this.ivChatImage = ivChatImage;
    this.ivDelete = ivDelete;
    this.ivDisappear = ivDisappear;
    this.ivEdit = ivEdit;
    this.ivEditNickName = ivEditNickName;
    this.ivForward = ivForward;
    this.ivMediaSharing = ivMediaSharing;
    this.ivMediaVisibility = ivMediaVisibility;
    this.ivMessageConfidential = ivMessageConfidential;
    this.ivReadReceipts = ivReadReceipts;
    this.ivVaultSave = ivVaultSave;
    this.layoutChatName = layoutChatName;
    this.layoutChatNameEdit = layoutChatNameEdit;
    this.layoutGroupMembers = layoutGroupMembers;
    this.layoutSettings = layoutSettings;
    this.rvImages = rvImages;
    this.rvMembers = rvMembers;
    this.scrollView = scrollView;
    this.separator = separator;
    this.separator1 = separator1;
    this.separator2 = separator2;
    this.separatorDis = separatorDis;
    this.seperator10 = seperator10;
    this.seperator11 = seperator11;
    this.seperator12 = seperator12;
    this.seperator13 = seperator13;
    this.seperator9 = seperator9;
    this.space = space;
    this.titleDisappear = titleDisappear;
    this.titleGroupMembers = titleGroupMembers;
    this.titleMediaDocsLinks = titleMediaDocsLinks;
    this.toolbar = toolbar;
    this.tvAutoSaveVault = tvAutoSaveVault;
    this.tvAutoSaveVaultNote = tvAutoSaveVaultNote;
    this.tvChatColorWallpaper = tvChatColorWallpaper;
    this.tvChatId = tvChatId;
    this.tvChatName = tvChatName;
    this.tvClearChat = tvClearChat;
    this.tvClearChatLayout = tvClearChatLayout;
    this.tvClearGroup = tvClearGroup;
    this.tvClearGroupLayout = tvClearGroupLayout;
    this.tvDescription = tvDescription;
    this.tvDestroyGroup = tvDestroyGroup;
    this.tvGroupCreatedAt = tvGroupCreatedAt;
    this.tvLeaveGroup = tvLeaveGroup;
    this.tvMediaCount = tvMediaCount;
    this.tvMediaSharing = tvMediaSharing;
    this.tvMediaSharingNote = tvMediaSharingNote;
    this.tvMediaVisibility = tvMediaVisibility;
    this.tvMediaVisibilityNote = tvMediaVisibilityNote;
    this.tvMessageConfidential = tvMessageConfidential;
    this.tvMessageConfidentialNote = tvMessageConfidentialNote;
    this.tvNewContact = tvNewContact;
    this.tvNotificationSettings = tvNotificationSettings;
    this.tvReadReceipts = tvReadReceipts;
    this.tvReadReceiptsNote = tvReadReceiptsNote;
    this.tvSubs = tvSubs;
    this.tvTotal = tvTotal;
    this.tvTotalCount = tvTotalCount;
  }

  @NonNull
  public static ActivityChatDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chat_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChatDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityChatDetailsBinding>inflateInternal(inflater, R.layout.activity_chat_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChatDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chat_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChatDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityChatDetailsBinding>inflateInternal(inflater, R.layout.activity_chat_details, null, false, component);
  }

  public static ActivityChatDetailsBinding bind(@NonNull View view) {
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
  public static ActivityChatDetailsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityChatDetailsBinding)bind(component, view, R.layout.activity_chat_details);
  }
}
