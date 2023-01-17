package com.aueb.socialmediaapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        String s = ShowUsers.readFromInternalFile(getApplicationContext());
        if (s.isEmpty()) {
            String yum = ShowUsers.readFromFile(getApplicationContext());
            String userDb = InternalStorageInitializer.firstWrite(getApplicationContext(), yum);
            Log.d("data", userDb);
        }
        String m = ShowMessages.readFromInternalFile(getApplicationContext());
        if (m.isEmpty()) {
            String yom = ShowMessages.readFromFile(getApplicationContext());
            String messageDb = InternalStorageInitializer.firstWriteM(getApplicationContext(), yom);
            Log.d("data", messageDb);
        }
        proceedOnLogin();
    }


    public void proceedOnLogin(){

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}