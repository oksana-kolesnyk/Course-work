package uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='userName']")
    public WebElement userNameField;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    public WebElement loginButtonOnLoginPage;


    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void typeUserName (String text) {
        typeText(userNameField, text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void typePassword (String text) {
        typeText(passwordField, text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void LogIn() {

        typeUserName("testOksana");
        typePassword("Test123%");
        clickButton(loginButtonOnLoginPage);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}

