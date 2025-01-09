package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getPayLoad", "actualPayload", "Lcom/devbeans/io/chat/models/Payload;", "AckPayload", "ConfirmAckPayload", "ConfirmAckPayloadWithConv", "DeletePayload", "EditPayload", "ToSendPayload", "app_debug"})
public final class PayloadFilter {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.PayloadFilter INSTANCE = null;
    private static final java.lang.String TAG = null;
    
    private PayloadFilter() {
        super();
    }
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPayLoad(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload actualPayload) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$ConfirmAckPayload;", "", "ackId", "", "senderId", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAckId", "()Ljava/lang/String;", "getSenderId", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ConfirmAckPayload {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "ackId")
        private final java.lang.String ackId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.ConfirmAckPayload copy(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String type) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ConfirmAckPayload(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String type) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAckId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$ConfirmAckPayloadWithConv;", "", "ackId", "", "senderId", "type", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAckId", "()Ljava/lang/String;", "getConversationId", "getSenderId", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ConfirmAckPayloadWithConv {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "ackId")
        private final java.lang.String ackId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationId")
        private final java.lang.String conversationId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.ConfirmAckPayloadWithConv copy(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ConfirmAckPayloadWithConv(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAckId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationId() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$AckPayload;", "", "ackId", "", "type", "conversationId", "userChatId", "senderId", "conversationType", "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAckId", "()Ljava/lang/String;", "getConversationId", "getConversationType", "getMessageId", "getSenderId", "getType", "getUserChatId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class AckPayload {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "ackId")
        private final java.lang.String ackId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationId")
        private final java.lang.String conversationId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "userChatId")
        private final java.lang.String userChatId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationType")
        private final java.lang.String conversationType = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "messageId")
        private final java.lang.String messageId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.AckPayload copy(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public AckPayload(@org.jetbrains.annotations.NotNull
        java.lang.String ackId, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAckId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserChatId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessageId() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0011H\u00c6\u0003J\t\u0010,\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00af\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0011H\u00d6\u0001J\t\u0010<\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017\u00a8\u0006="}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$DeletePayload;", "", "type", "", "conversationId", "userChatId", "conversationType", "messageId", "createdAt", "data", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/encryption/MappedPayload;", "senderId", "senderPubKey", "recipientPubKeyFingerprint", "nextDHKey", "messageCounter", "", "chainIndex", "aVRatchetKeyMaterial", "messageCipher", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAVRatchetKeyMaterial", "()Ljava/lang/String;", "getChainIndex", "()I", "getConversationId", "getConversationType", "getCreatedAt", "getData", "()Ljava/util/ArrayList;", "getMessageCipher", "getMessageCounter", "getMessageId", "getNextDHKey", "getRecipientPubKeyFingerprint", "getSenderId", "getSenderPubKey", "getType", "getUserChatId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DeletePayload {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationId")
        private final java.lang.String conversationId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "userChatId")
        private final java.lang.String userChatId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationType")
        private final java.lang.String conversationType = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "messageId")
        private final java.lang.String messageId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "createdAt")
        private final java.lang.String createdAt = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "data")
        private final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "senderPubKey")
        private final java.lang.String senderPubKey = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "recipientPubKeyFingerprint")
        private final java.lang.String recipientPubKeyFingerprint = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "nextDHKey")
        private final java.lang.String nextDHKey = null;
        @com.google.gson.annotations.SerializedName(value = "messageCounter")
        private final int messageCounter = 0;
        @com.google.gson.annotations.SerializedName(value = "chainIndex")
        private final int chainIndex = 0;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "aVRatchetKeyMaterial")
        private final java.lang.String aVRatchetKeyMaterial = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "messageCipher")
        private final java.lang.String messageCipher = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.DeletePayload copy(@org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.Nullable
        java.lang.String senderPubKey, @org.jetbrains.annotations.Nullable
        java.lang.String recipientPubKeyFingerprint, @org.jetbrains.annotations.Nullable
        java.lang.String nextDHKey, int messageCounter, int chainIndex, @org.jetbrains.annotations.Nullable
        java.lang.String aVRatchetKeyMaterial, @org.jetbrains.annotations.Nullable
        java.lang.String messageCipher) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public DeletePayload(@org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.Nullable
        java.lang.String senderPubKey, @org.jetbrains.annotations.Nullable
        java.lang.String recipientPubKeyFingerprint, @org.jetbrains.annotations.Nullable
        java.lang.String nextDHKey, int messageCounter, int chainIndex, @org.jetbrains.annotations.Nullable
        java.lang.String aVRatchetKeyMaterial, @org.jetbrains.annotations.Nullable
        java.lang.String messageCipher) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserChatId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessageId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCreatedAt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> getData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getSenderPubKey() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getRecipientPubKeyFingerprint() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getNextDHKey() {
            return null;
        }
        
        public final int component12() {
            return 0;
        }
        
        public final int getMessageCounter() {
            return 0;
        }
        
        public final int component13() {
            return 0;
        }
        
        public final int getChainIndex() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAVRatchetKeyMaterial() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component15() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getMessageCipher() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$EditPayload;", "", "type", "", "conversationId", "userChatId", "conversationType", "messageId", "createdAt", "data", "senderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getConversationType", "getCreatedAt", "getData", "getMessageId", "getSenderId", "getType", "getUserChatId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class EditPayload {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationId")
        private final java.lang.String conversationId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "userChatId")
        private final java.lang.String userChatId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationType")
        private final java.lang.String conversationType = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "messageId")
        private final java.lang.String messageId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "createdAt")
        private final java.lang.String createdAt = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "data")
        private final java.lang.String data = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.EditPayload copy(@org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.lang.String data, @org.jetbrains.annotations.NotNull
        java.lang.String senderId) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public EditPayload(@org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.lang.String data, @org.jetbrains.annotations.NotNull
        java.lang.String senderId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserChatId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessageId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCreatedAt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b8\b\u0086\b\u0018\u00002\u00020\u0001B\u00d7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001eJ\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0010H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0019H\u00c6\u0003J\t\u0010@\u001a\u00020\u0019H\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0005H\u00c6\u0003J\u00f5\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010M\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020\u0019H\u00d6\u0001J\t\u0010P\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u001a\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010)R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010)R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010)R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010)R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010 \u00a8\u0006Q"}, d2 = {"Lcom/devbeans/io/chat/utils/PayloadFilter$ToSendPayload;", "", "payloadCanShareForward", "", "conversationId", "", "conversationType", "createdAt", "data", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/encryption/MappedPayload;", "isExpire", "isForwarded", "isConfidential", "messageId", "msgExpiryTime", "", "type", "userChatId", "senderId", "senderPubKey", "secretModel", "recipientPubKeyFingerprint", "NextDHKey", "messageCounter", "", "chainIndex", "aVRatchetKeyMaterial", "readReceipts", "isViewOnce", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZZ)V", "getNextDHKey", "()Ljava/lang/String;", "getAVRatchetKeyMaterial", "getChainIndex", "()I", "getConversationId", "getConversationType", "getCreatedAt", "getData", "()Ljava/util/ArrayList;", "()Z", "getMessageCounter", "getMessageId", "getMsgExpiryTime", "()J", "getPayloadCanShareForward", "getReadReceipts", "getRecipientPubKeyFingerprint", "getSecretModel", "getSenderId", "getSenderPubKey", "getType", "getUserChatId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class ToSendPayload {
        @com.google.gson.annotations.SerializedName(value = "payloadCanShareForward")
        private final boolean payloadCanShareForward = false;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationId")
        private final java.lang.String conversationId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "conversationType")
        private final java.lang.String conversationType = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "createdAt")
        private final java.lang.String createdAt = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "data")
        private final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data = null;
        @com.google.gson.annotations.SerializedName(value = "isExpire")
        private final boolean isExpire = false;
        @com.google.gson.annotations.SerializedName(value = "isForwarded")
        private final boolean isForwarded = false;
        @com.google.gson.annotations.SerializedName(value = "isConfidential")
        private final boolean isConfidential = false;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "messageId")
        private final java.lang.String messageId = null;
        @com.google.gson.annotations.SerializedName(value = "msgExpiryTime")
        private final long msgExpiryTime = 0L;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "userChatId")
        private final java.lang.String userChatId = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "senderId")
        private final java.lang.String senderId = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "senderPubKey")
        private final java.lang.String senderPubKey = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "secretModel")
        private final java.lang.String secretModel = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "recipientPubKeyFingerprint")
        private final java.lang.String recipientPubKeyFingerprint = null;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "nextDHKey")
        private final java.lang.String NextDHKey = null;
        @com.google.gson.annotations.SerializedName(value = "messageCounter")
        private final int messageCounter = 0;
        @com.google.gson.annotations.SerializedName(value = "chainIndex")
        private final int chainIndex = 0;
        @org.jetbrains.annotations.Nullable
        @com.google.gson.annotations.SerializedName(value = "aVRatchetKeyMaterial")
        private final java.lang.String aVRatchetKeyMaterial = null;
        @com.google.gson.annotations.SerializedName(value = "readReceipts")
        private final boolean readReceipts = false;
        @com.google.gson.annotations.SerializedName(value = "isViewOnce")
        private final boolean isViewOnce = false;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.PayloadFilter.ToSendPayload copy(boolean payloadCanShareForward, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data, boolean isExpire, boolean isForwarded, boolean isConfidential, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, long msgExpiryTime, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.Nullable
        java.lang.String senderPubKey, @org.jetbrains.annotations.Nullable
        java.lang.String secretModel, @org.jetbrains.annotations.Nullable
        java.lang.String recipientPubKeyFingerprint, @org.jetbrains.annotations.Nullable
        java.lang.String NextDHKey, int messageCounter, int chainIndex, @org.jetbrains.annotations.Nullable
        java.lang.String aVRatchetKeyMaterial, boolean readReceipts, boolean isViewOnce) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ToSendPayload(boolean payloadCanShareForward, @org.jetbrains.annotations.NotNull
        java.lang.String conversationId, @org.jetbrains.annotations.NotNull
        java.lang.String conversationType, @org.jetbrains.annotations.NotNull
        java.lang.String createdAt, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> data, boolean isExpire, boolean isForwarded, boolean isConfidential, @org.jetbrains.annotations.NotNull
        java.lang.String messageId, long msgExpiryTime, @org.jetbrains.annotations.NotNull
        java.lang.String type, @org.jetbrains.annotations.NotNull
        java.lang.String userChatId, @org.jetbrains.annotations.NotNull
        java.lang.String senderId, @org.jetbrains.annotations.Nullable
        java.lang.String senderPubKey, @org.jetbrains.annotations.Nullable
        java.lang.String secretModel, @org.jetbrains.annotations.Nullable
        java.lang.String recipientPubKeyFingerprint, @org.jetbrains.annotations.Nullable
        java.lang.String NextDHKey, int messageCounter, int chainIndex, @org.jetbrains.annotations.Nullable
        java.lang.String aVRatchetKeyMaterial, boolean readReceipts, boolean isViewOnce) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getPayloadCanShareForward() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getConversationType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCreatedAt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.devbeans.io.chat.encryption.MappedPayload> getData() {
            return null;
        }
        
        public final boolean component6() {
            return false;
        }
        
        public final boolean isExpire() {
            return false;
        }
        
        public final boolean component7() {
            return false;
        }
        
        public final boolean isForwarded() {
            return false;
        }
        
        public final boolean component8() {
            return false;
        }
        
        public final boolean isConfidential() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessageId() {
            return null;
        }
        
        public final long component10() {
            return 0L;
        }
        
        public final long getMsgExpiryTime() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component12() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserChatId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component13() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderId() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getSenderPubKey() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component15() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getSecretModel() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component16() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getRecipientPubKeyFingerprint() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component17() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getNextDHKey() {
            return null;
        }
        
        public final int component18() {
            return 0;
        }
        
        public final int getMessageCounter() {
            return 0;
        }
        
        public final int component19() {
            return 0;
        }
        
        public final int getChainIndex() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component20() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAVRatchetKeyMaterial() {
            return null;
        }
        
        public final boolean component21() {
            return false;
        }
        
        public final boolean getReadReceipts() {
            return false;
        }
        
        public final boolean component22() {
            return false;
        }
        
        public final boolean isViewOnce() {
            return false;
        }
    }
}