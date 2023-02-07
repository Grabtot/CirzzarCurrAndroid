package edu.itstep.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.itstep.application.databinding.FragmentFirstBinding;
import edu.itstep.application.emtity.Pizza;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private RecyclerView pizzaGrid;
    private PizzaAdapter mPizzaAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        pizzaGrid = binding.getRoot().findViewById(R.id.pizza_grid);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        pizzaGrid.setLayoutManager(layoutManager);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Map<String, Integer> pizzaSize = new HashMap<>();
        pizzaSize.put("Small", 150);
        pizzaSize.put("Medium", 170);
        pizzaSize.put("Big", 210);

        List<String> toppings = new ArrayList<>();
        toppings.add("Peperoni");
        toppings.add("Onion");
        toppings.add("Cheese");
        
        Pizza pizza = new Pizza(getString(R.string.pizza_pepperoni), R.drawable.pepperoni, pizzaSize, toppings);
        Pizza pizza1 = new Pizza(getString(R.string.pizza_veggie), R.drawable.veggie, pizzaSize, toppings);
        Pizza pizza2 = new Pizza(getString(R.string.pizza_margherita), R.drawable.margherita, pizzaSize, toppings);
        Pizza pizza3 = new Pizza(getString(R.string.pizza_hawaiian), R.drawable.hawaiian, pizzaSize, toppings);

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(pizza);
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);
        pizzaList.add(pizza3);

        mPizzaAdapter = new PizzaAdapter(getContext(), pizzaList);
        pizzaGrid.setAdapter(mPizzaAdapter);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}