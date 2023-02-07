package edu.itstep.application;

import android.view.View;
import android.widget.*;

class PizzaViewHolder {
    TextView name;
    ImageView image;
    TextView toppings;
    TextView price;

    public PizzaViewHolder(View view){
        name = view.findViewById(R.id.pizza_name);
        image = view.findViewById(R.id.pizza_image);
        toppings = view.findViewById(R.id.pizza_toppings);
        price = view.findViewById(R.id.min_price);
    }
}
