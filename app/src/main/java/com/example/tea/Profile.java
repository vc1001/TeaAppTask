package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.CamcorderProfile;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigationView=findViewById(R.id.bottomnavigation);

        navigationView.setSelectedItemId(R.id.profile);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int Itemid=item.getItemId();
                if (item.getItemId()==R.id.home){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    Toast.makeText(Profile.this, "Home", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.favourites) {
                    startActivity(new Intent(getApplicationContext(), Favourites.class));
                    Toast.makeText(Profile.this, "Favourites", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.cart) {
                    Toast.makeText(Profile.this, "Cart", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId()==R.id.profile) {
                    Toast.makeText(Profile.this, "Profile", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}