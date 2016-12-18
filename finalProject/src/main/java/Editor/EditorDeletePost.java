package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HP on 18.12.2016.
 */
public class EditorDeletePost {
  private WebDriver driver;

  public EditorDeletePost(ChromeDriver driver) {
    this.driver = driver;
  }

  public void goToPosts() {
    driver.findElement(By.linkText("2 Posts")).click();
  }

  public void openPost() {
    driver.findElement(By.className("row-title")).click();
  }

  public void delete() {
    driver.findElement(By.id("delete-action")).click();
  }

  public String getTrash() {
    return driver.findElement(By.className("trash")).getText();
  }
}
