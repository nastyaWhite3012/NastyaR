import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

  @DataProvider(name="DataProviderIsExist")
  public Object[][] isExist() {
    return new Object[][] {
        {true, new Double(7.0), new Double(8.0), new Double(9.0)},
        {false, new Double(0.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(0.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(0.0)},
        {false, new Double(-7.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(-8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(-9.0)},
        {true, new Double(7.0/1.0), new Double(8.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0/1.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0), new Double(9.0/1.0)},
        {true, new Double(7.0*1.0), new Double(8.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0*1.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0), new Double(9.0*1.0)},
        {true, new Double(7.0+1.0), new Double(8.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0+1.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0), new Double(9.0+1.0)},
        {true, new Double(7.0-2.0), new Double(8.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0-2.0), new Double(9.0)},
        {true, new Double(7.0), new Double(8.0), new Double(9.0-3.0)},
        {false, new Double(7.0/7.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0/8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0/9.0)},
        {false, new Double(7.0*7.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0*8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0*9.0)},
        {false, new Double(7.0+10.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0+8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0+9.0)},
        {false, new Double(7.0-7.0), new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0-8.0), new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0-9.0)},
        {false, Double.NaN, new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), Double.NaN, new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), Double.NaN},
        {false, Double.POSITIVE_INFINITY, new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), Double.POSITIVE_INFINITY, new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), Double.POSITIVE_INFINITY},
        {false, Double.NEGATIVE_INFINITY, new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), Double.NEGATIVE_INFINITY, new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), Double.NEGATIVE_INFINITY},
        {false, Double.MIN_VALUE, new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), Double.MIN_VALUE, new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), Double.MIN_VALUE},
        {false, Double.MAX_VALUE, new Double(8.0), new Double(9.0)},
        {false, new Double(7.0), Double.MAX_VALUE, new Double(9.0)},
        {false, new Double(7.0), new Double(8.0), Double.MAX_VALUE},
    };
  }

  @Test(dataProvider = "DataProviderIsExist")
  public void testIsExist(boolean expected, double a, double b, double c){
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isExist(a, b, c));
  }

  @DataProvider(name="DataProviderIsEquilateral")
  public Object[][] isEquilateral() {
    return new Object[][] {
        {true, new Double(7.0), new Double(7.0), new Double(7.0)},
        {false, new Double(7.0), new Double(7.0), new Double(8.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0)},
    };
  }

  @Test(dataProvider = "DataProviderIsEquilateral")
  public void testIsEquilateral(boolean expected, double a, double b, double c){
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isEquilateral(a, b, c));
  }

  @DataProvider(name="DataProviderIsIsosceles")
  public Object[][] isIsosceles() {
    return new Object[][] {
        {false, new Double(7.0), new Double(7.0), new Double(7.0)},
        {true, new Double(7.0), new Double(7.0), new Double(8.0)},
        {false, new Double(7.0), new Double(8.0), new Double(9.0)},
    };
  }

  @Test(dataProvider = "DataProviderIsIsosceles")
  public void testIsIsosceles(boolean expected, double a, double b, double c) {
    Triangle triangle  = new Triangle();
    assertEquals(expected, triangle.IsIsosceles(a, b, c));
  }
}