package com.aueb.socialmediaapplication.Entities;

import android.util.Log;

import com.aueb.socialmediaapplication.Activities.InputException;
import com.aueb.socialmediaapplication.Activities.ShowMessages;
import com.aueb.socialmediaapplication.Activities.UnreadChecks;
import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Util.InputUtil;

import java.util.ArrayList;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Message> messagesSent = new ArrayList<Message>();
    private ArrayList<Message> messagesReceived = new ArrayList<Message>();


    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getLastMessage(String username) {
        ArrayList<Message> messagesReceived = getMessagesReceived(username);
        ArrayList<Message> messagesSent = getMessagesSent(username);
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
            Log.d("avocado4ever", String.valueOf(messageLastSent.getId()));
            Log.d("avocado4infinity", String.valueOf(messageLastReceived.getId()));
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

    public ArrayList<Message> getMessagesSent(String username) {
        MessageDatabase messageDb = ShowMessages.fillWithMessages();
        ArrayList<Message> messages = messageDb.getAllMessages();
        for(Message m: messages) {
            if(m.getSender().equals(username))
                messagesSent.add(m);
        }
        return messagesSent;
    }

    public void setMessagesSent(ArrayList<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public ArrayList<Message> getMessagesReceived(String username) {
        MessageDatabase messageDb = ShowMessages.fillWithMessages();
        ArrayList<Message> messages = messageDb.getAllMessages();
        for(Message m: messages) {
            if(m.getReceiver().equals(username))
                messagesReceived.add(m);
        }
        return messagesReceived;
    }

    public void setMessagesReceived(ArrayList<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
