package Contributer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HP on 18.12.2016.
 */
public class ContributerLogOut {
  private WebDriver driver;

  /**
   * Constructor contributer's login page
   *
   * @param driver - chrome driver
   */
  public ContributerLogOut(ChromeDriver driver) {
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
