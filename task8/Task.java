import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class is for choose the command and
 * exit from the program
 */
public class Task {
  /**
   * Selected command is performed
   * and exit from the program
   *
   * @param items - entered data
   */
  public void task(ArrayList<Item> items) {
    Scanner scanner = new Scanner(System.in);
    String command;
    do {
      System.out.println("Enter one of the operations you want to do or enter exit\n-count types\n-count all\n-average price\n-average price type");
      command = scanner.nextLine();
      if (command.equals("count types")) {
        CountTypes countTypes = new CountTypes();
        countTypes.check(items);
      }
      if (command.equals("count all")) {
        CountAll countAll = new CountAll();
        countAll.check(items);
      }
      if (command.equals("average price")) {
        AveragePrice averagePrice = new AveragePrice();
        averagePrice.check(items);
      }
      if (command.equals("average price type")) {
        AveragePriceType averagePriceType = new AveragePriceType();
        averagePriceType.check(items);
      }
    } while (!command.equals("exit"));
    System.exit(0);
  }
}
