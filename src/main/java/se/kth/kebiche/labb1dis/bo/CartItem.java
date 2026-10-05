package se.kth.kebiche.labb1dis.bo;

public class CartItem {

    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        quantity = quantity + amount;
    }

    public double getSubtotal() {
        return item.getPrice() * quantity;
    }
}
