package com.example.pizzarecipes.service;

import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;
import com.example.pizzarecipes.R;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private static ProduitService instance;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed(); // préremplissage
    }

    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    private void seed() {
        // Using R.mipmap since you added images to mipmap folder
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0, R.mipmap.pizza1, "35min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce",
                "Pizza au poulet barbecue simple et rapide.",
                "STEP 1: Griller le poulet.\nSTEP 2: Garnir la pizza et cuire."));

        data.add(new Produit("BRUSCHETTA PIZZA", 5.0, R.mipmap.pizza2, "35min",
                "- 1/2 pound reduced-fat bulk pork sausage\n- 1 prebaked 12-inch pizza crust",
                "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes.",
                "STEP 1: Preheat oven to 450°F.\nSTEP 2: Top crust with sausage and tomatoes.\nSTEP 3: Bake 12-15 minutes."));

        data.add(new Produit("SPINACH PIZZA", 2.0, R.mipmap.pizza3, "25min",
                "- Sauce Alfredo, épinards, tomates, fromage",
                "Pizza crémeuse et légère aux légumes.",
                "STEP 1: Étaler la pâte.\nSTEP 2: Ajouter la garniture."));

        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8.0, R.mipmap.pizza4, "45min",
                "- 1 package (1/4 ounce) active dry yeast\n- 1 pound bulk Italian sausage",
                "Authentic Chicago-style deep dish pizza with hearty sausage.",
                "STEP 1: Prepare dough and let rise.\nSTEP 2: Press into deep dish pan.\nSTEP 3: Add sausage and cheese.\nSTEP 4: Bake 30-35 minutes."));

        data.add(new Produit("HOMEMADE PIZZA", 4.0, R.mipmap.pizza5, "50min",
                "- 1 package (1/4 ounce) active dry yeast\n- 2 1/2 cups all-purpose flour",
                "Classic homemade pizza from scratch with your favorite toppings.",
                "STEP 1: Dissolve yeast in warm water.\nSTEP 2: Knead dough and let rise.\nSTEP 3: Roll out and add toppings.\nSTEP 4: Bake at 425°F for 20 minutes."));

        data.add(new Produit("PESTO CHICKEN PIZZA", 3.0, R.mipmap.pizza6, "50min",
                "- 2 teaspoons active dry yeast\n- 1/2 cup pesto sauce",
                "Delicious pizza with basil pesto and grilled chicken.",
                "STEP 1: Prepare pizza dough.\nSTEP 2: Spread pesto sauce.\nSTEP 3: Top with chicken and cheese.\nSTEP 4: Bake until golden."));

        data.add(new Produit("LOADED MEXICAN PIZZA", 3.0, R.mipmap.pizza7, "30min",
                "- 1 can (15 ounces) black beans, rinsed and drained\n- 1 cup salsa",
                "Southwest flavors on a crispy tortilla crust.",
                "STEP 1: Layer tortillas with beans and salsa.\nSTEP 2: Top with cheese and jalapeños.\nSTEP 3: Bake 10-12 minutes."));

        data.add(new Produit("BACON CHEESEBURGER PIZZA", 2.0, R.mipmap.pizza8, "20min",
                "- 1/2 pound ground beef\n- 4 slices bacon, cooked and crumbled",
                "All the flavors of a bacon cheeseburger on a pizza crust!",
                "STEP 1: Brown ground beef.\nSTEP 2: Top pizza with beef, bacon, and cheese.\nSTEP 3: Bake 15 minutes.\nSTEP 4: Top with lettuce and tomato after baking."));

        data.add(new Produit("MARGHERITA PIZZA", 9.0, R.mipmap.pizza9, "30min",
                "- 3 teaspoons active dry yeast\n- Fresh basil, mozzarella, tomatoes",
                "Simple and classic Italian pizza with fresh ingredients.",
                "STEP 1: Stretch the dough.\nSTEP 2: Add tomato sauce and mozzarella.\nSTEP 3: Bake at 500°F.\nSTEP 4: Top with fresh basil."));

        data.add(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5.0, R.mipmap.pizza10, "45min",
                "- 1 package (1/4 ounce) active dry yeast\n- Pepperoni and sausage filling",
                "Stuffed crust pizza loaded with meats and cheese.",
                "STEP 1: Roll out two crusts.\nSTEP 2: Place fillings on bottom crust.\nSTEP 3: Cover with top crust and seal.\nSTEP 4: Bake 30-35 minutes."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return data;
    }
}