package com.example.hackaton.feature.activities.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hackaton.R;

public class PaActivity extends AppCompatActivity {
    AppCompatButton getcheck;
    AppCompatButton returnto;
    private static final String CHANNEL_ID = "channel_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        getcheck = findViewById(R.id.getcheck);
        returnto = findViewById(R.id.backtomenu);


        getcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        returnto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaActivity.this, MainPageActivity.class);
                startActivity(i);
            }
        });
    }

}