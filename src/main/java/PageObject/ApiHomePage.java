package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resource.base;

import java.util.List;

public class ApiHomePage {
    public ApiHomePage(AppiumDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
    public WebElement Preference;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement PreferenceDependency;

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement CheckBox;

    @AndroidFindBy(xpath = ("(//android.widget.RelativeLayout)[2]"))
    public WebElement Wifi;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement WifiEdit;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> Button;
}

