import java.util.Scanner;

/**
 * Created by HP on 02.10.2016.
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); //Create an object scanner in the class Scanner
    Calculator calc = new Calculator(); //Create an object calk in the class Calculator
    System.out.println("Enter 2 numbers.");
    double number1 = scanner.nextDouble(); //Read input data
    double number2 = scanner.nextDouble(); //Read input data
    System.out.println("The sum of the numbers is " + calc.sum(number1, number2)); //Output the sum
    System.out.println("The difference of the numbers is " + calc.dif(number1, number2)); //Output the difference
    System.out.println("The multiplication of the numbers is " + calc.mult(number1, number2)); //Output the multiplication
    System.out.println("The division of the numbers is " + calc.div(number1, number2)); //Output the division

  }
}
