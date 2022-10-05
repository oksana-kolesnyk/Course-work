package uiTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginToBooksSiteTest extends BasePage {

    public LoginToBooksSiteTest(WebDriver driver) {

        super(driver);
    }

    @Test
    public void LoginToSiteTest() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        homePage.isElementPresent(homePage.loginButton);
        homePage.clickButton(homePage.loginButton);

        loginPage.isElementPresent(loginPage.userNameField);
        loginPage.clickButton(loginPage.userNameField);
        loginPage.typeUserName("testOksana");

        loginPage.isElementPresent(loginPage.passwordField);
        loginPage.clickButton(loginPage.passwordField);
        loginPage.typePassword("Test123%");

        loginPage.clickButton(loginPage.loginButtonOnLoginPage);

        // Verify that text Git Pocket Guide is present on the page.
        Thread.sleep(4000);
        String text = String.valueOf(driver.getPageSource().contains("Git Pocket Guide"));
        System.out.println("Git Pocket Guide is present: "+text);

    }
}

