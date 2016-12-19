package Subscriber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Adds comment by subscriber
 */
public class SubscriberPostComment {
  private WebDriver driver;

  /**
   * Constructor of the page with publishing comment by subscriber
   *
   * @param driver - chrome driver
   */
  public SubscriberPostComment(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * go to test
   */
  public void goToDashboard() {
    driver.findElement(By.className("wp-menu-name")).click();
  }

  /**
   * go to post
   */
  public void goToPost() {
    driver.findElement(By.linkText("Hello world!")).click();
  }

  /**
   * add comment
   *
   * @param comment - added comment
   */
  public void writeComment(String comment) {
    driver.findElement(By.id("comment")).sendKeys(comment);
  }

  public void addComment() {
    driver.findElement(By.className("submit")).click();
  }

  /**
   * find word "Replay" after added comment
   *
   * @return text "Reply"
   */
  public String getPostCommentPageUrl() {
    return driver.findElement(By.className("comment-awaiting-moderation")).getText();
  }
}
