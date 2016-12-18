import Author.*;
import Database.ConnectionToDatabaseAuthor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by HP on 03.12.2016.
 */
public class TestAuthor {
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
  private static String POST_STATUS = "Published";
  private static String TRASH = "Trash (1)";
  private ChromeDriver driver;
  private AuthorLoginPage authorLoginPage;
  private AuthorHomePage authorHomePage;
  private AuthorAddPost authorAddPost;
  private AuthorPublishPost authorPublishPost;
  private AuthorDeletePost authorDeletePost;
  private ConnectionToDatabaseAuthor connectionToDatabaseAuthor;

  @BeforeTest
  public void beforeTest() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseAuthor.addUser();
  }

  @BeforeMethod
  public void setUp() {
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
    assertEquals(URL_HOME_PAGE, authorHomePage.getHomePageUrl());
  }

  @Test
  public void testAddPost() {
    authorAddPost = new AuthorAddPost(driver);
    authorAddPost.setTitle("BREAKING DOWN 'Law Of Supply And Demand'");
    authorAddPost.setPost("One of the most basic economic laws, the law of supply " +
        "and demand ties into almost all economic principles in one way or another. " +
        "In practice, supply and demand pull against each other until the market finds" +
        " an equilibrium price. However, multiple factors affect both supply and demand, " +
        "causing them to increase or decrease in various ways.\n");
    authorHomePage.enterSaveDraft();

    assertEquals(URL_HOME_PAGE, authorAddPost.getAddPostPageUrl());
  }

  @Test
  public void testPublishPost() {
    authorPublishPost = new AuthorPublishPost(driver);
    authorPublishPost.goToPosts();
    authorPublishPost.openPost();
    authorPublishPost.publishPost();

    assertEquals(POST_STATUS, authorPublishPost.getStatus());
  }

  @Test
  public void testToTrash() {
    authorDeletePost = new AuthorDeletePost(driver);
    authorDeletePost.goToPosts();
    authorDeletePost.openPost();
    authorDeletePost.delete();

    assertEquals(TRASH, authorDeletePost.getTrash());
  }

  @AfterMethod
  public void TearDown() {
    driver.close();
  }

  @AfterTest
  public void afterTest() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseAuthor.deleteUser();
  }
}
