package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignInPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
