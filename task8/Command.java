import java.util.ArrayList;

/**
 * Command is the super class
 */
public abstract class Command {
  /**
   * abstract method for commands
   *
   * @param items - entered data
   */
  public abstract void check(ArrayList<Item> items);
}
