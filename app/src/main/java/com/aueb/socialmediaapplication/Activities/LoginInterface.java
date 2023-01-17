package com.aueb.socialmediaapplication.Activities;

interface LoginInterface {

    void createAnAccount();

    String getPassword();

    void setPassword(String password);

    String getUsername();
    
    void setUsername(String username);

    void emptyFields();

    void showFailedLogin();

    void showSuccessLogin();

    void showInvalidEmail();

}