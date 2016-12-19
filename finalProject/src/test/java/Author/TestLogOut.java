package Author;

import Database.ConnectionToDatabaseAuthor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Test logging out by author
 */
@Test (singleThreaded = true)
public class TestLogOut {
  private ConnectionToDatabaseAuthor connectionToDatabaseAuthor;
  private ChromeDriver driver;
  private AuthorLoginPage authorLoginPage;
  private AuthorHomePage authorHomePage;
  private AuthorLogOut authorLogOut;
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-login.php?loggedout=true";

  @BeforeTest
  public void setUp() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseAuthor.addUser();
  }

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setUserName("author");
    authorLoginPage.setPassword("1");
    authorHomePage = authorLoginPage.enterLoginPageAuthor();
  }

  @Test
  public void testLoginAuthor() {
    authorLogOut = new AuthorLogOut(driver);
    authorLogOut.goToTitle();
    authorLogOut.logOut();

    assertEquals(URL_HOME_PAGE, authorHomePage.getHomePageUrl());
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }

  @AfterTest
  public void tearDown() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseAuthor.deleteUser();
  }
}
