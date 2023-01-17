package com.aueb.socialmediaapplication.Entities;

public class Message {

    private String messageText;
    private String sender;
    private String receiver;
    private int id;
    private int like;
    private int status;

    public Message(int id, String sender, String receiver, String messageText, int like, int status){
        this.messageText = messageText;
        this.sender = sender;
        this.receiver = receiver;
        this.like = like;
        this.id = id;
        this.status = status;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
