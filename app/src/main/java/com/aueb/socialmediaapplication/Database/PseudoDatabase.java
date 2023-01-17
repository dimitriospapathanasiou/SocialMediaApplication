package com.aueb.socialmediaapplication.Database;

import android.os.Environment;
import android.util.Log;

import com.aueb.socialmediaapplication.Activities.ShowUsers;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PseudoDatabase {

    public static String readFromText(){
        File storageDir = new File(Environment.getExternalStorageDirectory().toString(), "C:/Users/jimpapathanasiou/AndroidStudioProjects/SocialMediaApplication/app/src/main/assets");
        File file = new File(storageDir,"Users_Database.txt");
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }


    public static UserDatabase fillUp(){
        ShowUsers bop = new ShowUsers();
        //bop.nextLine(readFromFile(bop.getApplicationContext()));

        return null;
    }


}
