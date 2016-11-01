import java.util.ArrayList;

/**
 * Show statistics for an object Bus
 */
public class Bus extends Transport {
  private double averageSpeed;
  private double priceLiter;
  private double fuel;
  private int people;

  /**
   * Constructor for the
   * fields of the object Bus
   */
  public Bus() {
    this.averageSpeed = 60.0;
    this.priceLiter = 0.5;
    this.fuel = 20.5;
    this.people = 40;
  }

  /**
   * Check validity of the input data
   *
   * @param averageSpeed - average speed of the bus
   * @param priceLiter   - price per liter of the bus
   * @param fuel         - fuel consumption per 100 km of the bus
   * @param people       - people in the bus
   * @return true if parameters satisfy the condition otherwise false
   */
  public boolean validateInputData(double averageSpeed, double priceLiter, double fuel, int people) {
    if (averageSpeed < 0 || priceLiter < 0 || fuel < 0 || people < 0) {
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
