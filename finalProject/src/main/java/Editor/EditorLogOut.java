package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains editor's logout pages' elements
 */
public class EditorLogOut {
  private WebDriver driver;

  /**
   * Constructor author's login page
   *
   * @param driver - chrome driver
   */
  public EditorLogOut(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * go to title
   */
  public void goToTitle() {
    driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
  }

  /**
   * log out
   */
  public void logOut() {
    driver.findElement(By.xpath(".//*[@id='meta-2']/ul/li[2]/a")).click();
  }
}
