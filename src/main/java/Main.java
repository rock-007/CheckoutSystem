import stock.*;

import java.util.Scanner;

// This is the Main class having main method, we can run the application from here and can test the coding using the terminal.
public class Main {
    static ItemA itemA = new ItemA(ItemType.TYPEA.getCategory(), ItemType.TYPEA.getPrice(), 25);
    static ItemB itemB = new ItemB(ItemType.TYPEB.getCategory(), ItemType.TYPEB.getPrice(), 2);
    static ItemC itemC = new ItemC(ItemType.TYPEC.getCategory(), ItemType.TYPEC.getPrice(), 1);
    static ItemD itemD = new ItemD(ItemType.TYPED.getCategory(), ItemType.TYPED.getPrice(), 25);


    public static void main(String[] args) {
        itemA.setOfferMinQuantityPrice(ItemType.TYPEA.getMinQuantity(), ItemType.TYPEA.getOfferPrice());
        itemB.setOfferMinQuantityPrice(ItemType.TYPEB.getMinQuantity(), ItemType.TYPEB.getOfferPrice());
        Stock stock = new Stock("Ground Floor");
        stock.setItems(itemA, 50);
        stock.setItems(itemB, 50);
        stock.setItems(itemC, 50);
        stock.setItems(itemD, 50);
        CheckOutCounter checkOutCounter = new CheckOutCounter(CheckOutCounterType.ADAMTILL1.getTillNo(), CheckOutCounterType.ADAMTILL1.getName());
        //Display all Stock items in terminal
        stock.displayAllItems();
        scanItems(stock, checkOutCounter);

    }

    static void scanItems(Stock stock, CheckOutCounter checkOutCounter) {
        boolean stillScanning = true;
        Scanner scanner = new Scanner(System.in);
        // Scan Items from terminal
        do {
            // name the item to scan
            System.out.println("Please enter the item name to buy");
            String itemName = scanner.next();
            // provide the quantity to scan
            System.out.println("Please enter the item quantity ");
            int itemQuantity = scanner.nextInt();
            Item scannedItem = stock.searchItemQuantity(itemName, itemQuantity);
            // If the item and quantity exist in the stock
            if (scannedItem != null) {
                checkOutCounter.setScanItemsPriceQuantity(scannedItem, itemQuantity);
            } else System.out.println("Sorry the item is not in stock");
            System.out.println("Press enter for checkout or press 'n' for next item scan");
            scanner.nextLine();
            String selection = scanner.nextLine();
            //To break loop when checkout
            if (selection.equals("")) stillScanning = false;
        } while (stillScanning);
        //After checkout the final total is displayed and running total is reset to zero
        System.out.println("The final total is : " + checkOutCounter.checkOutCustomer());
    }

}
