import Author.AuthorLoginPage;
import Contributer.ContributerLoginPage;
import Database.ConnectionToDatabaseAuthor;
import Database.ConnectionToDatabaseContributer;
import Database.ConnectionToDatabaseEditor;
import Database.ConnectionToDatabaseSubscriber;
import Editor.EditorLoginPage;
import Subscriber.SubscriberLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Negative test for logging out for all users
 */
public class TestWrongData {
  private ChromeDriver driver;
  private AuthorLoginPage authorLoginPage;
  private ContributerLoginPage contributerLoginPage;
  private EditorLoginPage editorLoginPage;
  private SubscriberLoginPage subscriberLoginPage;
  private ConnectionToDatabaseAuthor connectionToDatabaseAuthor;
  private ConnectionToDatabaseContributer connectionToDatabaseContributer;
  private ConnectionToDatabaseEditor connectionToDatabaseEditor;
  private ConnectionToDatabaseSubscriber connectionToDatabaseSubscriber;
  private static String LOST_PASSWORD = "Lost your password?";
  private static String USERNAME_FIELD_IS_EMPTY = "ERROR: The username field is empty.";
  private static String PASSWORD_FIELD_IS_EMPTY = "ERROR: The password field is empty.";

  @BeforeTest
  public void beforeTest() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseContributer = new ConnectionToDatabaseContributer();
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
    connectionToDatabaseAuthor.addUser();
    connectionToDatabaseContributer.addUser();
    connectionToDatabaseEditor.addUser();
    connectionToDatabaseSubscriber.addUser();
  }

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }

  @Test
  public void testAuthorWrongUsername() {
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setUserName("authorr");
    authorLoginPage.setPassword("1");
    authorLoginPage.enterLoginPageAuthor();

    assertEquals(LOST_PASSWORD, authorLoginPage.errorMessage());
  }

  @Test
  public void testAuthorWrongPassword() {
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setUserName("author");
    authorLoginPage.setPassword("11");
    authorLoginPage.enterLoginPageAuthor();

    assertEquals(LOST_PASSWORD, authorLoginPage.errorMessage());
  }

  @Test
  public void testAuthorWrongUsernameAndPassword() {
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setUserName("authorr");
    authorLoginPage.setPassword("11");
    authorLoginPage.enterLoginPageAuthor();

    assertEquals(LOST_PASSWORD, authorLoginPage.errorMessage());
  }

  @Test
  public void testContributerWrongUsername() {
    contributerLoginPage = new ContributerLoginPage(driver);
    contributerLoginPage.openLoginPage();
    contributerLoginPage.setUserName("contributerr");
    contributerLoginPage.setPassword("1");
    contributerLoginPage.enterLoginPageContributer();

    assertEquals(LOST_PASSWORD, contributerLoginPage.errorMessage());
  }

  @Test
  public void testContributerWrongPassword() {
    contributerLoginPage = new ContributerLoginPage(driver);
    contributerLoginPage.openLoginPage();
    contributerLoginPage.setUserName("contributer");
    contributerLoginPage.setPassword("11");
    contributerLoginPage.enterLoginPageContributer();

    assertEquals(LOST_PASSWORD, contributerLoginPage.errorMessage());
  }

  @Test
  public void testContributerWrongUsernameAndPassword() {
    contributerLoginPage = new ContributerLoginPage(driver);
    contributerLoginPage.openLoginPage();
    contributerLoginPage.setUserName("contributerr");
    contributerLoginPage.setPassword("11");
    contributerLoginPage.enterLoginPageContributer();

    assertEquals(LOST_PASSWORD, contributerLoginPage.errorMessage());
  }

  @Test
  public void testEditorWrongUsername() {
    editorLoginPage = new EditorLoginPage(driver);
    editorLoginPage.openLoginPage();
    editorLoginPage.setUserName("editorr");
    editorLoginPage.setPassword("1");
    editorLoginPage.enterLoginPageEditor();

    assertEquals(LOST_PASSWORD, editorLoginPage.errorMessage());
  }

  @Test
  public void testEditorWrongPassword() {
    editorLoginPage = new EditorLoginPage(driver);
    editorLoginPage.openLoginPage();
    editorLoginPage.setUserName("editor");
    editorLoginPage.setPassword("11");
    editorLoginPage.enterLoginPageEditor();

    assertEquals(LOST_PASSWORD, editorLoginPage.errorMessage());
  }

  @Test
  public void testEditorWrongUsernameAndPassword() {
    editorLoginPage = new EditorLoginPage(driver);
    editorLoginPage.openLoginPage();
    editorLoginPage.setUserName("editorr");
    editorLoginPage.setPassword("11");
    editorLoginPage.enterLoginPageEditor();

    assertEquals(LOST_PASSWORD, editorLoginPage.errorMessage());
  }

  @Test
  public void testSubscriberWrongUsername() {
    subscriberLoginPage = new SubscriberLoginPage(driver);
    subscriberLoginPage.openLoginPage();
    subscriberLoginPage.setUserName("subscriberr");
    subscriberLoginPage.setPassword("1");
    subscriberLoginPage.enterLoginPageSubscriber();

    assertEquals(LOST_PASSWORD, subscriberLoginPage.errorMessage());
  }

  @Test
  public void testSubscriberWrongPassword() {
    subscriberLoginPage = new SubscriberLoginPage(driver);
    subscriberLoginPage.openLoginPage();
    subscriberLoginPage.setUserName("subscriber");
    subscriberLoginPage.setPassword("11");
    subscriberLoginPage.enterLoginPageSubscriber();

    assertEquals(LOST_PASSWORD, subscriberLoginPage.errorMessage());
  }

  @Test
  public void testSubscriberWrongUsernameAndPassword() {
    subscriberLoginPage = new SubscriberLoginPage(driver);
    subscriberLoginPage.openLoginPage();
    subscriberLoginPage.setUserName("subscriberr");
    subscriberLoginPage.setPassword("11");
    subscriberLoginPage.enterLoginPageSubscriber();

    assertEquals(LOST_PASSWORD, subscriberLoginPage.errorMessage());
  }

  @Test
  public void testWithoutNickname() {
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setPassword("");
    authorLoginPage.setPassword("1");
    authorLoginPage.enterLoginPageAuthor();

    assertEquals(USERNAME_FIELD_IS_EMPTY, authorLoginPage.fieldIsEmpty());
  }

  @Test
  public void testWithoutPassword() {
    authorLoginPage = new AuthorLoginPage(driver);
    authorLoginPage.openLoginPage();
    authorLoginPage.setUserName("author");
    authorLoginPage.setPassword("");
    authorLoginPage.enterLoginPageAuthor();

    assertEquals(PASSWORD_FIELD_IS_EMPTY, authorLoginPage.fieldIsEmpty());
  }

  @AfterMethod
  public void tearDown() {
    driver.close();
  }

  @AfterTest
  public void afterTest() {
    connectionToDatabaseAuthor = new ConnectionToDatabaseAuthor();
    connectionToDatabaseContributer = new ConnectionToDatabaseContributer();
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseSubscriber = new ConnectionToDatabaseSubscriber();
    connectionToDatabaseAuthor.deleteUser();
    connectionToDatabaseContributer.deleteUser();
    connectionToDatabaseEditor.deleteUser();
    connectionToDatabaseSubscriber.deleteUser();
  }
}
