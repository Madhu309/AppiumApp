package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WidgetPage {
    public WidgetPage(AppiumDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
    public WebElement Views;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
    public WebElement DateWidget;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"2. Inline\")")
    public WebElement Inline;

    @AndroidFindBy(xpath="//*[@content-desc='9']")
    public WebElement desc;


}
