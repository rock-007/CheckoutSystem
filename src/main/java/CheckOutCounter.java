import stock.Item;

import java.util.HashMap;
import java.util.Map;

public class CheckOutCounter {

    private int tillNo;
    private String operatorName;
    private Map<Item, int[]> scanItemsQuantityAndTotalPrice;

    //constructor
    public CheckOutCounter(int tillNo, String operatorName) {
        this.tillNo = tillNo;
        this.operatorName = operatorName;
        this.scanItemsQuantityAndTotalPrice = new HashMap<>();
    }

    public int getTillNo() {
        return tillNo;
    }

    public void setTillNo(int tillNo) {
        this.tillNo = tillNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Map<Item, int[]> getScanItemsPriceQuantity() {
        return scanItemsQuantityAndTotalPrice;
    }

    public void setScanItemsPriceQuantity(Item item, int quantity) {
        this.scanItemsQuantityAndTotalPrice.put(item, addItemsQuantityAndTotalPrice(item, quantity));
    }


    public int[] addItemsQuantityAndTotalPrice(Item item, int quantity) {
        //Array of size 2 as index 0 is quantity and index 1 is total price
        int[] quantityAndTotalPrice = new int[2];

        quantityAndTotalPrice[0] = this.getScannedItemPreviousQuantity(item) + quantity;
        quantityAndTotalPrice[1] = (int) item.CalculatePrice(quantityAndTotalPrice[0]);

        return quantityAndTotalPrice;

    }

    public int getScannedItemPreviousQuantity(Item item) {
        return scanItemsQuantityAndTotalPrice.getOrDefault(item, new int[]{0})[0];

    }

    public int getScanItemsRunningTotal() {
        int totalPrice = 0;
        for (Map.Entry<Item, int[]> eachScannedItem : scanItemsQuantityAndTotalPrice.entrySet()) {
            totalPrice += eachScannedItem.getValue()[1];
        }
        return totalPrice;
    }
}