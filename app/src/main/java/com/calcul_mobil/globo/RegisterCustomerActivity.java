package com.calcul_mobil.globo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterCustomerActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        mAuth = FirebaseAuth.getInstance();
    }


    public void registerCustomer(View view) {
        EditText inputEmail = findViewById(R.id.inputUsername);
        EditText inputPassword = findViewById(R.id.inputPassword);
        EditText inputConfirmPassword = findViewById(R.id.inputConfirmPassword);

        String inputEmailText = inputEmail.getText().toString();
        String inputPasswordText = inputPassword.getText().toString();
        String inputConfirmPasswordText = inputConfirmPassword.getText().toString();


        mAuth.createUserWithEmailAndPassword(inputEmailText, inputPasswordText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.w("Success", "createUserWithEmail:success", task.getException());
                            Intent intent = new Intent(RegisterCustomerActivity.this, RestaurantListActivity.class);
                            startActivity(intent);
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterCustomerActivity.this, "Registration successful",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Log.w("Failed", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterCustomerActivity.this, "Registration failed",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}