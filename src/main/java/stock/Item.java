package stock;

import behaviour.IPrice;

public class Item implements IPrice {

    private String name;
    private long price;
    private long[] offerMinQuantityPrice;

    public Item(String name, long price) {
        this.name = name;
        this.price = price;
        this.offerMinQuantityPrice =  new long[]{-1,price};
    }

    @Override
    public long CalculatePrice(int quantity) {
        return 0;
    }
}
