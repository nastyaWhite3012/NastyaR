import java.util.ArrayList;

/**
 * Count statistics for all objects:
 * Car, Bus, Bicycle and OnFoot
 */
public interface Statistics {
  /**
   * abstract method for statistics
   *
   * @param Point - input data
   */
  void stat(ArrayList<String> Point);
}
