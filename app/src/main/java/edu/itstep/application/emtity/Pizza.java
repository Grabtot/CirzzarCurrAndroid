package edu.itstep.application.emtity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Pizza implements Serializable {
    private final String name;
    private final int imageResource;
    private final Map<String, Integer> sizesPrices;
    private final List<String> toppings;

    public Pizza(String name, int imageResource, Map<String, Integer> sizesPrices, List<String> toppings) {
        this.name = name;
        this.imageResource = imageResource;
        this.sizesPrices = sizesPrices;
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public Map<String, Integer> getSizesPrices() {
        return sizesPrices;
    }

    public int getMinPrice() {
        int minPrice = Integer.MAX_VALUE;
        for (int price : sizesPrices.values()) {
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String getToppingsString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < toppings.size(); i++) {
            String topping = toppings.get(i);
            if (i != toppings.size() - 1) {
                res.append(topping).append(", ");
            } else {
                res.append(topping);
            }
        }
        return res.toString();
    }

    public int getPrice(String pizzaSize) {
        return sizesPrices.get(pizzaSize);
    }
}

