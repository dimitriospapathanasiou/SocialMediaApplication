package com.aueb.socialmediaapplication.Activities;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.User;

public class LoginChecks {

    LoginInterface view;
    UserDatabase userDAO;

    //Initialisation of main variables
    public LoginChecks(LoginInterface view, UserDatabase userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    //Making the necessary checks for a successful login
    public void onLogin() {
        if (view.getUsername().isEmpty() || view.getPassword().isEmpty()) {
            view.emptyFields();
            return;
        }

        User user = UserDatabase.getUserFromCredentials(view.getUsername(), view.getPassword());

        if (user == null) {
            view.showFailedLogin();
        } else  {
            view.showSuccessLogin();
        }

    }

    void onCreateAnAccount() {
        view.createAnAccount();
    }

    void detach() {
        view = null;
    }

}