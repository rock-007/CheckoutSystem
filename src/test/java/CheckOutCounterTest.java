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
        itemC = new ItemC(ItemType.TYPEC.getCategory(), ItemType.TYPEC.getPrice(), 1);
        itemD = new ItemD(ItemType.TYPED.getCategory(), ItemType.TYPED.getPrice(), 25);
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
        assertEquals(100, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        assertEquals(130, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        assertEquals(210, checkOutCounter.getScanItemsRunningTotal());

    }

    @Test
    public void canShowFinalTotal() {
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        assertEquals(100, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        assertEquals(130, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemA, 2);
        assertEquals(210, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemC, 1);
        assertEquals(230, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemD, 5);
        assertEquals(305, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemB, 1);
        assertEquals(320, checkOutCounter.getScanItemsRunningTotal());
        checkOutCounter.setScanItemsPriceQuantity(itemA, 5);
        assertEquals(530, checkOutCounter.checkOutCustomer());
        // After checkout the running total will be reset to zero.
        assertEquals(0, checkOutCounter.getScanItemsRunningTotal());


    }
}
