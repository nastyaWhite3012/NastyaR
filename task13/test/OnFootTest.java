import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by HP on 31.10.2016.
 */
public class OnFootTest {

  private OnFoot onFoot;
  ArrayList<String> Point;

  @BeforeTest
  public void setUp() throws Exception {
    onFoot = new OnFoot();
    Point = new ArrayList();
    Point.add(new String("0 0"));
  }

  @Test
  public void testStatTime() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(1.7204, onFoot.statTime(Point), 0.001);
  }

  @Test
  public void testStatPrice() throws Exception {
    Point.add(new String("5 7"));
    assertEquals(0.0, onFoot.statPrice(Point), 0.001);
  }

  @Test
  public void testStatTimeNotNull() throws Exception {
    Point.add("5 7");
    assertNotNull(onFoot.statTime(Point));
  }

  @Test
  public void testStatPriceNotNull() throws Exception {
    Point.add("5 7");
    assertNotNull(onFoot.statPrice(Point));
  }

  @DataProvider(name = "DataProviderValidateInputData")
  public Object[][] createSomeData() {
    return new Object[][]{
        {true, new Double(5.0), new Double(0.0), new Double(0.0), new Integer(1)},
        {false, new Double(-5.0), new Double(0.0), new Double(0.0), new Integer(1)},
        {false, new Double(5.0), new Double(1.0), new Double(0.0), new Integer(1)},
        {false, new Double(5.0), new Double(1.0), new Double(1.0), new Integer(2)}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputData")
  public void testValidateInputData(boolean expected, double averageSpeed, double priceLiter, double fuel, int people) {
    assertEquals(expected, onFoot.validateInputData(averageSpeed, priceLiter, fuel, people));
  }
}