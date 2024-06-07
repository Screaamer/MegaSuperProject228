package com.example.hackaton.feature.activities.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hackaton.R;
import com.example.hackaton.model.Order;
import com.example.hackaton.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderRegistrationActivity extends AppCompatActivity {
    int sum = 0;
    boolean fourth;
    TextView sumof;
    EditText adr;
    EditText date;
    EditText fio;
    EditText phone;
    EditText comment;
    AppCompatButton order;
    AppCompatButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_registration);
        sumof = findViewById(R.id.summof);
        adr = findViewById(R.id.editTextText);
        fio = findViewById(R.id.editTextText3);
        phone = findViewById(R.id.editTextText4);
        comment = findViewById(R.id.editTextTextMultiLine);
        order = findViewById(R.id.order);
        back = findViewById(R.id.backag);
        SharedPreferences sp2 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Type type2 = new TypeToken<User>(){}.getType();
        User user = new Gson().fromJson(sp2.getString("user_data", null), type2);
        Type type = new TypeToken<ArrayList<Order>>(){}.getType();
        SharedPreferences sp = getSharedPreferences("korza", MODE_PRIVATE);
        ArrayList<Order> orders = new Gson().fromJson(sp.getString("korzina", null), type);
        for (int i = 0; i < orders.size(); i ++) {
            String[] parts = orders.get(i).getPrice().split(" ");
            sum += Integer.parseInt(parts[0]);
        }
        sumof.setText(sum  + "₽");
        if(user != null) {
            fio.setText(user.getLastname() + " " + user.getName() + " " + user.getTname());

        }

        adr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableSubmitIfReady();
            }
        });


        fio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                enableSubmitIfReady();
            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableSubmitIfReady();
            }
        });

        comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderRegistrationActivity.this, LoadingScreen.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderRegistrationActivity.this, KorzinaActivity.class);
                startActivity(i);
            }
        });

    }


    public void enableSubmitIfReady() {
        String pattern1 = "^(\\+7|8)\\(\\d{3}\\)\\d{7}$";
        String pattern2 = "^(\\+7|8)\\s?\\(\\d{3}\\)\\s?\\d{3}\\s?\\d{2}\\s?\\d{2}$";
        String pattern3 = "^\\d{11}$";
        Pattern patterns1 = Pattern.compile(pattern1);
        Pattern patterns2 = Pattern.compile(pattern2);
        Pattern patterns3 = Pattern.compile(pattern3);
        Matcher matcher1 = patterns1.matcher(phone.getText().toString());
        Matcher matcher2 = patterns2.matcher(phone.getText().toString());
        Matcher matcher3 = patterns3.matcher(phone.getText().toString());
        boolean first = adr.getText().toString().length() > 3;
        boolean third = fio.getText().toString().length() > 3;
        fourth = matcher1.matches() || matcher2.matches() || matcher3.matches();


        order.setEnabled(first && third && fourth);

    }


}