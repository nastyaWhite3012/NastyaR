import java.util.ArrayList;
import java.util.Scanner;

/**
 * The forth command for user
 */
public class AveragePriceType extends Command {
  /**
   * Count an average price for certain type
   * and output this information
   *
   * @param items - entered data
   */
  public void check(ArrayList<Item> items) {
    Item[] arrayType = new Item[items.size()];
    Item[] arrayPrice = new Item[items.size()];
    double averagePrice = 0.0;

    System.out.println("Enter type you want to calculate the average price.");
    Scanner scanner = new Scanner(System.in);
    String scannerType = scanner.next();

    for (int i = 0; i < arrayPrice.length; i++) {
      arrayPrice[i] = items.get(i);
    }
    for (int i = 0; i < arrayType.length; i++) {
      arrayType[i] = items.get(i);
    }
    for (int i = 0; i < arrayType.length; i++) {
      if (scannerType.equals(arrayType[i].getType())) {
        for (int j = 0; i < arrayPrice.length; j++) {
          averagePrice += arrayPrice[j].getPrice();
          break;
        }
      }
    }
    System.out.println("The average price of " + scannerType + " is " + (averagePrice / arrayPrice.length));
  }
}
