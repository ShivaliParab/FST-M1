package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionBase.doSwipe;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").setAutomationName("UiAutomator2").
                setAppPackage("com.android.chrome").
                setAppActivity("com.google.android.apps.chrome.Main").
                noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Open Selenium page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        //wait for the page load
       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        //Scroll to end by setting the start and end points
        Point start = new Point((int)(dims.width*0.5),(int)(dims.height*0.8));
        Point end = new Point((int)(dims.width*0.5),(int)(dims.height*0.5));
        doSwipe(driver,start,end,100);

        //Locate the element and click it
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Elements get added at run time')]"))).click();

        //Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
        //Find elements on the page
        WebElement addTaskInput=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton=driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        //Enter tasks
        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Clear the list");
        addTaskButton.click();
        Thread.sleep(1000);

        //Strike the added items in list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        Thread.sleep(500);

        //Clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clear List')]")).click();

        //Assertion
        List<WebElement> tasksadded =driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='taskList']"));
        Assert.assertEquals(tasksadded.size(),0);
        System.out.println(tasksadded.size());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
