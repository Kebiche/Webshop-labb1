package se.kth.kebiche.labb1dis.bo;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Item item, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.getItem().getId() == item.getId()) {
                cartItem.addQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(item, quantity));
    }

    public void removeItem(int itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItem().getId() == itemId) {
                items.remove(i);
                return;
            }
        }
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public int getItemCount() {
        int count = 0;
        for (CartItem cartItem : items) {
            count = count + cartItem.getQuantity();
        }
        return count;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem cartItem : items) {
            total = total + cartItem.getSubtotal();
        }
        return total;
    }
}
