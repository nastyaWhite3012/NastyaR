package Subscriber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains subscriber's home pages' elements
 */
public class SubscriberHomePage {
  private WebDriver driver;

  /**
   * Constructor subscriber's home page
   *
   * @param driver - chrome driver
   */
  public SubscriberHomePage(ChromeDriver driver) {
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

  /**
   * post comment
   *
   * @return page with added comment
   */
  public SubscriberPostComment enterPostComment() {
    driver.findElement(By.id("submit")).click();
    return new SubscriberPostComment((ChromeDriver) driver);
  }
}