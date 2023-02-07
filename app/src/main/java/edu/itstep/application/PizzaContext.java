package edu.itstep.application;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.itstep.application.emtity.Pizza;

public class PizzaContext {

    private Context mContext;

    public PizzaContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<Pizza> getPizzas() {
        Map<String, Integer> pizzaSize = new HashMap<>();
        pizzaSize.put("Small", 150);
        pizzaSize.put("Medium", 170);
        pizzaSize.put("Big", 210);

        List<String> toppings = new ArrayList<>();
        toppings.add("Peperoni");
        toppings.add("Onion");
        toppings.add("Cheese");

        Resources resources = mContext.getResources();

        Pizza pizza = new Pizza(resources.getString(R.string.pizza_pepperoni), R.drawable.pepperoni, pizzaSize, toppings);
        Pizza pizza1 = new Pizza(resources.getString(R.string.pizza_veggie), R.drawable.veggie, pizzaSize, toppings);
        Pizza pizza2 = new Pizza(resources.getString(R.string.pizza_margherita), R.drawable.margherita, pizzaSize, toppings);
        Pizza pizza3 = new Pizza(resources.getString(R.string.pizza_hawaiian), R.drawable.hawaiian, pizzaSize, toppings);

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(pizza);
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);
        pizzaList.add(pizza3);
        return pizzaList;
    }
}
