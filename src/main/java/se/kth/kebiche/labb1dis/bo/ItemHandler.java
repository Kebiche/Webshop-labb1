package se.kth.kebiche.labb1dis.bo;

import java.util.ArrayList;
import java.util.Collection;
import se.kth.kebiche.labb1dis.db.ItemDB;
import se.kth.kebiche.labb1dis.ui.ItemInfo;

public class ItemHandler {

    public static Collection<ItemInfo> getItems() {
        ArrayList<ItemInfo> itemInfos = new ArrayList<>();
        for (Item item : ItemDB.searchItems()) {
            itemInfos.add(new ItemInfo(item.getId(), item.getName(), item.getDescription(), item.getPrice()));
        }
        return itemInfos;
    }
}
