import java.util.ArrayList;

/**
 * Start point of the program
 */
public class Main {
  /**
   * Create ArrayList of points for moving.
   * Create objects Car, Bus, Bicycle and OnFoot
   * and show statistics for each object
   *
   * @param args - console argument
   * @throws Exception - auto exception working with files
   */
  public static void main(String[] args) {
    ArrayList<String> Point = new ArrayList();

    try {
      ReaderFile readerFile = new ReaderFile();
      readerFile.readerFile(Point);
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }

    Car car = new Car();
    System.out.println("Car\nTime: " + car.statTime(Point) + " hours   Price: " + car.statPrice(Point) + " $");

    Bus bus = new Bus();
    System.out.println("Bus\nTime: " + bus.statTime(Point) + " hours   Price: " + bus.statPrice(Point) + " $");

    Bicycle bicycle = new Bicycle();
    System.out.println("Bicycle\nTime: " + bicycle.statTime(Point) + " hours   Price: " + bicycle.statPrice(Point) + " $");

    OnFoot onFoot = new OnFoot();
    System.out.println("On foot\nTime: " + onFoot.statTime(Point) + " hours   Price: " + onFoot.statPrice(Point) + " $");
  }
}
