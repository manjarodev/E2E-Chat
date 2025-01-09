package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChatDetailsBindingImpl extends ActivityChatDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvSubs, 1);
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.iv_edit, 3);
        sViewsWithIds.put(R.id.scrollView, 4);
        sViewsWithIds.put(R.id.iv_chat_image, 5);
        sViewsWithIds.put(R.id.layout_chat_name, 6);
        sViewsWithIds.put(R.id.layout_chat_name_edit, 7);
        sViewsWithIds.put(R.id.tv_chat_name, 8);
        sViewsWithIds.put(R.id.iv_edit_nick_name, 9);
        sViewsWithIds.put(R.id.tv_chat_id, 10);
        sViewsWithIds.put(R.id.tv_description, 11);
        sViewsWithIds.put(R.id.space, 12);
        sViewsWithIds.put(R.id.separator, 13);
        sViewsWithIds.put(R.id.Media_docs_links_layout, 14);
        sViewsWithIds.put(R.id.title_media_docs_links, 15);
        sViewsWithIds.put(R.id.tv_media_count, 16);
        sViewsWithIds.put(R.id.iv_forward, 17);
        sViewsWithIds.put(R.id.rv_images, 18);
        sViewsWithIds.put(R.id.separator_dis, 19);
        sViewsWithIds.put(R.id.iv_disappear, 20);
        sViewsWithIds.put(R.id.title_disappear, 21);
        sViewsWithIds.put(R.id.disappear_option, 22);
        sViewsWithIds.put(R.id.separator_1, 23);
        sViewsWithIds.put(R.id.iv_read_receipts, 24);
        sViewsWithIds.put(R.id.tv_read_receipts, 25);
        sViewsWithIds.put(R.id.check_read_receipts, 26);
        sViewsWithIds.put(R.id.tv_read_receipts_note, 27);
        sViewsWithIds.put(R.id.seperator_12, 28);
        sViewsWithIds.put(R.id.layout_settings, 29);
        sViewsWithIds.put(R.id.tv_notification_settings, 30);
        sViewsWithIds.put(R.id.tv_chat_color_wallpaper, 31);
        sViewsWithIds.put(R.id.iv_vault_save, 32);
        sViewsWithIds.put(R.id.tv_auto_save_vault, 33);
        sViewsWithIds.put(R.id.check_auto_save, 34);
        sViewsWithIds.put(R.id.tv_auto_save_vault_note, 35);
        sViewsWithIds.put(R.id.seperator_9, 36);
        sViewsWithIds.put(R.id.iv_media_sharing, 37);
        sViewsWithIds.put(R.id.tv_media_sharing, 38);
        sViewsWithIds.put(R.id.check_media_sharing, 39);
        sViewsWithIds.put(R.id.tv_media_sharing_note, 40);
        sViewsWithIds.put(R.id.seperator_10, 41);
        sViewsWithIds.put(R.id.iv_message_confidential, 42);
        sViewsWithIds.put(R.id.tv_message_confidential, 43);
        sViewsWithIds.put(R.id.check_message_confidential, 44);
        sViewsWithIds.put(R.id.tv_message_confidential_note, 45);
        sViewsWithIds.put(R.id.seperator_13, 46);
        sViewsWithIds.put(R.id.iv_media_visibility, 47);
        sViewsWithIds.put(R.id.tv_media_visibility, 48);
        sViewsWithIds.put(R.id.check_media_visibility, 49);
        sViewsWithIds.put(R.id.tv_media_visibility_note, 50);
        sViewsWithIds.put(R.id.seperator_11, 51);
        sViewsWithIds.put(R.id.tv_clear_chat_layout, 52);
        sViewsWithIds.put(R.id.tv_clear_chat, 53);
        sViewsWithIds.put(R.id.layout_group_members, 54);
        sViewsWithIds.put(R.id.title_group_members, 55);
        sViewsWithIds.put(R.id.tv_group_created_at, 56);
        sViewsWithIds.put(R.id.add_members_layout, 57);
        sViewsWithIds.put(R.id.iv_add, 58);
        sViewsWithIds.put(R.id.tv_new_contact, 59);
        sViewsWithIds.put(R.id.rv_members, 60);
        sViewsWithIds.put(R.id.tv_total, 61);
        sViewsWithIds.put(R.id.tv_total_count, 62);
        sViewsWithIds.put(R.id.separator_2, 63);
        sViewsWithIds.put(R.id.tv_clear_group_layout, 64);
        sViewsWithIds.put(R.id.tv_clear_group, 65);
        sViewsWithIds.put(R.id.tv_destroy_group, 66);
        sViewsWithIds.put(R.id.tv_leave_group, 67);
        sViewsWithIds.put(R.id.iv_delete, 68);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChatDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 69, sIncludes, sViewsWithIds));
    }
    private ActivityChatDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[57]
            , (androidx.appcompat.widget.SwitchCompat) bindings[34]
            , (androidx.appcompat.widget.SwitchCompat) bindings[39]
            , (androidx.appcompat.widget.SwitchCompat) bindings[49]
            , (androidx.appcompat.widget.SwitchCompat) bindings[44]
            , (androidx.appcompat.widget.SwitchCompat) bindings[26]
            , (android.widget.TextView) bindings[22]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[58]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            , (android.widget.ImageView) bindings[68]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[47]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[54]
            , (android.widget.LinearLayout) bindings[29]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[60]
            , (android.widget.ScrollView) bindings[4]
            , (android.view.View) bindings[13]
            , (android.view.View) bindings[23]
            , (android.view.View) bindings[63]
            , (android.view.View) bindings[19]
            , (android.view.View) bindings[41]
            , (android.view.View) bindings[51]
            , (android.view.View) bindings[28]
            , (android.view.View) bindings[46]
            , (android.view.View) bindings[36]
            , (android.view.View) bindings[12]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[55]
            , (android.widget.TextView) bindings[15]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatButton) bindings[53]
            , (android.widget.LinearLayout) bindings[52]
            , (androidx.appcompat.widget.AppCompatButton) bindings[65]
            , (android.widget.LinearLayout) bindings[64]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[66]
            , (android.widget.TextView) bindings[56]
            , (android.widget.TextView) bindings[67]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[50]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[59]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[61]
            , (android.widget.TextView) bindings[62]
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