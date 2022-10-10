package uiTests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class LogoutFromBooksSiteTest extends BasePage {

    public LogoutFromBooksSiteTest(){
        super();
    }

       @Test
    public void LogoutFromSiteTest() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        BooksPage booksPage = PageFactory.initElements(driver, BooksPage.class);

        //Click Login button.
        homePage.isElementPresent(homePage.loginButton);
        homePage.clickButton(homePage.loginButton);
        // Login to Books site (create appropriate method in LoginPage)
        loginPage.LogIn();
        //Click Logout button.
        booksPage.clickButton(booksPage.logoutButton);

        // Verify that Login in Book Store text is present on the page.
        Thread.sleep(4000);
        String text = String.valueOf(driver.getPageSource().contains("Login in Book Store"));
        System.out.println("Login in Book Store is present: "+text);

    }
}



