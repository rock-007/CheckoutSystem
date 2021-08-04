package stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    ItemA itema;
    ItemB itemb;
    ItemC itemc;
    ItemD itemd;


    @Before
    public void before() {
        itema = new ItemA(ItemType.TYPEA.getCategory(), ItemType.TYPEA.getPrice(), 25);
        itemb = new ItemB(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 2);
        itemc = new ItemC(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 1);
        itemd = new ItemD(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 25);

    }

    @Test
    public void itemAHasPriceValue() {
        assertEquals(50L, itema.getPrice());
    }

    @Test
    public void itemBHasNameValue() {
        assertEquals("MilkBottle", itemb.getName());
    }

    @Test
    public void itemCHasPortionSizeValue() {
        assertEquals(1, itemc.getPortionSize());
    }

    @Test
    public void itemDHasAgeRestrictionValue() {
        assertEquals(25, itemd.getAgeRestriction());
    }
}
