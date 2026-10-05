package se.kth.kebiche.labb1dis.ui;

public class CartItemInfo {

    private int itemId;
    private String name;
    private double price;
    private int quantity;
    private double subtotal;

    public CartItemInfo(int itemId, String name, double price, int quantity, double subtotal) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
