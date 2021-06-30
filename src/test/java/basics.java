
import PageObject.ApiHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resource.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class basics extends base {
    @Test
    public void basics() throws IOException, InterruptedException {
        service=startServer();
        AndroidDriver<AndroidElement> driver = Capabilities("Apidemoapp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ApiHomePage ap = new ApiHomePage(driver);
        ap.Preference.click();
        ap.PreferenceDependency.click();
        ap.CheckBox.click();
        ap.Wifi.click();
        ap.WifiEdit.sendKeys("HelloWorld");
        ap.Button.get(1).click();
        service.stop();
    }
    //to stop the other port
    @BeforeTest
    public void KillAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }
}






          // driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
            //driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
           // driver.findElementById("android:id/checkbox").click();
            //driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
            //driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
          //  driver.findElementsByClassName("android.widget.Button").get(1).click();


