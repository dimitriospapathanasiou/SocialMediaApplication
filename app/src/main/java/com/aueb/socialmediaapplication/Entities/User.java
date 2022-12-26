package com.aueb.socialmediaapplication.Entities;

import com.aueb.socialmediaapplication.Activities.InputException;
import com.aueb.socialmediaapplication.Util.InputUtil;

import java.util.ArrayList;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private ArrayList<Message> messagesSent = new ArrayList<Message>();
    private ArrayList<Message> messagesReceived = new ArrayList<Message>();


    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public void setUsername(String name) throws InputException {
        if (name.isEmpty()) {
            throw new InputException("Invalid username");
        }
        username = name;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) throws InputException {
        if (email.isEmpty()) {
            throw new InputException("Invalid email");
        }
        if (!InputUtil.isEmail(email)) {
            throw new InputException("Invalid email format");
        }
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) throws InputException {
        if (name.isEmpty()) {
            throw new InputException("Invalid name");
        }
        username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InputException {
        if (password.isEmpty()) {
            throw new InputException("Invalid password");
        }
        this.password = password;
    }

    public String getLastMessage() {
        ArrayList<Message> messagesReceived = getMessagesReceived();
        ArrayList<Message> messagesSent = getMessagesSent();
        if (messagesReceived.isEmpty()) {
            int lastSent = messagesSent.size() - 1;
            Message messageLastSent = messagesSent.get(lastSent);
            return messageLastSent.getMessageText();
        }
        else if (messagesSent.isEmpty()){
            int lastReceived = messagesReceived.size() - 1;
            Message messageLastReceived = messagesReceived.get(lastReceived);
            return messageLastReceived.getMessageText();
        }
        else {
            int lastReceived = messagesReceived.size() - 1;
            int lastSent = messagesSent.size() - 1;

                Message messageLastSent = messagesSent.get(lastSent);
                Message messageLastReceived = messagesReceived.get(lastReceived);
                if (messageLastSent.getId() < messageLastReceived.getId()) {
                    return messageLastReceived.getMessageText();
                } else {
                    return messageLastSent.getMessageText();
                }
        }
    }



    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public ArrayList<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(ArrayList<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public ArrayList<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(ArrayList<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }
}
