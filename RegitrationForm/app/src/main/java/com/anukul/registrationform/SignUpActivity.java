package com.anukul.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEd;
    private EditText passwordEd;
    private Button signUpBtn;
    private TextView loginTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();

    }

    private void initView() {
        emailEd = findViewById(R.id.activity_signUp_emailEd);
        passwordEd = findViewById(R.id.activity_signUp_passwordEd);
        signUpBtn = findViewById(R.id.activity_signUp_signUpBtn);
        loginTv = findViewById(R.id.activity_signUp_loginTv);

        loginTv.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_signUp_signUpBtn:
                gotoLoginActivity();
                break;
            case R.id.activity_signUp_loginTv:
                final Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void gotoLoginActivity() {
        final String email = emailEd.getText().toString().trim();
        final String password = passwordEd.getText().toString().trim();

        final Intent gotoLoginActivityIntent = new Intent(this, LoginActivity.class);
        gotoLoginActivityIntent.putExtra("KEY_EMAIL", email);
        gotoLoginActivityIntent.putExtra("KEY_PASSWORD", password);
        startActivity(gotoLoginActivityIntent);
    }
}
