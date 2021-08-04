package stock;

import java.util.HashMap;
import java.util.Map;

/**
 * The Stock class stores all the items that later will be scanned/sold through checkOutCounter
 */
public class Stock {
    private String storeLocation;
    private Map<Item, Integer> items;

    public Stock(String storeLocation) {
        this.storeLocation = storeLocation;
        this.items = new HashMap<>();
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void setItems(Item item, Integer quantity) {
        this.items.put(item, getItemsQuantity(item) + quantity);
    }

    public void displayAllItems() {
        for (Map.Entry<Item, Integer> eachItem : items.entrySet()) {
            System.out.println(eachItem.getKey().getName());
        }
    }

    public Integer getItemsQuantity(Item item) {
        return this.items.getOrDefault(item, 0);
    }

    public Item searchItemQuantity(String itemName, int itemQuantity) {
        Item result = null;
        for (Map.Entry<Item, Integer> eachItem : items.entrySet()) {
            if (eachItem.getKey().getName().equals(itemName) && eachItem.getValue() >= itemQuantity) {
                result = eachItem.getKey();
            }
        }
         return result;
    }


}
