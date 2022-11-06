package com.example.airplanelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowID;
    private Airline[] airlines;

    public DataAdapter(Context context, int rowID, Airline[] airlines) {
        this.context = context;
        this.rowID = rowID;
        this.airlines = airlines;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(airlines[position].getName());

        Integer id = context.getResources().getIdentifier(airlines[position].getIcon(), "drawable", context.getPackageName());
        holder.icon.setImageResource(id);
        Log.d("Test image", id.toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                Airline airline = airlines[holder.getAdapterPosition()];
                intent.putExtra("airline_name", airline);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return airlines.length;
    }


    // inner class for ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.textView);
            this.icon = itemView.findViewById(R.id.imageView);

        }
    }
}
