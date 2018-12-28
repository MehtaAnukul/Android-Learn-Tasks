package com.anukul.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }

    private void initView() {
        loginEmailEd = findViewById(R.id.activity_login_emailEd);
        loginPasswordEd = findViewById(R.id.activity_login_passwordEd);
        loginBtn = findViewById(R.id.activity_login_loginBtn);
        signUpTv = findViewById(R.id.activity_login_signUpTv);

        signUpTv.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_loginBtn:
                login();
                break;
            case R.id.activity_login_signUpTv:
                final Intent intent = new Intent(this,SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void login() {
        String loginEmail = loginEmailEd.getText().toString().trim();
        String loginPassword = loginPasswordEd.getText().toString().trim();

        intent = getIntent();
        String signUpEmail = intent.getStringExtra("KEY_EMAIL");
        String signUpPassword = intent.getStringExtra("KEY_PASSWORD");

        if(signUpEmail.equals(loginEmail) && signUpPassword.equals(loginPassword)){
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Something Wrong !", Toast.LENGTH_SHORT).show();
        }

    }
}
