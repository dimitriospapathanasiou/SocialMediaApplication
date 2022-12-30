package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.databinding.LayoutActivityMenuBinding;

public class Menu extends AppCompatActivity implements MenuInterface {

    LayoutActivityMenuBinding binding;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_menu);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        password = extras.getString("password");
        clickListeners();
    }

    private void clickListeners() {
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
                startActivity(new Intent(Menu.this, Login.class));
                finish();
            }
        });

        binding.btnViewMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMessage();
                Intent intent = new Intent(Menu.this, MessageMenu.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }

    @Override
    public void logOut() {
        Toast.makeText(this, "Going to sleep...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void viewMessage() {
        Toast.makeText(this, "Time to socialize!", Toast.LENGTH_LONG).show();
    }
}
