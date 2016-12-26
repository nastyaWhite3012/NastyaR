package Editor;

import Database.ConnectionToDatabaseEditor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by HP on 18.12.2016.
 */
@Test (singleThreaded = true)
public class TestLogOut {
  private ConnectionToDatabaseEditor connectionToDatabaseEditor;
  private ChromeDriver driver;
  private EditorLoginPage editorLoginPage;
  private EditorHomePage editorHomePage;
  private EditorLogOut editorLogOut;
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-login.php?loggedout=true";

  @BeforeTest
  public void setUp() {
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseEditor.addUser();
  }

  @BeforeMethod
  public void beforeMethod() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    editorLoginPage = new EditorLoginPage(driver);
    editorLoginPage.openLoginPage();
    editorLoginPage.setUserName("editor");
    editorLoginPage.setPassword("1");
    editorHomePage = editorLoginPage.enterLoginPageEditor();
  }

  @Test
  public void testLoginEditor() {
    editorLogOut = new EditorLogOut(driver);
    editorLogOut.goToTitle();
    editorLogOut.logOut();

    assertEquals(URL_HOME_PAGE, editorHomePage.getHomePageUrl());
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }

  @AfterTest
  public void tearDown() {
    connectionToDatabaseEditor = new ConnectionToDatabaseEditor();
    connectionToDatabaseEditor.deleteUser();
  }
}
