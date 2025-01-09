package com.devbeans.io.chat.viewmodels;

import androidx.lifecycle.ViewModel;

import com.devbeans.io.chat.models.ChatRoom;

import java.util.ArrayList;
import java.util.List;


//**********************************************
public class HomeFragmentViewModel
        extends ViewModel
//**********************************************
{


    //*********************************************************
    public HomeFragmentViewModel()
    //*********************************************************
    {
        super();
    }

    //*********************************************************
    private List<ChatRoom> dummyData()
    //*********************************************************
    {

        return new ArrayList<>();
    }


}
