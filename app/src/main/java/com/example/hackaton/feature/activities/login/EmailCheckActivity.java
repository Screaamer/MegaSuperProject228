package com.example.hackaton.feature.activities.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hackaton.R;
import com.example.hackaton.feature.activities.mainscreen.MainPageActivity;

public class EmailCheckActivity extends AppCompatActivity {
    String email;
    String userCode = "1322";
    TextView textView;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    AppCompatButton button;
    AppCompatButton back;
    TextView resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);
        email = getIntent().getStringExtra("emailStr");
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        button = findViewById(R.id.checkbtn);
        back = findViewById(R.id.backag);
        resend = findViewById(R.id.button);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EmailCheckActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et1.getText().toString().length() == 1){
                    et2.setEnabled(true);
                    et2.requestFocus();

                    et1.setEnabled(false);

                    et1.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et2.getText().toString().length() == 1){
                    et3.setEnabled(true);
                    et3.requestFocus();
                    et2.setEnabled(false);

                    et2.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et3.getText().toString().length() == 1){
                    et4.setEnabled(true);
                    et4.requestFocus();

                    et3.setEnabled(false);
                    et3.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et4.getText().toString().length() == 1){
                    et4.setEnabled(false);
                    et4.setTextColor(Color.BLACK);
                    userCode = et1.getText().toString()
                            + et2.getText().toString()
                            + et3.getText().toString()
                            + et4.getText().toString();
                    button.setEnabled(true);
                    button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.activebtn, null));
                    resend.setTextColor(Color.parseColor("#57A9FF"));
                    resend.setEnabled(true);
                    button.setEnabled(true);
                    resend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            et1.setText("");
                            et2.setText("");
                            et3.setText("");
                            et4.setText("");
                            userCode = "";
                            et1.setEnabled(true);
                            et1.requestFocus();
                            resend.setEnabled(false);
                            resend.setTextColor(Color.parseColor("#939396"));
                            button.setEnabled(false);
                            button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.unactiv_btn, null));

                        }
                    });

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(EmailCheckActivity.this, MainPageActivity.class);
                            startActivity(i);
                        }
                    });

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



}
