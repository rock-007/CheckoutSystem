package behaviour;

/**
 * The IPrice is an Interface having one abstract method  and Item class will implement this Price and will have
 * the implementation method for CalculatePrice.
 */
public interface IPrice {

    long CalculatePrice(int quantity);

}
