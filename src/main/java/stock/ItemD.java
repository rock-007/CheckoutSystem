package stock;

public class ItemD extends Item {

    private int ageRestriction;

    public ItemD(String name, long price, int ageRestriction) {
        super(name, price);
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
