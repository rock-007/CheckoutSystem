package stock;

import behaviour.IPrice;

import java.sql.SQLOutput;
import java.util.function.Function;
import java.util.function.Predicate;

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


        if (validOffer.test(quantity)) {

            return calculateSeparatePrices.apply(quantity);
        } else {

            return this.getPrice() * quantity;
        }

    }

    Function<Integer, Long> calculateSeparatePrices = quantity -> {

        int offerValidQuantity = quantity;
        int normalPriceQuantity = 0;
        while (this.offerMinQuantityPrice[0] % offerValidQuantity != 0) {

            offerValidQuantity--;
            normalPriceQuantity++;
        }
        return normalPriceQuantity * this.price + (offerValidQuantity / 3) * this.offerMinQuantityPrice[1];
    };

    Predicate<Integer> validOffer = quantity -> quantity >= this.offerMinQuantityPrice[0] && quantity != -1;

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long[] getOfferMinQuantityPrice() {
        return offerMinQuantityPrice;
    }

    public void setOfferMinQuantityPrice(long minQuantity, long offerPrice) {
        this.offerMinQuantityPrice[0] = minQuantity;
        this.offerMinQuantityPrice[1] = offerPrice;

    }
}
