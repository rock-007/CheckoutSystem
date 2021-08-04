package stock;

/**
 * The ItemA class is a subclass that extends Item super class, this ItemC class will have all the items that are categorized
 * by their ageRestriction
 */

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
