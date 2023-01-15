package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ShowUsers {

    static String userData;
    static String internalUserData;

    //Reads default credentials from Users_Database.txt assets file
    public static String readFromFile(Context context) {
        try {
            InputStream is = context.getAssets().open("Users_Database.txt");
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            userData = new String(buffer);
            return userData;
        } catch (Exception e) {
            e.printStackTrace();
            return "" ;
        }
    }

    //Reads the content of internal storage file
    public static String readFromInternalFile(Context context){
        try {
            FileInputStream fis = context.openFileInput("Users_Database.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Log.d("data",sb.toString());
            internalUserData = sb.toString();

            return internalUserData;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

    //Registers the users and matches the credentials' positions
    public static UserDatabase fillWithUsers(){

        ArrayList<String> credentials = new ArrayList<>();

        for (String word : internalUserData.split(",")) {
            Log.d("word",word);
            credentials.add(word);
        }

        UserDatabase userdb = new UserDatabase();
        for (int i = 0; i < credentials.size(); i+=5){
            String username = credentials.get(i);
            Log.d("username",username);
            String password = credentials.get(i+1);
            Log.d("password",password);
            String firstName = credentials.get(i+2);
            Log.d("firstname",firstName);
            String lastName = credentials.get(i+3);
            Log.d("lastname",lastName);
            String mail = credentials.get(i+4);
            Log.d("mail",mail);
            User user = new User(firstName,lastName,mail,username,password);
            userdb.register(user);
        }
        return userdb;
    }

}
