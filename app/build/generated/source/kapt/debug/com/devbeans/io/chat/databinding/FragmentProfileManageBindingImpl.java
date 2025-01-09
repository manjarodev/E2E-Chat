package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileManageBindingImpl extends FragmentProfileManageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.tvTitleToolbar, 2);
        sViewsWithIds.put(R.id.layout_user_info, 3);
        sViewsWithIds.put(R.id.iv_account_mbl, 4);
        sViewsWithIds.put(R.id.tv_label, 5);
        sViewsWithIds.put(R.id.tv_userId, 6);
        sViewsWithIds.put(R.id.iv_edit, 7);
        sViewsWithIds.put(R.id.tv_label_nickname, 8);
        sViewsWithIds.put(R.id.iv_circular_profile_new, 9);
        sViewsWithIds.put(R.id.iv_camera, 10);
        sViewsWithIds.put(R.id.tv_nickname, 11);
        sViewsWithIds.put(R.id.iv_edit_new, 12);
        sViewsWithIds.put(R.id.separator, 13);
        sViewsWithIds.put(R.id.layout_notification_settings, 14);
        sViewsWithIds.put(R.id.tv_notification_settings, 15);
        sViewsWithIds.put(R.id.layout_blocked_contacts, 16);
        sViewsWithIds.put(R.id.tv_block_contacts, 17);
        sViewsWithIds.put(R.id.layout_auto_lock_settings, 18);
        sViewsWithIds.put(R.id.tv_auto_lock_settings, 19);
        sViewsWithIds.put(R.id.settingsRecycler, 20);
        sViewsWithIds.put(R.id.space, 21);
        sViewsWithIds.put(R.id.tv_version, 22);
        sViewsWithIds.put(R.id.space1, 23);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileManageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private FragmentProfileManageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[10]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[9]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.view.View) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (android.widget.Space) bindings[21]
            , (android.widget.Space) bindings[23]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[22]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
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