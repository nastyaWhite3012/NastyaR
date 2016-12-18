package Author;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HP on 17.12.2016.
 */
public class AuthorPublishPost {
  private WebDriver driver;

  public AuthorPublishPost(ChromeDriver driver) {
    this.driver = driver;
  }

  public void goToPosts() {
    driver.findElement(By.linkText("1 Post")).click();
  }

  public void openPost() {
    driver.findElement(By.className("row-title")).click();
  }

  public void publishPost() {
    driver.findElement(By.id("publish")).click();
  }

  public String getStatus() {
    return driver.findElement(By.id("post-status-display")).getText();
  }
}
