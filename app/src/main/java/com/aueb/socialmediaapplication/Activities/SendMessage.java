package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.Entities.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SendMessage extends AppCompatActivity {

    static String messageData;
    ChatRoomInterface view;
    MessageDatabase messageDB;

    public SendMessage(ChatRoomInterface view, MessageDatabase messageDb) {
        this.view = view;
        this.messageDB = messageDb;
    }

    //Gathers the data that need to be stored when
    //a message is successfully sent
    public void onSend(){
        Log.d("ID", String.valueOf(view.getId()));
        Log.d("sender", String.valueOf(view.getSender()));
        Log.d("receiver", String.valueOf(view.getReceiver()));
        Log.d("text", String.valueOf(view.getText()));
        Log.d("like", String.valueOf(view.getLike()));
        Log.d("status", String.valueOf(view.getStatus()));
        Message message = new Message(view.getId(), view.getSender(), view.getReceiver(), view.getText(), view.getLike(), view.getStatus());
        messageDB.register(message);
        messageData = view.getId() + "," + view.getSender() + "," + view.getReceiver() + "," + view.getText() + "," + view.getLike() + "," + view.getStatus() + ",";
        view.writeToFile();
        view.showSuccessSend();
        }

    //Writes the message related data to the internal storage file
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

}
