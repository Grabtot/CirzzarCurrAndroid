package edu.itstep.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.itstep.application.databinding.FragmentFirstBinding;

public class ListFragment extends Fragment {

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


        mPizzaAdapter = new PizzaAdapter(getContext(), new PizzaContext(getContext()).getPizzas());
        pizzaGrid.setAdapter(mPizzaAdapter);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}