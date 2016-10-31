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
  public static void main(String[] args) throws Exception {
    ArrayList<String> Point = new ArrayList();

    ReaderFile readerFile = new ReaderFile();
    readerFile.readerFile(Point);

    Car car = new Car();
    car.stat(Point);

    Bus bus = new Bus();
    bus.stat(Point);

    Bicycle bicycle = new Bicycle();
    bicycle.stat(Point);

    OnFoot onFoot = new OnFoot();
    onFoot.stat(Point);
  }
}
