package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Get the pizza ID from intent
        long id = getIntent().getLongExtra("pizza_id", -1);

        // Find the pizza using the service
        Produit pizza = ProduitService.getInstance().findById(id);

        // Get references to all views
        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView meta = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView desc = findViewById(R.id.desc);
        TextView steps = findViewById(R.id.steps);

        // Display pizza data if found
        if (pizza != null) {
            img.setImageResource(pizza.getImageRes());
            title.setText(pizza.getNom());
            meta.setText(pizza.getDuree() + " - " + pizza.getPrix() + "€");
            ingredients.setText(pizza.getIngredients());
            desc.setText(pizza.getDescription());
            steps.setText(pizza.getEtapes());
        } else {
            title.setText("Pizza introuvable !");
        }
    }
}