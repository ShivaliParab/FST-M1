package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

    public class Activity2 {

        AndroidDriver driver;
        WebDriverWait wait;

        @BeforeClass
        public void setUp() throws MalformedURLException {

            //desired capabilites
            UiAutomator2Options options = new UiAutomator2Options().
                    setPlatformName("android").
                    setAutomationName("UiAutomator2").
                    setAppPackage("com.google.android.keep").
                    setAppActivity(".activities.BrowseActivity").
                    noReset();
            //appium server url
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        }

        @Test
        public void addNewNote()  throws  Exception{

            List<WebElement> notes = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.StaggeredGridLayoutManager[@resource-id='com.google.android.keep:id/notes']/androidx.cardview.widget.CardView"));
            int value = notes.size();
            System.out.println(value);

            //com.google.android.keep:id/new_note_button
            driver.findElement(AppiumBy.id("new_note_button")).click();
            //com.google.android.keep:id/editable_title
            driver.findElement(AppiumBy.id("editable_title")).sendKeys("Test Title");
            //com.google.android.keep:id/edit_note_text
            driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Adding a small description");
            //pressing the back button
            driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();


            //android.widget.TextView
            notes = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.StaggeredGridLayoutManager[@resource-id='com.google.android.keep:id/notes']/androidx.cardview.widget.CardView"));
            int newValue = notes.size();
            System.out.println(newValue);

            Assert.assertEquals(newValue, value + 1);
        }


        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
