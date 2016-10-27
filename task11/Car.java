import java.util.ArrayList;

/**
 * Show statistics for an object Car
 */
public class Car extends Transport {
  double averageSpeed;
  double priceLiter;
  double fuel;
  int people;

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
   * Count price and time for the object
   * Car and output this statistics
   *
   * @param Point - input data
   */
  public void stat(ArrayList<String> Point) {
    Distance distance = new Distance();
    double price = (fuel / 100 * distance.distance(Point) * priceLiter) / people;
    double time = distance.distance(Point) / averageSpeed;
    System.out.println("Car\nTime: " + time + " hours " + " Price: " + price + " $");
  }
}

