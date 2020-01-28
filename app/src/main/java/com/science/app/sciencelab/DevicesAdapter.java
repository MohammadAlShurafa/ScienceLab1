package com.science.app.sciencelab;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Item> deviceItems;
    CardView cardView;
    Intent intent;

    DevicesAdapter(Context context, ArrayList<Item> deviceItems) {
        this.context = context;
        this.deviceItems = deviceItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.device_item, parent, false);

        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Item id = deviceItems.get(position);
        holder.deviceNameTv.setText(id.getName());
        holder.devicePhotoIm.setImageResource(id.getImageId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, DetailesActivity.class);
                intent.putExtra("id", id.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return deviceItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView deviceNameTv;
        ImageView devicePhotoIm;
        CardView cardView;
        Toolbar toolbar;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceNameTv = itemView.findViewById(R.id.deviceNameTv);
            devicePhotoIm = itemView.findViewById(R.id.devicePhotoIm);
            cardView = itemView.findViewById(R.id.cv);
            toolbar = itemView.findViewById(R.id.toolbar_main);
        }
    }

    public void refresh(ArrayList<Item> items) {
        this.deviceItems.clear();
        this.deviceItems.addAll(items);
        notifyDataSetChanged();
    }

}

