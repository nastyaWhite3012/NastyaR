package Contributer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains contributer's login pages' elements
 */
public class ContributerLoginPage {
  private static String URL_LOGIN_PAGE = "http://localhost:8888/wp-login.php";
  private WebDriver driver;

  /**
   * Constructor contributer's login page
   *
   * @param driver - chrome driver
   */
  public ContributerLoginPage(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * open login page
   */
  public void openLoginPage() {
    driver.get(URL_LOGIN_PAGE);
  }

  /**
   * input user name
   *
   * @param userName - contributer's name
   */
  public void setUserName(String userName) {
    driver.findElement(By.id("user_login")).sendKeys(userName);
  }

  /**
   * input contributer's password
   *
   * @param password - contributer's password
   */
  public void setPassword(String password) {
    driver.findElement(By.id("user_pass")).sendKeys(password);
  }

  /**
   * enter the button Login
   *
   * @return contributer's home page
   */
  public ContributerHomePage enterLoginPageContributer() {
    driver.findElement(By.id("wp-submit")).click();
    return new ContributerHomePage((ChromeDriver) driver);
  }

  public String errorMessage() {
    return driver.findElement(By.linkText("Lost your password?")).getText();
  }
}