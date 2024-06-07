package com.example.hackaton.feature.activities.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackaton.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    EVal validator;

    private AppCompatButton btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editText);
        btn_continue = findViewById(R.id.next);
        validator = new EVal();


        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validator.validateEmail(email.getText().toString())){
                    Intent i = new Intent(LoginActivity.this, EmailCheckActivity.class);
                    i.putExtra("emailStr", email.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"Введена неверная почта",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public class EVal {
        private Pattern pattern;
        private Matcher matcher;
        private static final String EMAIL_REGEX =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public EVal() {
            pattern = Pattern.compile(EMAIL_REGEX);
        }

        // функция, которая проверяет, является ли email допустимым
        public boolean validateEmail(String email) {
            matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }
}