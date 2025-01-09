package com.devbeans.io.chat.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.models.ChatRoom;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class ArchiveActivityViewModel
        extends ViewModel
//************************************************************
{
    MutableLiveData<List<ChatRoom>> mChatRoomList = new MutableLiveData<>();


    //************************************************************
    public ArchiveActivityViewModel()
    //************************************************************
    {
        super();
        mChatRoomList.postValue(dummyData());
    }

    //************************************************************
    public MutableLiveData<List<ChatRoom>> getmChatRoomList()
    //************************************************************
    {
        return mChatRoomList;
    }

    //*********************************************************
    private List<ChatRoom> dummyData()
    //*********************************************************
    {
        List<ChatRoom> chatRoomList = new ArrayList<>();
        String sampleText = "This is a sample Text for showing sample of view";
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
//        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        return chatRoomList;
    }
}
