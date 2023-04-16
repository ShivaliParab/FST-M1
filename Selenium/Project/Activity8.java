package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity8 {
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
        public void applyLeave(){
            driver.findElement(By.xpath("//a//b[contains(text(),'Dashboard')]")).click();
            Actions a = new Actions(driver);
            WebElement applyLeaveLink = driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/leave/applyLeave']//span"));
            a.moveToElement(applyLeaveLink).build().perform();
            applyLeaveLink.click();
            WebElement leaveTypeField = driver.findElement(By.id("applyleave_txtLeaveType"));
            leaveTypeField.sendKeys("DayOff");
            leaveTypeField.sendKeys(Keys.TAB);
            driver.findElement(By.id("applyleave_txtFromDate")).clear();
            driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-04-27");
            driver.findElement(By.id("applyleave_txtToDate")).clear();
            driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2023-04-28");
            driver.findElement(By.id("applyBtn")).click();

            WebElement Leave = driver.findElement(By.id("menu_leave_viewLeaveModule"));
            a.moveToElement(Leave).build().perform();
            driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

           WebElement Status = driver.findElement(By.xpath("//a[contains(text(),'Pending Approval(7.00)')]"));
           String text1 = Status.getText();
           Assert.assertEquals(text1,"Pending Approval(7.00)");

        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
    }

