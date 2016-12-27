/**
 * Start point to run a program
 */
public class Main {
  /**
   * Create an abject of the class
   * description and calls the
   * method of this class
   *
   * @param args - console argument
   */
  public static void main(String[] args) {
    try {
      Description d = new Description();
      d.desc();
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }

  }
}
