import java.util.ArrayList;

/**
 * The first command for user
 */
public class CountTypes extends Command {
  /**
   * Count types of item and output
   * the quantity of types
   *
   * @param items - entered data
   */
  public void check(ArrayList<Item> items) {
    Item[] arrayType = new Item[items.size()];
    int sum = 0;

    for (int i = 0; i < arrayType.length; i++) {
      arrayType[i] = items.get(i);
    }

    for (int i = 0; i < arrayType.length; i++) {
      for (int j = i + 1; j < arrayType.length; j++) {
        if (arrayType[i].getType().equals(arrayType[j].getType())) {
          sum++;
        }
      }
    }
    System.out.println("Quantity of types " + (arrayType.length - sum));
  }
}
