package edu.itstep.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.itstep.application.emtity.Pizza;

public class PizzaCartAdapter extends ArrayAdapter<Pizza> {

    private final LayoutInflater mInflater;
    private Context mContext;
    private List<Pizza> mCart;
    private int mResource;

    public PizzaCartAdapter(Context context, int resource, List<Pizza> cart) {
        super(context, resource, cart);

        mContext = context;
        mCart = cart;
        mResource = resource;

        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = mInflater.inflate(mResource, parent, false);

        CartViewHolder viewHolder = new CartViewHolder(view);
        Pizza pizza = mCart.get(position);

        viewHolder.image.setImageResource(pizza.getImageResource());
        viewHolder.name.setText(pizza.getName());
        viewHolder.size.setText(pizza.getSelectedSize());
        viewHolder.price.setText(String.valueOf(pizza.getPrice(pizza.getSelectedSize())));



        return view;
    }
}
