package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class Activity_3 {

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //desired capabilites
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.calculator").
                setAppActivity("com.android.calculator2.Calculator").
                noReset();
        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

    }

    @Test
    public void addTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();

        driver.findElement(AppiumBy.id("op_add")).click();

        driver.findElement(AppiumBy.id("digit_9")).click();

        driver.findElement(By.id("eq")).click();

        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("5 + 9 = " + result);

        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtractTest() {

        driver.findElement(AppiumBy.id("digit_1")).click();

        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(AppiumBy.id("op_sub")).click();

        driver.findElement(AppiumBy.id("digit_5")).click();

        driver.findElement(By.id("eq")).click();

        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiplyTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();

        driver.findElement(AppiumBy.id("op_mul")).click();

        driver.findElement(AppiumBy.id("digit_1")).click();

        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(By.id("eq")).click();

        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "500");

    }

    @Test
    public void divideTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();

        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(AppiumBy.id("op_div")).click();

        driver.findElement(AppiumBy.id("digit_2")).click();

        driver.findElement(By.id("eq")).click();

        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "25");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}

