package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChatBindingImpl extends ActivityChatBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.reactions_shade, 3);
        sViewsWithIds.put(R.id.tvSubs, 4);
        sViewsWithIds.put(R.id.appbar, 5);
        sViewsWithIds.put(R.id.toolbar, 6);
        sViewsWithIds.put(R.id.layout_toolbar, 7);
        sViewsWithIds.put(R.id.iv_chat_image, 8);
        sViewsWithIds.put(R.id.iv_disappear_icon, 9);
        sViewsWithIds.put(R.id.tv_name, 10);
        sViewsWithIds.put(R.id.groupMembers, 11);
        sViewsWithIds.put(R.id.iv_share, 12);
        sViewsWithIds.put(R.id.iv_delete, 13);
        sViewsWithIds.put(R.id.iv_copy, 14);
        sViewsWithIds.put(R.id.iv_edit, 15);
        sViewsWithIds.put(R.id.btn_add_contact, 16);
        sViewsWithIds.put(R.id.iv_menu, 17);
        sViewsWithIds.put(R.id.rootView, 18);
        sViewsWithIds.put(R.id.messagesList, 19);
        sViewsWithIds.put(R.id.constraintLayout, 20);
        sViewsWithIds.put(R.id.top, 21);
        sViewsWithIds.put(R.id.tv_title, 22);
        sViewsWithIds.put(R.id.linearLayout, 23);
        sViewsWithIds.put(R.id.layout_image, 24);
        sViewsWithIds.put(R.id.tv_images, 25);
        sViewsWithIds.put(R.id.layout_audio, 26);
        sViewsWithIds.put(R.id.tv_audio, 27);
        sViewsWithIds.put(R.id.layout_video, 28);
        sViewsWithIds.put(R.id.tv_video, 29);
        sViewsWithIds.put(R.id.layout_files, 30);
        sViewsWithIds.put(R.id.tv_files, 31);
        sViewsWithIds.put(R.id.tv_can_not_send, 32);
        sViewsWithIds.put(R.id.input, 33);
        sViewsWithIds.put(R.id.iv_emoji, 34);
        sViewsWithIds.put(R.id.fab_sendMessage, 35);
        sViewsWithIds.put(R.id.conversation_reaction_scrubber_stub, 36);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChatBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }
    private ActivityChatBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[5]
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , new androidx.databinding.ViewStubProxy((android.view.ViewStub) bindings[36])
            , (android.widget.ImageButton) bindings[35]
            , (android.widget.TextView) bindings[11]
            , (com.devbeans.io.chat.utils.views.MessageInputChat) bindings[33]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[8]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageButton) bindings[34]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.LinearLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[23]
            , (com.devbeans.io.chat.adapters.viewholders.ChatMessagesList) bindings[19]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.FrameLayout) bindings[3]
            , (com.devbeans.io.chat.utils.views.MicrophoneRecorderView) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (androidx.appcompat.widget.Toolbar) bindings[6]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[29]
            );
        this.conversationReactionScrubberStub.setContainingBinding(this);
        this.layoutMessage.setTag(null);
        this.nestedScrollView.setTag(null);
        this.recorderView.setTag(null);
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
        if (conversationReactionScrubberStub.getBinding() != null) {
            executeBindingsOn(conversationReactionScrubberStub.getBinding());
        }
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