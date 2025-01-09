package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PrivacyFragmentBindingImpl extends PrivacyFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_confidential_message, 1);
        sViewsWithIds.put(R.id.check_confidential_message, 2);
        sViewsWithIds.put(R.id.tv_confidential_message_note, 3);
        sViewsWithIds.put(R.id.separator_1, 4);
        sViewsWithIds.put(R.id.tv_disappearing_message, 5);
        sViewsWithIds.put(R.id.options_message, 6);
        sViewsWithIds.put(R.id.tv_disappearing_message_note, 7);
        sViewsWithIds.put(R.id.separator_2, 8);
        sViewsWithIds.put(R.id.tv_hide_sensitive_message_preview, 9);
        sViewsWithIds.put(R.id.check_hide_sensitive_message, 10);
        sViewsWithIds.put(R.id.tv_hide_sensitive_message_preview_note, 11);
        sViewsWithIds.put(R.id.separator_3, 12);
        sViewsWithIds.put(R.id.tv_media_share_restrict, 13);
        sViewsWithIds.put(R.id.check_media_share_restrict, 14);
        sViewsWithIds.put(R.id.tv_media_share_restrict_note, 15);
        sViewsWithIds.put(R.id.separator_12, 16);
        sViewsWithIds.put(R.id.tv_block_unknown_contacts, 17);
        sViewsWithIds.put(R.id.check_block_unknown_contacts, 18);
        sViewsWithIds.put(R.id.tv_block_unknown_contacts_note, 19);
        sViewsWithIds.put(R.id.separator_4, 20);
        sViewsWithIds.put(R.id.layout_blocked_contacts, 21);
        sViewsWithIds.put(R.id.tv_blocked_contacts, 22);
        sViewsWithIds.put(R.id.tv_blocked_contacts_count, 23);
        sViewsWithIds.put(R.id.separator_11, 24);
        sViewsWithIds.put(R.id.tv_private_clipboard, 25);
        sViewsWithIds.put(R.id.check_private_clipboard, 26);
        sViewsWithIds.put(R.id.tv_private_clipboard_note, 27);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat_title, 28);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat, 29);
        sViewsWithIds.put(R.id.check_hide_sensitive_chat, 30);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat_note, 31);
        sViewsWithIds.put(R.id.separator_7, 32);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat_direct, 33);
        sViewsWithIds.put(R.id.check_hide_sensitive_chat_direct, 34);
        sViewsWithIds.put(R.id.separator_8, 35);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat_group, 36);
        sViewsWithIds.put(R.id.check_hide_sensitive_chat_group, 37);
        sViewsWithIds.put(R.id.separator_9, 38);
        sViewsWithIds.put(R.id.tv_hide_sensitive_chat_anonymous_group, 39);
        sViewsWithIds.put(R.id.check_hide_sensitive_chat_anonymous_group, 40);
        sViewsWithIds.put(R.id.separator_10, 41);
        sViewsWithIds.put(R.id.tv_media_settings, 42);
        sViewsWithIds.put(R.id.tv_auto_download, 43);
        sViewsWithIds.put(R.id.check_auto_save, 44);
        sViewsWithIds.put(R.id.tv_auto_save_note, 45);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PrivacyFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 46, sIncludes, sViewsWithIds));
    }
    private PrivacyFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.SwitchCompat) bindings[44]
            , (androidx.appcompat.widget.SwitchCompat) bindings[18]
            , (androidx.appcompat.widget.SwitchCompat) bindings[2]
            , (androidx.appcompat.widget.SwitchCompat) bindings[30]
            , (androidx.appcompat.widget.SwitchCompat) bindings[40]
            , (androidx.appcompat.widget.SwitchCompat) bindings[34]
            , (androidx.appcompat.widget.SwitchCompat) bindings[37]
            , (androidx.appcompat.widget.SwitchCompat) bindings[10]
            , (androidx.appcompat.widget.SwitchCompat) bindings[14]
            , (androidx.appcompat.widget.SwitchCompat) bindings[26]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.TextView) bindings[6]
            , (android.view.View) bindings[4]
            , (android.view.View) bindings[41]
            , (android.view.View) bindings[24]
            , (android.view.View) bindings[16]
            , (android.view.View) bindings[8]
            , (android.view.View) bindings[12]
            , (android.view.View) bindings[20]
            , (android.view.View) bindings[32]
            , (android.view.View) bindings[35]
            , (android.view.View) bindings[38]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[42]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[27]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}