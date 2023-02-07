package edu.itstep.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import edu.itstep.application.databinding.FragmentSecondBinding;
import edu.itstep.application.emtity.Pizza;

public class DetailsFragment extends BottomSheetDialogFragment {

    private FragmentSecondBinding binding;
    private Pizza selectedPizza;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);


        assert getArguments() != null;
        selectedPizza = (Pizza) getArguments().getSerializable("selected_pizza");
        binding.detailsName.setText(selectedPizza.getName());
        binding.detailsToppings.setText(selectedPizza.getToppingsString());
        binding.detailsPrice.setText(selectedPizza.getMinPrice() + "грн");


        binding.detailsSize.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton button = binding.getRoot().findViewById(i);
            String pizzaSize = button.getText().toString();

            binding.detailsPrice.setText(String.valueOf(selectedPizza.getPrice(pizzaSize)));
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.detailsOrderButton.setOnClickListener(view1 ->
                Toast.makeText(getContext(), "You order pizza", Toast.LENGTH_SHORT).show());
    }

    public void onChecked(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}