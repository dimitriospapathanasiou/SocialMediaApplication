package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.User;
import com.aueb.socialmediaapplication.Util.UserInfoUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class RegisterChecks {

    static String userData;
    RegisterInterface view;
    UserDatabase userDB;

    //Initialisation of variables
    public RegisterChecks(RegisterInterface view, UserDatabase userDB) {
        this.view = view;
        this.userDB = userDB;
    }

    //Makes the necessary checks and procedures after
    //the users fill their credentials upon registry
    public void onRegister() {
        if (view.getEmail().isEmpty() || view.getUsername().isEmpty() || view.getPassword().isEmpty() || view.getFirstName().isEmpty() || view.getLastName().isEmpty()) {
            view.showEmptyFieldsDetected();
            return;
        }

        if (!UserInfoUtil.isEmail(view.getEmail())) {
            view.showInvalidEmail();
            return;
        }

        if (userDB.isEmailTaken(view.getEmail())) {
            view.showEmailAlreadyExists();
            return;
        }


        User user = new User(view.getFirstName(),view.getLastName(), view.getEmail(),view.getUsername(),view.getPassword());
        userDB.register(user);
        userData = view.getUsername() + "," + view.getPassword() + "," + view.getFirstName() + "," + view.getLastName() + "," + view.getEmail() + ",";
        view.writeToFile();
        view.onSuccessfulRegister();
    }

    //Writes given data to internal storage file
    public static String writeToDatabase(Context context){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Users_Database.txt",Context.MODE_APPEND));
            outputStreamWriter.write(userData);
            outputStreamWriter.close();
            FileInputStream fis = context.openFileInput("Users_Database.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Log.d("data",sb.toString());
            return userData;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

    void detach() {
        view = null;
    }

}
