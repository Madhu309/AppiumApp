package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {
        public ViewPage(AppiumDriver<AndroidElement> driver)
        {
            PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        }

        @AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
        public WebElement Views;

        @AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']")
        public WebElement explist;

        @AndroidFindBy(xpath="//android.widget.TextView[@text='1. Custom Adapter']")
        public WebElement CustomAdapter;

}
