package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aueb.socialmediaapplication.Database.PseudoDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.Util.AndroidUtil;
import com.aueb.socialmediaapplication.databinding.LayoutActivityRegisterBinding;


public class Register extends AppCompatActivity implements RegisterInterface{

    LayoutActivityRegisterBinding binding;
    RegisterChecks presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Register");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_register);
        ShowUsers.readFromInternalFile(getApplicationContext());
        UserDatabase userDb = ShowUsers.fillWithUsers();
        presenter = new RegisterChecks(this, userDb);
        setClickListeners();
    }

    private void setClickListeners() {
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegister();
            }
        });
    }

    @Override
    public void writeToFile(){
        String s = RegisterChecks.writeToDatabase(getApplicationContext());
        Log.d("yomen",s);
    }

    @Override
    public void onSuccessfulRegister() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Register.this, Login.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Successful Register",
                "Congratulations " + getUsername() + ",\nYou can now use the app",
                "OKAY",
                runnable);
    }

    @Override
    public String getEmail() {
        return binding.emailEt.getText().toString();
    }

    @Override
    public void setEmail(String email) {
        binding.emailEt.setText(email);
    }

    @Override
    public String getUsername() {
        return binding.usernameEt.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.usernameEt.setText(username);
    }

    @Override
    public String getPassword() {
        return binding.passwordEt.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.passwordEt.setText(password);
    }

    @Override
    public String getFirstName() {
        return binding.firstnameEt.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        binding.firstnameEt.setText(firstName);
    }

    @Override
    public String getLastName() {
        return binding.lastnameEt.getText().toString();
    }

    @Override
    public void setLastName(String lastName) {
        binding.lastnameEt.setText(lastName);
    }

    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Empty fields detected. \nFill them to register..",
                "OKAY",
                runnable);
    }

    @Override
    public void showEmailAlreadyExists() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Email is reserved",
                "OKAY",
                runnable);
    }

    @Override
    public void showInvalidEmail() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Invalid Email",
                "Invalid email inserted. Please use your email",
                "OKAY",
                runnable);
    }

}
