package com.devbeans.io.chat.viewmodels;

import java.lang.System;

/**
 * A ViewModel class responsible for managing contact choices and selected contacts.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/viewmodels/ContactChoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_contactChoices", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/devbeans/io/chat/models/ContactChoice;", "_selectedContacts", "Lcom/devbeans/io/chat/models/Contact;", "contactChoices", "Landroidx/lifecycle/LiveData;", "getContactChoices", "()Landroidx/lifecycle/LiveData;", "selectedContacts", "getSelectedContacts", "loadContactChoices", "", "listA", "listB", "onContactChoiceSelected", "selectedContact", "app_debug"})
public final class ContactChoiceViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ContactChoice>> _contactChoices = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.Contact>> _selectedContacts = null;
    
    public ContactChoiceViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.devbeans.io.chat.models.ContactChoice>> getContactChoices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.devbeans.io.chat.models.Contact>> getSelectedContacts() {
        return null;
    }
    
    /**
     * Load contact choices based on matching contacts from listA and listB.
     *
     * @param listA List of contacts from the database.
     * @param listB List of contacts from a file.
     */
    public final void loadContactChoices(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> listA, @org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> listB) {
    }
    
    /**
     * Handle contact choice selection and update the database and selectedContacts LiveData.
     *
     * @param selectedContact Selected Contact object.
     */
    public final void onContactChoiceSelected(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact selectedContact) {
    }
}