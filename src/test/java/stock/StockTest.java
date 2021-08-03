package stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {
    ItemA itema;
    ItemB itemb;
    ItemC itemc;
    ItemD itemd;
    Stock stock;


    @Before
    public void before() {
        itema = new ItemA(ItemType.TYPEA.getCategory(), ItemType.TYPEA.getPrice(), 25);
        itemb = new ItemB(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 2);
        itemc = new ItemC(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 1);
        itemd = new ItemD(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 25);
        stock = new Stock("Ground Floor");
    }


    @Test
    public void canAddItemsToStock() {
        stock.setItems(itema, 1);
        stock.setItems(itemb, 1);
        stock.setItems(itemc, 1);
        assertEquals(3, stock.getItems().size());
    }

    @Test
    public void canIncrementCountOfExistingItem() {
        stock.setItems(itema, 1);
        stock.setItems(itemb, 1);
        stock.setItems(itemc, 1);
        stock.setItems(itema, 5);
        int result = stock.getItemsQuantity(itema);
        assertEquals(6, result);
    }


}
