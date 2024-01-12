package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.tea.model.CategoryModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView contentText;

    RecyclerView recyclerView1;

    CategoryAdapter catadapter;

    ArrayList<CategoryModel> modellist;

    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView1 = findViewById(R.id.recyclerview1);
        searchView=findViewById(R.id.search_bar);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
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

//        Button shopNowButton = findViewById(R.id.outlinedButton);
//        shopNowButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle click for the "Shop Now" button
//                contentText.setText("Shop Now Clicked");
//            }
//        });
    }

    private void filterlist(String text) {
        ArrayList<CategoryModel> catlist= new ArrayList<>();
        for (CategoryModel item: modellist){
            if (item.getCatname().toLowerCase().contains(text.toLowerCase())) {
                catlist.add(item);
            }
        }
        if (catlist.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            catadapter.setfilterlist(catlist);
        }

    }

}