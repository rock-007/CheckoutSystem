package stock;

/**
 * The ItemA class is a subclass that extends Item super class, this ItemC class will have all the items that are categorized
 * by their portionSize
 */

public class ItemC extends Item {
    private int portionSize;

    public ItemC(String name, long price, int portionSize) {
        super(name, price);
        this.portionSize = portionSize;
    }

    public int getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(int portionSize) {
        this.portionSize = portionSize;
    }
}
