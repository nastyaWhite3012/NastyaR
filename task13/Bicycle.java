import java.util.ArrayList;

/**
 * Show statistics for an object Bicycle
 */
public class Bicycle implements Statistics {
  private double averageSpeed = 15.0;
  private double priceLiter = 0.0;
  private double fuel = 0.0;
  private int people = 1;

  /**
   * Constructor for the fields
   * of the object Bicycle
   */
  public Bicycle() {
    this.averageSpeed = 15.0;
    this.priceLiter = 0.0;
    this.fuel = 0.0;
    this.people = 1;
  }

  /**
   * Check validity of the input data
   *
   * @param averageSpeed - average speed of the bicycle
   * @param priceLiter   - price per liter of the bicycle
   * @param fuel         - fuel consumption per 100 km of the bicycle
   * @param people       - people on the bicycle
   * @return true if parameters satisfy the condition otherwise false
   */
  public boolean validateInputData(double averageSpeed, double priceLiter, double fuel, int people) {
    if (averageSpeed < 0 || priceLiter != 0 || fuel != 0 || people != 1) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Count time per the distance
   *
   * @param Point - input data
   * @return time
   */
  public double statTime(ArrayList<String> Point) {
    Distance distance = new Distance();
    double time = 0.0;
    if (!validateInputData(averageSpeed, priceLiter, fuel, people)) {
      System.out.println("Wrong data!");
    } else {
      time = distance.distance(Point) / averageSpeed;
    }
    return time;
  }

  /**
   * Count price per the distance
   *
   * @param Point - input data
   * @return price
   */
  public double statPrice(ArrayList<String> Point) {
    Distance distance = new Distance();
    double price = 0.0;
    if (!validateInputData(averageSpeed, priceLiter, fuel, people)) {
      System.out.println("Wrong data!");
    } else {
      price = (fuel / 100) * distance.distance(Point) * priceLiter / people;
    }
    return price;
  }
}
