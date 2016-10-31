import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HP on 31.10.2016.
 */
public class BusTest {

  private Bus bus;
  ArrayList<String> Point;

  @Before
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
}