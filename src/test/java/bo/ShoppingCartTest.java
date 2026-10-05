package bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Enhetstester för kundvagnen. Testerna behöver varken databas eller Tomcat
 * eftersom ShoppingCart ligger i affärslagret.
 */
class ShoppingCartTest {

    private static final double DELTA = 0.001;

    private Item mug;
    private Item shirt;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        // Testet ligger i samma paket som Item och kan därför använda den protected konstruktorn.
        mug = new Item(1, "Kaffemugg", "Vit keramikmugg", 89.00);
        shirt = new Item(2, "T-shirt", "Svart t-shirt", 199.00);
        cart = new ShoppingCart();
    }

    @Test
    void newCartIsEmpty() {
        assertTrue(cart.getItems().isEmpty());
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotal(), DELTA);
    }

    @Test
    void addItemCreatesRow() {
        cart.addItem(mug, 2);

        assertEquals(1, cart.getItems().size());
        assertEquals(mug, cart.getItems().get(0).getItem());
        assertEquals(2, cart.getItems().get(0).getQuantity());
    }

    @Test
    void addingSameItemAgainIncreasesQuantityOnSameRow() {
        cart.addItem(mug, 2);
        cart.addItem(mug, 1);

        assertEquals(1, cart.getItems().size());
        assertEquals(3, cart.getItems().get(0).getQuantity());
    }

    @Test
    void differentItemsGetSeparateRows() {
        cart.addItem(mug, 1);
        cart.addItem(shirt, 1);

        assertEquals(2, cart.getItems().size());
    }

    @Test
    void itemCountIsSumOfQuantities() {
        cart.addItem(mug, 2);
        cart.addItem(shirt, 3);

        assertEquals(5, cart.getItemCount());
    }

    @Test
    void totalIsSumOfPriceTimesQuantity() {
        cart.addItem(mug, 3);   // 3 * 89  = 267
        cart.addItem(shirt, 1); // 1 * 199 = 199

        assertEquals(466.00, cart.getTotal(), DELTA);
    }

    @Test
    void removeItemRemovesWholeRow() {
        cart.addItem(mug, 3);
        cart.addItem(shirt, 1);

        cart.removeItem(mug.getId());

        assertEquals(1, cart.getItems().size());
        assertEquals(shirt, cart.getItems().get(0).getItem());
        assertEquals(199.00, cart.getTotal(), DELTA);
    }

    @Test
    void removeUnknownItemDoesNothing() {
        cart.addItem(mug, 1);

        cart.removeItem(999);

        assertEquals(1, cart.getItemCount());
    }
}
