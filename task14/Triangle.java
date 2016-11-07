import java.math.BigDecimal;

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
  public boolean isExist(BigDecimal a, BigDecimal b, BigDecimal c) {
    BigDecimal val = new BigDecimal("0.0");
    if (a.compareTo(val) == 1 && b.compareTo(val) == 1 && c.compareTo(val) == 1 && a.add(b).compareTo(c) == 1
        && b.add(c).compareTo(a) == 1 && a.add(c).compareTo(b) == 1) {
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
  public boolean isEquilateral(BigDecimal a, BigDecimal b, BigDecimal c) {
    if (a.compareTo(b) == 0 && b.compareTo(c) == 0 && c.compareTo(a) == 0) {
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
  public boolean IsIsosceles(BigDecimal a, BigDecimal b, BigDecimal c) {
    if (a.compareTo(b) == 0 && a.compareTo(c) == -1 || a.compareTo(c) == 0 && a.compareTo(b) == -1 ||
        c.compareTo(b) == 0 && c.compareTo(a) == -1) {
      return true;
    } else {
      return false;
    }
  }
}
