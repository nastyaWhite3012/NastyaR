import java.util.ArrayList;

/**
 * The third command for user
 */
public class AveragePrice extends Command {
  /**
   * Count an average price of all
   * items and output this information
   *
   * @param items - entered data
   */
  public void check(ArrayList<Item> items) {
    Item[] arrayPrice = new Item[items.size()];
    Item[] arrayQuantity = new Item[items.size()];
    int sum = 0;
    double averagePrice = 0.0;

    for (int i = 0; i < arrayPrice.length; i++) {
      arrayPrice[i] = items.get(i);
    }
    for (int i = 0; i < arrayQuantity.length; i++) {
      arrayQuantity[i] = items.get(i);
    }
    for (int i = 0; i < arrayQuantity.length; i++) {
      sum += arrayQuantity[i].getQuantity();
      averagePrice += arrayPrice[i].getPrice() * arrayQuantity[i].getQuantity();
    }
    System.out.println("The average price is " + (averagePrice / sum));
  }
}
