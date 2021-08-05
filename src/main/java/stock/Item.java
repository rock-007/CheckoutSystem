package stock;

import behaviour.IPrice;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The Item class is a Super class having common methods and properties that ItemA, ItemB, ItemC and ItemD can extend
 */


public class Item implements IPrice {
    private String name;
    private long price;
    /**
     * The offerMinQuantityPrice will have two values, at Index 0 it will show the minimum quantity (-1 means it's not valid) to qualify for offer and the Index 1
     * will be the offer price
     */
    private long[] offerMinQuantityPrice;

    public Item(String name, long price) {
        this.name = name;
        this.price = price;
        this.offerMinQuantityPrice = new long[]{-1, price};
    }
// calculateSeparatePrices will first identify the "quantity valid for offer" and "quantity valid for normal price", then calculate prices for both and add them to get the total price for that quantity.
    Function<Integer, Long> calculateSeparatePrices = quantity -> {
        int offerValidQuantity = quantity;
        int normalPriceQuantity = 0;
        while (offerValidQuantity % this.offerMinQuantityPrice[0] != 0) {
            offerValidQuantity--;
            normalPriceQuantity++;
        }
        return normalPriceQuantity * this.price + (offerValidQuantity / this.offerMinQuantityPrice[0]) * this.offerMinQuantityPrice[1];
    };
//validOffer will check if the quantity qualify for the offer or not.
    Predicate<Integer> validOffer = quantity -> quantity >= this.offerMinQuantityPrice[0] && this.offerMinQuantityPrice[0] != -1;

    // build the logic here to calculate the total price
    @Override
    public long CalculatePrice(int quantity) {
        if (validOffer.test(quantity)) {
            return calculateSeparatePrices.apply(quantity);
        } else {
            return this.getPrice() * quantity;
        }

    }

    public void setOfferMinQuantityPrice(long minQuantity, long offerPrice) {
        this.offerMinQuantityPrice[0] = minQuantity;
        this.offerMinQuantityPrice[1] = offerPrice;

    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long[] getOfferMinQuantityPrice() {
        return this.offerMinQuantityPrice;
    }

}
