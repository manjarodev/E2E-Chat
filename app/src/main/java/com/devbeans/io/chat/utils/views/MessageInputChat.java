package com.devbeans.io.chat.utils.views;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.devbeans.io.chat.utils.RecordTime;
import com.stfalcon.chatkit.messages.MessageInput;

public class MessageInputChat extends MessageInput implements MicrophoneRecorderView.Listener {
    @SuppressLint("StaticFieldLeak")
    private static MessageInputChat instance;
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private MicrophoneRecorderView microphoneRecorderView;
    private RecordTime recordTime;

    public static MessageInputChat getInstance() {
        if (instance == null) {
            instance = new MessageInputChat(context);
        }

        return instance;
    }

//    public void setListener(@Nullable MicrophoneRecorderView.Listener listener) {
//        this.microphoneRecorderView.setListener(listener);
//    }

    public ImageButton getAttachmentButton() {
        return instance.attachmentButton;
    }

    public MessageInputChat(Context context) {
        super(context);
        instance = this;
        MessageInputChat.context = context;
    }

    public MessageInputChat(Context context, AttributeSet attrs) {
        super(context, attrs);
        instance = this;
        MessageInputChat.context = context;
    }

    public MessageInputChat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        instance = this;
        MessageInputChat.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        this.microphoneRecorderView = findViewById(R.id.recorder_view);
//        this.recordTime = new RecordTime(findViewById(R.id.record_time),
//                findViewById(R.id.microphone),
//                TimeUnit.HOURS.toSeconds(1),
//                () -> microphoneRecorderView.cancelAction());

//        this.microphoneRecorderView.setListener(this);

    }

    public void display() {
        recordTime.display();
    }

    @Override
    public void setInputListener(InputListener inputListener) {
        super.setInputListener(inputListener);
    }

    @Override
    public void setAttachmentsListener(AttachmentsListener attachmentsListener) {
        super.setAttachmentsListener(attachmentsListener);
    }

    @Override
    public EditText getInputEditText() {
        return super.getInputEditText();
    }

    @Override
    public ImageButton getButton() {
        return super.getButton();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        super.onTextChanged(s, start, count, after);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        super.beforeTextChanged(charSequence, i, i1, i2);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        super.onFocusChange(v, hasFocus);
    }

    @Override
    public void setTypingListener(TypingListener typingListener) {
        super.setTypingListener(typingListener);
    }

    @Override
    public void onRecordPressed() {

        // was essential to over ride

    }

    @Override
    public void onRecordReleased() {

        // was essential to over ride

    }

    @Override
    public void onRecordCanceled() {

        // was essential to over ride

    }

    @Override
    public void onRecordLocked() {

        // was essential to over ride

    }

    @Override
    public void onRecordMoved(float offsetX, float absoluteX) {

        // was essential to over ride

    }

    @Override
    public void onRecordPermissionRequired() {

        // was essential to over ride

    }
}
