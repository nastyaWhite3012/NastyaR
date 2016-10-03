public class Main {
  /**
   * Class Main
   */
  public static void main(String[] args) { //Calculates required operations 
    Calculator calc = new Calculator(); //Create an object calk in the class Calculator
    System.out.println("Enter 2 numbers.");
    double number1 = Double.parseDouble(args[0]);
    double number2 = Double.parseDouble(args[1]);
    System.out.println("The sum of the numbers is " + calc.sum(number1, number2)); //Output the sum
    System.out.println("The difference of the numbers is " + calc.dif(number1, number2)); //Output the difference
    System.out.println("The multiplication of the numbers is " + calc.multiply(number1, number2)); //Output the multiplication
    if (calc.check(number1, number2) == 0)
      System.out.println("The division of the numbers is " + calc.div(number1, number2)); //Output the division
    else
      System.out.println("The division can't be done! Wrong data!");

  }
}
