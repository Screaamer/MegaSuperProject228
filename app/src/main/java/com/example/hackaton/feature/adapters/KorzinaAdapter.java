package com.example.hackaton.feature.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackaton.R;
import com.example.hackaton.model.Order;

import java.util.ArrayList;

import android.graphics.Color;

public class KorzinaAdapter extends RecyclerView.Adapter<KorzinaAdapter.ViewHolder> {
    private ArrayList<Order> localDataSet;
    public int typ;

    public ArrayList<Order> getLocalDataSet() {
        return localDataSet;
    }


    private TextView totalSumTextView;

    int pointer = 0;
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < localDataSet.size(); i ++) {
            String[] parts = localDataSet.get(i).getPrice().split(" ");
            sum += Integer.parseInt(parts[0]);
        }
        return sum;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView getName() {
            return name;
        }

        public TextView getCol() {
            return days;
        }

        public TextView getSum() {
            return sum;
        }

        private final TextView name;
        private final TextView days;
        private final TextView sum;
        private final AppCompatButton button;

        public AppCompatButton getButton() {
            return button;
        }

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            name = (TextView) view.findViewById(R.id.namespace);
            days = (TextView) view.findViewById(R.id.colvo);
            sum = (TextView) view.findViewById(R.id.price);
            button = (AppCompatButton) view.findViewById(R.id.btnn);

        }


    }


    public KorzinaAdapter(ArrayList<Order> dataSet, TextView sumView, int summation) {
        this.localDataSet = dataSet;
        this.totalSumTextView = totalSumTextView;
        this.typ = typ;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cardforcat, viewGroup, false);
            return new ViewHolder(view);




    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Order b = localDataSet.get(viewHolder.getAdapterPosition());
        if(typ == 0) {
            viewHolder.button.setText("Убрать");
            viewHolder.button.setTextColor(Color.parseColor("#1A6FEE"));
            viewHolder.button.setBackground(ResourcesCompat.getDrawable(viewHolder.itemView.getResources(), R.drawable.outline, null));
        } else {
            viewHolder.button.setEnabled(false);
            viewHolder.button.setAlpha(0);
        }

        if(b.getName().length() > 30) {
            viewHolder.getName().setText(b.getName().substring(0, 28) + "...");
            viewHolder.getCol().setText(b.getTime_result());
            viewHolder.getSum().setText(b.getPrice() + "₽");
        } else {
            viewHolder.getName().setText(b.getName());
            viewHolder.getCol().setText(b.getTime_result());
            viewHolder.getSum().setText(b.getPrice() + "₽");
        }
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int actpos = viewHolder.getAdapterPosition();
                localDataSet.remove(b);
                notifyItemRemoved(actpos);
                notifyItemRangeChanged(actpos, localDataSet.size());
                updateTotalSum();

            }
        });
    }


    private void updateTotalSum() {
        int sum = getSum();
        totalSumTextView.setText(String.valueOf(sum) + "₽");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
