import java.util.ArrayList;

/**
 * Show statistics for an object Bus
 */
public class Bus extends Transport {
  double averageSpeed;
  double priceLiter;
  double fuel;
  int people;

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
   * Count price and time for the object
   * Bus and output this statistics
   *
   * @param Point - input data
   */
  public void stat(ArrayList<String> Point) {
    Distance distance = new Distance();
    double price = (fuel / 100 * distance.distance(Point) * priceLiter) / people;
    double time = distance.distance(Point) / averageSpeed;
    System.out.println("Bus\nTime: " + time + " hours " + " Price: " + price + " $");
  }
}
