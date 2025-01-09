package com.devbeans.io.chat.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.models.ChatRoom;

import java.util.ArrayList;
import java.util.List;


/**
 * Will be responsible for all all business logic
 * of FolderFragment
 */
//************************************************************
public class FoldersFragmentViewModel
        extends ViewModel
//************************************************************
{


    MutableLiveData<List<ChatRoom>> mChatRoomList = new MutableLiveData<>();


    /**
     * Initializing Data when the ViewModel is created in Fragment Class
     * of the ViewModel
     */
    //************************************************************
    public FoldersFragmentViewModel()
    //************************************************************
    {
        super();
        mChatRoomList.postValue(dummyData());
    }

    /**
     * for returning data so we can observe the data change
     * at any instance
     *
     * @return mChatRoomList
     */
    //************************************************************
    public MutableLiveData<List<ChatRoom>> getChatRoomList()
    //************************************************************
    {
        return mChatRoomList;
    }

    /**
     * Data which is set only for testing purposes further this will be
     * changed data coming from tha API
     *
     * @return dummyData
     */
    //*********************************************************
    private List<ChatRoom> dummyData()
    //*********************************************************
    {
        List<ChatRoom> chatRoomList = new ArrayList<>();
        String sampleText = "This is a sample Text for showing sample of view";
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_2, "Company chat group", sampleText, "2 min Ago", true));
        chatRoomList.add(new ChatRoom(R.drawable.ic_avatar_1, "Amin Kol", sampleText, "2 min Ago", true));
        return chatRoomList;
    }
}
