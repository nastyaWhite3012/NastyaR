package Author;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains author's login pages' elements
 */
public class AuthorLoginPage {
  private static String URL_LOGIN_PAGE = "http://localhost:8888/wp-login.php";
  private WebDriver driver;

  /**
   * Constructor author's login page
   *
   * @param driver - chrome driver
   */
  public AuthorLoginPage(ChromeDriver driver) {
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
   * @param userName - author's name
   */
  public void setUserName(String userName) {
    driver.findElement(By.id("user_login")).sendKeys(userName);
  }

  /**
   * input author's password
   *
   * @param password - author's password
   */
  public void setPassword(String password) {
    driver.findElement(By.id("user_pass")).sendKeys(password);
  }

  /**
   * enter the button Login
   *
   * @return author's home page
   */
  public AuthorHomePage enterLoginPageAuthor() {
    driver.findElement(By.id("wp-submit")).click();
    return new AuthorHomePage((ChromeDriver) driver);
  }

  /**
   * get error message
   *
   * @return text "Lost your password?"
   */
  public String errorMessage() {
    return driver.findElement(By.linkText("Lost your password?")).getText();
  }

  /**
   * get error message
   *
   * @return text "login_error"
   */
  public String fieldIsEmpty() {
    return driver.findElement(By.id("login_error")).getText();
  }
}