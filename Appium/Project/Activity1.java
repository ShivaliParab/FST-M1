package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity1 {
    AndroidDriver driver;

    //WebDriver wait
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.apps.tasks").
                setAppActivity(".ui.TaskListsActivity").
                noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver(serverURL, caps);
        //Open app
    }

    @Test
    public void addFirstTasks() throws InterruptedException {
        //Find the NewList and Click
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(500);
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }

    @Test
    public void addSecondTasks() throws InterruptedException {
        //Find the NewList and Click
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(500);
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }

    @Test
    public void addThirdTasks() throws InterruptedException {
        //Find the NewList and Click
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(500);
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //Assertion
        List<WebElement> tasksadded =driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']"));
        Assert.assertEquals(tasksadded.size(),3);
        System.out.println(tasksadded.size());
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }

}

