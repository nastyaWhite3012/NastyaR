import java.util.Scanner;

/**
 * Program is for finding real roots
 * of a quadratic equation
 */
public class Main {
  public static void main(String[] args) {
    Solve s = new Solve();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a, b, c");
    try {
      double a = scanner.nextDouble();
      double b = scanner.nextDouble();
      double c = scanner.nextDouble();
      s.solve(a, b, c);
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }
  }
}
