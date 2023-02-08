package edu.itstep.application.emtity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Pizza implements Serializable, Parcelable {
    private final String name;
    private final int imageResource;
    private final Map<String, Integer> sizesPrices;
    private final List<String> toppings;
    private String selectedSize;

    public Pizza(String name, int imageResource, Map<String, Integer> sizesPrices, List<String> toppings) {
        this.name = name;
        this.imageResource = imageResource;
        this.sizesPrices = sizesPrices;
        this.toppings = toppings;
    }

    protected Pizza(Parcel in) {
        name = in.readString();
        imageResource = in.readInt();
        sizesPrices = in.readHashMap(null);
        toppings = in.createStringArrayList();
        selectedSize = in.readString();
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

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

    public String getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResource);
        dest.writeMap(sizesPrices);
        dest.writeStringList(toppings);
        dest.writeString(selectedSize);
    }

    public int getPrice() {
        return sizesPrices.get(selectedSize);
    }
}

