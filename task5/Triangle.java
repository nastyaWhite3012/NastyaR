/**
 * Class for triangles' types
 */
public class Triangle {
  public boolean existence(double a, double b, double c) {
    //condition when a triangle exists
    if (a > 0 && b > 0 && c > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean equilateral(double a, double b, double c) {
    //condition when a triangle is equilateral
    if (Double.isInfinite(1 / (a - b)) && Double.isInfinite(1 / (b - c)) && Double.isInfinite(1 / (a - c))) {
      return false;
    } else {
      return true;
    }
  }

  public boolean isosceles(double a, double b, double c) {
    //condition when a triangle is isosceles
    if (Double.isInfinite(1 / (a - b)) || Double.isInfinite(1 / (b - c)) || Double.isInfinite(1 / (a - c))) {
      return true;
    } else {
      return false;
    }
  }

  public boolean check(double a, double b, double c) {
    //condition when a triangle is scalene
    if (a < b + c && b < a + c && c < a + b) {
      return true;
    } else {
      return false;
    }
  }
}
