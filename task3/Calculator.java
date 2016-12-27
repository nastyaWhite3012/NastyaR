public class Calculator {
  /**
   * class Calculator does all calculations
   */
  public double sum(double number1, double number2) { //Create a method of sum
    return number1 + number2;
  }
  public double dif(double number1, double number2) { //Create a method of difference
    return number1 - number2;
  }
  public double multiply(double number1, double number2) { //Create a method of multiplication
    return number1 * number2;
  }
  public int check(double number1, double number2) { //Check the division by zero
    int a;
    if (Double.isNaN(number1/number2) || Double.isInfinite(number1/number2))
      return a = 1;
      else return a = 0;
  }
  public double div(double number1, double number2) { ////Create a method of division
    return number1 / number2;
  }
}
