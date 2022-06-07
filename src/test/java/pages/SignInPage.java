package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "sds-heading--1")
    public WebElement heading1;

    @FindBy(className = "signup-block")
    public WebElement paragraph;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//label[text()='Email']")
    public WebElement emailInputBoxText;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement passwordInputBoxText;

    @FindBy(className = "sds-helper-text")
    public WebElement passwordWarning;

    @FindBy(css = ".password-help a")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//form[@class='session-form']/div[2]")
    public WebElement userAgreement;

    @FindBy(css = ".sds-field button")
    public WebElement signInButton;

    @FindBy(css = ".sds-heading--3")
    public WebElement socialHeading;

    @FindBy(css = ".sidebar-social-login li")
    public List<WebElement> socialLinks;

    @FindBy(className = "sds-notification__content")
    public WebElement errorMessage;
}
