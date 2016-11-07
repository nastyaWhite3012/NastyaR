import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class TriangleTest {

  @DataProvider(name = "DataProviderIsExist")
  public Object[][] isExist() {
    return new Object[][]{
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(0.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(0.0)},
        {false, BigDecimal.valueOf(-7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(-8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(-9.0)},
        {true, BigDecimal.valueOf(7.0 / 1.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 / 1.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 / 1.0)},
        {true, BigDecimal.valueOf(7.0 * 1.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 * 1.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 * 1.0)},
        {true, BigDecimal.valueOf(7.0 + 1.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 + 1.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 + 1.0)},
        {true, BigDecimal.valueOf(7.0 - 2.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 - 2.0), BigDecimal.valueOf(9.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 - 3.0)},
        {false, BigDecimal.valueOf(7.0 / 7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 / 8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 / 9.0)},
        {false, BigDecimal.valueOf(7.0 * 7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 * 8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 * 9.0)},
        {false, BigDecimal.valueOf(7.0 + 10.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 + 8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 + 9.0)},
        {false, BigDecimal.valueOf(7.0 - 7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0 - 8.0), BigDecimal.valueOf(9.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0 - 9.0)},
    };
  }

  @Test(dataProvider = "DataProviderIsExist")
  public void testIsExist(boolean expected, BigDecimal a, BigDecimal b, BigDecimal c) {
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isExist(a, b, c));
  }

  @DataProvider(name = "DataProviderIsEquilateral")
  public Object[][] isEquilateral() {
    return new Object[][]{
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
    };
  }

  @Test(dataProvider = "DataProviderIsEquilateral")
  public void testIsEquilateral(boolean expected, BigDecimal a, BigDecimal b, BigDecimal c) {
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isEquilateral(a, b, c));
  }

  @DataProvider(name = "DataProviderIsIsosceles")
  public Object[][] isIsosceles() {
    return new Object[][]{
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0)},
        {true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0)},
        {false, BigDecimal.valueOf(7.0), BigDecimal.valueOf(8.0), BigDecimal.valueOf(9.0)},
    };
  }

  @Test(dataProvider = "DataProviderIsIsosceles")
  public void testIsIsosceles(boolean expected, BigDecimal a, BigDecimal b, BigDecimal c) {
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.IsIsosceles(a, b, c));
  }
}