/**
 * Created by HP on 02.10.2016.
 */
public class Calculator {
  public double sum(double number1, double number2) { //Create a method of sum
    return number1 + number2;
  }
  public double dif(double number1, double number2) { //Create a method of difference
    return number1 - number2;
  }
  public double mult(double number1, double number2) { //Create a method of multiplication
    return number1 * number2;
  }
  public double div(double number1, double number2) { //Create a method of division
    if (number2==0) //Check the division by zero
      System.out.println("Wrong data!");
      return number1 / number2;
  }
}
