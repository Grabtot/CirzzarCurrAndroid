package edu.itstep.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import edu.itstep.application.databinding.FragmentOrderBinding;
import edu.itstep.application.emtity.Pizza;


public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;
    private ListView mListView;
    private PizzaCartAdapter mAdapter;
    private List<Pizza> mCart = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        mListView = binding.cartList;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        List<Pizza> newCart = getArguments().getParcelableArrayList("cart");
        mCart.addAll(newCart);

        mAdapter = new PizzaCartAdapter(getContext(), R.layout.cart_item, mCart);
        binding.finalPrice.setText(String.valueOf(getFinalPrice()));
        mListView.setAdapter(mAdapter);
//        mListView.setSaveEnabled(true);
    }

    private int getFinalPrice() {
        int finalPrice = 0;
        for (Pizza pizza : mCart) {
            finalPrice += pizza.getPrice();
        }
        return finalPrice;
    }


}