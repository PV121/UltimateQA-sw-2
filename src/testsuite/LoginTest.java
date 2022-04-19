package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void openBrowserLogin() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // to find element for sign in link
        WebElement signIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signIn.click();

        String expectedMessage = "Welcome Back!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        // to find element for sign in link
        WebElement signIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signIn.click();

        // to find usernamefield element and send value in to it.
        WebElement username= driver.findElement(By.xpath("//input[@type='email']"));
        username.sendKeys("vp@gmail.com");

        // to find password element and send value in it.
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("1234586");

        // to click on login button
        WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        String expectedMessage = "Invalid email or password.";

        WebElement actualMessageElement= driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage= actualMessageElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @After
    public void closeBrowserLogin() {
        closeBrowser();
    }
}
