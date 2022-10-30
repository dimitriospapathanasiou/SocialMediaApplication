package com.aueb.socialmediaapplication.Database;

import com.aueb.socialmediaapplication.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    protected static List<User> usersList = new ArrayList<>();
    private static int userIdCounter = 0;


    public static User getUserFromCredentials(String email, String password) {
        for (User user : usersList) {
            if (user.getMail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean isEmailTaken(String email) {
        for (User user : usersList) {
            if (user.getMail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void register(User user) {
        delete(user.getUserId());
        user.setUserId(nextId());
        usersList.add(user);
    }

    public void delete(int userId) {
        for (User u : usersList) {
            if (u.getUserId() == userId) {
                usersList.remove(u);
                break;
            }
        }
    }

    public int nextId() {
        userIdCounter++;
        return userIdCounter;
    }

}
