package stock;

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
