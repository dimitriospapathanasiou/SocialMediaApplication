package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.util.Log;

import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class ShowMessages {

    static String messageData;
    static String internalMessageData;

    //Reads default credentials from Messages_Database.txt assets file
    public static String readFromFile(Context context) {
        try {
            InputStream is = context.getAssets().open("Messages_Database.txt");
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            messageData = new String(buffer);
            return messageData;
        } catch (Exception e) {
            e.printStackTrace();
            return "" ;
        }
    }

    //Reads the content of internal storage message file
    public static String readFromInternalFile(Context context){
        try {
            FileInputStream fis = context.openFileInput("Messages_Database.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Log.d("data",sb.toString());
            internalMessageData = sb.toString();

            return internalMessageData;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

    //Writes given data to internal storage message file
    public static String writeToDatabase(Context context){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Messages_Database.txt",Context.MODE_APPEND));
            outputStreamWriter.write(messageData);
            outputStreamWriter.close();
            FileInputStream fis = context.openFileInput("Messages_Database.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Log.d("data",sb.toString());
            return messageData;
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

    public static MessageDatabase fillWithMessages(){

        ArrayList<String> messageList = new ArrayList<>();

        for (String word : internalMessageData.split(",")) {
            Log.d("word",word);
            messageList.add(word);
        }

        MessageDatabase messagedb = new MessageDatabase();
        for (int i = 0; i < messageList.size(); i+=6){
            int id = Integer.parseInt(messageList.get(i));
            Log.d("id", String.valueOf(id));
            String from = messageList.get(i+1);
            Log.d("from",from);
            String to = messageList.get(i+2);
            Log.d("to",to);
            String text = messageList.get(i+3);
            Log.d("text",text);
            String like = messageList.get(i+4);
            Log.d("like",like);
            String status = messageList.get(i+5);
            Log.d("status",status);
            Message message = new Message(id,from,to,text,Integer.parseInt(like),Integer.parseInt(status));
            messagedb.register(message);
        }
        return messagedb;
    }
}
