package Contributer;

import Database.ConnectionToDatabaseContributer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by HP on 18.12.2016.
 */
@Test (singleThreaded = true)
public class TestLogOutContributer {
  private ConnectionToDatabaseContributer connectionToDatabaseContributer;
  private ChromeDriver driver;
  private ContributerLoginPage contributerLoginPage;
  private ContributerHomePage contributerHomePage;
  private ContributerLogOut contributerLogOut;
  private static String URL_HOME_PAGE = "http://localhost:8888/?feed=rss2";

  @BeforeTest
  public void setUp() {
    connectionToDatabaseContributer= new ConnectionToDatabaseContributer();
    connectionToDatabaseContributer.addUser();
  }

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    contributerLoginPage = new ContributerLoginPage(driver);
    contributerLoginPage.openLoginPage();
    contributerLoginPage.setUserName("contributer");
    contributerLoginPage.setPassword("1");
    contributerHomePage = contributerLoginPage.enterLoginPageContributer();
  }

  @Test
  public void testLoginContributer() {
    contributerLogOut = new ContributerLogOut(driver);
    contributerLogOut.goToTitle();
    contributerLogOut.logOut();

    assertEquals(URL_HOME_PAGE, contributerHomePage.getHomePageUrl());
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }

  @AfterTest
  public void tearDown() {
    connectionToDatabaseContributer = new ConnectionToDatabaseContributer();
    connectionToDatabaseContributer.deleteUser();
  }
}
