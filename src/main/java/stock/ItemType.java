package stock;
// ItemType is the enum class, it contains all the items information including (Category, price, minQuantitiy and offer price)

public enum ItemType {
    TYPEA("PizzaFlour", 50, 3, 130),
    TYPEB("MilkBottle", 30, 2, 45),
    TYPEC("Eggs", 20, -1, 0),
    TYPED("Wine", 15, -1, 0);

    private final String category;
    private final long price;
    private final long minQuantity;
    private final long offerPrice;

    ItemType(String category, long price, long minQuantity, long offerPrice) {
        this.category = category;
        this.price = price;
        this.minQuantity = minQuantity;
        this.offerPrice = offerPrice;
    }

    public String getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public long getMinQuantity() {
        return minQuantity;
    }

    public long getOfferPrice() {
        return offerPrice;
    }
}
