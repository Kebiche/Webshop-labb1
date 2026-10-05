package bo;

import java.util.ArrayList;
import db.ItemDB;
import ui.CartItemInfo;
import ui.ShoppingCartInfo;

public class CartHandler {

    public static ShoppingCart createCart() {
        return new ShoppingCart();
    }

    public static void addItem(ShoppingCart cart, int itemId, int quantity) {
        Item item = ItemDB.searchItem(itemId);
        if (item != null && quantity >= 1 && quantity <= 99) {
            cart.addItem(item, quantity);
        }
    }

    public static void removeItem(ShoppingCart cart, int itemId) {
        cart.removeItem(itemId);
    }

    public static ShoppingCartInfo getCart(ShoppingCart cart) {
        ArrayList<CartItemInfo> itemInfos = new ArrayList<>();
        for (CartItem cartItem : cart.getItems()) {
            Item item = cartItem.getItem();
            itemInfos.add(new CartItemInfo(item.getId(), item.getName(), item.getPrice(),
                    cartItem.getQuantity(), cartItem.getSubtotal()));
        }
        return new ShoppingCartInfo(itemInfos, cart.getTotal(), cart.getItemCount());
    }
}
