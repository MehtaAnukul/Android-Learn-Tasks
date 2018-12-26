package com.anukul.intentactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText nameEd;
    private Button backToMainActivityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameEd = findViewById(R.id.activity_second_nameEd);
        backToMainActivityBtn = findViewById(R.id.activity_second_clickBtn);

        final Intent intent = getIntent();

        backToMainActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("KEY_NAME",nameEd.getText().toString().trim());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
