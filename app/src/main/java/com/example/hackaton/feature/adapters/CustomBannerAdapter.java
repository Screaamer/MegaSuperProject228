package com.example.hackaton.feature.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.hackaton.R;
import com.example.hackaton.model.Banner;

import java.util.List;

public class CustomBannerAdapter extends RecyclerView.Adapter<CustomBannerAdapter.ViewHolder>{
    private List<Banner> localDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView getName() {
            return name;
        }

        public TextView getCol() {
            return col;
        }

        public TextView getSum() {
            return sum;
        }

        private final TextView name;
        private final TextView col;
        private final TextView sum;
        private final ImageView imageView;
        private final CardView card;





        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = (TextView) view.findViewById(R.id.namespace);
            col = (TextView) view.findViewById(R.id.colvo);
            sum = (TextView) view.findViewById(R.id.price);
            card = (CardView) view.findViewById(R.id.cardView);
            imageView = (ImageView) view.findViewById(R.id.image);
        }



    }


    public CustomBannerAdapter(List<Banner> dataSet, Context c) {
        localDataSet = dataSet;
        context = c;
    }



    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);


        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Banner b = localDataSet.get(position);


        Glide.with(context).load(b.getImg()).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {

                viewHolder.imageView.setImageDrawable(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });
        if(b.getName().length() > 20) {
            viewHolder.getName().setText(b.getName().substring(0, 20));
        } else {
            viewHolder.getName().setText(b.getName());
        }
        Log.d("duck", viewHolder.getName().toString() + " - " + viewHolder.getCol().toString());
        if(viewHolder.getCol().length() > 10){
            viewHolder.getCol().setText("3 исследования");
        }
        else{
            viewHolder.getCol().setText(b.getDesc());
        }

        viewHolder.getSum().setText(b.getPrice() + "₽");



    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


}
