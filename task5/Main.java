import java.util.Scanner;

/**
 * Program is for triangle
 * type definition
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Triangle tr = new Triangle();
    System.out.println("Enter the sides of the triangle");
    try {
      double a = scanner.nextDouble();
      double b = scanner.nextDouble();
      double c = scanner.nextDouble();
      if (tr.existence(a, b, c) == true) {
        //condition when a triangle exists
        if (tr.equilateral(a, b, c) == false) {
          //condition when a triangle is equilateral
          System.out.println("This is equilateral triangle.");  //равносторонний
        } else if (tr.isosceles(a, b, c) == true) {
          //condition when a triangle is isosceles
          System.out.println("This is isosceles triangle.");  //равнобедренный
        } else if (tr.check(a, b, c) == true) {
          //condition when a triangle is scalene
          System.out.println("This is scalene triangle"); //обычный
        } else {
          //condition when a triangle doesn't existl
          System.out.println("This triangle doesn't exist!");
        }
      } else {
        //condition when a triangle doesn't exist
        System.out.println("This triangle doesn't exist!");
      }
    } catch (Exception e) {
      System.out.println("Wrong data!");
    }
  }
}

