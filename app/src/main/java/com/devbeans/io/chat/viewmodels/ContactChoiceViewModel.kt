package com.devbeans.io.chat.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.ContactChoice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A ViewModel class responsible for managing contact choices and selected contacts.
 */
class ContactChoiceViewModel : ViewModel() {

    private val _contactChoices = MutableLiveData<List<ContactChoice>>()
    val contactChoices: LiveData<List<ContactChoice>> get() = _contactChoices

    private val _selectedContacts = MutableLiveData<List<Contact>>()
    val selectedContacts: LiveData<List<Contact>> get() = _selectedContacts

    /**
     * Load contact choices based on matching contacts from listA and listB.
     *
     * @param listA List of contacts from the database.
     * @param listB List of contacts from a file.
     */
    fun loadContactChoices(listA: List<Contact>, listB: List<Contact>) {
        viewModelScope.launch(Dispatchers.IO) {
            val choices = listA.mapNotNull { contactA ->
                // find matching contactFromFile from listB
                listB.find { it.chatUserId == contactA.chatUserId }?.let { matchingContactB ->
                    ContactChoice(contactFromDb = contactA, contactFromFile = matchingContactB)
                }
            }
            withContext(Dispatchers.Main) {
                _contactChoices.value = choices
            }
        }
    }

    /**
     * Handle contact choice selection and update the database and selectedContacts LiveData.
     *
     * @param selectedContact Selected Contact object.
     */
    fun onContactChoiceSelected(selectedContact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            val selectedChoice = contactChoices.value?.find { it.contactFromDb == selectedContact || it.contactFromFile == selectedContact } ?: return@launch

            val (contactToKeep, contactToReplace) = if (selectedChoice.contactFromDb == selectedContact) {
                selectedChoice.contactFromDb to selectedChoice.contactFromFile
            } else {
                selectedChoice.contactFromFile to selectedChoice.contactFromDb
            }

            MainApp.appContext?.contactsDao?.deleteContactByChatUserId(contactToReplace.chatUserId!!)
            MainApp.appContext?.contactsDao?.insert(contactToKeep)
        }
    }
}
