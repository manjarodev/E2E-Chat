package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMessageDetailsBindingImpl extends ActivityMessageDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvSubs, 1);
        sViewsWithIds.put(R.id.appbar, 2);
        sViewsWithIds.put(R.id.toolbar, 3);
        sViewsWithIds.put(R.id.layout_toolbar, 4);
        sViewsWithIds.put(R.id.iv_chat_image, 5);
        sViewsWithIds.put(R.id.iv_disappear_icon, 6);
        sViewsWithIds.put(R.id.tv_name, 7);
        sViewsWithIds.put(R.id.groupMembers, 8);
        sViewsWithIds.put(R.id.iv_share, 9);
        sViewsWithIds.put(R.id.iv_delete, 10);
        sViewsWithIds.put(R.id.iv_copy, 11);
        sViewsWithIds.put(R.id.iv_edit, 12);
        sViewsWithIds.put(R.id.btn_add_contact, 13);
        sViewsWithIds.put(R.id.iv_menu, 14);
        sViewsWithIds.put(R.id.main_layout, 15);
        sViewsWithIds.put(R.id.confidential_messageText, 16);
        sViewsWithIds.put(R.id.confidential_frame_layout, 17);
        sViewsWithIds.put(R.id.download, 18);
        sViewsWithIds.put(R.id.tv_size, 19);
        sViewsWithIds.put(R.id.loading, 20);
        sViewsWithIds.put(R.id.tvTapToReveal, 21);
        sViewsWithIds.put(R.id.space, 22);
        sViewsWithIds.put(R.id.activity_main_pdf_view, 23);
        sViewsWithIds.put(R.id.tvTapToRevealPDF, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMessageDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityMessageDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.pdfview.PDFView) bindings[23]
            , (com.google.android.material.appbar.AppBarLayout) bindings[2]
            , (androidx.appcompat.widget.AppCompatButton) bindings[13]
            , (android.widget.FrameLayout) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.TextView) bindings[8]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (android.widget.ProgressBar) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (android.widget.Space) bindings[22]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[24]
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