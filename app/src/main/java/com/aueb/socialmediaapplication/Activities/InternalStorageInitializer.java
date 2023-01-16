package com.aueb.socialmediaapplication.Activities;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStreamWriter;

//Fills internal storage with the default credentials
//from Users_Database.txt assets file

public class InternalStorageInitializer  {

    public static String firstWrite(Context context, String db){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Users_Database.txt",Context.MODE_APPEND));
            outputStreamWriter.write(String.valueOf(db));
            outputStreamWriter.close();
            StringBuilder sb = new StringBuilder();
            Log.d("data",sb.toString());
            return "";
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

    public static String firstWriteM(Context context, String db){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Messages_Database.txt",Context.MODE_APPEND));
            outputStreamWriter.write(String.valueOf(db));
            outputStreamWriter.close();
            StringBuilder sb = new StringBuilder();
            Log.d("data",sb.toString());
            return "";
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return "";
        }
    }

}
