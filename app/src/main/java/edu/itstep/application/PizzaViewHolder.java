package edu.itstep.application;

import android.view.View;
import android.widget.*;

import androidx.recyclerview.widget.RecyclerView;

class PizzaViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    ImageView image;
    TextView toppings;
    TextView price;
    Button cartButton;
    public PizzaViewHolder(View view){
        super(view);
        name = view.findViewById(R.id.pizza_name);
        image = view.findViewById(R.id.pizza_image);
        toppings = view.findViewById(R.id.pizza_toppings);
        price = view.findViewById(R.id.min_price);
        cartButton = view.findViewById(R.id.add_to_cart_button);
    }
}
