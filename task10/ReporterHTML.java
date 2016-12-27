import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Create HTML-table including servers
 * and their responses
 */
public class ReporterHTML {
  String HEAD = "<!DOCTYPE html>\n" +
      "<html>\n" +
      " <head>\n" +
      "  <meta charset=\"utf-8\">\n" +
      "\t<title>table</title>\n" +
      "\t<style>\n" +
      "   table {\n" +
      "    width: 560px;\n" +
      "    background: white;\n" +
      "    color: black;\n" +
      "    border-spacing: 1px;\n" +
      "\tfont-family: sans-serif;\n" +
      "   }\n" +
      "   th {\n" +
      "    background: #999999;\n" +
      "    padding: 5px;\n" +
      "\twidth: 280px;\n" +
      "\theight: 30px;\n" +
      "\tvertical-align: top;\n" +
      "   }\n" +
      "   tr {\n" +
      "   height: 30px;\n" +
      "   }\n" +
      "  </style>\n" +
      " </head> \n" +
      " <body>\n" +
      "  <table>\n" +
      "   <tr><th>Server</th><th>Response, ms</th></tr>";
  String FOOTER = "  </table>\n" +
      " </body>\n" +
      " </head>\n" +
      "</html>";
  String COLOR_CELL1 = "#efefef";
  String COLOR_CELL2 = "d9d9d9";
  String COLOR_BIG = "fc0000";

  /**
   * Create the head, the body and the footer of the HTML-table.
   * Formation information about the responses of
   * the servers
   *
   * @param IPList - IP-addresses' array
   * @throws Exception - auto exception working with files
   */
  public void createTable(ArrayList<IP> IPList) throws Exception {
    File html = new File("table1.html");
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(html));
      bw.write(HEAD);
      ServerAndColor(bw, IPList);
      bw.write(FOOTER);
      bw.close();
    } catch (IOException e) {
      System.out.println("Wrong BufferedWriter!");
    }
  }

  /**
   * Fill servers from the console or from file,
   * change colors according to the specifications,
   * find server with the biggest response
   * and this cell to another color
   *
   * @param bw     - object of the class BufferedWriter for writing
   * @param IPList - IP-addresses' array
   * @throws Exception - auto exception working with files
   */
  public void ServerAndColor(BufferedWriter bw, ArrayList<IP> IPList) throws Exception {
    IP[] arrayIP = new IP[IPList.size()];
    String server;
    Response response = new Response();
    String color;
    String colorCell = COLOR_CELL2;

    int[] random = new int[arrayIP.length];
    for (int i = 0; i < arrayIP.length; i++) {
      random[i] = response.Random(arrayIP);

    }
    for (int i = 0; i < arrayIP.length; i++) {
      arrayIP[i] = IPList.get(i);
      server = arrayIP[i].getServer();
      if (colorCell.equals(COLOR_CELL2)) {
        colorCell = COLOR_CELL1;
      } else {
        colorCell = COLOR_CELL2;
      }
      if (random[i] == maxRandom(random)) {
        color = COLOR_BIG;
      } else {
        color = colorCell;
      }

      createBody(bw, server, random[i], color);
    }
  }

  /**
   * Create and fill BODY of the HTML-table
   *
   * @param bw       - object of the class BufferedWriter for writing
   * @param server   - string according to the ip-address from the console or from the file
   * @param response - server's response
   * @param color    - cell's color
   * @throws Exception - auto exception working with files
   */
  public void createBody(BufferedWriter bw, String server, int response, String color) throws Exception {
    bw.write("<tr bgcolor=\"" + color + "\" padding=\"5px\"><td>" + server + "</td><td>" + response + "</td></tr>\n");
  }

  /**
   * Find max value among all servers' responses
   *
   * @param random - array of random responses
   * @return max value among all servers' responses
   */
  public int maxRandom(int[] random) {
    int max = random[0];
    for (int i = 0; i < random.length; i++) {
      if (random[i] > max) {
        max = random[i];
      }
    }
    return max;
  }
}
