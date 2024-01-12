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
import com.example.tea.model.CategoryModel;
import com.example.tea.model.ProductModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<ProductModel> productlist;

    Context context;

    public ProductAdapter(ArrayList<ProductModel> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }
    public void setproductfilterlist(ArrayList<ProductModel> productModels){
        this.productlist=productModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_layout,parent,false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        ProductModel productModel=productlist.get(position);
        holder.productimage.setImageResource(productModel.getProductImage());
        holder.productprice.setText(productModel.getProductPrice());
        holder.productrating.setImageResource(productModel.getProductRating());
        holder.productname.setText(productModel.getProductName());
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView productname,productprice;
        ImageView productimage,productrating;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productname = productname;
            this.productprice = productprice;
            this.productimage = productimage;
            this.productrating = productrating;

            productimage=itemView.findViewById(R.id.image2);
            productname=itemView.findViewById(R.id.productname);
            productrating=itemView.findViewById(R.id.rating);
            productprice=itemView.findViewById(R.id.price);
        }
    }
}
