package com.aueb.socialmediaapplication.Activities;

import static com.aueb.socialmediaapplication.Activities.ShowMessages.internalMessageData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.Entities.Message;
import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.Util.AndroidUtil;
import com.aueb.socialmediaapplication.databinding.LayoutActivityChatroomBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom extends AppCompatActivity implements ChatRoomInterface{

    LayoutActivityChatroomBinding binding;
    SendMessage presenter;
    String username;
    String password;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_chatroom);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        password = extras.getString("password");
        ShowMessages.readFromInternalFile(getApplicationContext());
        MessageDatabase messageDb = ShowMessages.fillWithMessages();
        presenter = new SendMessage(this, messageDb);
        clickListeners();
        clickListenersLog();
    }


    private void clickListenersLog(){
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatRoom.this, Menu.class));
                finish();
            }
        });
    }

    private void clickListeners() {

        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSend();
            }
        });
    }

    public String getText() {
        return binding.textEt.getText().toString();
    }

    @Override
    public String getSender() {
        return username;
    }

    public String getReceiver() {
        return binding.receiverEt.getText().toString();
    }

    @Override
    public int getLike() {
        return 0;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public int getId() {
        ArrayList<String> credentials = new ArrayList<>();

        for (String word : internalMessageData.split(",")) {
            Log.d("word",word);
            credentials.add(word);
        }
        int index = 0;
        MessageDatabase messagedb = new MessageDatabase();
        for (int i = 0; i < credentials.size(); i+=6){
            Log.d("yes", credentials.get(i));
            index = Integer.parseInt(credentials.get(i));
        }
        return index + 1;
    }

    public void writeToFile(){
        String s = SendMessage.writeToDatabase(getApplicationContext());
        Log.d("newmessage",s);
    }

    @Override
    public void showMessages(List<Message> messageList) {

    }

    public void showSuccessSend() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ChatRoom.this, Login.class);
                intent.putExtra("text",getText());
                intent.putExtra("receiver",getReceiver());
                startActivity(intent);
            }
        };

    }


}
