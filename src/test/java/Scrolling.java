import PageObject.Utilities;
import PageObject.ViewPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import resource.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Scrolling extends base
{
    public AndroidDriver<AndroidElement> driver;

    @Test
    public void scrollingDemo() throws IOException, InterruptedException {
        service=startServer();
        driver=Capabilities("Apidemoapp");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ViewPage vp=new ViewPage(driver);
        vp.Views.click();
        Utilities u=new Utilities(driver);
        u.scrollToText("WebView");
        service.stop();
    }
}
