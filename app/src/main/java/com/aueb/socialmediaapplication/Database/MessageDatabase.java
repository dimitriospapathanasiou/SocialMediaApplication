package com.aueb.socialmediaapplication.Database;

import com.aueb.socialmediaapplication.Entities.Message;

import java.util.ArrayList;

public class MessageDatabase {
    protected static ArrayList<Message> messageList = new ArrayList<>();
    private static int messageIdCounter = 0;

    public Message getmessagefromId(String id){
        for(Message m : messageList){
            if(String.valueOf(m.getId()).equals(id)){
                return m;
            }
        }
        return null;
    }


    public void register(Message message) {
        delete(message.getId());
        messageList.add(message);
    }

    public void delete(int messageId) {
        for (Message m : messageList) {
            if (m.getId() == messageId) {
                messageList.remove(m);
                break;
            }
        }
    }

    public int nextId() {
        messageIdCounter++;
        return messageIdCounter;
    }

    public ArrayList<Message> getAllMessages(){
        return messageList;
    }

}
