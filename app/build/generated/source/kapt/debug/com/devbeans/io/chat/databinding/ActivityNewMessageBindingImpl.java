package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNewMessageBindingImpl extends ActivityNewMessageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvSubs, 1);
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.cancel, 3);
        sViewsWithIds.put(R.id.iv_back, 4);
        sViewsWithIds.put(R.id.title_toolbar, 5);
        sViewsWithIds.put(R.id.tv_total_count, 6);
        sViewsWithIds.put(R.id.layout_create_group, 7);
        sViewsWithIds.put(R.id.iv_group_image, 8);
        sViewsWithIds.put(R.id.et_group_name, 9);
        sViewsWithIds.put(R.id.tv_title_count, 10);
        sViewsWithIds.put(R.id.layout_disappear, 11);
        sViewsWithIds.put(R.id.tv_disappear_option, 12);
        sViewsWithIds.put(R.id.tv_indicator_group_title, 13);
        sViewsWithIds.put(R.id.layout_top, 14);
        sViewsWithIds.put(R.id.search_bar, 15);
        sViewsWithIds.put(R.id.add_contact_layout, 16);
        sViewsWithIds.put(R.id.iv_contact, 17);
        sViewsWithIds.put(R.id.tv_new_contact, 18);
        sViewsWithIds.put(R.id.iv_qr, 19);
        sViewsWithIds.put(R.id.layout_new_group, 20);
        sViewsWithIds.put(R.id.iv_group, 21);
        sViewsWithIds.put(R.id.tv_new_group, 22);
        sViewsWithIds.put(R.id.layout_new_anonymous_group, 23);
        sViewsWithIds.put(R.id.iv_group_anonymous, 24);
        sViewsWithIds.put(R.id.tv_new_group_anonymous, 25);
        sViewsWithIds.put(R.id.layout_rv, 26);
        sViewsWithIds.put(R.id.layout_member, 27);
        sViewsWithIds.put(R.id.tv_members, 28);
        sViewsWithIds.put(R.id.rv_members, 29);
        sViewsWithIds.put(R.id.layout_contacts, 30);
        sViewsWithIds.put(R.id.tv_contacts, 31);
        sViewsWithIds.put(R.id.rv_contacts, 32);
        sViewsWithIds.put(R.id.layout_button, 33);
        sViewsWithIds.put(R.id.btn_create_group, 34);
        sViewsWithIds.put(R.id.confirm_create_group, 35);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNewMessageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 36, sIncludes, sViewsWithIds));
    }
    private ActivityNewMessageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (androidx.appcompat.widget.AppCompatButton) bindings[34]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatButton) bindings[35]
            , (android.widget.EditText) bindings[9]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[24]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[8]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.LinearLayout) bindings[33]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[30]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[27]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[23]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[32]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (android.widget.EditText) bindings[15]
            , (android.widget.TextView) bindings[5]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[12]
            , (android.view.View) bindings[13]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[6]
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