package com.devbeans.io.chat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.devbeans.io.chat.databinding.ActivityAddMemberBindingImpl;
import com.devbeans.io.chat.databinding.ActivityArchiveBindingImpl;
import com.devbeans.io.chat.databinding.ActivityAutoLockSettingBindingImpl;
import com.devbeans.io.chat.databinding.ActivityChatBindingImpl;
import com.devbeans.io.chat.databinding.ActivityChatDetailsBindingImpl;
import com.devbeans.io.chat.databinding.ActivityChatSettingsBindingImpl;
import com.devbeans.io.chat.databinding.ActivityContactDetailBindingImpl;
import com.devbeans.io.chat.databinding.ActivityDetailsEditBindingImpl;
import com.devbeans.io.chat.databinding.ActivityDisappearingMsgBindingImpl;
import com.devbeans.io.chat.databinding.ActivityEditProfileBindingImpl;
import com.devbeans.io.chat.databinding.ActivityImportExportBindingImpl;
import com.devbeans.io.chat.databinding.ActivityMainBindingImpl;
import com.devbeans.io.chat.databinding.ActivityMediaDetailsBindingImpl;
import com.devbeans.io.chat.databinding.ActivityMembersBindingImpl;
import com.devbeans.io.chat.databinding.ActivityMessageDetailsBindingImpl;
import com.devbeans.io.chat.databinding.ActivityNewMessageBindingImpl;
import com.devbeans.io.chat.databinding.ActivityNotificationBindingImpl;
import com.devbeans.io.chat.databinding.ActivityPicturePreviewBindingImpl;
import com.devbeans.io.chat.databinding.ActivityPrivacyBindingImpl;
import com.devbeans.io.chat.databinding.ActivityQrscannerBindingImpl;
import com.devbeans.io.chat.databinding.ActivityRemoveViewBindingImpl;
import com.devbeans.io.chat.databinding.ActivityScreenShowingBindingImpl;
import com.devbeans.io.chat.databinding.ActivityShareToBindingImpl;
import com.devbeans.io.chat.databinding.ActivitySplashBindingImpl;
import com.devbeans.io.chat.databinding.AdjustTimeFragmentBindingImpl;
import com.devbeans.io.chat.databinding.AttachementSentBindingImpl;
import com.devbeans.io.chat.databinding.AutoLockSettingFragmentBindingImpl;
import com.devbeans.io.chat.databinding.BlockedContactFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ChangePinTimerFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ChatColorSelectionAdapterItemBindingImpl;
import com.devbeans.io.chat.databinding.ChatWallpaperSelectionAdapterItemBindingImpl;
import com.devbeans.io.chat.databinding.ConfirmPinFragmentBindingImpl;
import com.devbeans.io.chat.databinding.CreatePinFragmentBindingImpl;
import com.devbeans.io.chat.databinding.CustomBlockDailogBindingImpl;
import com.devbeans.io.chat.databinding.CustomDailogAddContactBindingImpl;
import com.devbeans.io.chat.databinding.CustomDailogBlockBindingImpl;
import com.devbeans.io.chat.databinding.CustomDailogNewContactBindingImpl;
import com.devbeans.io.chat.databinding.CustomDailogViewBindingImpl;
import com.devbeans.io.chat.databinding.CustomDeleteMessageBindingImpl;
import com.devbeans.io.chat.databinding.CustomMenuBindingImpl;
import com.devbeans.io.chat.databinding.CustomNicknameDailogBindingImpl;
import com.devbeans.io.chat.databinding.CustomSelectorDailogBindingImpl;
import com.devbeans.io.chat.databinding.CustomUpdateNicknameDailogBindingImpl;
import com.devbeans.io.chat.databinding.DisappearingFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ExportFragmentBindingImpl;
import com.devbeans.io.chat.databinding.FragmentAgreementWipeBindingImpl;
import com.devbeans.io.chat.databinding.FragmentBottomSheetContactChoiceBindingImpl;
import com.devbeans.io.chat.databinding.FragmentChatSettingsBindingImpl;
import com.devbeans.io.chat.databinding.FragmentChatWallpaperBindingImpl;
import com.devbeans.io.chat.databinding.FragmentContactsBindingImpl;
import com.devbeans.io.chat.databinding.FragmentDeleteBindingImpl;
import com.devbeans.io.chat.databinding.FragmentDocsBindingImpl;
import com.devbeans.io.chat.databinding.FragmentFileStorageBindingImpl;
import com.devbeans.io.chat.databinding.FragmentFilesBindingImpl;
import com.devbeans.io.chat.databinding.FragmentFoldersBindingImpl;
import com.devbeans.io.chat.databinding.FragmentHomeBindingImpl;
import com.devbeans.io.chat.databinding.FragmentImportExportBindingImpl;
import com.devbeans.io.chat.databinding.FragmentLinksBindingImpl;
import com.devbeans.io.chat.databinding.FragmentMediaBindingImpl;
import com.devbeans.io.chat.databinding.FragmentProfileManageBindingImpl;
import com.devbeans.io.chat.databinding.FragmentVerifyPinSettingsBindingImpl;
import com.devbeans.io.chat.databinding.FragmentWallpaperPreviewBindingImpl;
import com.devbeans.io.chat.databinding.FragmentWipeChatDataBindingImpl;
import com.devbeans.io.chat.databinding.ImportExportDialogOptionBindingImpl;
import com.devbeans.io.chat.databinding.ImportFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ImportListFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ItemArchiveBindingImpl;
import com.devbeans.io.chat.databinding.ItemBlocklistBindingImpl;
import com.devbeans.io.chat.databinding.ItemChatsBindingImpl;
import com.devbeans.io.chat.databinding.ItemContactBindingImpl;
import com.devbeans.io.chat.databinding.ItemContactViewBindingImpl;
import com.devbeans.io.chat.databinding.ItemDocumentBindingImpl;
import com.devbeans.io.chat.databinding.ItemFilesBindingImpl;
import com.devbeans.io.chat.databinding.ItemFoldersBindingImpl;
import com.devbeans.io.chat.databinding.ItemGroupMemberBindingImpl;
import com.devbeans.io.chat.databinding.ItemImageBindingImpl;
import com.devbeans.io.chat.databinding.ItemLinksBindingImpl;
import com.devbeans.io.chat.databinding.ItemListFragmentBindingImpl;
import com.devbeans.io.chat.databinding.ItemMediaBindingImpl;
import com.devbeans.io.chat.databinding.ItemMemberBindingImpl;
import com.devbeans.io.chat.databinding.ItemMessageReceiveBindingImpl;
import com.devbeans.io.chat.databinding.ItemMessageSentBindingImpl;
import com.devbeans.io.chat.databinding.ItemSharetoMemberBindingImpl;
import com.devbeans.io.chat.databinding.ListItemContactChoiceBindingImpl;
import com.devbeans.io.chat.databinding.NetworkFragmentBindingImpl;
import com.devbeans.io.chat.databinding.PrivacyFragmentBindingImpl;
import com.devbeans.io.chat.databinding.SplashFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDMEMBER = 1;

  private static final int LAYOUT_ACTIVITYARCHIVE = 2;

  private static final int LAYOUT_ACTIVITYAUTOLOCKSETTING = 3;

  private static final int LAYOUT_ACTIVITYCHAT = 4;

  private static final int LAYOUT_ACTIVITYCHATDETAILS = 5;

  private static final int LAYOUT_ACTIVITYCHATSETTINGS = 6;

  private static final int LAYOUT_ACTIVITYCONTACTDETAIL = 7;

  private static final int LAYOUT_ACTIVITYDETAILSEDIT = 8;

  private static final int LAYOUT_ACTIVITYDISAPPEARINGMSG = 9;

  private static final int LAYOUT_ACTIVITYEDITPROFILE = 10;

  private static final int LAYOUT_ACTIVITYIMPORTEXPORT = 11;

  private static final int LAYOUT_ACTIVITYMAIN = 12;

  private static final int LAYOUT_ACTIVITYMEDIADETAILS = 13;

  private static final int LAYOUT_ACTIVITYMEMBERS = 14;

  private static final int LAYOUT_ACTIVITYMESSAGEDETAILS = 15;

  private static final int LAYOUT_ACTIVITYNEWMESSAGE = 16;

  private static final int LAYOUT_ACTIVITYNOTIFICATION = 17;

  private static final int LAYOUT_ACTIVITYPICTUREPREVIEW = 18;

  private static final int LAYOUT_ACTIVITYPRIVACY = 19;

  private static final int LAYOUT_ACTIVITYQRSCANNER = 20;

  private static final int LAYOUT_ACTIVITYREMOVEVIEW = 21;

  private static final int LAYOUT_ACTIVITYSCREENSHOWING = 22;

  private static final int LAYOUT_ACTIVITYSHARETO = 23;

  private static final int LAYOUT_ACTIVITYSPLASH = 24;

  private static final int LAYOUT_ADJUSTTIMEFRAGMENT = 25;

  private static final int LAYOUT_ATTACHEMENTSENT = 26;

  private static final int LAYOUT_AUTOLOCKSETTINGFRAGMENT = 27;

  private static final int LAYOUT_BLOCKEDCONTACTFRAGMENT = 28;

  private static final int LAYOUT_CHANGEPINTIMERFRAGMENT = 29;

  private static final int LAYOUT_CHATCOLORSELECTIONADAPTERITEM = 30;

  private static final int LAYOUT_CHATWALLPAPERSELECTIONADAPTERITEM = 31;

  private static final int LAYOUT_CONFIRMPINFRAGMENT = 32;

  private static final int LAYOUT_CREATEPINFRAGMENT = 33;

  private static final int LAYOUT_CUSTOMBLOCKDAILOG = 34;

  private static final int LAYOUT_CUSTOMDAILOGADDCONTACT = 35;

  private static final int LAYOUT_CUSTOMDAILOGBLOCK = 36;

  private static final int LAYOUT_CUSTOMDAILOGNEWCONTACT = 37;

  private static final int LAYOUT_CUSTOMDAILOGVIEW = 38;

  private static final int LAYOUT_CUSTOMDELETEMESSAGE = 39;

  private static final int LAYOUT_CUSTOMMENU = 40;

  private static final int LAYOUT_CUSTOMNICKNAMEDAILOG = 41;

  private static final int LAYOUT_CUSTOMSELECTORDAILOG = 42;

  private static final int LAYOUT_CUSTOMUPDATENICKNAMEDAILOG = 43;

  private static final int LAYOUT_DISAPPEARINGFRAGMENT = 44;

  private static final int LAYOUT_EXPORTFRAGMENT = 45;

  private static final int LAYOUT_FRAGMENTAGREEMENTWIPE = 46;

  private static final int LAYOUT_FRAGMENTBOTTOMSHEETCONTACTCHOICE = 47;

  private static final int LAYOUT_FRAGMENTCHATSETTINGS = 48;

  private static final int LAYOUT_FRAGMENTCHATWALLPAPER = 49;

  private static final int LAYOUT_FRAGMENTCONTACTS = 50;

  private static final int LAYOUT_FRAGMENTDELETE = 51;

  private static final int LAYOUT_FRAGMENTDOCS = 52;

  private static final int LAYOUT_FRAGMENTFILESTORAGE = 53;

  private static final int LAYOUT_FRAGMENTFILES = 54;

  private static final int LAYOUT_FRAGMENTFOLDERS = 55;

  private static final int LAYOUT_FRAGMENTHOME = 56;

  private static final int LAYOUT_FRAGMENTIMPORTEXPORT = 57;

  private static final int LAYOUT_FRAGMENTLINKS = 58;

  private static final int LAYOUT_FRAGMENTMEDIA = 59;

  private static final int LAYOUT_FRAGMENTPROFILEMANAGE = 60;

  private static final int LAYOUT_FRAGMENTVERIFYPINSETTINGS = 61;

  private static final int LAYOUT_FRAGMENTWALLPAPERPREVIEW = 62;

  private static final int LAYOUT_FRAGMENTWIPECHATDATA = 63;

  private static final int LAYOUT_IMPORTEXPORTDIALOGOPTION = 64;

  private static final int LAYOUT_IMPORTFRAGMENT = 65;

  private static final int LAYOUT_IMPORTLISTFRAGMENT = 66;

  private static final int LAYOUT_ITEMARCHIVE = 67;

  private static final int LAYOUT_ITEMBLOCKLIST = 68;

  private static final int LAYOUT_ITEMCHATS = 69;

  private static final int LAYOUT_ITEMCONTACT = 70;

  private static final int LAYOUT_ITEMCONTACTVIEW = 71;

  private static final int LAYOUT_ITEMDOCUMENT = 72;

  private static final int LAYOUT_ITEMFILES = 73;

  private static final int LAYOUT_ITEMFOLDERS = 74;

  private static final int LAYOUT_ITEMGROUPMEMBER = 75;

  private static final int LAYOUT_ITEMIMAGE = 76;

  private static final int LAYOUT_ITEMLINKS = 77;

  private static final int LAYOUT_ITEMLISTFRAGMENT = 78;

  private static final int LAYOUT_ITEMMEDIA = 79;

  private static final int LAYOUT_ITEMMEMBER = 80;

  private static final int LAYOUT_ITEMMESSAGERECEIVE = 81;

  private static final int LAYOUT_ITEMMESSAGESENT = 82;

  private static final int LAYOUT_ITEMSHARETOMEMBER = 83;

  private static final int LAYOUT_LISTITEMCONTACTCHOICE = 84;

  private static final int LAYOUT_NETWORKFRAGMENT = 85;

  private static final int LAYOUT_PRIVACYFRAGMENT = 86;

  private static final int LAYOUT_SPLASHFRAGMENT = 87;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(87);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_add_member, LAYOUT_ACTIVITYADDMEMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_archive, LAYOUT_ACTIVITYARCHIVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_auto_lock_setting, LAYOUT_ACTIVITYAUTOLOCKSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_chat, LAYOUT_ACTIVITYCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_chat_details, LAYOUT_ACTIVITYCHATDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_chat_settings, LAYOUT_ACTIVITYCHATSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_contact_detail, LAYOUT_ACTIVITYCONTACTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_details_edit, LAYOUT_ACTIVITYDETAILSEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_disappearing_msg, LAYOUT_ACTIVITYDISAPPEARINGMSG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_import_export, LAYOUT_ACTIVITYIMPORTEXPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_media_details, LAYOUT_ACTIVITYMEDIADETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_members, LAYOUT_ACTIVITYMEMBERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_message_details, LAYOUT_ACTIVITYMESSAGEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_new_message, LAYOUT_ACTIVITYNEWMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_notification, LAYOUT_ACTIVITYNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_picture_preview, LAYOUT_ACTIVITYPICTUREPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_privacy, LAYOUT_ACTIVITYPRIVACY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_qrscanner, LAYOUT_ACTIVITYQRSCANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_remove_view, LAYOUT_ACTIVITYREMOVEVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_screen_showing, LAYOUT_ACTIVITYSCREENSHOWING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_share_to, LAYOUT_ACTIVITYSHARETO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.adjust_time_fragment, LAYOUT_ADJUSTTIMEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.attachement_sent, LAYOUT_ATTACHEMENTSENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.auto_lock_setting_fragment, LAYOUT_AUTOLOCKSETTINGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.blocked_contact_fragment, LAYOUT_BLOCKEDCONTACTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.change_pin_timer_fragment, LAYOUT_CHANGEPINTIMERFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.chat_color_selection_adapter_item, LAYOUT_CHATCOLORSELECTIONADAPTERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.chat_wallpaper_selection_adapter_item, LAYOUT_CHATWALLPAPERSELECTIONADAPTERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.confirm_pin_fragment, LAYOUT_CONFIRMPINFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.create_pin_fragment, LAYOUT_CREATEPINFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_block_dailog, LAYOUT_CUSTOMBLOCKDAILOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_dailog_add_contact, LAYOUT_CUSTOMDAILOGADDCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_dailog_block, LAYOUT_CUSTOMDAILOGBLOCK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_dailog_new_contact, LAYOUT_CUSTOMDAILOGNEWCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_dailog_view, LAYOUT_CUSTOMDAILOGVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_delete_message, LAYOUT_CUSTOMDELETEMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_menu, LAYOUT_CUSTOMMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_nickname_dailog, LAYOUT_CUSTOMNICKNAMEDAILOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_selector_dailog, LAYOUT_CUSTOMSELECTORDAILOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.custom_update_nickname_dailog, LAYOUT_CUSTOMUPDATENICKNAMEDAILOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.disappearing_fragment, LAYOUT_DISAPPEARINGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.export_fragment, LAYOUT_EXPORTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_agreement_wipe, LAYOUT_FRAGMENTAGREEMENTWIPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_bottom_sheet_contact_choice, LAYOUT_FRAGMENTBOTTOMSHEETCONTACTCHOICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_chat_settings, LAYOUT_FRAGMENTCHATSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_chat_wallpaper, LAYOUT_FRAGMENTCHATWALLPAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_contacts, LAYOUT_FRAGMENTCONTACTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_delete, LAYOUT_FRAGMENTDELETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_docs, LAYOUT_FRAGMENTDOCS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_file_storage, LAYOUT_FRAGMENTFILESTORAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_files, LAYOUT_FRAGMENTFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_folders, LAYOUT_FRAGMENTFOLDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_import_export, LAYOUT_FRAGMENTIMPORTEXPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_links, LAYOUT_FRAGMENTLINKS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_media, LAYOUT_FRAGMENTMEDIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_profile_manage, LAYOUT_FRAGMENTPROFILEMANAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_verify_pin_settings, LAYOUT_FRAGMENTVERIFYPINSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_wallpaper_preview, LAYOUT_FRAGMENTWALLPAPERPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.fragment_wipe_chat_data, LAYOUT_FRAGMENTWIPECHATDATA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.import_export_dialog_option, LAYOUT_IMPORTEXPORTDIALOGOPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.import_fragment, LAYOUT_IMPORTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.import_list_fragment, LAYOUT_IMPORTLISTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_archive, LAYOUT_ITEMARCHIVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_blocklist, LAYOUT_ITEMBLOCKLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_chats, LAYOUT_ITEMCHATS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_contact, LAYOUT_ITEMCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_contact_view, LAYOUT_ITEMCONTACTVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_document, LAYOUT_ITEMDOCUMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_files, LAYOUT_ITEMFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_folders, LAYOUT_ITEMFOLDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_group_member, LAYOUT_ITEMGROUPMEMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_links, LAYOUT_ITEMLINKS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_list_fragment, LAYOUT_ITEMLISTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_media, LAYOUT_ITEMMEDIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_member, LAYOUT_ITEMMEMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_message_receive, LAYOUT_ITEMMESSAGERECEIVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_message_sent, LAYOUT_ITEMMESSAGESENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.item_shareto_member, LAYOUT_ITEMSHARETOMEMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.list_item_contact_choice, LAYOUT_LISTITEMCONTACTCHOICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.network_fragment, LAYOUT_NETWORKFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.privacy_fragment, LAYOUT_PRIVACYFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.devbeans.io.chat.R.layout.splash_fragment, LAYOUT_SPLASHFRAGMENT);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYADDMEMBER: {
        if ("layout/activity_add_member_0".equals(tag)) {
          return new ActivityAddMemberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_member is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYARCHIVE: {
        if ("layout/activity_archive_0".equals(tag)) {
          return new ActivityArchiveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_archive is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYAUTOLOCKSETTING: {
        if ("layout/activity_auto_lock_setting_0".equals(tag)) {
          return new ActivityAutoLockSettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_auto_lock_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHAT: {
        if ("layout/activity_chat_0".equals(tag)) {
          return new ActivityChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHATDETAILS: {
        if ("layout/activity_chat_details_0".equals(tag)) {
          return new ActivityChatDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chat_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHATSETTINGS: {
        if ("layout/activity_chat_settings_0".equals(tag)) {
          return new ActivityChatSettingsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chat_settings is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCONTACTDETAIL: {
        if ("layout/activity_contact_detail_0".equals(tag)) {
          return new ActivityContactDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_contact_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDETAILSEDIT: {
        if ("layout/activity_details_edit_0".equals(tag)) {
          return new ActivityDetailsEditBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_details_edit is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDISAPPEARINGMSG: {
        if ("layout/activity_disappearing_msg_0".equals(tag)) {
          return new ActivityDisappearingMsgBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_disappearing_msg is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITPROFILE: {
        if ("layout/activity_edit_profile_0".equals(tag)) {
          return new ActivityEditProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYIMPORTEXPORT: {
        if ("layout/activity_import_export_0".equals(tag)) {
          return new ActivityImportExportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_import_export is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAIN: {
        if ("layout/activity_main_0".equals(tag)) {
          return new ActivityMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMEDIADETAILS: {
        if ("layout/activity_media_details_0".equals(tag)) {
          return new ActivityMediaDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_media_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMEMBERS: {
        if ("layout/activity_members_0".equals(tag)) {
          return new ActivityMembersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_members is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMESSAGEDETAILS: {
        if ("layout/activity_message_details_0".equals(tag)) {
          return new ActivityMessageDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_message_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNEWMESSAGE: {
        if ("layout/activity_new_message_0".equals(tag)) {
          return new ActivityNewMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_new_message is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNOTIFICATION: {
        if ("layout/activity_notification_0".equals(tag)) {
          return new ActivityNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPICTUREPREVIEW: {
        if ("layout/activity_picture_preview_0".equals(tag)) {
          return new ActivityPicturePreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_picture_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPRIVACY: {
        if ("layout/activity_privacy_0".equals(tag)) {
          return new ActivityPrivacyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_privacy is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYQRSCANNER: {
        if ("layout/activity_qrscanner_0".equals(tag)) {
          return new ActivityQrscannerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_qrscanner is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREMOVEVIEW: {
        if ("layout/activity_remove_view_0".equals(tag)) {
          return new ActivityRemoveViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_remove_view is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSCREENSHOWING: {
        if ("layout/activity_screen_showing_0".equals(tag)) {
          return new ActivityScreenShowingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_screen_showing is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSHARETO: {
        if ("layout/activity_share_to_0".equals(tag)) {
          return new ActivityShareToBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_share_to is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ADJUSTTIMEFRAGMENT: {
        if ("layout/adjust_time_fragment_0".equals(tag)) {
          return new AdjustTimeFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adjust_time_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_ATTACHEMENTSENT: {
        if ("layout/attachement_sent_0".equals(tag)) {
          return new AttachementSentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for attachement_sent is invalid. Received: " + tag);
      }
      case  LAYOUT_AUTOLOCKSETTINGFRAGMENT: {
        if ("layout/auto_lock_setting_fragment_0".equals(tag)) {
          return new AutoLockSettingFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for auto_lock_setting_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_BLOCKEDCONTACTFRAGMENT: {
        if ("layout/blocked_contact_fragment_0".equals(tag)) {
          return new BlockedContactFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for blocked_contact_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_CHANGEPINTIMERFRAGMENT: {
        if ("layout/change_pin_timer_fragment_0".equals(tag)) {
          return new ChangePinTimerFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for change_pin_timer_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_CHATCOLORSELECTIONADAPTERITEM: {
        if ("layout/chat_color_selection_adapter_item_0".equals(tag)) {
          return new ChatColorSelectionAdapterItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for chat_color_selection_adapter_item is invalid. Received: " + tag);
      }
      case  LAYOUT_CHATWALLPAPERSELECTIONADAPTERITEM: {
        if ("layout/chat_wallpaper_selection_adapter_item_0".equals(tag)) {
          return new ChatWallpaperSelectionAdapterItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for chat_wallpaper_selection_adapter_item is invalid. Received: " + tag);
      }
      case  LAYOUT_CONFIRMPINFRAGMENT: {
        if ("layout/confirm_pin_fragment_0".equals(tag)) {
          return new ConfirmPinFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for confirm_pin_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_CREATEPINFRAGMENT: {
        if ("layout/create_pin_fragment_0".equals(tag)) {
          return new CreatePinFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for create_pin_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMBLOCKDAILOG: {
        if ("layout/custom_block_dailog_0".equals(tag)) {
          return new CustomBlockDailogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_block_dailog is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMDAILOGADDCONTACT: {
        if ("layout/custom_dailog_add_contact_0".equals(tag)) {
          return new CustomDailogAddContactBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_dailog_add_contact is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMDAILOGBLOCK: {
        if ("layout/custom_dailog_block_0".equals(tag)) {
          return new CustomDailogBlockBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_dailog_block is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMDAILOGNEWCONTACT: {
        if ("layout/custom_dailog_new_contact_0".equals(tag)) {
          return new CustomDailogNewContactBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_dailog_new_contact is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMDAILOGVIEW: {
        if ("layout/custom_dailog_view_0".equals(tag)) {
          return new CustomDailogViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_dailog_view is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMDELETEMESSAGE: {
        if ("layout/custom_delete_message_0".equals(tag)) {
          return new CustomDeleteMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_delete_message is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMMENU: {
        if ("layout/custom_menu_0".equals(tag)) {
          return new CustomMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMNICKNAMEDAILOG: {
        if ("layout/custom_nickname_dailog_0".equals(tag)) {
          return new CustomNicknameDailogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_nickname_dailog is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMSELECTORDAILOG: {
        if ("layout/custom_selector_dailog_0".equals(tag)) {
          return new CustomSelectorDailogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_selector_dailog is invalid. Received: " + tag);
      }
      case  LAYOUT_CUSTOMUPDATENICKNAMEDAILOG: {
        if ("layout/custom_update_nickname_dailog_0".equals(tag)) {
          return new CustomUpdateNicknameDailogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for custom_update_nickname_dailog is invalid. Received: " + tag);
      }
      case  LAYOUT_DISAPPEARINGFRAGMENT: {
        if ("layout/disappearing_fragment_0".equals(tag)) {
          return new DisappearingFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for disappearing_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_EXPORTFRAGMENT: {
        if ("layout/export_fragment_0".equals(tag)) {
          return new ExportFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for export_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTAGREEMENTWIPE: {
        if ("layout/fragment_agreement_wipe_0".equals(tag)) {
          return new FragmentAgreementWipeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_agreement_wipe is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBOTTOMSHEETCONTACTCHOICE: {
        if ("layout/fragment_bottom_sheet_contact_choice_0".equals(tag)) {
          return new FragmentBottomSheetContactChoiceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_bottom_sheet_contact_choice is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHATSETTINGS: {
        if ("layout/fragment_chat_settings_0".equals(tag)) {
          return new FragmentChatSettingsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chat_settings is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHATWALLPAPER: {
        if ("layout/fragment_chat_wallpaper_0".equals(tag)) {
          return new FragmentChatWallpaperBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chat_wallpaper is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCONTACTS: {
        if ("layout/fragment_contacts_0".equals(tag)) {
          return new FragmentContactsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_contacts is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTDELETE: {
        if ("layout/fragment_delete_0".equals(tag)) {
          return new FragmentDeleteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_delete is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDOCS: {
        if ("layout/fragment_docs_0".equals(tag)) {
          return new FragmentDocsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_docs is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFILESTORAGE: {
        if ("layout/fragment_file_storage_0".equals(tag)) {
          return new FragmentFileStorageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_file_storage is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFILES: {
        if ("layout/fragment_files_0".equals(tag)) {
          return new FragmentFilesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_files is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFOLDERS: {
        if ("layout/fragment_folders_0".equals(tag)) {
          return new FragmentFoldersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_folders is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOME: {
        if ("layout/fragment_home_0".equals(tag)) {
          return new FragmentHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIMPORTEXPORT: {
        if ("layout/fragment_import_export_0".equals(tag)) {
          return new FragmentImportExportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_import_export is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLINKS: {
        if ("layout/fragment_links_0".equals(tag)) {
          return new FragmentLinksBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_links is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMEDIA: {
        if ("layout/fragment_media_0".equals(tag)) {
          return new FragmentMediaBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_media is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROFILEMANAGE: {
        if ("layout/fragment_profile_manage_0".equals(tag)) {
          return new FragmentProfileManageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile_manage is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVERIFYPINSETTINGS: {
        if ("layout/fragment_verify_pin_settings_0".equals(tag)) {
          return new FragmentVerifyPinSettingsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_verify_pin_settings is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWALLPAPERPREVIEW: {
        if ("layout/fragment_wallpaper_preview_0".equals(tag)) {
          return new FragmentWallpaperPreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_wallpaper_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWIPECHATDATA: {
        if ("layout/fragment_wipe_chat_data_0".equals(tag)) {
          return new FragmentWipeChatDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_wipe_chat_data is invalid. Received: " + tag);
      }
      case  LAYOUT_IMPORTEXPORTDIALOGOPTION: {
        if ("layout/import_export_dialog_option_0".equals(tag)) {
          return new ImportExportDialogOptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for import_export_dialog_option is invalid. Received: " + tag);
      }
      case  LAYOUT_IMPORTFRAGMENT: {
        if ("layout/import_fragment_0".equals(tag)) {
          return new ImportFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for import_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_IMPORTLISTFRAGMENT: {
        if ("layout/import_list_fragment_0".equals(tag)) {
          return new ImportListFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for import_list_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMARCHIVE: {
        if ("layout/item_archive_0".equals(tag)) {
          return new ItemArchiveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_archive is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBLOCKLIST: {
        if ("layout/item_blocklist_0".equals(tag)) {
          return new ItemBlocklistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_blocklist is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHATS: {
        if ("layout/item_chats_0".equals(tag)) {
          return new ItemChatsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chats is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCONTACT: {
        if ("layout/item_contact_0".equals(tag)) {
          return new ItemContactBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_contact is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCONTACTVIEW: {
        if ("layout/item_contact_view_0".equals(tag)) {
          return new ItemContactViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_contact_view is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDOCUMENT: {
        if ("layout/item_document_0".equals(tag)) {
          return new ItemDocumentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_document is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFILES: {
        if ("layout/item_files_0".equals(tag)) {
          return new ItemFilesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_files is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFOLDERS: {
        if ("layout/item_folders_0".equals(tag)) {
          return new ItemFoldersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_folders is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMGROUPMEMBER: {
        if ("layout/item_group_member_0".equals(tag)) {
          return new ItemGroupMemberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_group_member is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGE: {
        if ("layout/item_image_0".equals(tag)) {
          return new ItemImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLINKS: {
        if ("layout/item_links_0".equals(tag)) {
          return new ItemLinksBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_links is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLISTFRAGMENT: {
        if ("layout/item_list_fragment_0".equals(tag)) {
          return new ItemListFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_list_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMEDIA: {
        if ("layout/item_media_0".equals(tag)) {
          return new ItemMediaBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_media is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMEMBER: {
        if ("layout/item_member_0".equals(tag)) {
          return new ItemMemberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_member is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGERECEIVE: {
        if ("layout/item_message_receive_0".equals(tag)) {
          return new ItemMessageReceiveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_receive is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGESENT: {
        if ("layout/item_message_sent_0".equals(tag)) {
          return new ItemMessageSentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message_sent is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSHARETOMEMBER: {
        if ("layout/item_shareto_member_0".equals(tag)) {
          return new ItemSharetoMemberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_shareto_member is invalid. Received: " + tag);
      }
      case  LAYOUT_LISTITEMCONTACTCHOICE: {
        if ("layout/list_item_contact_choice_0".equals(tag)) {
          return new ListItemContactChoiceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for list_item_contact_choice is invalid. Received: " + tag);
      }
      case  LAYOUT_NETWORKFRAGMENT: {
        if ("layout/network_fragment_0".equals(tag)) {
          return new NetworkFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for network_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_PRIVACYFRAGMENT: {
        if ("layout/privacy_fragment_0".equals(tag)) {
          return new PrivacyFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for privacy_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_SPLASHFRAGMENT: {
        if ("layout/splash_fragment_0".equals(tag)) {
          return new SplashFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for splash_fragment is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(87);

    static {
      sKeys.put("layout/activity_add_member_0", com.devbeans.io.chat.R.layout.activity_add_member);
      sKeys.put("layout/activity_archive_0", com.devbeans.io.chat.R.layout.activity_archive);
      sKeys.put("layout/activity_auto_lock_setting_0", com.devbeans.io.chat.R.layout.activity_auto_lock_setting);
      sKeys.put("layout/activity_chat_0", com.devbeans.io.chat.R.layout.activity_chat);
      sKeys.put("layout/activity_chat_details_0", com.devbeans.io.chat.R.layout.activity_chat_details);
      sKeys.put("layout/activity_chat_settings_0", com.devbeans.io.chat.R.layout.activity_chat_settings);
      sKeys.put("layout/activity_contact_detail_0", com.devbeans.io.chat.R.layout.activity_contact_detail);
      sKeys.put("layout/activity_details_edit_0", com.devbeans.io.chat.R.layout.activity_details_edit);
      sKeys.put("layout/activity_disappearing_msg_0", com.devbeans.io.chat.R.layout.activity_disappearing_msg);
      sKeys.put("layout/activity_edit_profile_0", com.devbeans.io.chat.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_import_export_0", com.devbeans.io.chat.R.layout.activity_import_export);
      sKeys.put("layout/activity_main_0", com.devbeans.io.chat.R.layout.activity_main);
      sKeys.put("layout/activity_media_details_0", com.devbeans.io.chat.R.layout.activity_media_details);
      sKeys.put("layout/activity_members_0", com.devbeans.io.chat.R.layout.activity_members);
      sKeys.put("layout/activity_message_details_0", com.devbeans.io.chat.R.layout.activity_message_details);
      sKeys.put("layout/activity_new_message_0", com.devbeans.io.chat.R.layout.activity_new_message);
      sKeys.put("layout/activity_notification_0", com.devbeans.io.chat.R.layout.activity_notification);
      sKeys.put("layout/activity_picture_preview_0", com.devbeans.io.chat.R.layout.activity_picture_preview);
      sKeys.put("layout/activity_privacy_0", com.devbeans.io.chat.R.layout.activity_privacy);
      sKeys.put("layout/activity_qrscanner_0", com.devbeans.io.chat.R.layout.activity_qrscanner);
      sKeys.put("layout/activity_remove_view_0", com.devbeans.io.chat.R.layout.activity_remove_view);
      sKeys.put("layout/activity_screen_showing_0", com.devbeans.io.chat.R.layout.activity_screen_showing);
      sKeys.put("layout/activity_share_to_0", com.devbeans.io.chat.R.layout.activity_share_to);
      sKeys.put("layout/activity_splash_0", com.devbeans.io.chat.R.layout.activity_splash);
      sKeys.put("layout/adjust_time_fragment_0", com.devbeans.io.chat.R.layout.adjust_time_fragment);
      sKeys.put("layout/attachement_sent_0", com.devbeans.io.chat.R.layout.attachement_sent);
      sKeys.put("layout/auto_lock_setting_fragment_0", com.devbeans.io.chat.R.layout.auto_lock_setting_fragment);
      sKeys.put("layout/blocked_contact_fragment_0", com.devbeans.io.chat.R.layout.blocked_contact_fragment);
      sKeys.put("layout/change_pin_timer_fragment_0", com.devbeans.io.chat.R.layout.change_pin_timer_fragment);
      sKeys.put("layout/chat_color_selection_adapter_item_0", com.devbeans.io.chat.R.layout.chat_color_selection_adapter_item);
      sKeys.put("layout/chat_wallpaper_selection_adapter_item_0", com.devbeans.io.chat.R.layout.chat_wallpaper_selection_adapter_item);
      sKeys.put("layout/confirm_pin_fragment_0", com.devbeans.io.chat.R.layout.confirm_pin_fragment);
      sKeys.put("layout/create_pin_fragment_0", com.devbeans.io.chat.R.layout.create_pin_fragment);
      sKeys.put("layout/custom_block_dailog_0", com.devbeans.io.chat.R.layout.custom_block_dailog);
      sKeys.put("layout/custom_dailog_add_contact_0", com.devbeans.io.chat.R.layout.custom_dailog_add_contact);
      sKeys.put("layout/custom_dailog_block_0", com.devbeans.io.chat.R.layout.custom_dailog_block);
      sKeys.put("layout/custom_dailog_new_contact_0", com.devbeans.io.chat.R.layout.custom_dailog_new_contact);
      sKeys.put("layout/custom_dailog_view_0", com.devbeans.io.chat.R.layout.custom_dailog_view);
      sKeys.put("layout/custom_delete_message_0", com.devbeans.io.chat.R.layout.custom_delete_message);
      sKeys.put("layout/custom_menu_0", com.devbeans.io.chat.R.layout.custom_menu);
      sKeys.put("layout/custom_nickname_dailog_0", com.devbeans.io.chat.R.layout.custom_nickname_dailog);
      sKeys.put("layout/custom_selector_dailog_0", com.devbeans.io.chat.R.layout.custom_selector_dailog);
      sKeys.put("layout/custom_update_nickname_dailog_0", com.devbeans.io.chat.R.layout.custom_update_nickname_dailog);
      sKeys.put("layout/disappearing_fragment_0", com.devbeans.io.chat.R.layout.disappearing_fragment);
      sKeys.put("layout/export_fragment_0", com.devbeans.io.chat.R.layout.export_fragment);
      sKeys.put("layout/fragment_agreement_wipe_0", com.devbeans.io.chat.R.layout.fragment_agreement_wipe);
      sKeys.put("layout/fragment_bottom_sheet_contact_choice_0", com.devbeans.io.chat.R.layout.fragment_bottom_sheet_contact_choice);
      sKeys.put("layout/fragment_chat_settings_0", com.devbeans.io.chat.R.layout.fragment_chat_settings);
      sKeys.put("layout/fragment_chat_wallpaper_0", com.devbeans.io.chat.R.layout.fragment_chat_wallpaper);
      sKeys.put("layout/fragment_contacts_0", com.devbeans.io.chat.R.layout.fragment_contacts);
      sKeys.put("layout/fragment_delete_0", com.devbeans.io.chat.R.layout.fragment_delete);
      sKeys.put("layout/fragment_docs_0", com.devbeans.io.chat.R.layout.fragment_docs);
      sKeys.put("layout/fragment_file_storage_0", com.devbeans.io.chat.R.layout.fragment_file_storage);
      sKeys.put("layout/fragment_files_0", com.devbeans.io.chat.R.layout.fragment_files);
      sKeys.put("layout/fragment_folders_0", com.devbeans.io.chat.R.layout.fragment_folders);
      sKeys.put("layout/fragment_home_0", com.devbeans.io.chat.R.layout.fragment_home);
      sKeys.put("layout/fragment_import_export_0", com.devbeans.io.chat.R.layout.fragment_import_export);
      sKeys.put("layout/fragment_links_0", com.devbeans.io.chat.R.layout.fragment_links);
      sKeys.put("layout/fragment_media_0", com.devbeans.io.chat.R.layout.fragment_media);
      sKeys.put("layout/fragment_profile_manage_0", com.devbeans.io.chat.R.layout.fragment_profile_manage);
      sKeys.put("layout/fragment_verify_pin_settings_0", com.devbeans.io.chat.R.layout.fragment_verify_pin_settings);
      sKeys.put("layout/fragment_wallpaper_preview_0", com.devbeans.io.chat.R.layout.fragment_wallpaper_preview);
      sKeys.put("layout/fragment_wipe_chat_data_0", com.devbeans.io.chat.R.layout.fragment_wipe_chat_data);
      sKeys.put("layout/import_export_dialog_option_0", com.devbeans.io.chat.R.layout.import_export_dialog_option);
      sKeys.put("layout/import_fragment_0", com.devbeans.io.chat.R.layout.import_fragment);
      sKeys.put("layout/import_list_fragment_0", com.devbeans.io.chat.R.layout.import_list_fragment);
      sKeys.put("layout/item_archive_0", com.devbeans.io.chat.R.layout.item_archive);
      sKeys.put("layout/item_blocklist_0", com.devbeans.io.chat.R.layout.item_blocklist);
      sKeys.put("layout/item_chats_0", com.devbeans.io.chat.R.layout.item_chats);
      sKeys.put("layout/item_contact_0", com.devbeans.io.chat.R.layout.item_contact);
      sKeys.put("layout/item_contact_view_0", com.devbeans.io.chat.R.layout.item_contact_view);
      sKeys.put("layout/item_document_0", com.devbeans.io.chat.R.layout.item_document);
      sKeys.put("layout/item_files_0", com.devbeans.io.chat.R.layout.item_files);
      sKeys.put("layout/item_folders_0", com.devbeans.io.chat.R.layout.item_folders);
      sKeys.put("layout/item_group_member_0", com.devbeans.io.chat.R.layout.item_group_member);
      sKeys.put("layout/item_image_0", com.devbeans.io.chat.R.layout.item_image);
      sKeys.put("layout/item_links_0", com.devbeans.io.chat.R.layout.item_links);
      sKeys.put("layout/item_list_fragment_0", com.devbeans.io.chat.R.layout.item_list_fragment);
      sKeys.put("layout/item_media_0", com.devbeans.io.chat.R.layout.item_media);
      sKeys.put("layout/item_member_0", com.devbeans.io.chat.R.layout.item_member);
      sKeys.put("layout/item_message_receive_0", com.devbeans.io.chat.R.layout.item_message_receive);
      sKeys.put("layout/item_message_sent_0", com.devbeans.io.chat.R.layout.item_message_sent);
      sKeys.put("layout/item_shareto_member_0", com.devbeans.io.chat.R.layout.item_shareto_member);
      sKeys.put("layout/list_item_contact_choice_0", com.devbeans.io.chat.R.layout.list_item_contact_choice);
      sKeys.put("layout/network_fragment_0", com.devbeans.io.chat.R.layout.network_fragment);
      sKeys.put("layout/privacy_fragment_0", com.devbeans.io.chat.R.layout.privacy_fragment);
      sKeys.put("layout/splash_fragment_0", com.devbeans.io.chat.R.layout.splash_fragment);
    }
  }
}
