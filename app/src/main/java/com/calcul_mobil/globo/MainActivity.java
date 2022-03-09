package com.calcul_mobil.globo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void registerCustomer(View view) {
        Intent registerCustomerIntent = new Intent(this, RegisterCustomerActivity.class);

        startActivity(registerCustomerIntent);
    }

    public void registerRestaurant(View view) {
        Intent registerRestaurantIntent = new Intent(this, RegisterRestaurantActivity.class);

        startActivity(registerRestaurantIntent);
    }
}