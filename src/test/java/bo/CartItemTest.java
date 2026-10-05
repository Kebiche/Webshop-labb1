package bo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Enhetstester för en rad i kundvagnen.
 */
class CartItemTest {

    private static final double DELTA = 0.001;

    private final Item notebook = new Item(3, "Anteckningsbok", "A5, linjerad", 49.50);

    @Test
    void subtotalIsPriceTimesQuantity() {
        CartItem row = new CartItem(notebook, 4);

        assertEquals(198.00, row.getSubtotal(), DELTA);
    }

    @Test
    void addQuantityIncreasesQuantityAndSubtotal() {
        CartItem row = new CartItem(notebook, 1);

        row.addQuantity(2);

        assertEquals(3, row.getQuantity());
        assertEquals(148.50, row.getSubtotal(), DELTA);
    }
}
