import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HP on 31.10.2016.
 */
public class OnFootTest {

  private OnFoot onFoot;
  ArrayList<String> Point;

  @Before
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

}