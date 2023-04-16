package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity6 {
        WebDriver driver;

        //Create the setup method
        @BeforeClass
        public void setUp(){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
            //Set Up the firefox driver
            WebDriverManager.firefoxdriver().setup();
            // Initailize driver object
            driver = new FirefoxDriver();
            //Open the browser
            driver.get("http://alchemy.hguy.co/orangehrm");
            //Adding Implicit Wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        //Create the test method
        @Test(priority =1)
        public void loginToSystem(){
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();
            String text = driver.findElement(By.id("welcome")).getText();
            //Assertions
            Assert.assertEquals(text, "Welcome Harmoine");
            System.out.println(text);
        }

        @Test(priority = 2)
        public void directoryMenuItem(){
            Boolean visible= driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
            System.out.println(visible);
            if(visible == true) {
                System.out.println("Directory is Visible");
            } else
            {
                System.out.println("Directory is not visible");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement directoryMenuItem = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
            directoryMenuItem.click();
            directoryMenuItem.click();
            WebElement searchDirectory = driver.findElement(By.xpath("//div[@class='head']//h1"));
            String Text2 = searchDirectory.getText();
            Assert.assertEquals(Text2,"Search Directory");
            System.out.println(Text2);
        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
}