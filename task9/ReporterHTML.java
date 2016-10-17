import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Create HTML-table including information
 * about current folder's and file's
 * name, type, date creation and size
 */
public class ReporterHTML {
  String COLOR1 = "#efefef";
  String COLOR2 = "#f7f7f7";
  String HEAD = "<!DOCTYPE html>\n" +
      "<html>\n" +
      " <head>\n" +
      "  <meta charset=\"utf-8\">\n" +
      "  <title>Тег table</title>\n" +
      "  <style>\n" +
      "   table {\n" +
      "    width: 520px;\n" +
      "    background: white;\n" +
      "    color: black;\n" +
      "    border-spacing: 1px;\n" +
      "\tfont-family: sans-serif;\n" +
      "   }\n" +
      "   th {\n" +
      "    background: #cfcfcf;\n" +
      "    padding: 5px;\n" +
      "\twidth: 130px;\n" +
      "\theight: 40px;\n" +
      "\tvertical-align: top;\n" +
      "   }\n" +
      "   tr {\n" +
      "   height: 20px;\n" +
      "   }\n" +
      "  </style>\n" +
      " </head> \n" +
      " <body>\n" +
      "  <table>\n" +
      "   <tr><th>ИМЯ</th><th>ТИП</th><th>ДАТА СОЗДАНИЯ</th><th>РАЗМЕР (в Kb)</th></tr>\n";
  String FOOTER = "  </table>\n" +
      " </body>\n" +
      "</html>";

  /**
   * Create the head, the body and the footer of the HTML-table.
   * Formation information about folder's or file's name,
   * type, date creation and size
   *
   * @param fList - current directory's array
   */
  public void createTable(File[] fList) {
    File html = new File("table1.html");

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(html));
      SizeDirAndDate sd = new SizeDirAndDate();
      bw.write(HEAD);
      String cellColor = COLOR2;

      for (File file : fList) {
        String name = file.getName();
        String type = "";
        long size = 0;
        if (file.isFile()) {
          type = "File";
          size = file.length();
        }
        if (file.isDirectory()) {
          type = "Dir";
          String p = file.getPath();
          size = sd.convertToKb(sd.sizeDir(fList, p));
        }
        if (cellColor.equals(COLOR1)) {
          cellColor = COLOR2;
        } else {
          cellColor = COLOR1;
        }
        Path path = Paths.get(file.getPath());
        String date = sd.getDate(path);
        writeCell(bw, name, type, date, size, cellColor);
      }
      bw.write(FOOTER);
      bw.close();
    } catch (IOException e) {
      System.out.println("Wrong data!");
    }
  }

  /**
   * Create the bode of the HTML-table adding the
   * information about folder's or file's name,
   * type, date creation and size
   *
   * @param bw        - object of the class BufferedWriter for writing
   * @param name      - folder's or file's name
   * @param type      - folder's or file's type
   * @param date      - folder's or file's date creation
   * @param size      - folder's or file's size
   * @param cellColor - cell's color
   * @throws IOException auto exception working with files
   */
  public void writeCell(BufferedWriter bw, String name, String type, String date, long size, String cellColor) throws IOException {
    bw.write("<tr bgcolor=\"" + cellColor + "\" padding=\"5px\"><td>" + name + "</td><td>" + type + "</td><td>" + date +
        "</td><td>" + size + "</td></tr>\n");
  }
}
