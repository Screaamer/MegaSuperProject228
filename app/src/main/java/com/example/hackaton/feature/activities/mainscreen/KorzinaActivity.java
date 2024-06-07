package com.example.hackaton.feature.activities.mainscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackaton.R;
import com.example.hackaton.feature.adapters.KorzinaAdapter;
import com.example.hackaton.model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hackaton.R;
import com.example.hackaton.model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class KorzinaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Order> localDataSet;

    AppCompatButton back;
    TextView sumpres;
    AppCompatButton btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korzina);

        recyclerView = findViewById(R.id.recforkorz);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        back = findViewById(R.id.backag);
        sumpres = findViewById(R.id.summof);
        btnnext = findViewById(R.id.appCompatButton2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KorzinaActivity.this, MainPageActivity.class);
                startActivity(i);
            }
        });

        String json = getIntent().getStringExtra("korzina");
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Order>>(){}.getType();
        ArrayList<Order> list = gson.fromJson(json, collectionType);

        KorzinaAdapter korzinaAdapter = new KorzinaAdapter(list, sumpres, 0);
        recyclerView.setAdapter(korzinaAdapter);

        localDataSet = korzinaAdapter.getLocalDataSet();

        sumpres.setText(korzinaAdapter.getSum() + "₽");

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("korza", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                String korza_str = new Gson().toJson(localDataSet);
                editor.putString("korzina", korza_str);
                editor.apply();

                Intent i = new Intent(KorzinaActivity.this, OrderRegistrationActivity.class);
                startActivity(i);
            }
        });
    }
}