package com.aueb.socialmediaapplication.Activities;

import static com.aueb.socialmediaapplication.Activities.ShowMessages.internalMessageData;

import android.util.Log;
import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Entities.Message;

import java.util.ArrayList;

public class UnreadChecks {

    static String messageData;
    UnreadMessages view;
    MessageDatabase messageDB;

    public UnreadChecks(UnreadMessages view, MessageDatabase messageDb) {
        this.view = view;
        this.messageDB = messageDb;
    }

    //Adds a like by changing from 0 to 1
    public void onSend(){
        int id = view.getIDofMessage();
        ArrayList<String> credentials = new ArrayList<>();
        for (String word : internalMessageData.split(",")) {
            Log.d("word",word);
            credentials.add(word);
        }
        for (int i = 0; i < credentials.size(); i+=6){
            if (credentials.get(i).equals(id)) {
                credentials.set(i+4, String.valueOf(1));
            }
        }
    }

    //Changes status of messages that just got read from 0 to 1
    public static String newIds(String username){
        ArrayList<String> credentials = new ArrayList<>();
        String ids = "";
        for (String word : internalMessageData.split(",")) {
            Log.d("word",word);
            credentials.add(word);
        }
        for (int i = 0; i < credentials.size(); i+=6){
            if (credentials.get(i+2).equals(username) && credentials.get(i+5).equals("0")) {
                credentials.set(i+5, String.valueOf(1));
                ids += "ID:" + credentials.get(i) + "  ''" + credentials.get(i+3) + "''  FROM: " + credentials.get(i+1) + "\n";
            }

        }
        return ids;
    }



}
