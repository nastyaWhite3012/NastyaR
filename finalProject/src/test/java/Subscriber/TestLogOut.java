package Subscriber;

import Database.ConnectionToDatabaseSubscriber;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Test logging out by subscriber
 */
@Test (singleThreaded = true)
public class TestLogOut {
  private ConnectionToDatabaseSubscriber connectionToDatabaseSubscriber;
  private ChromeDriver driver;
  private SubscriberLoginPage subscriberLoginPage;
  private SubscriberHomePage subscriberHomePage;
  private SubscriberLogOut subscriberLogOut;
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-login.php?loggedout=true";

  @BeforeTest
  public void setUp() {
    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
    connectionToDatabaseSubscriber.addUser();
  }

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    subscriberLoginPage = new SubscriberLoginPage(driver);
    subscriberLoginPage.openLoginPage();
    subscriberLoginPage.setUserName("subscriber");
    subscriberLoginPage.setPassword("1");
    subscriberHomePage = subscriberLoginPage.enterLoginPageSubscriber();
  }

  @Test
  public void testLoginEditor() {
    subscriberLogOut = new SubscriberLogOut(driver);
    subscriberLogOut.goToTitle();
    subscriberLogOut.logOut();

    assertEquals(URL_HOME_PAGE, subscriberHomePage.getHomePageUrl());
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }

  @AfterTest
  public void tearDown() {
    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
    connectionToDatabaseSubscriber.deleteUser();
  }
}
