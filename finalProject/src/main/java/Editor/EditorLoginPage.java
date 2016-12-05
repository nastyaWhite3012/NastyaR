package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains editor's login pages' elements
 */
public class EditorLoginPage {
  private static String URL_LOGIN_PAGE = "http://localhost:8888/wp-login.php";
  private WebDriver driver;

  /**
   * Constructor editor's login page
   *
   * @param driver - chrome driver
   */
  public EditorLoginPage(ChromeDriver driver) {
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
   * @param userName - editor's name
   */
  public void setUserName(String userName) {
    driver.findElement(By.id("user_login")).sendKeys(userName);
  }

  /**
   * set editor's password
   *
   * @param password - editor's password
   */
  public void setPassword(String password) {
    driver.findElement(By.id("user_pass")).sendKeys(password);
  }

  /**
   * enter the button Login
   *
   * @return editor's home page
   */
  public EditorHomePage enterLoginPageEditor() {
    driver.findElement(By.id("wp-submit")).click();
    return new EditorHomePage((ChromeDriver) driver);
  }
}