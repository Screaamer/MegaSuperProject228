package com.example.hackaton.feature.ui.analizi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackaton.feature.activities.mainscreen.KorzinaActivity;
import com.example.hackaton.feature.adapters.CatalogAdapter;
import com.example.hackaton.feature.adapters.CustomBannerAdapter;
import com.example.hackaton.model.Banner;
import com.example.hackaton.R;
import com.example.hackaton.model.Order;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnaliziFragment extends Fragment {
//    Order p1 = new Order("0", getActivity().getString(R.string.name1), getActivity().getString(R.string.descr1), getActivity().getString(R.string.price1), getActivity().getString(R.string.categ1), getActivity().getString(R.string.t_res1), getActivity().getString(R.string.preps1), getActivity().getString(R.string.bio1));
//   Order p2 = new Order("1", getString(R.string.name2), getString(R.string.descr2), getString(R.string.price2), getString(R.string.categ2), getString(R.string.t_res2), getString(R.string.preps2), getString(R.string.bio2));
//    Order p3 = new Order("2",getString(R.string.name3), getString(R.string.descr3), getString(R.string.price3), getString(R.string.categ3), getString(R.string.t_res3), getString(R.string.preps3), getString(R.string.bio3));
//    Order p4 = new Order("3", getString(R.string.name4), getString(R.string.descr4), getString(R.string.price4), getString(R.string.categ4), getString(R.string.t_res4), getString(R.string.preps4), getString(R.string.bio4));
//    Order p5 = new Order("4", getString(R.string.name5), getString(R.string.descr5), getString(R.string.price5), getString(R.string.categ5), getString(R.string.t_res5), getString(R.string.preps5), getString(R.string.bio5));
//    Order p6 = new Order("5",getString(R.string.name6), getString(R.string.descr6), getString(R.string.price6), getString(R.string.categ6), getString(R.string.t_res6), getString(R.string.preps6), getString(R.string.bio6));
//    Order p7 = new Order("6", getString(R.string.name7), getString(R.string.descr7), getString(R.string.price7), getString(R.string.categ7), getString(R.string.t_res7), getString(R.string.preps7), getString(R.string.bio7));
//    Order p8 = new Order("7", getString(R.string.name8), getString(R.string.descr8), getString(R.string.price8), getString(R.string.categ8), getString(R.string.t_res8), getString(R.string.preps8), getString(R.string.bio8));
//    Order p9 = new Order("8", getString(R.string.name9), getString(R.string.descr9), getString(R.string.price9), getString(R.string.categ9), getString(R.string.t_res9), getString(R.string.preps9), getString(R.string.bio9));
//    Order p10 = new Order("9", getString(R.string.name10), getString(R.string.descr10), getString(R.string.price10), getString(R.string.categ10), getString(R.string.t_res10), getString(R.string.preps10), getString(R.string.bio10));
//    Order p11 = new Order("10", getString(R.string.name11), getString(R.string.descr11), getString(R.string.price11), getString(R.string.categ11), getString(R.string.t_res11), getString(R.string.preps11), getString(R.string.bio11));
//    Order p12 = new Order("11", getString(R.string.name12), getString(R.string.descr12), getString(R.string.price12), getString(R.string.categ12), getString(R.string.t_res12), getString(R.string.preps12), getString(R.string.bio12));
//    Order p13 = new Order("12", getString(R.string.name13), getString(R.string.descr13), getString(R.string.price13), getString(R.string.categ13), getString(R.string.t_res13), getString(R.string.preps13), getString(R.string.bio13));
//    Order p14 = new Order("13", getString(R.string.name14), getString(R.string.descr14), getString(R.string.price14), getString(R.string.categ14), getString(R.string.t_res1), getString(R.string.preps1), getString(R.string.bio1));
//    Order p15 = new Order("14", getString(R.string.name15), getString(R.string.descr15), getString(R.string.price15), getString(R.string.categ15), getString(R.string.t_res15), getString(R.string.preps15), getString(R.string.bio15));
//    Order p16 = new Order("15", getString(R.string.name16), getString(R.string.descr16), getString(R.string.price16), getString(R.string.categ16), getString(R.string.t_res16), getString(R.string.preps16), getString(R.string.bio16));
// Вот бы это работало конечно


   RecyclerView recyclerView;
    ArrayList<Order> popular = new ArrayList<>();
    ArrayList<Order> agro = new ArrayList<>();
    ArrayList<Order> kisl = new ArrayList<>();

    RecyclerView recyclerView2;
    AppCompatButton b1;
    AppCompatButton b2;
    AppCompatButton b3;
    CardView korz;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

                CatalogAdapter catalogAdapter = new CatalogAdapter(popular);
                recyclerView2.setAdapter(catalogAdapter);
                LinearLayoutManager lm2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView2.setLayoutManager(lm2);

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        catalogAdapter.setLocalDataSet(popular);
                        b1.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.activebtn, null));
                        b2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b1.setTextColor(Color.parseColor("#FFFFFF"));
                        b2.setTextColor(Color.parseColor("#7E7E9A"));
                        b3.setTextColor(Color.parseColor("#7E7E9A"));
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        catalogAdapter.setLocalDataSet(agro);
                        b1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.activebtn, null));
                        b1.setTextColor(Color.parseColor("#7E7E9A"));
                        b2.setTextColor(Color.parseColor("#FFFFFF"));
                        b3.setTextColor(Color.parseColor("#7E7E9A"));
                    }
                });
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        catalogAdapter.setLocalDataSet(kisl);
                        b1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.another_btn_2, null));
                        b3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.activebtn, null));
                        b1.setTextColor(Color.parseColor("#7E7E9A"));
                        b2.setTextColor(Color.parseColor("#7E7E9A"));
                        b3.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                });
                korz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Gson gson = new Gson();
                        String json = gson.toJson(catalogAdapter.korza);
                        Intent i = new Intent(getContext(), KorzinaActivity.class);
                        i.putExtra("korzina", json);
                        startActivity(i);
                    }
                });

            }





    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_analizi, container, false);
        recyclerView = view.findViewById(R.id.horizontalScrollView);
        recyclerView2 = view.findViewById(R.id.catalogrec);
        korz = view.findViewById(R.id.cardforkorz);
        b1 = view.findViewById(R.id.b1);
        b2 = view.findViewById(R.id.b2);
        b3 = view.findViewById(R.id.b3);




        return view;
    }

}