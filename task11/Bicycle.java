import java.util.ArrayList;

/**
 * Show statistics for an object Bicycle
 */
public class Bicycle implements Statistics {
  double averageSpeed = 15.0;
  double priceLiter = 0.0;
  double fuel = 0.0;
  int people = 1;

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
   * Count price and time for the object
   * Bicycle and output this statistics
   *
   * @param Point - input data
   */
  public void stat(ArrayList<String> Point) {
    Distance distance = new Distance();
    double price = 0.0;
    double time = distance.distance(Point) / averageSpeed;
    System.out.println("Bicycle\nTime: " + time + " hours " + " Price: " + price + " &");
  }
}
