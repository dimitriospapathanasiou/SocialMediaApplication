package com.aueb.socialmediaapplication.Entities;

import com.aueb.socialmediaapplication.Activities.InputException;
import com.aueb.socialmediaapplication.Activities.InputUtil;

import java.util.ArrayList;

public class User {

    private int id;
    private  String username;
    private String email;
    private String password;
    private ArrayList<Message> messages = new ArrayList<Message>();

    public User(){

    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername(){

        return username;
    }

    public void setUsername(String name) throws InputException{
        if (name.isEmpty()){
            throw new InputException("Invalid username");
        }
        username = name;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) throws InputException{
        if (email.isEmpty()) {
            throw new InputException("Invalid email");
        }
        if (!InputUtil.isEmail(email)) {
            throw new InputException("Invalid email format");
        }
        this.email = email;
    }

    public String getUserName(){
        return username;
    }

    public void setUserName(String name) throws InputException{
        if (name.isEmpty()) {
            throw new InputException("Invalid name");
        }
        username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InputException{
        if (password.isEmpty()) {
            throw new InputException("Invalid password");
        }
        this.password = password;
    }


    public ArrayList<Message> getAllMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> ms){
        messages = ms;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

}
