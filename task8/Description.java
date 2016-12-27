import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create an ArrayList and input data
 */
public class Description {

  ArrayList<Item> itemList = new ArrayList<>();

  /**
   * Enter data in the ArrayList
   * and call the method task of
   * Task's class
   */
  public void desc() {
    String type, name;
    int quantity;
    double price;
    Scanner scanner = new Scanner(System.in);
    String condition;
    int i = 1;

    do {
      System.out.println("Enter " + i + " type");
      type = scanner.next();
      System.out.println("Enter name of " + type);
      name = scanner.next();
      System.out.println("Enter quantity of " + name);
      quantity = scanner.nextInt();
      System.out.println("Enter prise of " + name);
      price = scanner.nextDouble();
      System.out.println("If you want to enter another type of product, enter yes.");
      condition = scanner.next();
      itemList.add(new Item(type, name, quantity, price));
      i++;
    } while (condition.equals("yes"));
    Task t = new Task();
    t.task(itemList);
  }
}
