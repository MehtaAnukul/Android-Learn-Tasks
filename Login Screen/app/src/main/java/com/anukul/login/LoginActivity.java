package com.anukul.login;

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
    private EditText signupEmailEd;
    private EditText loginPasswordEd;
    private EditText signupPasswordEd;
    private Button loginBtn;
    private TextView signUpTv;
  //  private final String EMAIL_CONSTANT = "admin";
   // private final String PASSWORD_COMSTANT = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


        /*loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEd.getText().toString();
                String password = passwordEd.getText().toString();

                if(email.equals(EMAIL_CONSTANT) && password.equals(PASSWORD_COMSTANT)){
                    Toast.makeText(LoginActivity.this,"Login successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginActivity.this,"something Want Wrong",Toast.LENGTH_LONG).show();
                }

            }
        });*/
    }

    private void initView() {
        loginEmailEd = findViewById(R.id.activity_login_id_et);
        signupEmailEd = findViewById(R.id.activity_signup_emailEd);
        loginPasswordEd = findViewById(R.id.activity_login_password_et);
        signupPasswordEd = findViewById(R.id.activity_signup_passwordEd);
        loginBtn = findViewById(R.id.activity_login_loginbtn);
        signUpTv = findViewById(R.id.activity_login_signup_tv);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_loginbtn:
                login();
            case R.id.activity_login_signup_tv:
                gotoSignUpActivity();
                break;
        }
    }

    private void gotoSignUpActivity() {
        final Intent gotoSignUpActivity = new Intent(LoginActivity.this,signupActivity.class);
        startActivity(gotoSignUpActivity);
    }

    private void login() {
        String loginEmail = loginEmailEd.getText().toString().trim();
        String loginPassword = loginPasswordEd.getText().toString().trim();
        String signupEmail = signupEmailEd.getText().toString().trim();
        String signupPassword = signupPasswordEd.getText().toString().trim();

        if(loginEmail.equals(signupEmail) && loginPassword.equals(signupPassword)){
            Toast.makeText(LoginActivity.this,"login successfully",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(LoginActivity.this,"something Wrong",Toast.LENGTH_SHORT).show();
        }
    }
}
