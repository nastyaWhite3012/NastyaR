import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Program is for triangle
 * type definition
 */
public class Main {
  /**
   * input sides of the triangle and
   * output type of the triangle
   *
   * @param args - console arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the sides of the triangle");
    Triangle tr = new Triangle();
    BigDecimal a = scanner.nextBigDecimal();
    BigDecimal b = scanner.nextBigDecimal();
    BigDecimal c = scanner.nextBigDecimal();
    if (tr.isExist(a, b, c)) {
      if (tr.isEquilateral(a, b, c)) {
        System.out.println("This is equilateral triangle.");
      } else if (tr.IsIsosceles(a, b, c)) {
        System.out.println("This is isosceles triangle.");
      } else {
        System.out.println("This is scalene triangle.");
      }
    } else {
      System.out.println("This triangle doesn't exist!");
    }
  }
}

