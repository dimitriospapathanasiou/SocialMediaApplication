package com.aueb.socialmediaapplication.Util;

public class InputUtil {

    public static final String emailFormat = "[^@]+@[^\\.]+\\..+";

    public static boolean isEmail(String email) {
        return email.matches(emailFormat);
    }

}
