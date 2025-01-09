package com.devbeans.io.chat.verifypin;

import java.lang.System;

/**
 * This class is responsible for creating and verifying pins for the application.
 * It supports two different activities: [MainActivity] and [AutoLockSettingActivity]
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0006\u0010*\u001a\u00020\u0019J\u0006\u0010+\u001a\u00020\u0019J\b\u0010,\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/devbeans/io/chat/verifypin/CreatePinActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "atPage", "", "binding", "Lcom/devbeans/io/chat/databinding/ActivityCreatePinBinding;", "editTexts", "", "Landroid/widget/EditText;", "getEditTexts", "()[Landroid/widget/EditText;", "setEditTexts", "([Landroid/widget/EditText;)V", "[Landroid/widget/EditText;", "editTextsTwo", "getEditTextsTwo", "setEditTextsTwo", "isFromSettings", "", "pinOne", "", "pinTwo", "toggle", "checkFromSettings", "", "clearTextFirst", "clearTextTwo", "getPinFirst", "getPinTwo", "handlePages", "verifyPin", "initViews", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performNext", "performVerify", "setupEditTexts", "setupListeners", "setupPinCreationViews", "showErrorFirst", "showErrorTwo", "verifyPinFromSettings", "Companion", "app_debug"})
public final class CreatePinActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.devbeans.io.chat.databinding.ActivityCreatePinBinding binding;
    private java.lang.String pinOne = "";
    private java.lang.String pinTwo = "";
    private boolean isFromSettings = false;
    private boolean toggle = false;
    private int atPage = 0;
    public android.widget.EditText[] editTexts;
    public android.widget.EditText[] editTextsTwo;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.verifypin.CreatePinActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_PIN = "com.chat.pin";
    
    public CreatePinActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText[] getEditTexts() {
        return null;
    }
    
    public final void setEditTexts(@org.jetbrains.annotations.NotNull
    android.widget.EditText[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText[] getEditTextsTwo() {
        return null;
    }
    
    public final void setEditTextsTwo(@org.jetbrains.annotations.NotNull
    android.widget.EditText[] p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Sets up the necessary listeners for the views in the activity.
     */
    private final void setupListeners() {
    }
    
    /**
     * Verifies the second pin entered by the user.
     * If the pins match, save the pin and move to the main activity.
     */
    private final void performVerify() {
    }
    
    /**
     * Handles the next action based on the current state of the application.
     * If the activity is launched from settings, verify the pin.
     * Otherwise, set up the views for pin creation.
     */
    private final void performNext() {
    }
    
    /**
     * Verifies the pin entered by the user when the activity is launched from settings.
     */
    private final void verifyPinFromSettings() {
    }
    
    /**
     * Handles the different pages/states for the pin verification process.
     * @param verifyPin The entered pin to be verified.
     */
    private final void handlePages(java.lang.String verifyPin) {
    }
    
    /**
     * Sets up the views for pin creation process.
     */
    private final void setupPinCreationViews() {
    }
    
    /**
     * Initializes the views based on the current state of the activity.
     */
    private final void initViews() {
    }
    
    private final void setupEditTexts() {
    }
    
    public final void clearTextFirst() {
    }
    
    public final void clearTextTwo() {
    }
    
    public final void showErrorFirst() {
    }
    
    public final void showErrorTwo() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPinFirst() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPinTwo() {
        return null;
    }
    
    /**
     * Determines if the activity was launched from the settings.
     */
    private final void checkFromSettings() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/verifypin/CreatePinActivity$Companion;", "", "()V", "KEY_PIN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}