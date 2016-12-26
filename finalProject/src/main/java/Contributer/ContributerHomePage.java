package Contributer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains contributer's home pages' elements
 */
public class ContributerHomePage {
  private WebDriver driver;

  /**
   * Constructor contributer's home page
   *
   * @param driver - chrome driver
   */
  public ContributerHomePage(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * get home page's url
   *
   * @return get home page's url
   */
  public String getHomePageUrl() {
    return driver.getCurrentUrl();
  }
}