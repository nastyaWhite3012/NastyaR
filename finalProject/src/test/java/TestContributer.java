import Contributer.ContributerHomePage;
import Contributer.ContributerLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by HP on 03.12.2016.
 */
public class TestContributer {
  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
  private ChromeDriver driver;
  ContributerLoginPage contributerLoginPage;
  ContributerHomePage contributerHomePage;

  @BeforeMethod
  public void SetUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginContributer() {
    contributerLoginPage = new ContributerLoginPage(driver);
    contributerLoginPage.openLoginPage();
    contributerLoginPage.setUserName("contributer");
    contributerLoginPage.setPassword("1");
    contributerHomePage = contributerLoginPage.enterLoginPageContributer();

    assertEquals(URL_HOME_PAGE, contributerHomePage.getHomePageUrl());
  }

  @AfterMethod
  public void TearDown() {
    driver.close();
  }
}
