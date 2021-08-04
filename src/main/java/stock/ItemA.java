package stock;

/**
 * The ItemA class is a subclass that extends Item super class, this ItemA class will have all the items that are categorized
 * by their weight
 */

public class ItemA extends Item {
    private int weight;

    public ItemA(String name, long price, int weight) {
        super(name, price);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
