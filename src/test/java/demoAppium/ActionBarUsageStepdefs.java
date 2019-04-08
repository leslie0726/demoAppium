package demoAppium;  
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java8.En;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class ActionBarUsageStepdefs implements En {
	
    private AppiumDriver<WebElement> driver;
    
	
	
    public ActionBarUsageStepdefs() {
        Given("啟動APP", () -> {
        	DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
            cap.setCapability("appPackage", "io.appium.android.apis");
            cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,  AutomationName.ANDROID_UIAUTOMATOR2);
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        });

        When("按下APP選項", () -> {
        	MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("App");
        	el1.click();

        });

        When("按下Action Bar選項", () -> {
        	
        	MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Action Bar");
        	el2.click();
        });

        When("按下Action Bar Usage選項", () -> {
        	MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Action Bar Usage");
        	el3.click();
        });

        Then("出現Action Bar Usage的畫面", () -> {
        	MobileElement el4 = (MobileElement) driver.findElementById("android:id/action_bar");
        	el4.click();
        });

    }

}