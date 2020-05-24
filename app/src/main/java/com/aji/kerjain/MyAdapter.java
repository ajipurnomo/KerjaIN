package com.aji.kerjain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_Item> list_items;
    private Context context;

    public MyAdapter(List<List_Item> list_items, Context context) {
        this.list_items = list_items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List_Item list_item = list_items.get(position);
        holder.textViewHead.setText(list_item.getHead());
        holder.textViewDeskripsi.setText(list_item.getDeskripsi());
        holder.textViewLokasi.setText(list_item.getLokasi());

    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewHead;
        public TextView textViewDeskripsi;
        public TextView textViewLokasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHead = (TextView) itemView.findViewById(R.id.head);
            textViewDeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            textViewLokasi = (TextView) itemView.findViewById(R.id.lokasi);
        }
    }

}
