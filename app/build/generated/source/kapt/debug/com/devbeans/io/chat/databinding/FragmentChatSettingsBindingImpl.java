package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChatSettingsBindingImpl extends FragmentChatSettingsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.scrollView, 2);
        sViewsWithIds.put(R.id.fragment_container_view_settings, 3);
        sViewsWithIds.put(R.id.tv_appearance, 4);
        sViewsWithIds.put(R.id.layout_theme, 5);
        sViewsWithIds.put(R.id.tv_theme, 6);
        sViewsWithIds.put(R.id.tv_theme_note, 7);
        sViewsWithIds.put(R.id.separator_1, 8);
        sViewsWithIds.put(R.id.layout_wallpaper_color, 9);
        sViewsWithIds.put(R.id.tv_wallpaper_color, 10);
        sViewsWithIds.put(R.id.tv_wallpaper_color_note, 11);
        sViewsWithIds.put(R.id.separator_2, 12);
        sViewsWithIds.put(R.id.layout_font_emoji, 13);
        sViewsWithIds.put(R.id.tv_font_emoji, 14);
        sViewsWithIds.put(R.id.tv_font_emoji_note, 15);
        sViewsWithIds.put(R.id.tv_chat_settings, 16);
        sViewsWithIds.put(R.id.tv_enter_to_send_messages, 17);
        sViewsWithIds.put(R.id.check_enter_to_send_messages, 18);
        sViewsWithIds.put(R.id.tv_enter_to_send_messages_note, 19);
        sViewsWithIds.put(R.id.separator_3, 20);
        sViewsWithIds.put(R.id.tv_show_typing_indicator, 21);
        sViewsWithIds.put(R.id.check_show_typing_indicator, 22);
        sViewsWithIds.put(R.id.tv_show_typing_indicator_note, 23);
        sViewsWithIds.put(R.id.separator_4, 24);
        sViewsWithIds.put(R.id.tv_read_receipts_heading, 25);
        sViewsWithIds.put(R.id.tv_read_receipts, 26);
        sViewsWithIds.put(R.id.check_read_receipts, 27);
        sViewsWithIds.put(R.id.tv_read_receipts_note, 28);
        sViewsWithIds.put(R.id.separator_5, 29);
        sViewsWithIds.put(R.id.tv_read_receipts_unknown, 30);
        sViewsWithIds.put(R.id.check_read_receipts_unknown, 31);
        sViewsWithIds.put(R.id.tv_read_receipts_note_unknown, 32);
        sViewsWithIds.put(R.id.separator_8, 33);
        sViewsWithIds.put(R.id.tv_read_receipts_privacy, 34);
        sViewsWithIds.put(R.id.check_read_receipts_privacy, 35);
        sViewsWithIds.put(R.id.tv_read_receipts_note_privacy, 36);
        sViewsWithIds.put(R.id.separator_9, 37);
        sViewsWithIds.put(R.id.layout_keep_chat, 38);
        sViewsWithIds.put(R.id.tv_keep_chat, 39);
        sViewsWithIds.put(R.id.tv_keep_chat_note, 40);
        sViewsWithIds.put(R.id.separator_6, 41);
        sViewsWithIds.put(R.id.layout_app_language, 42);
        sViewsWithIds.put(R.id.tv_app_language, 43);
        sViewsWithIds.put(R.id.tv_app_language_note, 44);
        sViewsWithIds.put(R.id.separator_7, 45);
        sViewsWithIds.put(R.id.layout_import_export, 46);
        sViewsWithIds.put(R.id.tv_import_export, 47);
        sViewsWithIds.put(R.id.tv_import_export_note, 48);
        sViewsWithIds.put(R.id.separator_12, 49);
        sViewsWithIds.put(R.id.layout_history, 50);
        sViewsWithIds.put(R.id.iv_icon, 51);
        sViewsWithIds.put(R.id.tv_heading, 52);
        sViewsWithIds.put(R.id.tv_message, 53);
        sViewsWithIds.put(R.id.lvWipe, 54);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentChatSettingsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 55, sIncludes, sViewsWithIds));
    }
    private FragmentChatSettingsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.SwitchCompat) bindings[18]
            , (androidx.appcompat.widget.SwitchCompat) bindings[27]
            , (androidx.appcompat.widget.SwitchCompat) bindings[35]
            , (androidx.appcompat.widget.SwitchCompat) bindings[31]
            , (androidx.appcompat.widget.SwitchCompat) bindings[22]
            , (androidx.fragment.app.FragmentContainerView) bindings[3]
            , (android.widget.ImageView) bindings[51]
            , (android.widget.LinearLayout) bindings[42]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[50]
            , (android.widget.LinearLayout) bindings[46]
            , (android.widget.LinearLayout) bindings[38]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[54]
            , (android.widget.ScrollView) bindings[2]
            , (android.view.View) bindings[8]
            , (android.view.View) bindings[49]
            , (android.view.View) bindings[12]
            , (android.view.View) bindings[20]
            , (android.view.View) bindings[24]
            , (android.view.View) bindings[29]
            , (android.view.View) bindings[41]
            , (android.view.View) bindings[45]
            , (android.view.View) bindings[33]
            , (android.view.View) bindings[37]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[52]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[53]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
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