package Subscriber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains subscriber's login pages' elements
 */
public class SubscriberLoginPage {
  private static String URL_LOGIN_PAGE = "http://localhost:8888/wp-login.php";
  private WebDriver driver;

  /**
   * Constructor subscriber's login page
   *
   * @param driver - chrome driver
   */
  public SubscriberLoginPage(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * open login page
   */
  public void openLoginPage() {
    driver.get(URL_LOGIN_PAGE);
  }

  /**
   * input subscriber's name
   *
   * @param userName - subscriber's name
   */
  public void setUserName(String userName) {
    driver.findElement(By.id("user_login")).sendKeys(userName);
  }

  /**
   * input subscriber's password
   *
   * @param password - subscriber's password
   */
  public void setPassword(String password) {
    driver.findElement(By.id("user_pass")).sendKeys(password);
  }

  /**
   * enter the button Login
   *
   * @return subscriber's home page
   */
  public SubscriberHomePage enterLoginPageSubscriber() {
    driver.findElement(By.id("wp-submit")).click();
    return new SubscriberHomePage((ChromeDriver) driver);
  }
}