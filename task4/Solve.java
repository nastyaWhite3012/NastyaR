/**
 * Class is for solving a
 * quadratic equation
 */
public class Solve {
  /**
   * find discriminant
   *
   * @param a - console argument
   * @param b - console argument
   * @param c - console argument
   * @return discriminant
   */
  public double discriminant(double a, double b, double c) {
    return b * b - 4 * a * c;
  }

  /**
   * find roots of a quadratic equation
   *
   * @param a - console argument
   * @param b - console argument
   * @param c - console argument
   */
  public void solve(double a, double b, double c) {
    //solve a quadratic equation
    if (Double.isInfinite(1 / discriminant(a, b, c))) {
      //condition when discriminant = 0
      double x1 = -1 * b / 2 * a;
      System.out.println("x1 = x2 = " + x1);
    } else if (discriminant(a, b, c) > 0) {
      //condition when discriminant > 0
      double x1 = (-1 * b + Math.sqrt(discriminant(a, b, c))) / (2 * a);
      double x2 = (-1 * b - Math.sqrt(discriminant(a, b, c))) / (2 * a);
      System.out.println("x1 = " + x1);
      System.out.println("x2 = " + x2);
    } else {
      System.out.println("This equation has a negative discriminant!");
    }
  }
}
