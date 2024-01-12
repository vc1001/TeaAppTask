package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Favourites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        BottomNavigationView navigationView=findViewById(R.id.bottomnavigation);

        navigationView.setSelectedItemId(R.id.favourites);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int Itemid=item.getItemId();
                if (item.getItemId()==R.id.home){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    Toast.makeText(Favourites.this, "Home", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.favourites) {
                    Toast.makeText(Favourites.this, "Favourites", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.cart) {
                    startActivity(new Intent(getApplicationContext(),Cart.class));
                    Toast.makeText(Favourites.this, "Cart", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId()==R.id.profile) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(Favourites.this, "Profile", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}