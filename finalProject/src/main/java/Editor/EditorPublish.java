package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains pages' elements with publishing post by editor
 */
public class EditorPublish {
  private WebDriver driver;

  /**
   * Constructor editor's login page
   *
   * @param driver - chrome driver
   */
  public EditorPublish(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * go to posts
   */
  public void goToPosts() {
    driver.findElement(By.linkText("1 Post")).click();
  }

  /**
   * go to drafts
   */
  public void goToDraft() {
    driver.findElement(By.className("draft")).click();
  }

  /**
   * go to edit
   */
  public void goToEdit() {
    driver.findElement(By.className("row-title")).click();
  }

  /**
   * publish the post
   */
  public void setPublish() {
    driver.findElement(By.id("publish")).click();
  }
}
