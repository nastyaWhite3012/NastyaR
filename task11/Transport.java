import java.util.ArrayList;

/**
 * Transport is the super class
 */
public abstract class Transport implements Statistics {
  /**
   * abstract method for statistics
   *
   * @param Point - input data
   */
  public abstract void stat(ArrayList<String> Point);
}
