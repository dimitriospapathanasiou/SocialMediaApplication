package com.aueb.socialmediaapplication.Activities;

import android.util.Log;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.util.ArrayList;

public class SearchUsers {
    ContactInterface view;
    UserDatabase userDB;

    //Initialisation of variables
    public SearchUsers(ContactInterface view, UserDatabase usdb) {
        this.view = view;
        this.userDB = usdb;
    }

    //Processes user list for ContactList catalogue
    //Adds a user depending on Receiver-Sender status
    //of a message
    public void loadUsers(User user) {
        ArrayList<User> userList= new ArrayList<User>();
        ArrayList<User> allUsers = userDB.getAllUsers();
        Log.d("allusers", String.valueOf(allUsers));
        ArrayList<Message> messagesReceived = user.getMessagesReceived(user.getUserName());
        ArrayList<Message> messagesSent = user.getMessagesSent(user.getUserName());
        Log.d("userId2",String.valueOf(user.getUserId()));
        Log.d("messagesReceived", String.valueOf(messagesReceived));
        for(User u: allUsers) {
            for (Message m : messagesReceived) {
                if(!isUserInList(u.getUserName(),userList)) {
                    Log.d("avocado4", String.valueOf(user.getUserName()));
                    Log.d("avocado5", String.valueOf(m.getSender()));
                    if (u.getUserName().equals(m.getSender()))
                        userList.add(u);
                }
            }
        }
        for(User u: allUsers) {
            for (Message m : messagesSent) {
                if(!isUserInList(u.getUserName(),userList)) {
                    Log.d("avocado4", String.valueOf(user.getUserName()));
                    Log.d("avocado5", String.valueOf(m.getReceiver()));
                    if (u.getUserName().equals(m.getReceiver()))
                        userList.add(u);
                }
            }
        }
        userList.remove(user);
        Log.d("avocado3", String.valueOf(userList));
        for(User u: userList){
            Log.d("avocado", u.getUserName());
            Log.d("avocado2", String.valueOf(u.getUserId()));
        }

        if(!userList.isEmpty())
            view.showUsers(userList);
    }

    //Checks whether the given user exists on ArrayList
    public static boolean isUserInList(String username, ArrayList<User> users) {

        for (User u : users) {
            if (u.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
