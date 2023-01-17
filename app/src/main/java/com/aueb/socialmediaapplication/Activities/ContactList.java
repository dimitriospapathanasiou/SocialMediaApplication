package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aueb.socialmediaapplication.Database.PseudoDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.User;
import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.databinding.LayoutActivityContactlistBinding;
import com.aueb.socialmediaapplication.databinding.LayoutItemContactBinding;

import java.util.List;

public class ContactList extends AppCompatActivity implements ContactInterface{

    LayoutActivityContactlistBinding binding;
    LayoutItemContactBinding binding2;
    SearchUsers presenter;
    String username;
    String password;
    ItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_contactlist);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        password = extras.getString("password");
        UserDatabase userDb = ShowUsers.fillWithUsers();
        presenter = new SearchUsers(this, userDb);
        itemClickListener=new ItemClickListener() {
            @Override
            public void onClick(int position, String value) {
                // Display toast
                Toast.makeText(getApplicationContext(),"Position : "
                        +position +" || Value : "+value,Toast.LENGTH_SHORT).show();
            }
        };
        setUpRecyclerView();
        User user = UserDatabase.getUserFromCredentials(username,password);
        Log.d("userId",String.valueOf(user.getUserId()));
        Log.d("username",String.valueOf(user.getUserName()));
        presenter.loadUsers(user);
        clickListenersLog();
    }

    private void clickListenersLog(){
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactList.this, Login.class));
                finish();
            }
        });
    }

    private void setUpRecyclerView() {
        binding.contacts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showUsers(List<User> userList) {
        binding.contacts.setAdapter(new ContactListAdapter(userList, this));
    }


    @Override
    public void openChat(String name) {
        Intent intent = new Intent(ContactList.this, ChatRoom.class);
        intent.putExtra("username",username);
        intent.putExtra("password",password);
        intent.putExtra("name",name);
        startActivity(intent);
    }

}
