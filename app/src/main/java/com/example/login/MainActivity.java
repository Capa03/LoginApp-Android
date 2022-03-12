package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton();
        signUpButton();
    }

    public void login() {
        Intent intent = new Intent(this, SecondActivity.class);

        EditText editTextUsername = findViewById(R.id.usernameText);
        EditText editTextPassword = findViewById(R.id.TextPassword);

        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.length() == 0 || password.length() == 0) {
            editTextUsername.setError("INVALID USER");
            editTextPassword.setError("Enter password: ");
        } else {
            intent.putExtra(EXTRA_MESSAGE, username);
            startActivity(intent);
        }
    }

    public void loginButton() {
        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void signUpButton() {
        Intent intent = new Intent(this, SignUpActivity.class);
        Button button = findViewById(R.id.buttonSignUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}

