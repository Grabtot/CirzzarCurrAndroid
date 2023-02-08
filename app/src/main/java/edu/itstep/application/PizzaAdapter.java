package edu.itstep.application;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.itstep.application.emtity.Pizza;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<Pizza> mPizzaList;

    public PizzaAdapter(Context context, List<Pizza> pizzaList) {
        mContext = context;
        mPizzaList = pizzaList;
    }


    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.pizza_item, parent, false);
        return new PizzaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        Pizza pizza = mPizzaList.get(position);

        holder.image.setImageResource(pizza.getImageResource());
        holder.name.setText(pizza.getName());
        holder.price.setText("от " + pizza.getMinPrice() + " грн");
        holder.toppings.setText(pizza.getToppingsString());
        holder.cartButton.setTag(position);
        holder.cartButton.setOnClickListener(this);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mPizzaList.size();
    }

    @Override
    public void onClick(View view) {

        FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();

        int position = (int) view.getTag();
        Pizza selectedPizza = mPizzaList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("selected_pizza", selectedPizza);

        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        detailsFragment.show(fragmentManager, "second_fragment");
    }
}


