package com.aueb.socialmediaapplication.Activities;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;

import java.util.List;

public interface ChatRoomInterface {
    void showMessages(List<Message> messageList);

    void showSuccessSend();
    void writeToFile();

    String getText();
    String getSender();
    String getReceiver();
    int getLike();
    int getStatus();

    int getId();
}
