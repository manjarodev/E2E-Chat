package com.devbeans.io.chat.adapters.viewholders;


import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.ViewHolder;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.MessageContentType;
import com.stfalcon.chatkit.messages.MessagesListAdapter;
import com.stfalcon.chatkit.messages.MessagesListStyle;
import com.stfalcon.chatkit.utils.DateFormatter;
import com.stfalcon.chatkit.utils.RoundedImageView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Created by troy379 on 31.03.17.
 */
@SuppressWarnings("WeakerAccess")
public class ChatMessageHolders {

    private static final short VIEW_TYPE_DATE_HEADER = 130;
    private static final short VIEW_TYPE_TEXT_MESSAGE = 131;
    private static final short VIEW_TYPE_IMAGE_MESSAGE = 132;
    private static final short CONTENT_TYPE_VOICE = 1;
    private static final short CONTENT_TYPE_FILE = 2;
    private static final short CONTENT_TYPE_VIDEO = 3;
    private static final short CONTENT_TYPE_IMAGE = 4;
    private static final short CONTENT_TYPE_NOTIFY = 5;
    private static final short CONTENT_TYPE_CONFIDENTIAL = 6;
    private static final short CONTENT_TYPE_VIEW_ONCE = 7;
    private static final short CONTENT_TYPE_IS_SELF_EXPIRY = 8;

    public static final String TEXT = "text";
    public static final String FILE = "file";
    public static final String IMAGE = "image";
    public static final String AUDIO = "audio";
    public static final String VIDEO = "video";
    public static final String EXPIRE_MSG_SELF = "conv_expiry_self";
    public static final String MEMBER_ADDED = "member_added";
    public static final String MEMBER_REMOVED = "member_removed";
    public static final String ADMIN_ASSIGNED = "admin_assigned";
    public static final String ADMIN_REMOVED = "admin_removed";
    public static final String MEMBER_LEAVE = "member_leave";
    public static final String CHANGE_OWNER = "change_owner";
    public static final String EXPIRE_MSG = "conv_expiry";
    public static final String GROUP_NAME_CHANGE = "group_name_change";
    public static final String ANONYMOUS_GROUP_CONV_CREATED = "annonymouns_conv_created";
    public static final String GROUP_CONV_CREATED = "conv_created";
    public static final String GROUP_ICON_CHANGE = "group_icon_change";
    public static final String GROUP_DES_CHANGE = "group_description_change";
    public static final String GROUP_IS_CONFIDENTIAL_CHANGE = "group_is_confidential_change";
    public static final String GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE = "group_is_media_share_restrict_change";


    private Class<? extends com.stfalcon.chatkit.commons.ViewHolder<Date>> dateHeaderHolder;
    private int dateHeaderLayout;

    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<IMessage> incomingTextConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<IMessage> outcomingTextConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType.Image> incomingImageConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType.Image> outcomingImageConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingVoiceConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingVoiceConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingVideoConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingVideoConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingFileConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingFileConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingImagesConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingImagesConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingNotifyConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingNotifyConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingConfidentialConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingConfidentialConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingViewOnceConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingViewOnceConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> incomingSelfGroupConfig;
    private final com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<MessageContentType> outgoingSelfGroupConfig;


    private List<com.stfalcon.chatkit.messages.MessageHolders.ContentTypeConfig> customContentTypes = new ArrayList<>();
    private com.stfalcon.chatkit.messages.MessageHolders.ContentChecker contentChecker;

