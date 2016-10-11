import java.util.ArrayList;

/**
 * The second command for user
 */
public class CountAll extends Command {
  /**
   * Count all quantity items and output
   * how much items are
   *
   * @param items - entered data
   */
  public void check(ArrayList<Item> items) {
    Item[] arrayQuantity = new Item[items.size()];
    int sum = 0;
    for (int i = 0; i < arrayQuantity.length; i++) {
      arrayQuantity[i] = items.get(i);
    }
    for (int i = 0; i < arrayQuantity.length; i++) {
      sum += arrayQuantity[i].getQuantity();
    }
    System.out.println("The quantity of all items is " + sum);
  }
}
