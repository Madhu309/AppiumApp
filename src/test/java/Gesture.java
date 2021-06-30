import PageObject.ViewPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import resource.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class Gesture extends base
{
    public AndroidDriver<AndroidElement> driver;
    @Test
    public void Gestures() throws IOException, InterruptedException {
        service=startServer();
        driver = Capabilities("Apidemoapp");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ViewPage vp=new ViewPage(driver);
        vp.Views.click();

        TouchAction t = new TouchAction(driver);
        vp.explist.click();
        vp.CustomAdapter.click();
        //WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
       //t.tap(tapOptions().withElement(element(expandList))).perform();
       //driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
         WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
         t.longPress(longPressOptions().withElement(element(pn))).release().perform();
         System.out.println(driver.findElementById("android:id/title").isDisplayed());
        service.stop();

    }
}