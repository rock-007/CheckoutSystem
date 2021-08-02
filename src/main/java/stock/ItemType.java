package stock;

public enum ItemType {
    TYPEA("A", 50),
    TYPEB("B", 30),
    TYPEC("C", 20),
    TYPED("D", 15);

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
