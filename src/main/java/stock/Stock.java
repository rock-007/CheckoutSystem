package stock;

import java.util.HashMap;
import java.util.Map;

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

        public Integer getItemsQuantity(Item item) {

            return this.items.getOrDefault(item, 0);
        }


}
