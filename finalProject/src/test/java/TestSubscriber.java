//import Database.ConnectionToDatabaseSubscriber;
//import Subscriber.SubscriberHomePage;
//import Subscriber.SubscriberLoginPage;
//import Subscriber.SubscriberPostComment;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.testng.AssertJUnit.assertEquals;
//
///**
// * Created by HP on 03.12.2016.
// */
//public class TestSubscriber {
//  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/profile.php";
//  private static String URL_POST_COMMENT = "Your comment is awaiting moderation.";
//  private ChromeDriver driver;
//  SubscriberLoginPage subscriberLoginPage;
//  SubscriberHomePage subscriberHomePage;
//  SubscriberPostComment subscriberPostComment;
//  ConnectionToDatabaseSubscriber connectionToDatabaseSubscriber;
//
//  @BeforeTest
//  public void beforeTest() {
//    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
//    connectionToDatabaseSubscriber.addUser();
//  }
//
//  @BeforeMethod
//  public void setUp() {
//    driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//    subscriberLoginPage = new SubscriberLoginPage(driver);
//    subscriberLoginPage.openLoginPage();
//    subscriberLoginPage.setUserName("subscriber");
//    subscriberLoginPage.setPassword("1");
//    subscriberHomePage = subscriberLoginPage.enterLoginPageSubscriber();
//  }
//
//  @Test
//  public void testLoginSubscriber() {
//    assertEquals(URL_HOME_PAGE, subscriberHomePage.getHomePageUrl());
//  }
//
//  @Test
//  public void testAddComment() {
//    subscriberPostComment = new SubscriberPostComment(driver);
//    subscriberPostComment.goToDashboard();
//    subscriberPostComment.goToPost();
//    subscriberPostComment.writeComment("Interesting!");
//    subscriberPostComment.addComment();
//    subscriberPostComment = subscriberHomePage.enterPostComment();
//
//    assertEquals(URL_POST_COMMENT, subscriberPostComment.getPostCommentPageUrl());
//  }
//
//  @AfterMethod
//  public void tearDown() {
//    driver.close();
//  }
//
//  @AfterTest
//  public void afterTest() {
//    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
//    connectionToDatabaseSubscriber.deleteComment();
//    connectionToDatabaseSubscriber.deleteUser();
//  }
//}