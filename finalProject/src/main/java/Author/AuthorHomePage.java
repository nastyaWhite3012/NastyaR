package Author;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains author's home pages' elements
 */
public class AuthorHomePage {
  private WebDriver driver;

  /**
   * Constructor author's home page
   *
   * @param driver - chrome driver
   */
  public AuthorHomePage(ChromeDriver driver) {
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
   * save post
   *
   * @return page with added post
   */
  public AuthorAddPost enterSaveDraft() {
    driver.findElement(By.id("save-post")).click();
    return new AuthorAddPost((ChromeDriver) driver);
  }
}