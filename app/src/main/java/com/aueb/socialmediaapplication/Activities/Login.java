package com.aueb.socialmediaapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.R;
import com.aueb.socialmediaapplication.Util.AndroidUtil;
import com.aueb.socialmediaapplication.databinding.LayoutActivityLoginBinding;

public class Login extends AppCompatActivity implements LoginInterface{

    LayoutActivityLoginBinding binding;
    LoginChecks presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_login);
        UserDatabase userDb = new UserDatabase(); // get users' credentials from database

        presenter = new LoginChecks(this, userDb);

        clickListeners();
    }

    private void clickListeners() {
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin();
            }
        });

        binding.createAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateAnAccount();
            }
        });
    }

    @Override
    public void successfulLogin() {
        startActivity(new Intent(Login.this, Menu.class));
        finish();
    }

    @Override
    public void createAnAccount() {
        startActivity(new Intent(Login.this, Register.class));
    }


    @Override
    public String getUsername() {
        return binding.emailEt.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.emailEt.setText(username);
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
    public void emptyFields() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        AndroidUtil.showDialog(this,
                "Empty fields",
                "Please insert email and password to login",
                "OKAY",
                runnable);
    }

    @Override
    public void showFailedLogin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        AndroidUtil.showDialog(this,
                "Couldn't login",
                "Wrong username or password. \nPlease try again",
                "OKAY",
                runnable);
    }

    @Override
    public void showSuccessLogin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Login.this, Menu.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Welcome back !",
                "Enter the app",
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
                "Invalid email",
                "Email is not valid",
                "OKAY",
                runnable);
    }

}

