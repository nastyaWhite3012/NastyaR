//import Database.ConnectionToDatabaseEditor;
//import Editor.*;
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
//public class TestEditor {
//  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
//  private static String TRASH = "Trash (2)";
//  private ChromeDriver driver;
//  private EditorLoginPage editorLoginPage;
//  private EditorHomePage editorHomePage;
//  private EditorPublish editorPublish;
//  private EditorAddPost editorAddPost;
//  private EditorDeletePost editorDeletePost;
//  private ConnectionToDatabaseEditor connectionToDatabaseEditor;
//
//  @BeforeTest
//  public void beforeTst() {
//    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
//    connectionToDatabaseEditor.addUser();
//  }
//
//  @BeforeMethod
//  public void setUp() {
//    driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//    editorLoginPage = new EditorLoginPage(driver);
//    editorLoginPage.openLoginPage();
//    editorLoginPage.setUserName("editor");
//    editorLoginPage.setPassword("1");
//    editorHomePage = editorLoginPage.enterLoginPageEditor();
//  }
//
//  @Test
//  public void testLoginEditor() {
//    assertEquals(URL_HOME_PAGE, editorHomePage.getHomePageUrl());
//  }
//
//  @Test
//  public void testAddPost() {
//    editorAddPost = new EditorAddPost(driver);
//    editorAddPost.setTitle("BREAKING DOWN 'Supply'");
//    editorAddPost.setPost("Supply and demand trends form the basis of the modern economy. " +
//        "Each specific good or service will have its own supply and demand patterns based " +
//        "on price, utility and personal preference. If people demand a good and are willing " +
//        "to pay more for it, producers will add to the supply. As the supply increases, the " +
//        "price will fall given the same level of demand. Ideally, markets will reach a point of" +
//        " equilibrium where the supply equals the demand (no excess supply and no shortages) for" +
//        " a given price point; at this point, consumer utility and producer profits are maximized.");
//    editorHomePage.enterSaveDraft();
//
//    assertEquals(URL_HOME_PAGE, editorAddPost.getAddPostPageUrl());
//  }
//
//  @Test
//  public void testPublish() {
//    editorPublish = new EditorPublish(driver);
//    editorPublish.goToPosts();
//    editorPublish.goToDraft();
//    editorPublish.goToEdit();
//    editorPublish.setPublish();
//
//    assert (driver.getCurrentUrl().contains("action=edit"));
//  }
//
//  @Test
//  public void testToTrash() {
//    editorDeletePost = new EditorDeletePost(driver);
//    editorDeletePost.goToPosts();
//    editorDeletePost.openPost();
//    editorDeletePost.delete();
//
//    assertEquals(TRASH, editorDeletePost.getTrash());
//  }
//
//  @AfterMethod
//  public void tearDown() {
//    driver.close();
//  }
//
//  @AfterTest
//  public void afterTest() {
//    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
//    connectionToDatabaseEditor.deleteUser();
//  }
//}
//
