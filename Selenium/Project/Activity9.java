package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity9 {
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
            Assert.assertEquals(text, "Welcome John");
            System.out.println(text);
        }

        @Test(priority = 2)
        public void retrieveEmergencyContacts(){
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();
            //Grab the table
            WebElement table = driver.findElement(By.id("emgcontact_list"));
            // Fetch all the TR elements from table
            List<WebElement> allRows = table.findElements(By.tagName("tr"));
            //Iterate over tr to get all cell values
            for (WebElement row : allRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.println("content from the Table -  " + cell.getText());
                    System.out.print("\t");
                }
                System.out.println();
            }
        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
}