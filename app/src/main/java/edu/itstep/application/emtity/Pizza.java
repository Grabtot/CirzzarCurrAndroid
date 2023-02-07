package edu.itstep.application.emtity;

import java.util.List;
import java.util.Map;

public class Pizza {
    private String name;
    private int imageResource;
    private Map<String, Integer> sizesPrices;
    private List<String> toppings;

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
}

