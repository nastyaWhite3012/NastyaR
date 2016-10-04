import java.util.Scanner;

/**
 * Program is for finding real roots
 * of a quadratic equation
 */
public class Main {
  /**
   * input coefficients of a
   * quadratic equation and
   * output the roots
   *
   * @param args - console arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a, b, c");
    try {
      Solve s = new Solve();
      double a = scanner.nextDouble();
      double b = scanner.nextDouble();
      double c = scanner.nextDouble();
      s.solve(a, b, c);
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }
  }
}
