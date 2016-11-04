import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.geom.Arc2D;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by HP on 31.10.2016.
 */
public class CarTest {

  private Car car;
  ArrayList<String> Point;

  @BeforeTest
  public void setUp() throws Exception {
    car = new Car();
    Point = new ArrayList();
    Point.add(new String("0 0"));

  }

  @Test
  public void testStatTime() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.0955, car.statTime(Point), 0.001);
  }

  @Test
  public void testStatPrice() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.3225, car.statPrice(Point), 0.001);
  }

  @Test
  public void testStatTimeNotNull() throws Exception {
    Point.add("5 7");
    assertNotNull(car.statTime(Point));
  }

  @Test
  public void testStatPriceNotNull() throws Exception {
    Point.add("5 7");
    assertNotNull(car.statPrice(Point));
  }

  @DataProvider(name = "DataProviderValidateInputData")
  public Object[][] createSomeData() {
    return new Object[][]{
        {true, new Double(90.0), new Double(0.5), new Double(7.5), new Integer(1)},
        {false, new Double(-90.0), new Double(0.5), new Double(7.5), new Integer(1)},
        {false, new Double(90.0), new Double(-0.5), new Double(7.5), new Integer(1)},
        {false, new Double(90.0), new Double(0.5), new Double(-7.5), new Integer(1)},
        {false, new Double(90.0), new Double(0.5), new Double(7.5), new Integer(2)},
    };
  }

  @Test(dataProvider = "DataProviderValidateInputData")
  public void testValidateInputData(boolean expected, double averageSpeed, double priceLiter, double fuel, int people) {
    assertEquals(expected, car.validateInputData(averageSpeed, priceLiter, fuel, people));
  }
}