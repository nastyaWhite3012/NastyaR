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
    try {
      Triangle tr = new Triangle();
      double a = scanner.nextDouble();
      double b = scanner.nextDouble();
      double c = scanner.nextDouble();
      if (tr.isExist(a, b, c)) {
        if (!tr.isEquilateral(a, b, c)) {
          System.out.println("This is equilateral triangle.");
        } else if (tr.IsIsosceles(a, b, c)) {
          System.out.println("This is isosceles triangle.");
        } else if (tr.check(a, b, c)) {
          System.out.println("This is scalene triangle");
        } else {
          System.out.println("This triangle doesn't exist!");
        }
      } else {
        System.out.println("This triangle doesn't exist!");
      }
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }
  }
}

