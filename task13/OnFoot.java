import java.util.ArrayList;

/**
 * Show statistics for an object OnFoot
 */
public class OnFoot implements Statistics {
  private double averageSpeed;
  private double priceLiter;
  private double fuel;
  private int people;

  /**
   * Constructor for the fields
   * of the object OnFoot
   */
  public OnFoot() {
    this.averageSpeed = 5.0;
    this.priceLiter = 0.0;
    this.fuel = 0.0;
    this.people = 1;
  }

  /**
   * Check validity of the input data
   *
   * @param averageSpeed - average speed on foot
   * @param priceLiter   - price per liter on foot
   * @param fuel         - fuel consumption per 100 km on foot
   * @param people       - person
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
