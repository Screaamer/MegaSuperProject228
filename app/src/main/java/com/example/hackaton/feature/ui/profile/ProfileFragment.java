package com.example.hackaton.feature.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hackaton.R;
import com.example.hackaton.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class ProfileFragment extends Fragment {

    private Spinner spinner;
    private EditText name;
    private EditText lastname;
    private EditText otname;
    private EditText birth;

    private AppCompatButton save;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil, container, false);
        spinner = view.findViewById(R.id.spinner);
        name = view.findViewById(R.id.e1);
        otname = view.findViewById(R.id.e2);
        lastname = view.findViewById(R.id.e3);
        birth = view.findViewById(R.id.e4);
        List<String> arr = new ArrayList<>();
        save = view.findViewById(R.id.save);
        arr.add("Мужской");
        arr.add("Женский");
        ArrayAdapter<?> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("userdata", name.getText().toString());
                enableSubmitIfReady();
            }
        });

        lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("userdata", lastname.getText().toString());
                enableSubmitIfReady();
            }
        });

        otname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("userdata", otname.getText().toString());
                enableSubmitIfReady();
            }
        });
        birth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("userdata", birth.getText().toString());
                enableSubmitIfReady();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(0, name.getText().toString(), otname.getText().toString(), lastname.getText().toString(), birth.getText().toString(), spinner.getSelectedItem().toString());
                String userd_data_json = new Gson().toJson(user);
                SharedPreferences sharedPref = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("user_data", userd_data_json);
                editor.apply();
                save.setText("Ваш профиль создан!");
                name.setText("");
                otname.setText("");
                lastname.setText("");
                birth.setText("");
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        save.setText("Создать");
                    }
                }, 1000);


            }
        });




        return view;
    }
    public void enableSubmitIfReady() {

        boolean first = name.getText().toString().length() > 3;
        boolean second = lastname.getText().toString().length() > 3;
        boolean third = otname.getText().toString().length() > 3;
        boolean fourth = birth.getText().toString().length() > 3;
        save.setEnabled(first && second && third && fourth);

    }
}

