package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        ListView lv = findViewById(R.id.lvPizzas);

        // Get all pizzas from service
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        // Create and set adapter
        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        lv.setAdapter(adapter);

        // Handle item clicks
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            intent.putExtra("pizza_id", id);
            startActivity(intent);
        });
    }
}