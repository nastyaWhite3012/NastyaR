package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains editor's home pages' elements
 */
public class EditorHomePage {
  private WebDriver driver;

  /**
   * Constructor editor's home page
   *
   * @param driver - chrome driver
   */
  public EditorHomePage(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * save post
   *
   * @return page with added post
   */
  public EditorAddPost enterSaveDraft() {
    driver.findElement(By.id("save-post")).click();
    return new EditorAddPost((ChromeDriver) driver);
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