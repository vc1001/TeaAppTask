package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private TextView contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        contentText = findViewById(R.id.text1);

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

        Button shopNowButton = findViewById(R.id.outlinedButton);
        shopNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for the "Shop Now" button
                contentText.setText("Shop Now Clicked");
            }
        });
    }
}