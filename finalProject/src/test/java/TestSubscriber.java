import Subscriber.SubscriberHomePage;
import Subscriber.SubscriberLoginPage;
import Subscriber.SubscriberPostComment;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by HP on 03.12.2016.
 */
public class TestSubscriber {
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/profile.php";
  private static String URL_POST_COMMENT = "REPLY";
  private ChromeDriver driver;
  SubscriberLoginPage subscriberLoginPage;
  SubscriberHomePage subscriberHomePage;
  SubscriberPostComment subscriberPostComment;

  @BeforeMethod
  public void SetUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    subscriberLoginPage = new SubscriberLoginPage(driver);
    subscriberLoginPage.openLoginPage();
    subscriberLoginPage.setUserName("subscriber");
    subscriberLoginPage.setPassword("1");
    subscriberHomePage = subscriberLoginPage.enterLoginPageSubscriber();
  }

  @Test
  public void testLoginSubscriber() {
    assertEquals(URL_HOME_PAGE, subscriberHomePage.getHomePageUrl());
  }

  @Test
  public void testAddPost() {
    subscriberPostComment = new SubscriberPostComment(driver);
    subscriberPostComment.goToTest();
    subscriberPostComment.goToPost();
    subscriberPostComment.addComment("Interesting!");
    subscriberPostComment = subscriberHomePage.enterPostComment();

    assertEquals(URL_POST_COMMENT, subscriberPostComment.getPostCommentPageUrl());
  }

  @AfterMethod
  public void TearDown() {
    driver.close();
  }
}