package com.aueb.socialmediaapplication.Activities;

import com.aueb.socialmediaapplication.Entities.User;

import java.util.List;

public interface ContactInterface {
    void showUsers(List<User> songList);
    //void receiveUsername(String username);
    void openChat(String name);
}
