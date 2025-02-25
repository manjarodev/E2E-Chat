package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemArchiveBindingImpl extends ItemArchiveBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rowBGRight, 1);
        sViewsWithIds.put(R.id.delete_task, 2);
        sViewsWithIds.put(R.id.img_delete, 3);
        sViewsWithIds.put(R.id.archive_task, 4);
        sViewsWithIds.put(R.id.img_archive, 5);
        sViewsWithIds.put(R.id.rowBGLeft, 6);
        sViewsWithIds.put(R.id.pin_task, 7);
        sViewsWithIds.put(R.id.img_pin, 8);
        sViewsWithIds.put(R.id.rowFG, 9);
        sViewsWithIds.put(R.id.iv_chat_image, 10);
        sViewsWithIds.put(R.id.iv_disappear_icon, 11);
        sViewsWithIds.put(R.id.tv_chat_name, 12);
        sViewsWithIds.put(R.id.tv_time, 13);
        sViewsWithIds.put(R.id.tv_last_message, 14);
        sViewsWithIds.put(R.id.messageCount, 15);
        sViewsWithIds.put(R.id.iv_pin, 16);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemArchiveBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ItemArchiveBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[8]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[10]
            , (android.widget.ImageView) bindings[11]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[16]
            , (android.widget.TextView) bindings[15]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (com.vanniktech.emoji.EmojiTextView) bindings[14]
            , (android.widget.TextView) bindings[13]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
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