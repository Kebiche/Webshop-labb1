package se.kth.kebiche.labb1dis.bo;

import java.util.Collection;
import se.kth.kebiche.labb1dis.db.ItemDB;

public class ItemHandler {

    public static Collection<Item> getItems() {
        return ItemDB.searchItems();
    }

    public static Item getItem(int id) {
        return ItemDB.searchItem(id);
    }
}
