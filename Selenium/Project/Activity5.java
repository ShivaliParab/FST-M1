package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity5 {
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
        public void editUserInfo(){
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.xpath("//input[@value='Edit']")).click();
            driver.findElement(By.id("personal_txtEmpFirstName")).clear();
            driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("John");
            driver.findElement(By.id("personal_txtEmpLastName")).clear();
            driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Doe");
            Select dropDown = new Select(driver.findElement(By.id("personal_cmbNation")));
            dropDown.selectByVisibleText("American");
            driver.findElement(By.id("personal_optGender_1")).click();
            driver.findElement(By.xpath("//input[@value='Save']")).click();

        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
    }

