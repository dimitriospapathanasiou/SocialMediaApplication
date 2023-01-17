package com.aueb.socialmediaapplication.Util;

public class UserInfoUtil {

    /**
     * emailFormat is the type an email address should have in order to be considered as valid.
     */
    public static final String emailFormat = "[^@]+@[^\\.]+\\..+";

    /**
     * isEmail checks whether the email given matches the emailFormat.
     * @param email is the user's email address.
     * @return true if the email matches the format given above.
     */
    public static boolean isEmail(String email) {
        return email.matches(emailFormat);
    }

}
