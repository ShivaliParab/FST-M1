package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity7 {
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
        public void addEmployeeQualifications(){
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1']")).click();
            driver.findElement(By.id("addWorkExperience")).click();
            driver.findElement(By.id("experience_employer")).sendKeys("IBM");
            driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
            driver.findElement(By.id("experience_from_date")).clear();
            driver.findElement(By.id("experience_from_date")).sendKeys("2019-09-27");
            driver.findElement(By.id("experience_to_date")).clear();
            driver.findElement(By.id("experience_to_date")).sendKeys("2023-03-27");
            driver.findElement(By.id("btnWorkExpSave")).click();
        }
        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
}
