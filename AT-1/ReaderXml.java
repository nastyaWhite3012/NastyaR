import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Reads xml file with
 * written commands
 */
public class ReaderXml {
  private final String PATH = ".\\data.xml";

  /**
   * reads xml file and writes commands in document
   *
   * @return document with commands
   * @throws Exception - auto exception working with file
   */
  public Document setDocument() throws Exception {
    File inputFile = new File(PATH);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(inputFile);
    return document;
  }

  /**
   * writes commands from xml file in ArrayList
   *
   * @param listLine - ArrayList for writing commands
   * @return ArrayList with all commands from xml file
   * @throws Exception - auto exception working with files
   */
  public ArrayList<String> readCommand(ArrayList<String> listLine) throws Exception {
    Document document = setDocument();
    NodeList nodeList = document.getElementsByTagName("command");
    for (int i = 0; i < nodeList.getLength(); i++) {
      NamedNodeMap attrs = nodeList.item(i).getAttributes();
      String command = attrs.getNamedItem("atr").getNodeValue();
      listLine.add(command);
    }
    return listLine;
  }
}
