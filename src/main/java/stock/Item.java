package stock;

import behaviour.IPrice;

public class Item implements IPrice {

    private String name;
    private long price;
    private long[] offerMinQuantityPrice;

    public Item(String name, long price) {
        this.name = name;
        this.price = price;
        this.offerMinQuantityPrice = new long[]{-1, price};
    }

    // build the logic here to calculate the total price
    @Override
    public long CalculatePrice(int quantity) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long[] getOfferMinQuantityPrice() {
        return offerMinQuantityPrice;
    }
}
