import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;

import static org.testng.Assert.*;

public class TriangleTest {

  public static final String PATH = ".\\ddt.xml";
  private static final String NEGATIVE = "negative";
  private static final String POSITIVE = "positive";
  private static final String NULLSIDE = "nullSide";
  private static final String SIDE_A = "side_a";
  private static final String SIDE_B = "side_b";
  private static final String SIDE_C = "side_c";
  private static final String EXPECTED = "expected";

  @DataProvider(name = "negativeFromXml")
  public Object[][] readNegativeXML() throws Exception {
    File inputFile = new File(PATH);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(inputFile);
    NodeList nodes = document.getElementsByTagName(NEGATIVE);
    Object[][] result = new Object[nodes.getLength()][];
    for (int i = 0; i < nodes.getLength(); i++) {
      NamedNodeMap attrs = nodes.item(i).getAttributes();
      result[i] = new Object[]{
          new Boolean(attrs.getNamedItem(EXPECTED).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_A).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_B).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_C).getNodeValue())
      };
    }
    return result;
  }

  @Test(dataProvider = "negativeFromXml")
  public void testIsExistNegative(boolean expected, BigDecimal a, BigDecimal b, BigDecimal c) {
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isExist(a, b, c));
  }

  @DataProvider(name = "positiveFromXml")
  public Object[][] readXMLPositive() throws Exception {
    File inputFile = new File(PATH);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(inputFile);
    NodeList nodes = document.getElementsByTagName(POSITIVE);
    Object[][] result = new Object[nodes.getLength()][];
    for (int i = 0; i < nodes.getLength(); i++) {
      NamedNodeMap attrs = nodes.item(i).getAttributes();
      result[i] = new Object[]{
          new Boolean(attrs.getNamedItem(EXPECTED).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_A).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_B).getNodeValue()),
          new BigDecimal(attrs.getNamedItem(SIDE_C).getNodeValue()),
      };
    }
    return result;
  }

  @Test(dataProvider = "positiveFromXml")
  public void testIsExistPositive(boolean expected, BigDecimal a, BigDecimal b, BigDecimal c) {
    Triangle triangle = new Triangle();
    assertEquals(expected, triangle.isExist(a, b, c));
  }
}