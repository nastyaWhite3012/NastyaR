import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by HP on 27.10.2016.
 */
public class DistanceTest {

  @Test
  public void testValidateDistanceNegativeCoordinatesPositive() throws Exception {
    Distance distance = new Distance();
    double[][] coordinate = {{-5, -6}, {-7, -8}};
    assertTrue(distance.validateDistance(coordinate));
  }

  @Test
  public void testDistanceArrayNotNull() throws Exception {
    ArrayList<String> Point = new ArrayList();
    String[] arrayPoint = new String[Point.size()];
    assertNotNull(arrayPoint);
  }

  @Test
  public void testDistanceCoordinateNotNull() throws Exception {
    ArrayList<String> Point = new ArrayList();
    String[] arrayPoint = new String[Point.size()];
    double[][] coordinate = new double[arrayPoint.length][2];
    assertNotNull(coordinate);
  }

  @Test
  public void testDistanceSqrt() throws Exception {
    double distance = 25;
    assertTrue(Math.sqrt(distance) == 5);
  }

  @DataProvider(name = "DataProviderValidateDistance")
  public Object[][] createSomeData() {
    return new Object[][]{
        {true, new double[][]{{0, 0}, {10, 10}}},
        {false, new double[][]{{0, 0}, {0, 0}}}
    };
  }

  @Test(dataProvider = "DataProviderValidateDistance")
  public void testValidateDistance(boolean expected, double[][] coordinate) {
    Distance distance = new Distance();
    assertEquals(expected, distance.validateDistance(coordinate));
  }
}