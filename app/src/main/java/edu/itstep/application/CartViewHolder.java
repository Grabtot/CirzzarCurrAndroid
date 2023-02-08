package edu.itstep.application;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CartViewHolder {
    ImageView image;
    TextView name;
    TextView size;
    TextView price;

    public CartViewHolder(View view){
        image = view.findViewById(R.id.pizza_cart_icon);
        name = view.findViewById(R.id.pizza_cart_name);
        size = view.findViewById(R.id.pizza_cart_size);
        price = view.findViewById(R.id.pizza_cart_price);
    }
}
