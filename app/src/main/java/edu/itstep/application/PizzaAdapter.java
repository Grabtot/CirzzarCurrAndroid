package edu.itstep.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
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
        holder.toppings.setText(pizza.getToppings().toString());
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

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        PizzaViewHolder holder;
//
//        if (view == null) {
//            view = LayoutInflater.from(mContext).inflate(R.layout.pizza_item, parent, false);
//            holder = new PizzaViewHolder(view);
//            view.setTag(holder);
//        } else {
//            holder = (PizzaViewHolder) view.getTag();
//        }
//
//        Pizza pizza = mPizzaList.get(position);
//
//        holder.image.setImageResource(pizza.getImageResource());
//        holder.name.setText(pizza.getName());
//        holder.price.setText("от " + pizza.getMinPrice() + " грн");
//        holder.toppings.setText(pizza.getToppings().toString());
//        view.findViewById(R.id.add_to_cart_button).setOnClickListener(this);
//        return view;
//    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        NavHostFragment.findNavController(fragmentManager.findFragmentById(R.id.nav_host_fragment_content_main))
                .navigate(R.id.action_FirstFragment_to_SecondFragment);

    }
}