    public ChatMessageHolders() {
        this.dateHeaderHolder = com.stfalcon.chatkit.messages.MessageHolders.DefaultDateHeaderViewHolder.class;
        this.dateHeaderLayout = com.stfalcon.chatkit.R.layout.item_date_header;

        this.incomingTextConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.stfalcon.chatkit.messages.MessageHolders.DefaultIncomingTextMessageViewHolder.class, com.stfalcon.chatkit.R.layout.item_incoming_text_message);
        this.outcomingTextConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.stfalcon.chatkit.messages.MessageHolders.DefaultOutcomingTextMessageViewHolder.class, com.stfalcon.chatkit.R.layout.item_outcoming_text_message);
        this.incomingImageConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.stfalcon.chatkit.messages.MessageHolders.DefaultIncomingImageMessageViewHolder.class, com.stfalcon.chatkit.R.layout.item_incoming_image_message);
        this.outcomingImageConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.stfalcon.chatkit.messages.MessageHolders.DefaultOutcomingImageMessageViewHolder.class, com.stfalcon.chatkit.R.layout.item_outcoming_image_message);


        this.incomingVoiceConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(IncomingVoiceMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_audio);
        this.outgoingVoiceConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingVoiceMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_audio);

        this.incomingVideoConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(IncomingVideoMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_video);
        this.outgoingVideoConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingVideoMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_video);


        this.incomingFileConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(IncomingFileMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_file);
        this.outgoingFileConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingFileMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_file);


        this.incomingImagesConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.devbeans.io.chat.adapters.viewholders.IncomingImageMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_image);
        this.outgoingImagesConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingImageMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_image);


        this.incomingNotifyConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(NotifyIncomingViewHolder.class, com.devbeans.io.chat.R.layout.item_notify);
        this.outgoingNotifyConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(NotifyOutgoingViewHolder.class, com.devbeans.io.chat.R.layout.item_notify);


        this.incomingConfidentialConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(com.devbeans.io.chat.adapters.viewholders.IncomingConfidentialTextMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_confidential);
        this.outgoingConfidentialConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingConfidentialTextMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_confidential);


        this.incomingViewOnceConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(IncomingViewOnceTextMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_receive_view_once);
        this.outgoingViewOnceConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(OutgoingViewOnceTextMessageViewHolder.class, com.devbeans.io.chat.R.layout.item_message_sent_view_once);


        this.incomingSelfGroupConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(SelfGroupIncomingViewHolderMessageHolder.class, com.devbeans.io.chat.R.layout.item_group_settings);
        this.outgoingSelfGroupConfig = new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(SelfGroupOutgoingViewHolderMessageHolder.class, com.devbeans.io.chat.R.layout.item_group_settings);


    }

    /**
     * Sets both of custom view holder class and layout resource for incoming text message.
     *
     * @param holder holder class.
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            @LayoutRes int layout) {
        this.incomingTextConfig.holder = holder;
        this.incomingTextConfig.layout = layout;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for incoming text message.
     *
     * @param holder  holder class.
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            @LayoutRes int layout,
            Object payload) {
        this.incomingTextConfig.holder = holder;
        this.incomingTextConfig.layout = layout;
        this.incomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom view holder class for incoming text message.
     *
     * @param holder holder class.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder) {
        this.incomingTextConfig.holder = holder;
        return this;
    }

    /**
     * Sets custom view holder class for incoming text message.
     *
     * @param holder  holder class.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            Object payload) {
        this.incomingTextConfig.holder = holder;
        this.incomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom layout resource for incoming text message.
     *
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextLayout(@LayoutRes int layout) {
        this.incomingTextConfig.layout = layout;
        return this;
    }

    /**
     * Sets custom layout resource for incoming text message.
     *
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingTextLayout(@LayoutRes int layout, Object payload) {
        this.incomingTextConfig.layout = layout;
        this.incomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for outcoming text message.
     *
     * @param holder holder class.
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            @LayoutRes int layout) {
        this.outcomingTextConfig.holder = holder;
        this.outcomingTextConfig.layout = layout;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for outcoming text message.
     *
     * @param holder  holder class.
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            @LayoutRes int layout,
            Object payload) {
        this.outcomingTextConfig.holder = holder;
        this.outcomingTextConfig.layout = layout;
        this.outcomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom view holder class for outcoming text message.
     *
     * @param holder holder class.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder) {
        this.outcomingTextConfig.holder = holder;
        return this;
    }

    /**
     * Sets custom view holder class for outcoming text message.
     *
     * @param holder  holder class.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends IMessage>> holder,
            Object payload) {
        this.outcomingTextConfig.holder = holder;
        this.outcomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom layout resource for outcoming text message.
     *
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextLayout(@LayoutRes int layout) {
        this.outcomingTextConfig.layout = layout;
        return this;
    }

    /**
     * Sets custom layout resource for outcoming text message.
     *
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingTextLayout(@LayoutRes int layout, Object payload) {
        this.outcomingTextConfig.layout = layout;
        this.outcomingTextConfig.payload = payload;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for incoming image message.
     *
     * @param holder holder class.
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            @LayoutRes int layout) {
        this.incomingImageConfig.holder = holder;
        this.incomingImageConfig.layout = layout;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for incoming image message.
     *
     * @param holder  holder class.
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            @LayoutRes int layout,
            Object payload) {
        this.incomingImageConfig.holder = holder;
        this.incomingImageConfig.layout = layout;
        this.incomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom view holder class for incoming image message.
     *
     * @param holder holder class.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder) {
        this.incomingImageConfig.holder = holder;
        return this;
    }

    /**
     * Sets custom view holder class for incoming image message.
     *
     * @param holder  holder class.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            Object payload) {
        this.incomingImageConfig.holder = holder;
        this.incomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom layout resource for incoming image message.
     *
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageLayout(@LayoutRes int layout) {
        this.incomingImageConfig.layout = layout;
        return this;
    }

    /**
     * Sets custom layout resource for incoming image message.
     *
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setIncomingImageLayout(@LayoutRes int layout, Object payload) {
        this.incomingImageConfig.layout = layout;
        this.incomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for outcoming image message.
     *
     * @param holder holder class.
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            @LayoutRes int layout) {
        this.outcomingImageConfig.holder = holder;
        this.outcomingImageConfig.layout = layout;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for outcoming image message.
     *
     * @param holder  holder class.
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            @LayoutRes int layout,
            Object payload) {
        this.outcomingImageConfig.holder = holder;
        this.outcomingImageConfig.layout = layout;
        this.outcomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom view holder class for outcoming image message.
     *
     * @param holder holder class.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder) {
        this.outcomingImageConfig.holder = holder;
        return this;
    }

    /**
     * Sets custom view holder class for outcoming image message.
     *
     * @param holder  holder class.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageHolder(
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends MessageContentType.Image>> holder,
            Object payload) {
        this.outcomingImageConfig.holder = holder;
        this.outcomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets custom layout resource for outcoming image message.
     *
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageLayout(@LayoutRes int layout) {
        this.outcomingImageConfig.layout = layout;
        return this;
    }

    /**
     * Sets custom layout resource for outcoming image message.
     *
     * @param layout  layout resource.
     * @param payload custom data.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setOutcomingImageLayout(@LayoutRes int layout, Object payload) {
        this.outcomingImageConfig.layout = layout;
        this.outcomingImageConfig.payload = payload;
        return this;
    }

    /**
     * Sets both of custom view holder class and layout resource for date header.
     *
     * @param holder holder class.
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setDateHeaderConfig(
            @NonNull Class<? extends com.stfalcon.chatkit.commons.ViewHolder<Date>> holder,
            @LayoutRes int layout) {
        this.dateHeaderHolder = holder;
        this.dateHeaderLayout = layout;
        return this;
    }

    /**
     * Sets custom view holder class for date header.
     *
     * @param holder holder class.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setDateHeaderHolder(@NonNull Class<? extends com.stfalcon.chatkit.commons.ViewHolder<Date>> holder) {
        this.dateHeaderHolder = holder;
        return this;
    }

    /**
     * Sets custom layout reource for date header.
     *
     * @param layout layout resource.
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public ChatMessageHolders setDateHeaderLayout(@LayoutRes int layout) {
        this.dateHeaderLayout = layout;
        return this;
    }

    /**
     * Registers custom content type (e.g. multimedia, events etc.)
     *
     * @param type            unique id for content type
     * @param holder          holder class for incoming and outcoming messages
     * @param incomingLayout  layout resource for incoming message
     * @param outcomingLayout layout resource for outcoming message
     * @param contentChecker  {@link com.stfalcon.chatkit.messages.MessageHolders.ContentChecker} for registered type
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public <TYPE extends MessageContentType>
    ChatMessageHolders registerContentType(
            byte type, @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<TYPE>> holder,
            @LayoutRes int incomingLayout,
            @LayoutRes int outcomingLayout,
            @NonNull com.stfalcon.chatkit.messages.MessageHolders.ContentChecker contentChecker) {

        return registerContentType(type,
                holder, incomingLayout,
                holder, outcomingLayout,
                contentChecker);
    }

    /**
     * Registers custom content type (e.g. multimedia, events etc.)
     *
     * @param type            unique id for content type
     * @param incomingHolder  holder class for incoming message
     * @param outcomingHolder holder class for outcoming message
     * @param incomingLayout  layout resource for incoming message
     * @param outcomingLayout layout resource for outcoming message
     * @param contentChecker  {@link com.stfalcon.chatkit.messages.MessageHolders.ContentChecker} for registered type
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public <TYPE extends MessageContentType>
    ChatMessageHolders registerContentType(
            byte type,
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<TYPE>> incomingHolder, @LayoutRes int incomingLayout,
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<TYPE>> outcomingHolder, @LayoutRes int outcomingLayout,
            @NonNull com.stfalcon.chatkit.messages.MessageHolders.ContentChecker contentChecker) {

        if (type == 0)
            throw new IllegalArgumentException("content type must be greater or less than '0'!");

        customContentTypes.add(
                new com.stfalcon.chatkit.messages.MessageHolders.ContentTypeConfig<>(type,
                        new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(incomingHolder, incomingLayout),
                        new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(outcomingHolder, outcomingLayout)));
        this.contentChecker = contentChecker;
        return this;
    }

    /**
     * Registers custom content type (e.g. multimedia, events etc.)
     *
     * @param type             unique id for content type
     * @param incomingHolder   holder class for incoming message
     * @param outcomingHolder  holder class for outcoming message
     * @param incomingPayload  payload for incoming message
     * @param outcomingPayload payload for outcoming message
     * @param incomingLayout   layout resource for incoming message
     * @param outcomingLayout  layout resource for outcoming message
     * @param contentChecker   {@link com.stfalcon.chatkit.messages.MessageHolders.ContentChecker} for registered type
     * @return {@link com.stfalcon.chatkit.messages.MessageHolders} for subsequent configuration.
     */
    public <TYPE extends MessageContentType>
    ChatMessageHolders registerContentType(
            byte type,
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<TYPE>> incomingHolder, Object incomingPayload, @LayoutRes int incomingLayout,
            @NonNull Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<TYPE>> outcomingHolder, Object outcomingPayload, @LayoutRes int outcomingLayout,
            @NonNull com.stfalcon.chatkit.messages.MessageHolders.ContentChecker contentChecker) {

        if (type == 0)
            throw new IllegalArgumentException("content type must be greater or less than '0'!");

        customContentTypes.add(
                new com.stfalcon.chatkit.messages.MessageHolders.ContentTypeConfig<>(type,
                        new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(incomingHolder, incomingLayout, incomingPayload),
                        new com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<>(outcomingHolder, outcomingLayout, outcomingPayload)));
        this.contentChecker = contentChecker;
        return this;
    }

    /*
     * INTERFACES
     * */

    /**
     * The interface, which contains logic for checking the availability of content.
     */
    public interface ContentChecker<MESSAGE extends IMessage> {

        /**
         * Checks the availability of content.
         *
         * @param message current message in list.
         * @param type    content type, for which content availability is determined.
         * @return weather the message has content for the current message.
         */
        boolean hasContentFor(MESSAGE message, byte type);
    }

    /*
     * PRIVATE METHODS
     * */

    public com.stfalcon.chatkit.commons.ViewHolder getHolder(ViewGroup parent, int viewType, MessagesListStyle messagesListStyle) {
        switch (viewType) {
            case VIEW_TYPE_DATE_HEADER:
                return getHolder(parent, dateHeaderLayout, dateHeaderHolder, messagesListStyle, null);
            case VIEW_TYPE_TEXT_MESSAGE:
                return getHolder(parent, incomingTextConfig, messagesListStyle);
            case -VIEW_TYPE_TEXT_MESSAGE:
                return getHolder(parent, outcomingTextConfig, messagesListStyle);
            case VIEW_TYPE_IMAGE_MESSAGE:
                return getHolder(parent, incomingImageConfig, messagesListStyle);
            case -VIEW_TYPE_IMAGE_MESSAGE:
                return getHolder(parent, outcomingImageConfig, messagesListStyle);
            case CONTENT_TYPE_FILE:
                return getHolder(parent, incomingFileConfig, messagesListStyle);
            case -CONTENT_TYPE_FILE:
                return getHolder(parent, outgoingFileConfig, messagesListStyle);
            case CONTENT_TYPE_IMAGE:
                return getHolder(parent, incomingImagesConfig, messagesListStyle);
            case -CONTENT_TYPE_IMAGE:
                return getHolder(parent, outgoingImagesConfig, messagesListStyle);
            case CONTENT_TYPE_VOICE:
                return getHolder(parent, incomingVoiceConfig, messagesListStyle);
            case -CONTENT_TYPE_VOICE:
                return getHolder(parent, outgoingVoiceConfig, messagesListStyle);
            case CONTENT_TYPE_VIDEO:
                return getHolder(parent, incomingVideoConfig, messagesListStyle);
            case -CONTENT_TYPE_VIDEO:
                return getHolder(parent, outgoingVideoConfig, messagesListStyle);
            case CONTENT_TYPE_NOTIFY:
                return getHolder(parent, incomingNotifyConfig, messagesListStyle);
            case -CONTENT_TYPE_NOTIFY:
                return getHolder(parent, outgoingNotifyConfig, messagesListStyle);
            case CONTENT_TYPE_CONFIDENTIAL:
                return getHolder(parent, incomingConfidentialConfig, messagesListStyle);
            case -CONTENT_TYPE_CONFIDENTIAL:
                return getHolder(parent, outgoingConfidentialConfig, messagesListStyle);
            case CONTENT_TYPE_VIEW_ONCE:
                return getHolder(parent, incomingViewOnceConfig, messagesListStyle);
            case -CONTENT_TYPE_VIEW_ONCE:
                return getHolder(parent, outgoingViewOnceConfig, messagesListStyle);
            case CONTENT_TYPE_IS_SELF_EXPIRY:
                return getHolder(parent, incomingSelfGroupConfig, messagesListStyle);
            case -CONTENT_TYPE_IS_SELF_EXPIRY:
                return getHolder(parent, outgoingSelfGroupConfig, messagesListStyle);

            default:
                for (com.stfalcon.chatkit.messages.MessageHolders.ContentTypeConfig typeConfig : customContentTypes) {
                    if (Math.abs(typeConfig.type) == Math.abs(viewType)) {
                        if (viewType > 0)
                            return getHolder(parent, typeConfig.incomingConfig, messagesListStyle);
                        else
                            return getHolder(parent, typeConfig.outcomingConfig, messagesListStyle);
                    }
                }
        }
        throw new IllegalStateException("Wrong message view type. Please, report this issue on GitHub with full stacktrace in description.");
    }

    @SuppressWarnings("unchecked")
    public void bind(final com.stfalcon.chatkit.commons.ViewHolder holder, final Object item, boolean isSelected,
                     final ImageLoader imageLoader,
                     final View.OnClickListener onMessageClickListener,
                     final View.OnLongClickListener onMessageLongClickListener,
                     final DateFormatter.Formatter dateHeadersFormatter,
                     final SparseArray<MessagesListAdapter.OnMessageViewClickListener> clickListenersArray) {

        if (item instanceof IMessage) {
            ((com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder) holder).isSelected = isSelected;
            ((com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder) holder).imageLoader = imageLoader;
            holder.itemView.setOnLongClickListener(onMessageLongClickListener);
            holder.itemView.setOnClickListener(onMessageClickListener);

            for (int i = 0; i < clickListenersArray.size(); i++) {
                final int key = clickListenersArray.keyAt(i);
                final View view = holder.itemView.findViewById(key);
                if (view != null) {
                    view.setOnClickListener(v -> clickListenersArray.get(key).onMessageViewClick(view, (IMessage) item));
                }
            }
        } else if (item instanceof Date) {
            ((com.stfalcon.chatkit.messages.MessageHolders.DefaultDateHeaderViewHolder) holder).dateHeadersFormatter = dateHeadersFormatter;
        }

        holder.onBind(item);
    }


    public int getViewType(Object item, String senderId) {
        boolean isOutcoming = false;
        int viewType;

        if (item instanceof IMessage) {
            IMessage message = (IMessage) item;
            isOutcoming = message.getUser().getId().contentEquals(senderId);
            viewType = getContentViewType(message);

        } else viewType = VIEW_TYPE_DATE_HEADER;

        return isOutcoming ? viewType * -1 : viewType;
    }

    private com.stfalcon.chatkit.commons.ViewHolder getHolder(ViewGroup parent, com.stfalcon.chatkit.messages.MessageHolders.HolderConfig holderConfig,
                                                              MessagesListStyle style) {
        return getHolder(parent, holderConfig.layout, holderConfig.holder, style, holderConfig.payload);
    }

    private <HOLDER extends com.stfalcon.chatkit.commons.ViewHolder>
    com.stfalcon.chatkit.commons.ViewHolder getHolder(ViewGroup parent, @LayoutRes int layout, Class<HOLDER> holderClass,
                                                      MessagesListStyle style, Object payload) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        try {
            Constructor<HOLDER> constructor = null;
            HOLDER holder;
            try {
                constructor = holderClass.getDeclaredConstructor(View.class, Object.class);
                constructor.setAccessible(true);
                holder = constructor.newInstance(v, payload);
            } catch (NoSuchMethodException e) {
                constructor = holderClass.getDeclaredConstructor(View.class);
                constructor.setAccessible(true);
                holder = constructor.newInstance(v);
            }
            if (holder instanceof com.stfalcon.chatkit.messages.MessageHolders.DefaultMessageViewHolder && style != null) {
                ((com.stfalcon.chatkit.messages.MessageHolders.DefaultMessageViewHolder) holder).applyStyle(style);
            }
            return holder;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Somehow we couldn't create the ViewHolder for message. Please, report this issue on GitHub with full stacktrace in description.", e);
        }
    }

    @SuppressWarnings("unchecked")
    private short getContentViewType(IMessage message) {
        if (message instanceof MessageContentType.Image
                && ((MessageContentType.Image) message).getImageUrl() != null) {
            return VIEW_TYPE_IMAGE_MESSAGE;
        }

        if (message instanceof MessageContentType.PayloadCheck
                && ((MessageContentType.PayloadCheck) message).getPayloadType() != null) {
            MessageContentType.PayloadCheck type = ((MessageContentType.PayloadCheck) message);

            if (type.getPayloadType() != null) {
                String payloadType = type.getPayloadType();

                return handleTypes(payloadType, type);
            }

        }

        // other default types will be here

        if (message instanceof MessageContentType) {
            for (int i = 0; i < customContentTypes.size(); i++) {
                com.stfalcon.chatkit.messages.MessageHolders.ContentTypeConfig config = customContentTypes.get(i);
                if (contentChecker == null) {
                    throw new IllegalArgumentException("ContentChecker cannot be null when using custom content types!");
                }
                boolean hasContent = contentChecker.hasContentFor(message, config.type);
                if (hasContent) return config.type;
            }
        }

        return VIEW_TYPE_TEXT_MESSAGE;
    }

    private short handleTypes(String payloadType, MessageContentType.PayloadCheck type) {
        if (payloadType.equalsIgnoreCase(EXPIRE_MSG_SELF)) {
            return CONTENT_TYPE_IS_SELF_EXPIRY;
        } else if (!type.getIsConfidentialType() && !type.getIsViewOnceType()) {
            switch (payloadType) {
                case FILE:
                    return CONTENT_TYPE_FILE;
                case IMAGE:
                    return CONTENT_TYPE_IMAGE;
                case AUDIO:
                    return CONTENT_TYPE_VOICE;
                case VIDEO:
                    return CONTENT_TYPE_VIDEO;
                case MEMBER_ADDED:
                case MEMBER_REMOVED:
                case ADMIN_ASSIGNED:
                case ADMIN_REMOVED:
                case MEMBER_LEAVE:
                case CHANGE_OWNER:
                case EXPIRE_MSG:
                case GROUP_NAME_CHANGE:
                case GROUP_DES_CHANGE:
                case GROUP_ICON_CHANGE:
                case GROUP_IS_CONFIDENTIAL_CHANGE:
                case GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE:
                    return CONTENT_TYPE_NOTIFY;
            }
        } else if (type.getIsConfidentialType()) {
            return CONTENT_TYPE_CONFIDENTIAL;

        } else {
            if (type.getIsViewOnceType())
                return CONTENT_TYPE_VIEW_ONCE;
        }
        return VIEW_TYPE_TEXT_MESSAGE;
    }

    /*
     * HOLDERS
     * */

    /**
     * The base class for view holders for incoming and outcoming message.
     * You can extend it to create your own holder in conjuction with custom layout or even using default layout.
     */
    public static abstract class BaseMessageViewHolder<MESSAGE extends IMessage> extends com.stfalcon.chatkit.commons.ViewHolder<MESSAGE> {

        boolean isSelected;

        /**
         * For setting custom data to ViewHolder
         */
        protected Object payload;

        /**
         * Callback for implementing images loading in message list
         */
        protected ImageLoader imageLoader;

        @Deprecated
        public BaseMessageViewHolder(View itemView) {
            super(itemView);
        }

        public BaseMessageViewHolder(View itemView, Object payload) {
            super(itemView);
            this.payload = payload;
        }

        /**
         * Returns whether is item selected
         *
         * @return weather is item selected.
         */
        public boolean isSelected() {
            return isSelected;
        }

        /**
         * Returns weather is selection mode enabled
         *
         * @return weather is selection mode enabled.
         */
        public boolean isSelectionModeEnabled() {
            return MessagesListAdapter.isSelectionModeEnabled;
        }

        /**
         * Getter for {@link #imageLoader}
         *
         * @return image loader interface.
         */
        public ImageLoader getImageLoader() {
            return imageLoader;
        }

        protected void configureLinksBehavior(final TextView text) {
            text.setLinksClickable(false);
            text.setMovementMethod(new LinkMovementMethod() {
                @Override
                public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
                    boolean result = false;
                    if (!MessagesListAdapter.isSelectionModeEnabled) {
                        result = super.onTouchEvent(widget, buffer, event);
                    }
                    itemView.onTouchEvent(event);
                    return result;
                }
            });
        }
    }

    /**
     * Default view holder implementation for incoming text message
     */
    public static class IncomingTextMessageViewHolder<MESSAGE extends IMessage>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseIncomingMessageViewHolder<MESSAGE> {

        protected ViewGroup bubble;
        protected TextView text;

        @Deprecated
        public IncomingTextMessageViewHolder(View itemView) {
            super(itemView);
            initViewHolder(itemView);
        }

        public IncomingTextMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            initViewHolder(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            super.onBind(message);
            if (bubble != null) {
                bubble.setSelected(isSelected());
            }

            if (text != null) {
                text.setText(message.getText());
            }
        }

        @Override
        public void applyStyle(MessagesListStyle style) {
            super.applyStyle(style);
            if (bubble != null) {
                bubble.setPadding(style.getIncomingDefaultBubblePaddingLeft(),
                        style.getIncomingDefaultBubblePaddingTop(),
                        style.getIncomingDefaultBubblePaddingRight(),
                        style.getIncomingDefaultBubblePaddingBottom());
                ViewCompat.setBackground(bubble, style.getIncomingBubbleDrawable());
            }

            if (text != null) {
                text.setTextColor(style.getIncomingTextColor());
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getIncomingTextSize());
                text.setTypeface(text.getTypeface(), style.getIncomingTextStyle());
                text.setAutoLinkMask(style.getTextAutoLinkMask());
                text.setLinkTextColor(style.getIncomingTextLinkColor());
                configureLinksBehavior(text);
            }
        }

        private void initViewHolder(View itemView) {
            bubble = itemView.findViewById(com.stfalcon.chatkit.R.id.bubble);
            text = itemView.findViewById(com.stfalcon.chatkit.R.id.messageText);
        }
    }

    /**
     * Default view holder implementation for outcoming text message
     */
    public static class OutcomingTextMessageViewHolder<MESSAGE extends IMessage>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseOutcomingMessageViewHolder<MESSAGE> {

        protected ViewGroup bubble;
        protected TextView text;

        @Deprecated
        public OutcomingTextMessageViewHolder(View itemView) {
            super(itemView);
            initOutGoing(itemView);
        }

        public OutcomingTextMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            initOutGoing(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            super.onBind(message);
            if (bubble != null) {
                bubble.setSelected(isSelected());
            }

            if (text != null) {
                text.setText(message.getText());
            }
        }

        @Override
        public final void applyStyle(MessagesListStyle style) {
            super.applyStyle(style);
            if (bubble != null) {
                bubble.setPadding(style.getOutcomingDefaultBubblePaddingLeft(),
                        style.getOutcomingDefaultBubblePaddingTop(),
                        style.getOutcomingDefaultBubblePaddingRight(),
                        style.getOutcomingDefaultBubblePaddingBottom());
                ViewCompat.setBackground(bubble, style.getOutcomingBubbleDrawable());
            }

            if (text != null) {
                text.setTextColor(style.getOutcomingTextColor());
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getOutcomingTextSize());
                text.setTypeface(text.getTypeface(), style.getOutcomingTextStyle());
                text.setAutoLinkMask(style.getTextAutoLinkMask());
                text.setLinkTextColor(style.getOutcomingTextLinkColor());
                configureLinksBehavior(text);
            }
        }

        private void initOutGoing(View itemView) {
            bubble = itemView.findViewById(com.stfalcon.chatkit.R.id.bubble);
            text = itemView.findViewById(com.stfalcon.chatkit.R.id.messageText);
        }
    }

    /**
     * Default view holder implementation for incoming image message
     */
    public static class IncomingImageMessageViewHolder<MESSAGE extends MessageContentType.Image>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseIncomingMessageViewHolder<MESSAGE> {

        protected ImageView image;
        protected View imageOverlay;

        @Deprecated
        public IncomingImageMessageViewHolder(View itemView) {
            super(itemView);
            initViews(itemView);
        }

        public IncomingImageMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            initViews(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            super.onBind(message);
            if (image != null && imageLoader != null) {
                imageLoader.loadImage(image, message.getImageUrl(), getPayloadForImageLoader(message));
            }

            if (imageOverlay != null) {
                imageOverlay.setSelected(isSelected());
            }
        }

        @Override
        public final void applyStyle(MessagesListStyle style) {
            super.applyStyle(style);
            if (time != null) {
                time.setTextColor(style.getIncomingImageTimeTextColor());
                time.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getIncomingImageTimeTextSize());
                time.setTypeface(time.getTypeface(), style.getIncomingImageTimeTextStyle());
            }

            if (imageOverlay != null) {
                ViewCompat.setBackground(imageOverlay, style.getIncomingImageOverlayDrawable());
            }
        }

        /**
         * Override this method to have ability to pass custom data in ImageLoader for loading image(not avatar).
         *
         * @param message Message with image
         */
        protected Object getPayloadForImageLoader(MESSAGE message) {
            return null;
        }

        private void initViews(View itemView) {
            image = itemView.findViewById(com.stfalcon.chatkit.R.id.image);
            imageOverlay = itemView.findViewById(com.stfalcon.chatkit.R.id.imageOverlay);

            if (image instanceof RoundedImageView) {
                ((RoundedImageView) image).setCorners(
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius,
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius,
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius,
                        0
                );
            }
        }
    }

    /**
     * Default view holder implementation for outcoming image message
     */
    public static class OutcomingImageMessageViewHolder<MESSAGE extends MessageContentType.Image>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseOutcomingMessageViewHolder<MESSAGE> {

        protected ImageView image;
        protected View imageOverlay;

        @Deprecated
        public OutcomingImageMessageViewHolder(View itemView) {
            super(itemView);
            initOutcomingImage(itemView);
        }

        public OutcomingImageMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            initOutcomingImage(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            super.onBind(message);
            if (image != null && imageLoader != null) {
                imageLoader.loadImage(image, message.getImageUrl(), getPayloadForImageLoader(message));
            }

            if (imageOverlay != null) {
                imageOverlay.setSelected(isSelected());
            }
        }

        @Override
        public final void applyStyle(MessagesListStyle style) {
            super.applyStyle(style);
            if (time != null) {
                time.setTextColor(style.getOutcomingImageTimeTextColor());
                time.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getOutcomingImageTimeTextSize());
                time.setTypeface(time.getTypeface(), style.getOutcomingImageTimeTextStyle());
            }

            if (imageOverlay != null) {
                ViewCompat.setBackground(imageOverlay, style.getOutcomingImageOverlayDrawable());
            }
        }

        /**
         * Override this method to have ability to pass custom data in ImageLoader for loading image(not avatar).
         *
         * @param message Message with image
         */
        protected Object getPayloadForImageLoader(MESSAGE message) {
            return null;
        }

        private void initOutcomingImage(View itemView) {
            image = itemView.findViewById(com.stfalcon.chatkit.R.id.image);
            imageOverlay = itemView.findViewById(com.stfalcon.chatkit.R.id.imageOverlay);

            if (image instanceof RoundedImageView) {
                ((RoundedImageView) image).setCorners(
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius,
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius,
                        0,
                        com.stfalcon.chatkit.R.dimen.message_bubble_corners_radius
                );
            }
        }
    }

    /**
     * Default view holder implementation for date header
     */
    public static class DefaultDateHeaderViewHolder extends ViewHolder<Date>
            implements com.stfalcon.chatkit.messages.MessageHolders.DefaultMessageViewHolder {

        protected TextView text;
        protected String dateFormat;
        protected DateFormatter.Formatter dateHeadersFormatter;

        public DefaultDateHeaderViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(com.stfalcon.chatkit.R.id.messageText);
        }

        @Override
        public void onBind(Date date) {
            if (text != null) {
                String formattedDate = null;
                if (dateHeadersFormatter != null) formattedDate = dateHeadersFormatter.format(date);
                text.setText(formattedDate == null ? DateFormatter.format(date, dateFormat) : formattedDate);
            }
        }

        @Override
        public void applyStyle(MessagesListStyle style) {
            if (text != null) {
                text.setTextColor(style.getDateHeaderTextColor());
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getDateHeaderTextSize());
                text.setTypeface(text.getTypeface(), style.getDateHeaderTextStyle());
                text.setPadding(style.getDateHeaderPadding(), style.getDateHeaderPadding(),
                        style.getDateHeaderPadding(), style.getDateHeaderPadding());
            }
            dateFormat = style.getDateHeaderFormat();
            dateFormat = dateFormat == null ? DateFormatter.Template.STRING_DAY_MONTH_YEAR.get() : dateFormat;
        }
    }

    /**
     * Base view holder for incoming message
     */
    public abstract static class BaseIncomingMessageViewHolder<MESSAGE extends IMessage>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<MESSAGE> implements com.stfalcon.chatkit.messages.MessageHolders.DefaultMessageViewHolder {

        protected TextView time;
        protected ImageView userAvatar;

        @Deprecated
        public BaseIncomingMessageViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }

        public BaseIncomingMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            init(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            if (time != null) {
                time.setText(DateFormatter.format(message.getCreatedAt(), DateFormatter.Template.TIME));
            }

            if (userAvatar != null) {
                boolean isAvatarExists = imageLoader != null
                        && message.getUser().getAvatar() != null
                        && !message.getUser().getAvatar().isEmpty();

                userAvatar.setVisibility(isAvatarExists ? View.VISIBLE : View.GONE);
                if (isAvatarExists) {
                    imageLoader.loadImage(userAvatar, message.getUser().getAvatar(), null);
                }
            }
        }

        @Override
        public void applyStyle(MessagesListStyle style) {
            if (time != null) {
                time.setTextColor(style.getIncomingTimeTextColor());
                time.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getIncomingTimeTextSize());
                time.setTypeface(time.getTypeface(), style.getIncomingTimeTextStyle());
            }

            if (userAvatar != null) {
                userAvatar.getLayoutParams().width = style.getIncomingAvatarWidth();
                userAvatar.getLayoutParams().height = style.getIncomingAvatarHeight();
            }

        }

        private void init(View itemView) {
            time = itemView.findViewById(com.stfalcon.chatkit.R.id.messageTime);
            userAvatar = itemView.findViewById(com.stfalcon.chatkit.R.id.messageUserAvatar);
        }
    }

    /**
     * Base view holder for outcoming message
     */
    public abstract static class BaseOutcomingMessageViewHolder<MESSAGE extends IMessage>
            extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<MESSAGE> implements com.stfalcon.chatkit.messages.MessageHolders.DefaultMessageViewHolder {

        protected TextView time;

        @Deprecated
        public BaseOutcomingMessageViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }

        public BaseOutcomingMessageViewHolder(View itemView, Object payload) {
            super(itemView, payload);
            init(itemView);
        }

        @Override
        public void onBind(MESSAGE message) {
            if (time != null) {
                time.setText(DateFormatter.format(message.getCreatedAt(), DateFormatter.Template.TIME));
            }
        }

        @Override
        public void applyStyle(MessagesListStyle style) {
            if (time != null) {
                time.setTextColor(style.getOutcomingTimeTextColor());
                time.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getOutcomingTimeTextSize());
                time.setTypeface(time.getTypeface(), style.getOutcomingTimeTextStyle());
            }
        }

        private void init(View itemView) {
            time = itemView.findViewById(com.stfalcon.chatkit.R.id.messageTime);
        }
    }

    /*
     * DEFAULTS
     * */

    interface DefaultMessageViewHolder {
        void applyStyle(MessagesListStyle style);
    }

    private static class DefaultIncomingTextMessageViewHolder
            extends com.stfalcon.chatkit.messages.MessageHolders.IncomingTextMessageViewHolder<IMessage> {

        public DefaultIncomingTextMessageViewHolder(View itemView) {
            super(itemView, null);
        }
    }

    private static class DefaultOutcomingTextMessageViewHolder
            extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingTextMessageViewHolder<IMessage> {

        public DefaultOutcomingTextMessageViewHolder(View itemView) {
            super(itemView, null);
        }
    }

    private static class DefaultIncomingImageMessageViewHolder
            extends com.stfalcon.chatkit.messages.MessageHolders.IncomingImageMessageViewHolder<MessageContentType.Image> {

        public DefaultIncomingImageMessageViewHolder(View itemView) {
            super(itemView, null);
        }
    }

    private static class DefaultOutcomingImageMessageViewHolder
            extends com.stfalcon.chatkit.messages.MessageHolders.OutcomingImageMessageViewHolder<MessageContentType.Image> {

        public DefaultOutcomingImageMessageViewHolder(View itemView) {
            super(itemView, null);
        }
    }

    private static class ContentTypeConfig<TYPE extends MessageContentType> {

        private byte type;
        private com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<TYPE> incomingConfig;
        private com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<TYPE> outcomingConfig;

        private ContentTypeConfig(
                byte type, com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<TYPE> incomingConfig, com.stfalcon.chatkit.messages.MessageHolders.HolderConfig<TYPE> outcomingConfig) {

            this.type = type;
            this.incomingConfig = incomingConfig;
            this.outcomingConfig = outcomingConfig;
        }
    }

    private static class HolderConfig<T extends IMessage> {

        protected Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends T>> holder;
        protected int layout;
        protected Object payload;

        HolderConfig(Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends T>> holder, int layout) {
            this.holder = holder;
            this.layout = layout;
        }

        HolderConfig(Class<? extends com.stfalcon.chatkit.messages.MessageHolders.BaseMessageViewHolder<? extends T>> holder, int layout, Object payload) {
            this.holder = holder;
            this.layout = layout;
            this.payload = payload;
        }
    }
}
