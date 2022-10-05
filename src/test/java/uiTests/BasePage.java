package uiTests;

import org.junit.After;
import org.junit.Before;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



    public class BasePage {
        public WebDriver driver;
        WebDriverWait wait;
        public String title;
        public WebElement element;

        public BasePage () {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            driver = new ChromeDriver(options=options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        public BasePage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        @Before
        public void setUp() {
        }

        @After
        public void tearDown() {
            //Close browser
            driver.quit();
        }


        public boolean isElementPresent(WebElement element) {
            try {
                element.isDisplayed ();
            } catch (NoSuchElementException e) {
            }
            return false;
        }

        public void clickButton (WebElement button) {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            {
                Actions builder = new Actions(driver);
                builder.moveToElement(button, 0, 0).perform();
            }
            button.click();
        }

        public void typeText (WebElement field, String text) {
            wait.until(ExpectedConditions.visibilityOf(field));
            {
                Actions builder = new Actions(driver);
                builder.moveToElement(field, 0, 0).perform();
            }
            field.sendKeys(text);
            wait.until(ExpectedConditions.textToBePresentInElementValue(field, text));
        }

    }

