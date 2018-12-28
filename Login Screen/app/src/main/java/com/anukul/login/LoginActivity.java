package com.anukul.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText loginEmailEd;
    private EditText loginPasswordEd;
    private Button loginBtn;
    private TextView signUpTv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        intent = getIntent();
    }

    private void initView() {
        loginEmailEd = findViewById(R.id.activity_login_id_et);
        loginPasswordEd = findViewById(R.id.activity_login_password_et);
        loginBtn = findViewById(R.id.activity_login_loginbtn);
        signUpTv = findViewById(R.id.activity_login_signup_tv);
        signUpTv.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_loginbtn:
                login();
                break;
            case R.id.activity_login_signup_tv:
                Intent intent = new Intent(this,signupActivity.class);
                startActivity(intent);
        }
    }
    private void login() {
        String loginEmail = loginEmailEd.getText().toString().trim();
        String loginPassword = loginPasswordEd.getText().toString().trim();

        String signupEmail = intent.getStringExtra("KEY_EMAIL");
        String signupPassword = intent.getStringExtra("KEY_PASSWORD");

        if (loginEmail.equals(signupEmail) && loginPassword.equals(signupPassword)) {
            Toast.makeText(LoginActivity.this, "login successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, "something Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
