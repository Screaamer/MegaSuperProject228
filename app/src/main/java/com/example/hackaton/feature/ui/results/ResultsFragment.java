package com.example.hackaton.feature.ui.results;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackaton.R;
import com.example.hackaton.feature.adapters.KorzinaAdapter;
import com.example.hackaton.model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResultsFragment extends Fragment {

    ArrayList<Order> reslist = new ArrayList<>();
    TextView sumpres;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        recyclerView = view.findViewById(R.id.recc);
        sumpres = view.findViewById(R.id.prompt);

        // Создаем пустой заказ для отображения, если корзина пуста
        ArrayList<Order> exeptionlist = new ArrayList<>();
        exeptionlist.add(new Order("0", "Ваша корзина пуста!", "Оформите хотя бы один заказ", "0", "", "", "", ""));
        String exstr = new Gson().toJson(exeptionlist);

        // Получаем данные о заказах из SharedPreferences
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("korza", Context.MODE_PRIVATE);
        Type type = new TypeToken<ArrayList<Order>>(){}.getType();
        ArrayList<Order> orders = new Gson().fromJson(sharedPreferences.getString("korzina", exstr), type);

        // Добавляем данные в список заказов и отображаем их в RecyclerView
        reslist.addAll(orders);
        KorzinaAdapter korzinaAdapter = new KorzinaAdapter(reslist, sumpres, 1);
        recyclerView.setAdapter(korzinaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Отображаем сумму заказа
        sumpres.setText(korzinaAdapter.getSum() + "₽");

        return view;
    }
}