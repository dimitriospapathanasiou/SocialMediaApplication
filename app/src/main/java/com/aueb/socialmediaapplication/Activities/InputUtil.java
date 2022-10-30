package com.aueb.socialmediaapplication.Activities;

public class InputUtil {

    public static final String emailFormat = "[^@]+@[^\\.]+\\..+";

    public static boolean isEmail(String email) {
        return email.matches(emailFormat);
    }

}
