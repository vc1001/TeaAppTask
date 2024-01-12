package com.example.tea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tea.R;
import com.example.tea.model.CategoryModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    ArrayList<CategoryModel> arrayList;

    Context context;

    public CategoryAdapter(ArrayList<CategoryModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    public void setfilterlist(ArrayList<CategoryModel> catlist){
        this.arrayList=catlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).
                inflate(R.layout.categories_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {


        CategoryModel model=arrayList.get(position);
        holder.name.setText(model.getCatname());
        holder.image.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CircleImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = name;
            this.image = image;

            name=itemView.findViewById(R.id.categoriesname);
            image=itemView.findViewById(R.id.roundimage);
        }
    }
}