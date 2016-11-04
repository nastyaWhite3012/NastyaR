import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by HP on 31.10.2016.
 */
public class BicycleTest {

  private Bicycle bicycle;
  ArrayList<String> Point;

  @BeforeTest
  public void setUp() throws Exception {
    bicycle = new Bicycle();
    Point = new ArrayList();
    Point.add(new String("0 0"));
  }

  @Test
  public void testStatTime() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.5734, bicycle.statTime(Point), 0.001);
  }

  @Test
  public void testStatPrice() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.0, bicycle.statPrice(Point), 0.001);
  }

  @Test
  public void testStatTimeNotNull() throws Exception {
    Point.add(new String("5 7"));
    assertNotNull(bicycle.statTime(Point));
  }

  @Test
  public void testStatPriceNotNull() throws Exception {
    Point.add(new String("5 7"));
    assertNotNull(bicycle.statPrice(Point));
  }

  @DataProvider(name = "DataProviderValidateInputData")
  public Object[][] createSomeData() {
    return new Object[][]{
        {true, new Double(15.0), new Double(0.0), new Double(0.0), new Integer(1)},
        {false, new Double(-15.0), new Double(0.0), new Double(0.0), new Integer(1)},
        {false, new Double(15.0), new Double(1.0), new Double(0.0), new Integer(1)},
        {false, new Double(15.0), new Double(0.0), new Double(1.0), new Integer(1)},
        {false, new Double(15.0), new Double(0.0), new Double(0.0), new Integer(2)}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputData")
  public void testValidateInputData(boolean expected, double averageSpeed, double priceLiter, double fuel, int people) {
    assertEquals(expected, bicycle.validateInputData(averageSpeed, priceLiter, fuel, people));
  }
}