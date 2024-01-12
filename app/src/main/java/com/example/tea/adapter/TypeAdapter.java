package com.example.tea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tea.R;
import com.example.tea.model.TypeModel;

import java.util.ArrayList;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.Myviewholder> {
    ArrayList<TypeModel> typelist;
    Context context;

    public TypeAdapter(ArrayList<TypeModel> typelist, Context context) {
        this.typelist = typelist;
        this.context = context;
    }
    public void setypefilterlist(ArrayList<TypeModel>typefilter){
        this.typelist=typefilter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TypeAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_layout,parent,false);

        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeAdapter.Myviewholder holder, int position) {
        TypeModel model = typelist.get(position);
        holder.name.setText(model.getName());
        holder.image.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        return typelist.size();
    }
    public static class Myviewholder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            this.name = name;
            this.image = image;

            name= itemView.findViewById(R.id.productname);
            image=itemView.findViewById(R.id.image2);
        }
    }
}
