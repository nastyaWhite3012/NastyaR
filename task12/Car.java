import java.util.ArrayList;

/**
 * Show statistics for an object Car
 */
public class Car extends Transport {
  private double averageSpeed;
  private double priceLiter;
  private double fuel;
  private int people;

  /**
   * Constructor for the
   * fields of the object Car
   */
  public Car() {
    this.averageSpeed = 90.0;
    this.priceLiter = 0.5;
    this.fuel = 7.5;
    this.people = 1;
  }

  /**
   * Check validity of the input data
   *
   * @param averageSpeed - average speed of the car
   * @param priceLiter   - price per liter of the car
   * @param fuel         - fuel consumption per 100 km of the car
   * @param people       - people in the car
   * @return true if parameters satisfy the condition otherwise false
   */
  public boolean validateInputData(double averageSpeed, double priceLiter, double fuel, int people) {
    if (averageSpeed < 0 || priceLiter < 0 || fuel < 0 || people != 1) {
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

