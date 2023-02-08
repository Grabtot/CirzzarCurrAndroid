package edu.itstep.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.itstep.application.databinding.FragmentDetailsBinding;
import edu.itstep.application.emtity.Pizza;

public class DetailsFragment extends BottomSheetDialogFragment {

    private FragmentDetailsBinding binding;
    private List<Pizza> selectedPizzas;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
    ) {

        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        selectedPizzas = new ArrayList<>();
        assert getArguments() != null;
        Pizza selectedPizza = (Pizza) getArguments().getSerializable("selected_pizza");
        selectedPizzas.add(selectedPizza);

        binding.detailsName.setText(selectedPizza.getName());
        binding.detailsToppings.setText(selectedPizza.getToppingsString());
        binding.detailsPrice.setText(selectedPizza.getMinPrice() + "грн");

        selectedPizza.setSelectedSize("Small");
        binding.detailsSize.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton button = binding.getRoot().findViewById(i);
            String pizzaSize = button.getText().toString();
            selectedPizza.setSelectedSize(pizzaSize);
            binding.detailsPrice.setText(String.valueOf(selectedPizza.getPrice(pizzaSize)));
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.detailsOrderButton.setOnClickListener(view1 ->
        {
            Bundle bundle = new Bundle();
            bundle.putSerializable("cart", (Serializable) selectedPizzas);

            NavHostFragment.findNavController(DetailsFragment.this)
                    .navigate(R.id.action_FirstFragment_to_orderFragment, bundle);
            dismiss();
        });
    }

    public void onChecked(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}