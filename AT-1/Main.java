import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Start point of the program.
 * The program executes next commands:
 * operation "open" with argument "url" and "timeout" - checks if the page loads in given timeout;
 * operation "checkLinkPresentByHref" with argument "href" - finds url's link on the current page;
 * operation "checkLinkPresentByName" with argument "name" - finds link's name on the current page;
 * operation "checkPageTitle" with argument "title" - compares argument with current pages's title;
 * operation "checkPageContains" with argument "text" - finds argument on the current pages;
 * All the commands' results writes in the log.txt located in current directory
 * Input data gets from txt file or command line
 * To end enter commands in command line press "enter" 2 times
 */
public class Main {
  /**
   * Does the commands
   *
   * @param args - cmd argument
   */
  public static void main(String[] args) {
    ArrayList<String> lineList = new ArrayList<>();

    ReaderTxt readerTxt = new ReaderTxt();
    readerTxt.readTxt(lineList);

    if (lineList.isEmpty()) {
      try {
        ReaderXml readerXml = new ReaderXml();
        readerXml.readCommand(lineList);
      } catch (Exception e) {
        System.out.println("Enter commands in cmd:");
      }
    }

    if (lineList.isEmpty()) {
      ReaderCmd readerCmd = new ReaderCmd();
      readerCmd.readCmd(lineList);
    }
    try {
      ParserCommand parser = new ParserCommand();
      TesterSelenium testerSelenium = new TesterSelenium();
      System.setErr(new PrintStream(new File("log.txt")));
      double start = System.currentTimeMillis();
      for (int i = 0; i < lineList.size(); i++) {
        switch (parser.parserOperation(lineList.get(i))) {
          case "open":
            String url = parser.parserOpenUrl(lineList.get(i));
            String timeGiven = parser.parserOpenTime(lineList.get(i));
            testerSelenium.testURL(url, timeGiven);
            break;
          case "checkLinkPresentByHref":
            String href = parser.parserArgument(lineList.get(i));
            testerSelenium.testHREF(href);
            break;
          case "checkLinkPresentByName":
            String name = parser.parserArgument(lineList.get(i));
            testerSelenium.testNAME(name);
            break;
          case "checkPageTitle":
            String title = parser.parserArgument(lineList.get(i));
            testerSelenium.testTITLE(title);
            break;
          case "checkPageContains":
            String text = parser.parserArgument(lineList.get(i));
            testerSelenium.testTEXT(text);
            break;
        }
      }
      double finish = System.currentTimeMillis();
      Log log = new Log();
      log.getTotalTests(lineList.size());
      log.getPassedFailed(lineList.size(), testerSelenium.getFail());
      log.getTotalTime(start, finish);
      log.getAverageTime(start, finish, lineList.size());
      testerSelenium.closeDriver();
    } catch (Exception e) {
      System.out.println("fail in log!");
    }
  }
}
