package stock;

public enum ItemType {
    TYPEA("Pizza Flour",50),
    TYPEB("Milk Bottle",30),
    TYPEC("Eggs",20),
    TYPED("Wine",15);

    private final String category;
    private final long price;

    ItemType(String category, long price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }
}
