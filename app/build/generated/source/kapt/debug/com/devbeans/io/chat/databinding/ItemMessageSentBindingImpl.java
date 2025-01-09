package com.devbeans.io.chat.databinding;
import com.devbeans.io.chat.R;
import com.devbeans.io.chat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemMessageSentBindingImpl extends ItemMessageSentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_sendingTextMessageLayout, 1);
        sViewsWithIds.put(R.id.text_outgoing_layout_bubble_text, 2);
        sViewsWithIds.put(R.id.text_time_and_tick_layout, 3);
        sViewsWithIds.put(R.id.text_textview_time, 4);
        sViewsWithIds.put(R.id.text_text_sendTick, 5);
        sViewsWithIds.put(R.id.text_sentTxt, 6);
        sViewsWithIds.put(R.id.image_sendingImageMessageLayout, 7);
        sViewsWithIds.put(R.id.image_outgoing_image_layout_bubble, 8);
        sViewsWithIds.put(R.id.image_layout_forwarded, 9);
        sViewsWithIds.put(R.id.image_iv_forwarded, 10);
        sViewsWithIds.put(R.id.image_tv_forwarded, 11);
        sViewsWithIds.put(R.id.image_time_and_tick_layout_image, 12);
        sViewsWithIds.put(R.id.image_textview_time_image, 13);
        sViewsWithIds.put(R.id.image_text_sendTick_image, 14);
        sViewsWithIds.put(R.id.image_sentImage, 15);
        sViewsWithIds.put(R.id.image_sentTxt_image, 16);
        sViewsWithIds.put(R.id.image_iv_share, 17);
        sViewsWithIds.put(R.id.video_sendingImageMessageLayout_video, 18);
        sViewsWithIds.put(R.id.video_outgoing_image_layout_bubble_video, 19);
        sViewsWithIds.put(R.id.video_layout_forwarded_video, 20);
        sViewsWithIds.put(R.id.video_iv_forwarded_video, 21);
        sViewsWithIds.put(R.id.video_tv_forwarded_video, 22);
        sViewsWithIds.put(R.id.video_time_and_tick_layout_video, 23);
        sViewsWithIds.put(R.id.video_textview_time_sent_video, 24);
        sViewsWithIds.put(R.id.video_text_sendTick_video, 25);
        sViewsWithIds.put(R.id.video_video_time, 26);
        sViewsWithIds.put(R.id.video_iv_video, 27);
        sViewsWithIds.put(R.id.video_textview_time_video, 28);
        sViewsWithIds.put(R.id.video_sentImage_video, 29);
        sViewsWithIds.put(R.id.video_sentTxt_video, 30);
        sViewsWithIds.put(R.id.video_iv_share_video, 31);
        sViewsWithIds.put(R.id.audio_sendingTextMessageLayout_audio, 32);
        sViewsWithIds.put(R.id.audio_outgoing_layout_bubble_audio, 33);
        sViewsWithIds.put(R.id.audio_time_and_tick_layout_audio, 34);
        sViewsWithIds.put(R.id.audio_textview_time_audio, 35);
        sViewsWithIds.put(R.id.audio_text_sendTick_audio, 36);
        sViewsWithIds.put(R.id.audio_tv_audio_time, 37);
        sViewsWithIds.put(R.id.audio_cv_file_audio, 38);
        sViewsWithIds.put(R.id.audio_iv_file_play_pause, 39);
        sViewsWithIds.put(R.id.audio_seekBar_audio, 40);
        sViewsWithIds.put(R.id.file_sendingTextMessageLayout_file, 41);
        sViewsWithIds.put(R.id.file_outgoing_layout_bubble, 42);
        sViewsWithIds.put(R.id.file_time_and_tick_layout_file, 43);
        sViewsWithIds.put(R.id.file_textview_time_file, 44);
        sViewsWithIds.put(R.id.file_text_sendTick_file, 45);
        sViewsWithIds.put(R.id.file_cv_file, 46);
        sViewsWithIds.put(R.id.file_iv_file, 47);
        sViewsWithIds.put(R.id.file_tv_file_name, 48);
        sViewsWithIds.put(R.id.file_tv_file_size, 49);
        sViewsWithIds.put(R.id.file_dash, 50);
        sViewsWithIds.put(R.id.file_tv_file_pages, 51);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemMessageSentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }
    private ItemMessageSentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[38]
            , (android.widget.ImageView) bindings[39]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[33]
            , (android.widget.SeekBar) bindings[40]
            , (android.widget.RelativeLayout) bindings[32]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.TextView) bindings[35]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.TextView) bindings[37]
            , (androidx.cardview.widget.CardView) bindings[46]
            , (android.widget.TextView) bindings[50]
            , (android.widget.ImageView) bindings[47]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[42]
            , (android.widget.RelativeLayout) bindings[41]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.TextView) bindings[44]
            , (android.widget.LinearLayout) bindings[43]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[49]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[7]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.TextView) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.LinearLayout) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[19]
            , (android.widget.RelativeLayout) bindings[18]
            , (androidx.cardview.widget.CardView) bindings[29]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[28]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.TextView) bindings[22]
            , (android.widget.LinearLayout) bindings[26]
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