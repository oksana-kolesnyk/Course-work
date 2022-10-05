package uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{

    public BooksPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@id='submit']")
    public WebElement logoutButton;

}
