package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException ignored) {}

            startActivity(new Intent(SplashActivity.this, ListPizzaActivity.class));
            finish(); // prevent going back to splash
        });
        t.start();
    }
}