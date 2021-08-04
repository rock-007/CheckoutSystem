package stock;

/**
 * The ItemB class is a subclass that extends Item super class, this ItemA class will have all the items that are categorized
 * by their volume
 */
public class ItemB extends Item {
    private int volume;

    public ItemB(String name, long price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
