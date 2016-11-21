import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads command from
 * command line
 */
public class ReaderCmd {
  /**
   * reads command.
   *
   * @return ArrayList with all commands from cmd
   */
  public ArrayList<String> readCmd(ArrayList<String> lineList) {
    Scanner scanner = new Scanner(System.in);
    String line = "";
    do {
      line = scanner.nextLine();
      lineList.add(line);
    } while (!line.isEmpty());
    lineList.remove(lineList.size() - 1);
    return lineList;
  }
}
