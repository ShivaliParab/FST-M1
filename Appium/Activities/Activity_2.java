package examples;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Activity_2 {
        AppiumDriver driver;
        WebDriverWait wait;
        @BeforeClass
        public void setUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options().
                    setPlatformName("android").
                    setAutomationName("UiAutomator2").
                    setAppPackage("com.android.chrome").
                    setAppActivity("com.google.android.apps.chrome.Main").
                    noReset();
            //appium server url
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            driver.get("https://www.training-support.net/");
        }

        @Test
        public void chromeTest() {

            String pageHeading = driver.findElement(AppiumBy.xpath(
                    "//android.widget.TextView[contains(@text, 'Training Support')]"
            )).getText();

            // Print to console
            System.out.println("Heading: " + pageHeading);



            driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(
                    "//android.widget.TextView[contains(@text, 'About Us')]"
            )));

            String aboutHeading = driver.findElement(AppiumBy.xpath(
                    "//android.widget.TextView[contains(@text, 'About Us')]"
            )).getText();
            System.out.println("Heading in About us page : " + aboutHeading);


        }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
}