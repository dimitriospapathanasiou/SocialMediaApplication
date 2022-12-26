package com.aueb.socialmediaapplication.Entities;

public class Message {

    private String messageText;
    private String sender;
    private String receiver;
    private int id;

    public Message(String messageText, String sender, String receiver, int id){
        this.messageText = messageText;
        this.sender = sender;
        this.receiver = receiver;
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
