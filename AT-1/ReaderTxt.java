import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Reads txt file with
 * written commands
 */
public class ReaderTxt {
  private final String PATH = ".\\data.txt";

  /**
   * reads txt file with written commands
   * and writes it in ArrayList
   *
   * @param lineList - ArrayList for writing commands
   * @return ArrayList with all commands from txt file
   */
  public ArrayList<String> readTxt(ArrayList<String> lineList) {
    try {
      Path path = Paths.get(PATH);
      BufferedReader br = Files.newBufferedReader(path);
      String line;
      while ((line = br.readLine()) != null) {
        lineList.add(line);
      }
      br.close();
    } catch (Exception e) {
      System.out.println();
    }
    return lineList;
  }
}
