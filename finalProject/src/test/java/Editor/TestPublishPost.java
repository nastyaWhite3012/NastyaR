package Editor;

import Database.ConnectionToDatabaseEditor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Test publishing post by editor
 */
@Test (singleThreaded = true)
public class TestPublishPost {
  private ChromeDriver driver;
  private EditorLoginPage editorLoginPage;
  private EditorHomePage editorHomePage;
  private EditorPublish editorPublish;
  private EditorAddPost editorAddPost;
  private ConnectionToDatabaseEditor connectionToDatabaseEditor;

  @BeforeTest
  public void setUp() {
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseEditor.addUser();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    editorLoginPage = new EditorLoginPage(driver);
    editorLoginPage.openLoginPage();
    editorLoginPage.setUserName("editor");
    editorLoginPage.setPassword("1");
    editorHomePage = editorLoginPage.enterLoginPageEditor();
  }

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
    editorAddPost = new EditorAddPost(driver);
    editorAddPost.setTitle("BREAKING DOWN 'Supply'");
    editorAddPost.setPost("Supply and demand trends form the basis of the modern economy. " +
        "Each specific good or service will have its own supply and demand patterns based " +
        "on price, utility and personal preference. If people demand a good and are willing " +
        "to pay more for it, producers will add to the supply. As the supply increases, the " +
        "price will fall given the same level of demand. Ideally, markets will reach a point of" +
        " equilibrium where the supply equals the demand (no excess supply and no shortages) for" +
        " a given price point; at this point, consumer utility and producer profits are maximized.");
    editorHomePage.enterSaveDraft();
    TimeUnit.SECONDS.sleep(1);

  }

  @Test
  public void testPublishPost() {
    editorPublish = new EditorPublish(driver);
    editorPublish.goToPosts();
    editorPublish.goToDraft();
    editorPublish.goToEdit();
    editorPublish.setPublish();

    assert (driver.getCurrentUrl().contains("action=edit"));
  }

  @AfterMethod
  public void afterTest() {
    driver.close();
  }

  @AfterTest
  public void tearDown() {
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseEditor.deleteDraft();
    connectionToDatabaseEditor.deleteUser();
  }
}
