import java.util.ArrayList;

/**
 * Count statistics (time and
 * price) for all objects:
 * Car, Bus, Bicycle and OnFoot
 */
public interface Statistics {

  /**
   * Count time for statistics
   *
   * @param Point - input data
   * @return time
   */
  double statTime(ArrayList<String> Point);

  /**
   * Count price for statistics
   *
   * @param Point - input data
   * @return price
   */
  double statPrice(ArrayList<String> Point);

  /**
   * @param averageSpeed - average speed
   * @param priceLiter   - price per liter
   * @param fuel         - fuel consumption per 100 km
   * @param people       - people
   * @return true if parameters satisfy the condition otherwise false
   */
  boolean validateInputData(double averageSpeed, double priceLiter, double fuel, int people);
}
