package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.databinding.LayoutActivityMessagemenuBinding;

public class MessageMenu extends AppCompatActivity implements MessageMenuInterface {

    LayoutActivityMessagemenuBinding binding;
    String username;
    String password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_messagemenu);
            Bundle extras = getIntent().getExtras();
            username = extras.getString("username");
            password = extras.getString("password");
            clickListeners();
        }

        private void clickListeners() {
            binding.btnNewMessage.setOnClickListener(view -> newMessage());

            binding.btnWriteMessage.setOnClickListener(view -> writeMessage());

            binding.btnReadMessages.setOnClickListener(view -> readMessages());
        }


        @Override
        public void readMessages() {
            Toast.makeText(this, "Loading new messages!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MessageMenu.this, ContactList.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
        }

        @Override
        public void writeMessage() {
            Toast.makeText(this, "Opening...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MessageMenu.this, ChatRoom.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
        }

        @Override
        public void newMessage() {
            Toast.makeText(this, "Loading new messages!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MessageMenu.this, UnreadMessages.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
        }
    }
