package com.devbeans.io.chat.ffmpeg;

import java.lang.System;

/**
 * Created by Ashvin Vavaliya on 10,December,2020
 * Simform Solutions Pvt Ltd.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001dJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 \u00a2\u0006\u0002\u0010!J)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010%JM\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010.JE\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u00100J)\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001dJ!\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b\u00a2\u0006\u0002\u00107J)\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001dJ5\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u000b\u00a2\u0006\u0002\u0010;J!\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u00107J5\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010AJ!\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u00107J)\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000f\u00a2\u0006\u0002\u0010FJ)\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010IJU\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0(2\b\u0010L\u001a\u0004\u0018\u00010\u000b2\b\u0010M\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010NJ=\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010QJ)\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001dJ9\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010WJY\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010ZJ)\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u001dJ!\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u00107J)\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010IJ9\u0010_\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010cJ1\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 \u00a2\u0006\u0002\u0010fJ)\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0002\u0010iR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006j"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/FFmpegQueryExtension;", "", "()V", "FRAME_RATE", "", "getFRAME_RATE", "()I", "setFRAME_RATE", "(I)V", "addTextOnVideo", "", "", "inputVideo", "textInput", "posX", "", "posY", "fontPath", "isTextBackgroundDisplay", "", "fontSize", "fontcolor", "output", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "addVideoWaterMark", "imageInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)[Ljava/lang/String;", "applyRatio", "ratio", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "audioMotion", "atempo", "", "(Ljava/lang/String;Ljava/lang/String;D)[Ljava/lang/String;", "audioVolumeUpdate", "inputFile", "volume", "(Ljava/lang/String;FLjava/lang/String;)[Ljava/lang/String;", "combineImagesAndVideos", "paths", "Ljava/util/ArrayList;", "Lcom/devbeans/io/chat/ffmpeg/Paths;", "Lkotlin/collections/ArrayList;", "width", "height", "second", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "combineVideos", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)[Ljava/lang/String;", "compressAudio", "inputAudioPath", "bitrate", "compressImage", "inputPath", "outputPath", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "tag", "compressor", "outputVideo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)[Ljava/lang/String;", "convertVideoToGIF", "cutAudio", "inputVideoPath", "startTime", "endTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "cutVideo", "extractAudio", "extractImages", "spaceOfFrame", "(Ljava/lang/String;Ljava/lang/String;F)[Ljava/lang/String;", "flipVideo", "degree", "(Ljava/lang/String;ILjava/lang/String;)[Ljava/lang/String;", "getResult", "inputs", "query", "queryAudio", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)[Ljava/lang/String;", "imageToVideo", "input", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)[Ljava/lang/String;", "mergeAudioVideo", "inputAudio", "mergeAudios", "inputAudioList", "duration", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "mergeGIF", "gifInput", "(Ljava/util/ArrayList;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)[Ljava/lang/String;", "mergeImageAndAudio", "inputImage", "removeAudioFromVideo", "rotateVideo", "videoFadeInFadeOut", "", "fadeInEndSeconds", "fadeOutStartSeconds", "(Ljava/lang/String;JIILjava/lang/String;)[Ljava/lang/String;", "videoMotion", "setpts", "(Ljava/lang/String;Ljava/lang/String;DD)[Ljava/lang/String;", "videoReverse", "isWithAudioReverse", "(Ljava/lang/String;ZLjava/lang/String;)[Ljava/lang/String;", "app_debug"})
public final class FFmpegQueryExtension {
    private int FRAME_RATE = 25;
    
    public FFmpegQueryExtension() {
        super();
    }
    
    public final int getFRAME_RATE() {
        return 0;
    }
    
    public final void setFRAME_RATE(int p0) {
    }
    
    /**
     * startTime = 00:00:00 HH:MM:SS
     * endTime = 00:00:00 HH:MM:SS
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] cutVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideoPath, @org.jetbrains.annotations.Nullable
    java.lang.String startTime, @org.jetbrains.annotations.Nullable
    java.lang.String endTime, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    /**
     * compress and rotate images
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] compressImage(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath) {
        return null;
    }
    
    /**
     * compress images
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] compressImage(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath, @org.jetbrains.annotations.NotNull
    java.lang.String tag) {
        return null;
    }
    
    /**
     * second = how many long create the video in second
     * input = Local image path
     * width = video width
     * height = video height
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] imageToVideo(@org.jetbrains.annotations.NotNull
    java.lang.String input, @org.jetbrains.annotations.NotNull
    java.lang.String output, int second, @org.jetbrains.annotations.Nullable
    java.lang.Integer width, @org.jetbrains.annotations.Nullable
    java.lang.Integer height) {
        return null;
    }
    
    /**
     * posX = X position of water-mark in percentage (1% to 100%)
     * posY = Y position of water-mark in percentage (1% to 100%)
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] addVideoWaterMark(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String imageInput, @org.jetbrains.annotations.Nullable
    java.lang.Float posX, @org.jetbrains.annotations.Nullable
    java.lang.Float posY, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] addTextOnVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String textInput, @org.jetbrains.annotations.Nullable
    java.lang.Float posX, @org.jetbrains.annotations.Nullable
    java.lang.Float posY, @org.jetbrains.annotations.NotNull
    java.lang.String fontPath, boolean isTextBackgroundDisplay, int fontSize, @org.jetbrains.annotations.NotNull
    java.lang.String fontcolor, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] combineImagesAndVideos(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.ffmpeg.Paths> paths, @org.jetbrains.annotations.Nullable
    java.lang.Integer width, @org.jetbrains.annotations.Nullable
    java.lang.Integer height, @org.jetbrains.annotations.NotNull
    java.lang.String second, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] combineVideos(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.ffmpeg.Paths> paths, @org.jetbrains.annotations.Nullable
    java.lang.Integer width, @org.jetbrains.annotations.Nullable
    java.lang.Integer height, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    private final java.lang.String[] getResult(java.util.ArrayList<java.lang.String> inputs, java.lang.String query, java.lang.String queryAudio, java.util.ArrayList<com.devbeans.io.chat.ffmpeg.Paths> paths, java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] compressor(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.Nullable
    java.lang.Integer width, @org.jetbrains.annotations.Nullable
    java.lang.Integer height, @org.jetbrains.annotations.NotNull
    java.lang.String outputVideo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] extractImages(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output, float spaceOfFrame) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] extractAudio(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] videoMotion(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output, double setpts, double atempo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] videoReverse(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, boolean isWithAudioReverse, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] videoFadeInFadeOut(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, long duration, int fadeInEndSeconds, int fadeOutStartSeconds, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] convertVideoToGIF(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] rotateVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, int degree, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    /**
     * degree = 0: 90 Counter Clockwise and Vertical Flip  (default)
     * degree = 1: 90 Clockwise
     * degree = 2: 90 Counter Clockwise
     * degree = 3: 90 Clockwise and Vertical Flip
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] flipVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, int degree, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] mergeAudioVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String inputAudio, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] removeAudioFromVideo(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] mergeImageAndAudio(@org.jetbrains.annotations.NotNull
    java.lang.String inputImage, @org.jetbrains.annotations.NotNull
    java.lang.String inputAudio, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] applyRatio(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String ratio, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] mergeGIF(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.ffmpeg.Paths> gifInput, @org.jetbrains.annotations.Nullable
    java.lang.Float posX, @org.jetbrains.annotations.Nullable
    java.lang.Float posY, @org.jetbrains.annotations.Nullable
    java.lang.Float width, @org.jetbrains.annotations.Nullable
    java.lang.Float height, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] mergeAudios(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.devbeans.io.chat.ffmpeg.Paths> inputAudioList, @org.jetbrains.annotations.NotNull
    java.lang.String duration, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] audioVolumeUpdate(@org.jetbrains.annotations.NotNull
    java.lang.String inputFile, float volume, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] audioMotion(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideo, @org.jetbrains.annotations.NotNull
    java.lang.String output, double atempo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] cutAudio(@org.jetbrains.annotations.NotNull
    java.lang.String inputVideoPath, @org.jetbrains.annotations.Nullable
    java.lang.String startTime, @org.jetbrains.annotations.Nullable
    java.lang.String endTime, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] compressAudio(@org.jetbrains.annotations.NotNull
    java.lang.String inputAudioPath, @org.jetbrains.annotations.NotNull
    java.lang.String bitrate, @org.jetbrains.annotations.NotNull
    java.lang.String output) {
        return null;
    }
}