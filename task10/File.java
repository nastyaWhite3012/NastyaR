import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Read file "Server.txt" and add IP-addresses
 * from the file to the ArrayList
 */
public class File {
  /**
   * Read file "Server.txt" and add IP-addresses
   * from the file to the ArrayList
   *
   * @param IPList - IP-addresses' array
   * @throws Exception - auto exception working with files
   */
  public void FileReader(ArrayList<IP> IPList) throws Exception {
    Path path = Paths.get("Server.txt");
    BufferedReader br = Files.newBufferedReader(path);
    String line;
    while ((line = br.readLine()) != null) {
      IPList.add(new IP(line));
    }
    br.close();
  }
}
