package selenium_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity4 {
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
        public void addNewEmployee(){
            driver.findElement(By.id("menu_pim_viewPimModule")).click();
            driver.findElement(By.id("menu_pim_viewPimModule")).click();
            driver.findElement(By.id("btnAdd")).click();
            WebElement Firstname = driver.findElement(By.id("firstName"));
            Firstname.sendKeys("NewUser");
            WebElement LastName = driver.findElement(By.id("lastName"));
            LastName.sendKeys("Employee2");
            driver.findElement(By.id("btnSave")).click();
        }

        @Test(priority = 3)
        public void verifyEmployeeList(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement employeeList = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewEmployeeList")));
            employeeList.click();
            WebElement employeeNameField = driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
            employeeNameField.sendKeys("NewUser Employee2");
            employeeNameField.sendKeys(Keys.TAB);
            driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

            WebElement tableContent = driver.findElement(By.xpath("//tr[@class='odd'][1]"));
            String text1 = tableContent.getText();
            Assert.assertEquals(text1,"1166 NewUser Employee2");

        }

        @AfterClass(alwaysRun = true)
        public void tearDown(){
            //Close the browser
            driver.quit();
        }
    }