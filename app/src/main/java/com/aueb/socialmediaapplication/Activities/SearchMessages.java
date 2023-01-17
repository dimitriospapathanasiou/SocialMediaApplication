package com.aueb.socialmediaapplication.Activities;

import android.util.Log;

import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.util.ArrayList;

public class SearchMessages {

    ChatRoomInterface view;
    MessageDatabase msgdb;

    //Initialisation of variables
    public SearchMessages(ChatRoomInterface view, MessageDatabase msgdb) {
        this.view = view;
        this.msgdb = msgdb;
    }

    public void loadMessages(String username, String name) {
        ArrayList<Message> messagesList= new ArrayList<Message>();
        ArrayList<Message> allMessages = msgdb.getAllMessages();
        for (Message m: allMessages){
            if ((m.getReceiver().equals(username) && m.getSender().equals(name)) || (m.getReceiver().equals(name) && m.getSender().equals(username))){
                Log.d("yos", m.getReceiver());
                Log.d("rrr", username);
                messagesList.add(m);
                Log.d("rmm", m.getMessageText()); }
        }
        view.showMessages(messagesList);

    }
}
