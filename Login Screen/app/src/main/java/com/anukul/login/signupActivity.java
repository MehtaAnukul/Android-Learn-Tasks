package com.anukul.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class signupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEd;
    private EditText passwordEd;
    private EditText rePasswordEd;
    private Button signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();
    }

    private void initView() {
        emailEd = findViewById(R.id.activity_signup_emailEd);
        passwordEd = findViewById(R.id.activity_signup_passwordEd);
        rePasswordEd = findViewById(R.id.activity_signup_confirmPasswordEd);
        signupbtn = findViewById(R.id.activity_signup_signupbtn);

        signupbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_signup_signupbtn:
                gotoLoginActivity();
                break;
        }
    }

    private void gotoLoginActivity() {
        final String email = emailEd.getText().toString().trim();
        final String password = passwordEd.getText().toString().trim();
        final String rePassword = rePasswordEd.getText().toString().trim();

        final Intent gotoLoginActivityIntent = new Intent(signupActivity.this,LoginActivity.class);
        gotoLoginActivityIntent.putExtra("KEY_EMAIL",email);
        gotoLoginActivityIntent.putExtra("KEY_PASSWORD",password);
        gotoLoginActivityIntent.putExtra("KEY_REPASSWORD",rePassword);
        startActivity(gotoLoginActivityIntent);

    }
}
