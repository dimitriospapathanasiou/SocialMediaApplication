package com.aueb.socialmediaapplication.Activities;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.util.ArrayList;

public class SearchUsers {
    ContactInterface view;
    UserDatabase userDB;

    public SearchUsers(ContactInterface view, UserDatabase usdb) {
        this.view = view;
        this.userDB = usdb;
    }

    public void loadUsers(User user) {
        ArrayList<User> userList= new ArrayList<User>();
        ArrayList<User> allUsers = userDB.getAllUsers();
        ArrayList<Message> messagesReceived = user.getMessagesReceived();

        for(User u: allUsers) {
            for (Message m : messagesReceived) {
                if(!isUserInList(u.getUserName(),userList)) {
                    if (user.getUserName().equals(m.getSender()))
                        userList.add(u);
                    if (user.getUserName().equals(m.getReceiver()))
                        userList.add(u);
                }
            }
        }

        userList.remove(user);

        if(!userList.isEmpty())
            view.showUsers(userList);
    }

    public static boolean isUserInList(String name, ArrayList<User> users) {

        for (User u : users) {
            if (u.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
