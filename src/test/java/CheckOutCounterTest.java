import org.junit.Before;
import org.junit.Test;
import stock.*;

import static org.junit.Assert.assertEquals;

public class CheckOutCounterTest {

    ItemA itemA;
    ItemB itemB;
    ItemC itemC;
    ItemD itemD;
    Stock stock;
    CheckOutCounter checkOutCounter;

    @Before
    public void before() {
        itemA = new ItemA(ItemType.TYPEA.getCategory(), ItemType.TYPEA.getPrice(), 25);
        itemB = new ItemB(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 2);
        itemC = new ItemC(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 1);
        itemD = new ItemD(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 25);
        itemA.setOfferMinQuantityPrice(ItemType.TYPEA.getMinQuantity(), ItemType.TYPEA.getOfferPrice());
        itemB.setOfferMinQuantityPrice(ItemType.TYPEB.getMinQuantity(), ItemType.TYPEB.getOfferPrice());
        stock = new Stock("Ground Floor");
        stock.setItems(itemA, 50);
        stock.setItems(itemB, 50);
        stock.setItems(itemC, 50);
        stock.setItems(itemD, 50);
        checkOutCounter = new CheckOutCounter(CheckOutCounterType.ADAMTILL1.getTillNo(), CheckOutCounterType.ADAMTILL1.getName());
    }

    @Test
    public void hasTillOperatorName() {

        assertEquals("ADAM ID1234", checkOutCounter.getOperatorName());
    }


    @Test
    public void canShowRunningTotal() {

        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        assertEquals(2, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        assertEquals(3, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        assertEquals(5, checkOutCounter.getScanItemsRunningTotal());

    }

    @Test
    public void canShowFinalTotal() {
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        checkOutCounter.setScanItemsPriceQuantity(itemC, 1);
        checkOutCounter.setScanItemsPriceQuantity(itemD, 5);
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        checkOutCounter.setScanItemsPriceQuantity(itemA, 5);


    }
}
