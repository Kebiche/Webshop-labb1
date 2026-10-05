package ui;

import java.util.ArrayList;

public class ShoppingCartInfo {

    private ArrayList<CartItemInfo> items;
    private double total;
    private int itemCount;

    public ShoppingCartInfo(ArrayList<CartItemInfo> items, double total, int itemCount) {
        this.items = items;
        this.total = total;
        this.itemCount = itemCount;
    }

    public ArrayList<CartItemInfo> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}
