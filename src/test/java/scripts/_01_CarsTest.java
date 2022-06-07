package scripts;

import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _01_CarsTest extends Base{

    @Test(priority = 1, description = "TASK-1")
    public void signInPageValidation() {
        driver.get("https://www.cars.com/");
        homePage.signInButton.click();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        Assert.assertTrue(signInPage.heading1.isDisplayed());
        Assert.assertEquals(signInPage.paragraph.getText(), "New to Cars.com? Sign up. Are you a dealer?");
        Assert.assertTrue(signInPage.emailInputBox.isEnabled());
        Assert.assertEquals(signInPage.emailInputBoxText.getText(), "Email");

        Assert.assertTrue(signInPage.passwordInputBox.isEnabled());
        Assert.assertEquals(signInPage.passwordInputBoxText.getText(), "Password");

        Assert.assertEquals(signInPage.passwordWarning.getText(), "Minimum of eight characters");
        Assert.assertEquals(signInPage.forgotPasswordLink.getText(), "Forgot password?");
        Assert.assertEquals(signInPage.userAgreement.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");

        Assert.assertTrue(signInPage.signInButton.isDisplayed());
        Assert.assertTrue(signInPage.signInButton.isEnabled());
        Assert.assertEquals(signInPage.signInButton.getText(), "Sign in");
    }

    @Test(priority = 2, description = "TASK-2")
    public void signInSocialMedia(){
        driver.get("https://www.cars.com/");
        homePage.signInButton.click();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        Assert.assertEquals(signInPage.socialHeading.getText(), "Connect with social");
        for (int i = 0; i < signInPage.socialLinks.size(); i++) {
            Assert.assertTrue(signInPage.socialLinks.get(i).isDisplayed());
            Assert.assertTrue(signInPage.socialLinks.get(i).isEnabled());
            switch(i){
                case(0):
                    Assert.assertEquals(signInPage.socialLinks.get(i).getText(), "Sign in with Facebook");
                    break;
                case(1):
                    Assert.assertEquals(signInPage.socialLinks.get(i).getText(), "Sign in with Google");
                    break;
                case(2):
                    Assert.assertEquals(signInPage.socialLinks.get(i).getText(), "Sign in with Apple");
                    break;
                default:
                    throw new NotFoundException("Unexpected WebElement found in the list!!!");

            }
        }
    }

    @Test(priority = 3, description = "TASK-3")
    public void invalidSignInCredentials(){
        driver.get("https://www.cars.com/");
        homePage.signInButton.click();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        signInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        signInPage.passwordInputBox.sendKeys("abcd1234");
        signInPage.signInButton.click();

        Assert.assertEquals(signInPage.errorMessage.getText(), "We were unable to sign you in.\n" +
                "Your email or password was not recognized. Try again soon.");
    }
}
