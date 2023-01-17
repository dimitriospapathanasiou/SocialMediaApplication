package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aueb.socialmediaapplication.Database.MessageDatabase;
import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.databinding.LayoutActivityUnreadmessagesBinding;

public class UnreadMessages extends AppCompatActivity {

    LayoutActivityUnreadmessagesBinding binding;
    String username;
    UnreadChecks presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_unreadmessages);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        ShowMessages.readFromInternalFile(getApplicationContext());
        MessageDatabase messageDb = ShowMessages.fillWithMessages();
        presenter = new UnreadChecks(this, messageDb);
        String s = UnreadChecks.newIds(username);
        binding.idmessage.setText(s);
        clickListeners();
        clickListenersLog();
    }

    private void clickListeners() {
        binding.like2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSend();
            }
        });
    }

    public void done(){
        binding.idmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSend();
            }
        });
    }

    private void clickListenersLog(){
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UnreadMessages.this, Login.class));
                finish();
            }
        });
    }

    public int getIDofMessage() {
        return Integer.parseInt(binding.pickidEt.getText().toString());
    }


}
