package com.devbeans.io.chat.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devbeans.io.chat.models.Contact;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class ContactFragmentViewModel
        extends ViewModel
//************************************************************
{
    MutableLiveData<List<Contact>> contactList = new MutableLiveData<>();

    //************************************************************
    public ContactFragmentViewModel()
    //************************************************************
    {
        super();
        contactList.postValue(dummyData());
    }

    //************************************************************
    public MutableLiveData<List<Contact>> getContacts()
    //************************************************************
    {
        return contactList;
    }

    //*********************************************************
    private List<Contact> dummyData()
    //*********************************************************
    {
        List<Contact> chatRoomList = new ArrayList<>();
        String sampleText = "This is a sample Text for showing sample of view";
        chatRoomList.add(new Contact("Fox Kol","",""));
        chatRoomList.add(new Contact("Amin Kol","",""));
        chatRoomList.add(new Contact("Fox Kol","",""));
        chatRoomList.add(new Contact("Bajon Kol","",""));
        chatRoomList.add(new Contact("Aajon Kol","",""));
        return chatRoomList;
    }
}
