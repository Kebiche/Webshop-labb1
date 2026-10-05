package bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ui.CartItemInfo;
import ui.ShoppingCartInfo;

/**
 * Enhetstester för CartHandler. Testar de metoder som inte behöver databasen:
 * att skapa en kundvagn, ta bort varor och göra om kundvagnen till Info-objekt.
 * addItem hämtar varan från databasen och testas därför manuellt i webbläsaren.
 */
class CartHandlerTest {

    private static final double DELTA = 0.001;

    private final Item mug = new Item(1, "Kaffemugg", "Vit keramikmugg", 89.00);
    private final Item shirt = new Item(2, "T-shirt", "Svart t-shirt", 199.00);

    @Test
    void createCartReturnsEmptyCart() {
        ShoppingCart cart = CartHandler.createCart();

        assertNotNull(cart);
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void getCartOfEmptyCartGivesEmptyInfo() {
        ShoppingCartInfo info = CartHandler.getCart(CartHandler.createCart());

        assertTrue(info.getItems().isEmpty());
        assertEquals(0, info.getItemCount());
        assertEquals(0.0, info.getTotal(), DELTA);
    }

    @Test
    void getCartCopiesRowsToInfoObjects() {
        ShoppingCart cart = CartHandler.createCart();
        cart.addItem(mug, 3);
        cart.addItem(shirt, 1);

        ShoppingCartInfo info = CartHandler.getCart(cart);

        assertEquals(2, info.getItems().size());
        assertEquals(4, info.getItemCount());
        assertEquals(466.00, info.getTotal(), DELTA);

        CartItemInfo row = info.getItems().get(0);
        assertEquals(1, row.getItemId());
        assertEquals("Kaffemugg", row.getName());
        assertEquals(89.00, row.getPrice(), DELTA);
        assertEquals(3, row.getQuantity());
        assertEquals(267.00, row.getSubtotal(), DELTA);
    }

    @Test
    void removeItemRemovesRowFromCart() {
        ShoppingCart cart = CartHandler.createCart();
        cart.addItem(mug, 3);
        cart.addItem(shirt, 1);

        CartHandler.removeItem(cart, mug.getId());

        ShoppingCartInfo info = CartHandler.getCart(cart);
        assertEquals(1, info.getItems().size());
        assertEquals("T-shirt", info.getItems().get(0).getName());
    }
}
