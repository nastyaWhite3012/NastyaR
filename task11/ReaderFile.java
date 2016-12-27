import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Read file "CheckPoints.txt"
 */
public class ReaderFile {
  /**
   * Read file "CheckPoints.txt" and
   * transfer points from the file to
   * the ArrayList
   *
   * @param Point - input data
   * @throws Exception - auto exception working with files
   */
  public void readerFile(ArrayList<String> Point) throws Exception {
    Path path = Paths.get("CheckPoints.txt");
    BufferedReader br = Files.newBufferedReader(path);
    String line;
    while ((line = br.readLine()) != null) {
      Point.add(new String(line));
    }
    br.close();
  }
}
