import java.io.File;

/**
 * Start point of the program
 */
public class Main {
  /**
   * Find all folders and files in
   * current directory and show their
   * name, type, date creation and type
   *
   * @param args - command line argument
   */
  public static void main(String[] args) {
    File f = new File(System.getProperty("user.dir"));
    File[] fList = f.listFiles();

    ReporterHTML reporterHTML = new ReporterHTML();
    reporterHTML.createTable(fList);
  }
}
