import PageObject.ViewPage;
import PageObject.WidgetPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import resource.base;

import javax.swing.text.View;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Swipe extends base
{
    public AndroidDriver<AndroidElement> driver;
    @Test
    public void swipedemo() throws IOException, InterruptedException {
        service=startServer();
        driver = Capabilities("Apidemoapp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WidgetPage wp=new WidgetPage(driver);
        wp.Views.click();
        wp.DateWidget.click();
        wp.Inline.click();
        wp.desc.click();
        TouchAction t = new TouchAction(driver);
        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
       t.longPress(longPressOptions().withElement(element(first))).moveTo(element(second)).release().perform();
        service.stop();
    }
}

