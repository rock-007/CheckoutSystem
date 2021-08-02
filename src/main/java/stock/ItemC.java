package stock;

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
