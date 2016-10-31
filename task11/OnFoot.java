import java.util.ArrayList;

/**
 * Show statistics for an object OnFoot
 */
public class OnFoot implements Statistics {
  double averageSpeed;
  double priceLiter;
  double fuel;
  int people;

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
   * Count price and time for the object
   * OnFoot and output this statistics
   *
   * @param Point - input data
   */
  public void stat(ArrayList<String> Point) {
    Distance distance = new Distance();
    double price = 0.0;
    double time = distance.distance(Point) / averageSpeed;
    System.out.println("Person\nTime: " + time + " hours " + " Price: " + price + " $");
  }
}
