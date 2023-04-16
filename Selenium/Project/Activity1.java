package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {


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
        public void homepageTest(){
            //Get the page title
            String pageTitle = driver.getTitle();
            //Assertions
            Assert.assertEquals(pageTitle, "OrangeHRM");
            System.out.println(pageTitle);

        }

       @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }

    }


