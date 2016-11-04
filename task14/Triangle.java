/**
 * Class for triangles' types
 */
public class Triangle {
  /**
   * check for nonzero sides
   *
   * @param a - console argument
   * @param b - console argument
   * @param c - console argument
   * @return true, if triangle exists otherwise false
   */
  public boolean isExist(double a, double b, double c) {
    if (a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && a + c > b) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * check for equilateral triangle
   *
   * @param a - console argument
   * @param b - console argument
   * @param c - console argument
   * @return true, if triangle is equilateral otherwise false
   */
  public boolean isEquilateral(double a, double b, double c) {
    if (Double.isInfinite(1 / (a - b)) && Double.isInfinite(1 / (b - c)) && Double.isInfinite(1 / (a - c))) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * check for isosceles triangle
   *
   * @param a - console argument
   * @param b - console argument
   * @param c - console argument
   * @return true, if triangle is isosceles otherwise false
   */
  public boolean IsIsosceles(double a, double b, double c) {
    boolean sideOne = Double.isInfinite(1 / (a - b)) && Math.abs(b - c) > 0;
    boolean sideTwo = Double.isInfinite(1 / (b - c)) && Math.abs(a - b) > 0;
    boolean sideThree = Double.isInfinite(1 / (a - c)) && Math.abs(b - c) > 0;
    if (sideOne || sideTwo || sideThree) {
      return true;
    } else {
      return false;
    }
  }
}
