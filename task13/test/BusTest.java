import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by HP on 31.10.2016.
 */
public class BusTest {

  private Bus bus;
  ArrayList<String> Point;

  @BeforeTest
  public void setUp() throws Exception {
    bus = new Bus();
    Point = new ArrayList();
    Point.add(new String("0 0"));

  }

  @Test
  public void testStatTime() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.1433, bus.statTime(Point), 0.001);
  }

  @Test
  public void testStatPrice() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.022, bus.statPrice(Point), 0.001);
  }

  @Test
  public void testStatTimeNotNull() throws Exception {
    Point.add(new String("5 7"));
    assertNotNull(bus.statTime(Point));
  }

  @Test
  public void testStatPriceNotNull() throws Exception {
    Point.add("5 7");
    assertNotNull(bus.statPrice(Point));
  }

  @DataProvider(name = "DataProviderValidateInputData")
  public Object[][] createSomeData() {
    return new Object[][]{
        {true, new Double(60.0), new Double(0.5), new Double(20.5), new Integer(40)},
        {false, new Double(-60.0), new Double(0.5), new Double(20.5), new Integer(40)},
        {false, new Double(60.0), new Double(-0.5), new Double(20.5), new Integer(40)},
        {false, new Double(60.0), new Double(0.5), new Double(-20.5), new Integer(40)},
        {false, new Double(60.0), new Double(0.5), new Double(20.5), new Integer(-40)}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputData")
  public void testValidateInputData(boolean expected, double averageSpeed, double priceLiter, double fuel, int people) {
    assertEquals(expected, bus.validateInputData(averageSpeed, priceLiter, fuel, people));
  }
}