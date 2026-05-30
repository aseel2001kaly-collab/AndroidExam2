package com.aseel.examapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private View mainLayout;
    private boolean backPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        mainLayout = findViewById(R.id.main_layout);

        etEmail.addTextChangedListener(loginTextWatcher);
        etPassword.addTextChangedListener(loginTextWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModeActivity.class);
                startActivity(intent);
            }
        });
    }

    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = etEmail.getText().toString().trim();
            String passwordInput = etPassword.getText().toString().trim();

            boolean isEmailValid = !emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches();
            boolean isPasswordValid = passwordInput.length() >= 6;

            btnLogin.setEnabled(isEmailValid && isPasswordValid);
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.backPressedOnce = true;
        Snackbar.make(mainLayout, "Press back again to exit", Snackbar.LENGTH_SHORT).show();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressedOnce = false;
            }
        }, 2000);
    }
                              }
