package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

/**
 * Represents an Avatar which the user can choose, edit, and render into a bitmap via the renderer.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar;", "", "databaseId", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "(Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;)V", "getDatabaseId", "()Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "isSameAs", "", "other", "withDatabaseId", "Companion", "DatabaseId", "Photo", "Resource", "Text", "Vector", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Photo;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Resource;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Text;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Vector;", "app_debug"})
public abstract class Avatar {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "databaseId")
    private final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.Avatar.Companion Companion = null;
    
    private Avatar(com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId getDatabaseId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public com.devbeans.io.chat.utils.avatar.Avatar withDatabaseId(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
        return null;
    }
    
    public abstract boolean isSameAs(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.Avatar other);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$Resource;", "Lcom/devbeans/io/chat/utils/avatar/Avatar;", "resourceId", "", "color", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "(ILcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;)V", "getColor", "()Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "getResourceId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "isSameAs", "toString", "", "app_debug"})
    public static final class Resource extends com.devbeans.io.chat.utils.avatar.Avatar {
        @com.google.gson.annotations.SerializedName(value = "resourceId")
        private final int resourceId = 0;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "color")
        private final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Resource copy(int resourceId, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color) {
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
        
        public Resource(int resourceId, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color) {
            super(null);
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getResourceId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair getColor() {
            return null;
        }
        
        @java.lang.Override
        public boolean isSameAs(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar other) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$Text;", "Lcom/devbeans/io/chat/utils/avatar/Avatar;", "text", "", "color", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "databaseId", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "(Ljava/lang/String;Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;)V", "getColor", "()Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "getDatabaseId", "()Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isSameAs", "toString", "withDatabaseId", "app_debug"})
    public static final class Text extends com.devbeans.io.chat.utils.avatar.Avatar {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "text")
        private final java.lang.String text = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "color")
        private final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "databaseId")
        private final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Text copy(@org.jetbrains.annotations.NotNull
        java.lang.String text, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
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
        
        public Text(@org.jetbrains.annotations.NotNull
        java.lang.String text, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getText() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair getColor() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId getDatabaseId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar withDatabaseId(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            return null;
        }
        
        @java.lang.Override
        public boolean isSameAs(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar other) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$Vector;", "Lcom/devbeans/io/chat/utils/avatar/Avatar;", "key", "", "color", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "databaseId", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "(Ljava/lang/String;Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;)V", "getColor", "()Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "getDatabaseId", "()Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "getKey", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isSameAs", "toString", "withDatabaseId", "app_debug"})
    public static final class Vector extends com.devbeans.io.chat.utils.avatar.Avatar {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "key")
        private final java.lang.String key = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "color")
        private final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color = null;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "databaseId")
        private final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Vector copy(@org.jetbrains.annotations.NotNull
        java.lang.String key, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
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
        
        public Vector(@org.jetbrains.annotations.NotNull
        java.lang.String key, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ColorPair color, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getKey() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair getColor() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId getDatabaseId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar withDatabaseId(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            return null;
        }
        
        @java.lang.Override
        public boolean isSameAs(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar other) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$Photo;", "Lcom/devbeans/io/chat/utils/avatar/Avatar;", "uri", "Landroid/net/Uri;", "size", "", "databaseId", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "(Landroid/net/Uri;JLcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;)V", "getDatabaseId", "()Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "getSize", "()J", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isSameAs", "toString", "", "withDatabaseId", "app_debug"})
    public static final class Photo extends com.devbeans.io.chat.utils.avatar.Avatar {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "uri")
        private final android.net.Uri uri = null;
        @com.google.gson.annotations.SerializedName(value = "size")
        private final long size = 0L;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "databaseId")
        private final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Photo copy(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, long size, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
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
        
        public Photo(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, long size, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.net.Uri getUri() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long getSize() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId getDatabaseId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.devbeans.io.chat.utils.avatar.Avatar withDatabaseId(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId databaseId) {
            return null;
        }
        
        @java.lang.Override
        public boolean isSameAs(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatar other) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "", "()V", "DoNotPersist", "NotSet", "Saved", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$DoNotPersist;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$NotSet;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$Saved;", "app_debug"})
    public static abstract class DatabaseId {
        
        private DatabaseId() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$DoNotPersist;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "()V", "app_debug"})
        public static final class DoNotPersist extends com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId {
            @org.jetbrains.annotations.NotNull
            public static final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId.DoNotPersist INSTANCE = null;
            
            private DoNotPersist() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$NotSet;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "()V", "app_debug"})
        public static final class NotSet extends com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId {
            @org.jetbrains.annotations.NotNull
            public static final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId.NotSet INSTANCE = null;
            
            private NotSet() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId$Saved;", "Lcom/devbeans/io/chat/utils/avatar/Avatar$DatabaseId;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Saved extends com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId {
            private final long id = 0L;
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.avatar.Avatar.DatabaseId.Saved copy(long id) {
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
            
            public Saved(long id) {
                super();
            }
            
            public final long component1() {
                return 0L;
            }
            
            public final long getId() {
                return 0L;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatar$Companion;", "", "()V", "getDefaultForGroup", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Resource;", "getDefaultForSelf", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Resource getDefaultForSelf() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatar.Resource getDefaultForGroup() {
            return null;
        }
    }
}