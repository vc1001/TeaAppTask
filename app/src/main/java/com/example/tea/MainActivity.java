package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tea.adapter.CategoryAdapter;
import com.example.tea.adapter.ProductAdapter;
import com.example.tea.adapter.TypeAdapter;
import com.example.tea.model.CategoryModel;
import com.example.tea.model.ProductModel;
import com.example.tea.model.TypeModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView contentText;

    RecyclerView recyclerView1,recyclerview2,recyclerview3;

    CategoryAdapter catadapter;
    TypeAdapter typeAdapter;
    ProductAdapter productAdapter;
    ArrayList<ProductModel> productlist;
    ArrayList<TypeModel> typemodellist;


    ArrayList<CategoryModel> modellist;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView1 = findViewById(R.id.recyclerview1);
        recyclerview2=findViewById(R.id.recyclerview2);
        recyclerview3=findViewById(R.id.recyclerview3);
        searchView=findViewById(R.id.search_bar);
        typemodellist=new ArrayList<>();
        productlist=new ArrayList<>();
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
             //   typeAdapter.filter(newText);
                return true;
            }
        });

        modellist=new ArrayList<>();
        CategoryModel c1=new CategoryModel(R.drawable.cofee3,"Top picks");
        CategoryModel c2 = new CategoryModel(R.drawable.coffe,"Top Deals");
        CategoryModel c3 = new CategoryModel(R.drawable.coffe1,"Cappacuino");
        CategoryModel c4 = new CategoryModel(R.drawable.coffee1,"Hot Coffees");
        CategoryModel c5= new CategoryModel(R.drawable.coffee6,"Cold Coffees");
        CategoryModel c6= new CategoryModel(R.drawable.coffee5,"IcedTeas");
        CategoryModel c7 = new CategoryModel(R.drawable.coffee4,"Frappucino \n Blended Beverages");

        modellist.add(c1);
        modellist.add(c2);
        modellist.add(c3);
        modellist.add(c4);
        modellist.add(c5);
        modellist.add(c6);
        modellist.add(c7);

        catadapter=new CategoryAdapter(modellist,this);
        recyclerView1.setAdapter(catadapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager);


        typeAdapter=new TypeAdapter(typemodellist,this);
        recyclerview2.setAdapter(typeAdapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        recyclerview2.setLayoutManager(gridLayoutManager);
        InitializeDataintoRecyclerview();
        productAdapter=new ProductAdapter(productlist,this);
        recyclerview3.setAdapter(productAdapter);
        LinearLayoutManager layoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerview3.setLayoutManager(layoutManager1);
        InitializeProductDataintoRecyclerView();







        BottomNavigationView navigationView = findViewById(R.id.bottomnavigation);

        navigationView.setSelectedItemId(R.id.home);



        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int Itemid =item.getItemId();
                if (item.getItemId()==R.id.home){
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId()==R.id.favourites) {
                    Toast.makeText(MainActivity.this, "Favourites", Toast.LENGTH_SHORT).show();
                    Intent i1=new Intent(MainActivity.this, Favourites.class);
                    startActivity(i1);
                } else if (item.getItemId()==R.id.cart) {
                    Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                    Intent i2= new Intent(MainActivity.this, Cart.class);
                    startActivity(i2);
                } else if (item.getItemId()==R.id.profile) {
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    Intent i3 = new Intent(MainActivity.this, Profile.class);
                    startActivity(i3);
                }

                return true;
            }
        });

    }

    private void filterlist(String text) {
        ArrayList<CategoryModel> catlist= new ArrayList<>();
        for (CategoryModel item: modellist){
            if (item.getCatname().toLowerCase().contains(text.toLowerCase())) {
                catlist.add(item);
            }
        }
        ArrayList<TypeModel> typelist=new ArrayList<>();
        for (TypeModel item: typemodellist){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                typelist.add(item);
            }
        }
        ArrayList<ProductModel> productmodel=new ArrayList<>();
        for (ProductModel item: productlist){
            if (item.getProductName().toLowerCase().contains(text.toLowerCase())){
                productmodel.add(item);
            }
        }
        if (catlist.isEmpty()&& typelist.isEmpty() && productmodel.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            catadapter.setfilterlist(catlist);
            typeAdapter.setypefilterlist(typelist);
            productAdapter.setproductfilterlist(productmodel);
        }

    }
    private void InitializeDataintoRecyclerview(){

        TypeModel t1=new TypeModel("Juices",R.drawable.juice1);
        TypeModel t2=new TypeModel("Hot Coffee",R.drawable.cofee3);
        TypeModel t3=new TypeModel("Cold Coffee",R.drawable.coffee6);
        TypeModel t4=new TypeModel("Hot Tea",R.drawable.tea);
        TypeModel t5=new TypeModel("Cold Tea",R.drawable.tea1);
        TypeModel t6=new TypeModel("Beverages",R.drawable.juice2);
        TypeModel t7=new TypeModel("Water",R.drawable.water1);
        TypeModel t8=new TypeModel("Milk",R.drawable.milk);

        typemodellist.add(t1);
        typemodellist.add(t2);
        typemodellist.add(t3);
        typemodellist.add(t4);
        typemodellist.add(t5);
        typemodellist.add(t6);
        typemodellist.add(t7);
        typemodellist.add(t8);




    }
    private void InitializeProductDataintoRecyclerView(){
        ProductModel p1=new ProductModel(R.drawable.products1,R.drawable.star4,"635","English Breakfast Black Tea");
        ProductModel p2=new ProductModel(R.drawable.products2,R.drawable.star4,"744","High Mountain Oolong Tea");
        ProductModel p3=new ProductModel(R.drawable.products3,R.drawable.star5,"820","French Early Jasmine Grey Tea");
        ProductModel p4=new ProductModel(R.drawable.products4,R.drawable.star5,"620","French early Green Tea");
        ProductModel p5=new ProductModel(R.drawable.products5,R.drawable.star4,"730","Illuminate Oolong Tea");
        ProductModel p6=new ProductModel(R.drawable.products6,R.drawable.star4,"400","Chocolate Venilla Herbal Tea");
        ProductModel p7=new ProductModel(R.drawable.products7,R.drawable.star5,"890","Matcha Latte");

        productlist.add(p1);
        productlist.add(p2);
        productlist.add(p3);
        productlist.add(p4);
        productlist.add(p4);
        productlist.add(p6);
        productlist.add(p7);
    }

}