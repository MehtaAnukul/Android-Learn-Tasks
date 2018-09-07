package com.anukul.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEd;
    private EditText passwordEd;
    private Button loginBtn;
    private final String EMAIL_CONSTANT = "admin";
    private final String PASSWORD_COMSTANT = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEd = findViewById(R.id.activity_login_id_et);
        passwordEd = findViewById(R.id.activity_login_password_et);
        loginBtn = findViewById(R.id.activity_login_loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
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
        });
    }
}
