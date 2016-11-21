import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Does commands
 */
public class TesterSelenium {
  int fail = 0;
  static WebDriver driver = new ChromeDriver();
  Log log = new Log();

  /**
   * executes operation "open"
   *
   * @param url     - argument of operation "open"
   * @param timeout - argument of operation "open"
   */
  public void testURL(String url, String timeout) {
    String result = "+";
    double startOpen = System.currentTimeMillis();
    String command = " [open " + '"' + url + '"' + " " + '"' + timeout + '"' + "]";
    try {
      long time = Long.parseLong(timeout);
      driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
      driver.get(url);
    } catch (Exception e) {
      fail++;
      result = "!";
    }
    double finishOpen = System.currentTimeMillis();
    log.getCommandTime(result, command, startOpen, finishOpen);
  }

  /**
   * executes operation "checkLinkPresentByHref"
   *
   * @param href - argument of operation "checkLinkPresentByHref"
   */
  public void testHREF(String href) {
    String result = "+";
    double startHref = System.currentTimeMillis();
    String command = " [checkLinkPresentByHref " + '"' + href + '"' + "]";
    try {
      driver.get(driver.getCurrentUrl());
      driver.findElement(By.xpath("//a[@href='" + href + "']"));
    } catch (Exception e) {
      fail++;
      result = "!";
    }
    double finishHref = System.currentTimeMillis();
    log.getCommandTime(result, command, startHref, finishHref);

  }

  /**
   * executes operation "checkLinkPresentByName"
   *
   * @param name - argument of operation "checkLinkPresentByName"
   */
  public void testNAME(String name) {
    String result = "+";
    double startName = System.currentTimeMillis();
    String command = " [checkLinkPresentByName " + '"' + name + '"' + "]";

    try {
      driver.get(driver.getCurrentUrl());
      driver.findElement(By.className(name));
    } catch (Exception e) {
      fail++;
      result = "!";
    }
    double finishName = System.currentTimeMillis();
    log.getCommandTime(result, command, startName, finishName);
  }

  /**
   * executes operation "checkPageTitle"
   *
   * @param title - argument of operation "checkPageTitle"
   */
  public void testTITLE(String title) {
    String result = "+";
    String command = " [checkPageTitle " + '"' + title + '"' + "]";
    driver.get(driver.getCurrentUrl());
    double startTitle = System.currentTimeMillis();
    if (!driver.getTitle().equals(title)) {
      fail++;
      result = "!";
    }
    double finishTitle = System.currentTimeMillis();
    log.getCommandTime(result, command, startTitle, finishTitle);
  }

  /**
   * executes operation "checkPageContains"
   *
   * @param text - argument of operation "checkPageContains"
   */
  public void testTEXT(String text) {
    String result = "+";
    String command = " [checkPageContains " + '"' + text + '"' + "]";
    driver.get(driver.getCurrentUrl());
    double startText = System.currentTimeMillis();
    if (!driver.getPageSource().contains(text)) {
      fail++;
      result = "!";
    }
    double finishText = System.currentTimeMillis();
    log.getCommandTime(result, command, startText, finishText);
  }

  /**
   * gets the amount of the failed operations
   *
   * @return amount of the failed operations
   */
  public int getFail() {
    return fail;
  }

  /**
   * closes browser after all commands done
   */
  public void closeDriver() {
    driver.quit();
  }

}
