package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {


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

        }

        //Create the test method
        @Test(priority =1)
        public void urlForHeaderImage(){
            //Get the page title
            WebElement imageurl = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png']"));

            System.out.println(imageurl.getAttribute("src"));

        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }

    }



