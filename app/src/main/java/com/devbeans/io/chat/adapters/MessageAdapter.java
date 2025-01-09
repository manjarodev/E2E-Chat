package com.devbeans.io.chat.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbeans.io.chat.adapters.viewholders.ChatMessageHolders;
import com.devbeans.io.chat.callBacks.SentMessageCallback;
import com.devbeans.io.chat.databinding.ItemMessageReceiveBinding;
import com.devbeans.io.chat.databinding.ItemMessageSentBinding;
import com.devbeans.io.chat.models.Message;
import com.devbeans.io.chat.models.Messages;
import com.devbeans.io.chat.utils.audio.AudioPlayer;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.ViewHolder;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessagesListAdapter;
import com.stfalcon.chatkit.utils.DateFormatter;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class MessageAdapter<MESSAGE extends IMessage>
        extends ChatMessagesListAdapter
//************************************************************
{


    protected static boolean isSelectionModeEnabled;

    protected List<Wrapper> itemsWrapper;
    private MessageHolders holders;
    private String senderId;

    private int selectedItemsCount;
    private SelectionListener selectionListener;

    private OnLoadMoreListener loadMoreListener;
    private OnMessageClickListener<MESSAGE> onMessageClickListener;
    private OnMessageViewClickListener<MESSAGE> onMessageViewClickListener;
    private OnMessageLongClickListener<MESSAGE> onMessageLongClickListener;
    private OnMessageViewLongClickListener<MESSAGE> onMessageViewLongClickListener;
    private ImageLoader imageLoader;
    private RecyclerView.LayoutManager layoutManager;
    private DateFormatter.Formatter dateHeadersFormatter;
    private SparseArray<OnMessageViewClickListener<IMessage>> viewClickListenersArray = new SparseArray<>();

    //Will make an interface for isSelectionModeEnabled which will contain onCountChange method
//    protected static boolean isSelectionModeEnabled = true;
    private final int TYPE_MESSAGE_SENT = 0;
    private final int TYPE_MESSAGE_RECEIVED = 1;
    private static final int TYPE_IMAGE_SENT = 2;
    private static final int TYPE_IMAGE_RECEIVED = 3;
    private static final int MSG_UPDATE_SEEK_BAR = 1845;
    RecyclerView.ViewHolder holder;

    Context mContext;
    private LayoutInflater inflater;
    private List<Messages> messageList = new ArrayList<>();
    private SentMessageCallback callback;
    boolean isNewMessage = false;
    public static Context context;
    Message mMessage;
    public AudioPlayer mPlayer = new AudioPlayer();

    public MessageAdapter(String senderId, ImageLoader imageLoader) {
        super(senderId, imageLoader);
    }

    public MessageAdapter(String senderId, ChatMessageHolders holders, ImageLoader imageLoader) {
        super(senderId, holders, imageLoader);
    }

    public MessageAdapter(Context context, String senderId, ChatMessageHolders holders, ImageLoader imageLoader) {
        super(senderId, holders, imageLoader);
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    public AudioPlayer getMediaPlayer() {
        return mPlayer;
    }

    @Override
    public void onLoadMore(int page, int total) {
        super.onLoadMore(page, total);
    }

    @Override
    public int getMessagesCount() {
        return super.getMessagesCount();
    }

    @Override
    public void addToStart(IMessage message, boolean scroll) {
        super.addToStart(message, scroll);
    }

    @Override
    public void addToEnd(List list, boolean reverse) {
        this.messageList = list;
//        Log.e("Tag Adapter", list.toString());
        super.addToEnd(list, reverse);
    }

    @Override
    public boolean update(IMessage message) {
        return super.update(message);
    }

    @Override
    public boolean update(String oldId, IMessage newMessage) {
        return super.update(oldId, newMessage);
    }

    @Override
    public void updateAndMoveToStart(IMessage newMessage) {
        super.updateAndMoveToStart(newMessage);
    }

    @Override
    public void upsert(IMessage message) {
        super.upsert(message);
    }

    @Override
    public void upsert(IMessage message, boolean moveToStartIfUpdate) {
        super.upsert(message, moveToStartIfUpdate);
    }

    @Override
    public void delete(IMessage message) {
        super.delete(message);
    }

    @Override
    public void delete(List list) {
        super.delete(list);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        super.deleteByIds(ids);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void clear(boolean notifyDataSetChanged) {
        super.clear(notifyDataSetChanged);
    }

    @Override
    public void enableSelectionMode(SelectionListener selectionListener) {
        super.enableSelectionMode((MessagesListAdapter.SelectionListener) selectionListener);
    }

    @Override
    public void disableSelectionMode() {
        super.disableSelectionMode();
    }

    @Override
    public ArrayList getSelectedMessages() {
        return super.getSelectedMessages();
    }

    @Override
    public String getSelectedMessagesText(Formatter formatter, boolean reverse) {
        return super.getSelectedMessagesText((MessagesListAdapter.Formatter) formatter, reverse);
    }

    @Override
    public String copySelectedMessagesText(Context context, Formatter formatter, boolean reverse) {
        return super.copySelectedMessagesText(context, (MessagesListAdapter.Formatter) formatter, reverse);
    }

    @Override
    public void unselectAllItems() {
        super.unselectAllItems();
    }

    @Override
    public void deleteSelectedMessages() {
        super.deleteSelectedMessages();
    }

    @Override
    public void setOnMessageClickListener(OnMessageClickListener onMessageClickListener) {
        super.setOnMessageClickListener((MessagesListAdapter.OnMessageClickListener) onMessageClickListener);
    }

    @Override
    public void setOnMessageViewClickListener(OnMessageViewClickListener onMessageViewClickListener) {
        super.setOnMessageViewClickListener((MessagesListAdapter.OnMessageViewClickListener) onMessageViewClickListener);
    }

    @Override
    public void registerViewClickListener(int viewId, OnMessageViewClickListener onMessageViewClickListener) {
        super.registerViewClickListener(viewId, (MessagesListAdapter.OnMessageViewClickListener) onMessageViewClickListener);
    }

    @Override
    public void setOnMessageLongClickListener(OnMessageLongClickListener onMessageLongClickListener) {
        super.setOnMessageLongClickListener((MessagesListAdapter.OnMessageLongClickListener) onMessageLongClickListener);
    }

    @Override
    public void setOnMessageViewLongClickListener(OnMessageViewLongClickListener onMessageViewLongClickListener) {
        super.setOnMessageViewLongClickListener((MessagesListAdapter.OnMessageViewLongClickListener) onMessageViewLongClickListener);
    }

    @Override
    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        super.setLoadMoreListener((MessagesListAdapter.OnLoadMoreListener) loadMoreListener);
    }

    @Override
    public void setDateHeadersFormatter(DateFormatter.Formatter dateHeadersFormatter) {
        super.setDateHeadersFormatter(dateHeadersFormatter);
    }

    @Override
    protected void generateDateHeaders(List list) {
        super.generateDateHeaders(list);
    }


//    //************************************************************
//    public void addAllMessages(List<Message> messageList)
//    //************************************************************
//    {
//        this.messageList.addAll(messageList);
//        notifyItemRangeInserted(0, messageList.size());
//    }

//    //************************************************************
//    public void addNewMessage(Message message, boolean isNewMessage)
//    //************************************************************
//    {
//        messageList.add((message));
//        this.isNewMessage = isNewMessage;
//        notifyItemInserted(messageList.size());
//    }


    //************************************************************
    public void setMargins(View v, int l, int t, int r, int b)
    //************************************************************
    {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    public List<Messages> getMessages() {
        return messageList;
    }

    //************************************************************
    //************************************************************
    public static class SentMessageViewHolder
            extends RecyclerView.ViewHolder
            //************************************************************
            //************************************************************
    {

        ItemMessageSentBinding mBinding;
        RelativeLayout relativeLayout;

        public View parent;


        //************************************************************
        public SentMessageViewHolder(@NonNull ItemMessageSentBinding mBinding)
        //************************************************************
        {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        //************************************************************
        public void setData(Context context, Message item,
                            SentMessageViewHolder viewHolder, int itemPosition,
                            SentMessageCallback callback)
        //************************************************************
        {
            switch (item.getType()) {
                case "text":
                    mBinding.textSendingTextMessageLayout.setVisibility(View.VISIBLE);
                    mBinding.videoSendingImageMessageLayoutVideo.setVisibility(View.GONE);
                    mBinding.imageSendingImageMessageLayout.setVisibility(View.GONE);
                    mBinding.audioSendingTextMessageLayoutAudio.setVisibility(View.GONE);
                    mBinding.fileSendingTextMessageLayoutFile.setVisibility(View.GONE);
                    setTextData();
                    break;
                case "image":
                    mBinding.textSendingTextMessageLayout.setVisibility(View.GONE);
                    mBinding.videoSendingImageMessageLayoutVideo.setVisibility(View.GONE);
                    mBinding.imageSendingImageMessageLayout.setVisibility(View.VISIBLE);
                    mBinding.audioSendingTextMessageLayoutAudio.setVisibility(View.GONE);
                    mBinding.fileSendingTextMessageLayoutFile.setVisibility(View.GONE);
                    setImageData();
                    break;
                case "video":
                    mBinding.textSendingTextMessageLayout.setVisibility(View.GONE);
                    mBinding.videoSendingImageMessageLayoutVideo.setVisibility(View.VISIBLE);
                    mBinding.imageSendingImageMessageLayout.setVisibility(View.GONE);
                    mBinding.audioSendingTextMessageLayoutAudio.setVisibility(View.GONE);
                    mBinding.fileSendingTextMessageLayoutFile.setVisibility(View.GONE);
                    setVideoData();
                    break;
                case "audio":
                    mBinding.textSendingTextMessageLayout.setVisibility(View.GONE);
                    mBinding.videoSendingImageMessageLayoutVideo.setVisibility(View.GONE);
                    mBinding.imageSendingImageMessageLayout.setVisibility(View.GONE);
                    mBinding.audioSendingTextMessageLayoutAudio.setVisibility(View.VISIBLE);
                    mBinding.fileSendingTextMessageLayoutFile.setVisibility(View.GONE);
                    setAudioData();
                    break;
                case "file":
                    mBinding.textSendingTextMessageLayout.setVisibility(View.GONE);
                    mBinding.videoSendingImageMessageLayoutVideo.setVisibility(View.GONE);
                    mBinding.imageSendingImageMessageLayout.setVisibility(View.GONE);
                    mBinding.audioSendingTextMessageLayoutAudio.setVisibility(View.GONE);
                    mBinding.fileSendingTextMessageLayoutFile.setVisibility(View.VISIBLE);
                    setFileData();
                    break;
            }
//            messageTxt.setText(item.getMessage());
//            parent.setOnClickListener(v ->
//            {
//                callback.onSentMessageClick(item, viewHolder, itemPosition);
//            });
//
//            parent.setOnLongClickListener(v ->
//            {
//                callback.onSentMessageLongClick(item, viewHolder, itemPosition);
//                return false;
//            });
        }

        //************************************************************
        private void setFileData()
        //************************************************************
        {

            // was essential to over ride

        }

        //************************************************************
        private void setAudioData()
        //************************************************************
        {

            // was essential to over ride

        }

        //************************************************************
        private void setVideoData()
        //************************************************************
        {
            // was essential to over ride

        }

        //************************************************************
        private void setImageData()
        //************************************************************
        {
            // was essential to over ride


        }

        //************************************************************
        private void setTextData()
        //************************************************************
        {
            // was essential to over ride


        }

    }

    //************************************************************
    //************************************************************
    public static class ReceivedMessageHolder
            extends RecyclerView.ViewHolder
            //************************************************************
            //************************************************************
    {

        ItemMessageReceiveBinding mBinding;
        public View parent;

        //************************************************************
        public ReceivedMessageHolder(@NonNull ItemMessageReceiveBinding mBinding)
        //************************************************************
        {
            super(mBinding.getRoot());
            this.mBinding = mBinding;

        }


        //************************************************************
        public void setData(Context context, Message item, ReceivedMessageHolder viewHolder,
                            int itemPosition, SentMessageCallback callback)
        //************************************************************
        {
            switch (item.getType()) {
                case "text":
                    mBinding.textTextMessageLayout.setVisibility(View.VISIBLE);

                    mBinding.imageReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.videoReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.audioSendingTextMessageLayout.setVisibility(View.GONE);

                    mBinding.fileSendingTextMessageLayout.setVisibility(View.GONE);

                    setTextData();
                    break;
                case "image":
                    mBinding.textTextMessageLayout.setVisibility(View.GONE);

                    mBinding.imageReceivingImageMessageLayout.setVisibility(View.VISIBLE);

                    mBinding.videoReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.audioSendingTextMessageLayout.setVisibility(View.GONE);

                    mBinding.fileSendingTextMessageLayout.setVisibility(View.GONE);
                    setImageData();
                    break;
                case "video":
                    mBinding.textTextMessageLayout.setVisibility(View.GONE);

                    mBinding.imageReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.videoReceivingImageMessageLayout.setVisibility(View.VISIBLE);

                    mBinding.audioSendingTextMessageLayout.setVisibility(View.GONE);

                    mBinding.fileSendingTextMessageLayout.setVisibility(View.GONE);
                    setVideoData();
                    break;
                case "audio":
                    mBinding.textTextMessageLayout.setVisibility(View.GONE);

                    mBinding.imageReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.videoReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.audioSendingTextMessageLayout.setVisibility(View.VISIBLE);

                    mBinding.fileSendingTextMessageLayout.setVisibility(View.GONE);
                    setAudioData();
                    break;
                case "file":
                    mBinding.textTextMessageLayout.setVisibility(View.GONE);

                    mBinding.imageReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.videoReceivingImageMessageLayout.setVisibility(View.GONE);

                    mBinding.audioSendingTextMessageLayout.setVisibility(View.GONE);

                    mBinding.fileSendingTextMessageLayout.setVisibility(View.VISIBLE);
                    setFileData();
                    break;
            }


//            messageTxt.setText(item.getMessage());
//            parent.setOnClickListener(v -> {
//                callback.onReceivedMessageClick(item, viewHolder, itemPosition);
//            });
//            parent.setOnLongClickListener(v -> {
//                callback.onReceivedMessageLongClick(item, viewHolder, itemPosition);
//                return false;
//            });
        }


        //************************************************************
        private void setTextData()
        //************************************************************
        {

            // was essential to over ride

        }

        //************************************************************
        private void setImageData()
        //************************************************************
        {

            // was essential to over ride

        }

        //************************************************************
        private void setVideoData()
        //************************************************************
        {

            // was essential to over ride

        }


        //************************************************************
        private void setAudioData()
        //************************************************************
        {

            // was essential to over ride

        }

        //************************************************************
        private void setFileData()
        //************************************************************
        {

            // was essential to over ride

        }

    }
}

