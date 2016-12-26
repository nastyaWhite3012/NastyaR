package Author;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains pages' elements with adding post by author
 */
public class AuthorAddPost {
  private WebDriver driver;

  /**
   * Constructor of the page with adding post by author
   *
   * @param driver - chrome driver
   */
  public AuthorAddPost(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * input title of the post by author
   *
   * @param title - the name of the adding post
   */
  public void setTitle(String title) {
    driver.findElement(By.id("title")).sendKeys(title);
  }

  /**
   * input the text of the post
   *
   * @param post - post's content
   */
  public void setPost(String post) {
    driver.findElement(By.id("content")).sendKeys(post);
  }

  /**
   * get added post page's url
   *
   * @return added post page's url
   */
  public String getAddPostPageUrl() {
    return driver.getCurrentUrl();
  }
}