import java.util.ArrayList;

/**
 * Transport is the super class
 */
public abstract class Transport implements Statistics {

  /**
   * abstract method for time
   *
   * @param Point - input data
   * @return time
   */
  public abstract double statTime(ArrayList<String> Point);

  /**
   * abstract method for price
   *
   * @param Point - input data
   * @return price
   */
  public abstract double statPrice(ArrayList<String> Point);

  /**
   * @param averageSpeed - average speed
   * @param priceLiter   - price per liter
   * @param fuel         - fuel consumption per 100 km
   * @param people       - people
   * @return true if parameters satisfy the condition otherwise false
   */
  public abstract boolean validateInputData(double averageSpeed, double priceLiter, double fuel, int people);
}
