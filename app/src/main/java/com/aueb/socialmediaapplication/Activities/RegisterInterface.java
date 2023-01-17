package com.aueb.socialmediaapplication.Activities;

public interface RegisterInterface {

    void onSuccessfulRegister();

    String getEmail();

    void setEmail(String email);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    void showEmptyFieldsDetected();

    void showEmailAlreadyExists();

    void showInvalidEmail();

    void writeToFile();

}
