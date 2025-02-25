package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRemoveViewBindingImpl extends ActivityRemoveViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvSubs, 1);
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.scrollView, 3);
        sViewsWithIds.put(R.id.iv_chat_image, 4);
        sViewsWithIds.put(R.id.layout_chat_name, 5);
        sViewsWithIds.put(R.id.layout_chat_name_edit, 6);
        sViewsWithIds.put(R.id.tv_chat_name, 7);
        sViewsWithIds.put(R.id.iv_edit_nick_name, 8);
        sViewsWithIds.put(R.id.tv_chat_id, 9);
        sViewsWithIds.put(R.id.tv_start_conversation, 10);
        sViewsWithIds.put(R.id.tv_add_contact, 11);
        sViewsWithIds.put(R.id.separator, 12);
        sViewsWithIds.put(R.id.Media_docs_links_layout, 13);
        sViewsWithIds.put(R.id.title_media_docs_links, 14);
        sViewsWithIds.put(R.id.tv_media_count, 15);
        sViewsWithIds.put(R.id.iv_forward, 16);
        sViewsWithIds.put(R.id.rv_images, 17);
        sViewsWithIds.put(R.id.separator_dis, 18);
        sViewsWithIds.put(R.id.iv_disappear, 19);
        sViewsWithIds.put(R.id.title_disappear, 20);
        sViewsWithIds.put(R.id.disappear_option, 21);
        sViewsWithIds.put(R.id.separator_1, 22);
        sViewsWithIds.put(R.id.tv_remove_member, 23);
        sViewsWithIds.put(R.id.tv_block, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRemoveViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityRemoveViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (android.widget.TextView) bindings[21]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (android.widget.ScrollView) bindings[3]
            , (android.view.View) bindings[12]
            , (android.view.View) bindings[22]
            , (android.view.View) bindings[18]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[14]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[1]
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