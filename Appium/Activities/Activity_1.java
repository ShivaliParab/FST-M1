package examples;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class Activity_1 {

        //Driver Declaration
        AndroidDriver driver;


        WebDriverWait wait;

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
        public void multiplicationTest() {
            //com.google.android.calculator:id/digit_8
            driver.findElement(AppiumBy.id("digit_8")).click();
            //com.google.android.calculator:id/op_mul
            driver.findElement(AppiumBy.id("op_mul")).click();
            //com.google.android.calculator:id/digit_3
            driver.findElement(AppiumBy.id("digit_3")).click();
            //com.google.android.calculator:id/eq
            driver.findElement(AppiumBy.accessibilityId("equals")).click();
            //com.google.android.calculator:id/result_final
            String result = driver.findElement(AppiumBy.id("result_final")).getText();
            //com.google.android.calculator:id/result_preview
            Assert.assertEquals(result, "24");


        }

        @AfterClass
        public void tearDown() {

            driver.quit();

        }

}

