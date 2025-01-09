package com.devbeans.io.chat.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devbeans.io.chat.models.Message;

import java.util.ArrayList;
import java.util.List;

//************************************************************
public class ChatViewModel
        extends ViewModel
//************************************************************
{
    MutableLiveData<List<Message>> mMessageList = new MutableLiveData<>();
    List<Message> messageList = new ArrayList<>();



    private enum TYPE {
        TEXT,AUDIO,VIDEO,FILE,IMAGE
    }


    //************************************************************
    public ChatViewModel()
    //************************************************************
    {
        super();
        dummyData();
        if (messageList.size() > 0)
            mMessageList.postValue(messageList);
    }

    //************************************************************
    public MutableLiveData<List<Message>> getMessageList()
    //************************************************************
    {
        return mMessageList;
    }

    //*********************************************************
    private void dummyData()
    //*********************************************************
    {
        Message message = new Message(0, 0, 0, "Hey Michelangelo!");
        message.setMe(true);


        Message message1 = new Message(0, 0, 0, "Good morning! My name is Steven");
        message1.setMe(false);
        message1.setType("text");
        messageList.add(message1);


        Message message2 = new Message(0, 0, 0, "Good morning! My name is Steven. I am a UX Designer from London and this is an example of a long message");
        message2.setMe(false);
        message2.setType("audio");
        messageList.add(message2);

        Message message3 = new Message(0, 0, 0, "Yes everything is going well thanks");
        message3.setMe(true);
        message3.setType("audio");
        messageList.add(message3);

        Message message4 = new Message(0, 0, 0, "We’re still waiting on the offer on our house to go through but I guess this type of thing can take a long time");
        message4.setMe(true);
        message4.setType("video");
        messageList.add(message4);


        Message message5 = new Message(0, 0, 0, "Yes to beers!");
        message5.setMe(true);
        message5.setType("file");
        messageList.add(message5);

        Message message6 = new Message(0, 0, 0, "Oh really? What’s the latest?");
        message6.setMe(false);
        message6.setType("video");
        messageList.add(message6);

        Message message7 = new Message(0, 0, 0, "No more news I’m afraid");
        message7.setMe(true);
        message7.setType("text");
        messageList.add(message7);

        Message message8 = new Message(0, 0, 0, "It’s been almost 3 months :/");
        message8.setMe(true);
        message8.setType("text");
        messageList.add(message8);

        Message message9 = new Message(0, 0, 0, "Hey Michelangelo!");
        message9.setMe(false);
        message9.setType("file");
        messageList.add(message9);

        Message message10 = new Message(0, 0, 0, "Good morning! My name is Steven");
        message10.setMe(false);
        message10.setType("text");
        messageList.add(message10);


        Message message12 = new Message(0, 0, 0, "Good morning! My name is Steven. I am a UX Designer from London and this is an example of a long message");
        message12.setMe(false);
        message12.setType("audio");
        messageList.add(message12);

        Message message13 = new Message(0, 0, 0, "Yes everything is going well thanks");
        message13.setMe(true);
        message13.setType("audio");
        messageList.add(message13);

        Message message14 = new Message(0, 0, 0, "We’re still waiting on the offer on our house to go through but I guess this type of thing can take a long time");
        message14.setMe(true);
        message14.setType("video");
        messageList.add(message14);


        Message message15 = new Message(0, 0, 0, "Yes to beers!");
        message15.setMe(true);
        message15.setType("file");
        messageList.add(message15);

        Message message16 = new Message(0, 0, 0, "Oh really? What’s the latest?");
        message16.setMe(false);
        message16.setType("video");
        messageList.add(message16);

        Message message17 = new Message(0, 0, 0, "No more news I’m afraid");
        message17.setMe(true);
        message17.setType("text");
        messageList.add(message17);

        Message message18 = new Message(0, 0, 0, "It’s been almost 3 months :/");
        message18.setMe(true);
        message18.setType("text");
        messageList.add(message18);

        Message message19 = new Message(0, 0, 0, "Hey Michelangelo!");
        message19.setMe(false);
        message19.setType("file");
        messageList.add(message19);

        Message message20 = new Message(0, 0, 0, "Good morning! My name is Steven");
        message20.setMe(false);
        message20.setType("text");
        messageList.add(message20);


        Message message21 = new Message(0, 0, 0, "Good morning! My name is Steven. I am a UX Designer from London and this is an example of a long message");
        message21.setMe(false);
        message21.setType("audio");
        messageList.add(message21);

//        Message message23 = new Message(0, 0, 0, "Yes everything is going well thanks");
//        message23.setMe(true);
//        message23.setType("audio");
//        messageList.add(message23);
//
//        Message message24 = new Message(0, 0, 0, "We’re still waiting on the offer on our house to go through but I guess this type of thing can take a long time");
//        message24.setMe(true);
//        message24.setType("video");
//        messageList.add(message24);
//
//
//        Message message25 = new Message(0, 0, 0, "Yes to beers!");
//        message25.setMe(true);
//        message25.setType("file");
//        messageList.add(message25);
//
//        Message message26 = new Message(0, 0, 0, "Oh really? What’s the latest?");
//        message26.setMe(false);
//        message26.setType("video");
//        messageList.add(message26);
//
//        Message message27 = new Message(0, 0, 0, "No more news I’m afraid");
//        message27.setMe(true);
//        message27.setType("text");
//        messageList.add(message27);
//
//        Message message28 = new Message(0, 0, 0, "It’s been almost 3 months :/");
//        message28.setMe(true);
//        message28.setType("text");
//        messageList.add(message28);
//
//        Message message29 = new Message(0, 0, 0, "Hey Michelangelo!");
//        message29.setMe(false);
//        message29.setType("file");
//        messageList.add(message29);
//
//        Message message30 = new Message(0, 0, 0, "Good morning! My name is Steven");
//        message30.setMe(false);
//        message30.setType("text");
//        messageList.add(message30);
//
//
//        Message message31 = new Message(0, 0, 0, "Good morning! My name is Steven. I am a UX Designer from London and this is an example of a long message");
//        message31.setMe(false);
//        message31.setType("audio");
//        messageList.add(message31);
//
//        Message message32 = new Message(0, 0, 0, "Yes everything is going well thanks");
//        message32.setMe(true);
//        message32.setType("audio");
//        messageList.add(message32);
//
//        Message message34 = new Message(0, 0, 0, "We’re still waiting on the offer on our house to go through but I guess this type of thing can take a long time");
//        message34.setMe(true);
//        message34.setType("video");
//        messageList.add(message34);
//
//
//        Message message35 = new Message(0, 0, 0, "Yes to beers!");
//        message35.setMe(true);
//        message35.setType("file");
//        messageList.add(message35);
//
//        Message message36 = new Message(0, 0, 0, "Oh really? What’s the latest?");
//        message36.setMe(false);
//        message36.setType("video");
//        messageList.add(message36);
//
//        Message message37 = new Message(0, 0, 0, "No more news I’m afraid");
//        message37.setMe(true);
//        message37.setType("text");
//        messageList.add(message37);
//
//        Message message38 = new Message(0, 0, 0, "It’s been almost 3 months :/");
//        message38.setMe(true);
//        message38.setType("text");
//        messageList.add(message38);
//
//        Message message39 = new Message(0, 0, 0, "Hey Michelangelo!");
//        message39.setMe(false);
//        message39.setType("file");
//        messageList.add(message39);


    }

}
