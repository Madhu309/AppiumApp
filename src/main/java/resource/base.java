package resource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class base
{
    public static AndroidDriver<AndroidElement> driver;
 public static AppiumDriverLocalService service;
    public AppiumDriverLocalService startServer()
    {
        boolean flag=CheckIfSeverIsRunning(4723);
        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean CheckIfSeverIsRunning(int port)
    {
        boolean isServerRunning=false;
        ServerSocket serverSocket;
        try{
            serverSocket=new ServerSocket(port);
            serverSocket.close();
        }
        catch (IOException e)
        {
            isServerRunning=true;
        }
        finally {
            serverSocket=null;
        }
        return  isServerRunning;
    }
    public static void StartEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startemulator.bat");
        Thread.sleep(6000);
    }

        //public static AndroidDriver<AndroidElement> driver;
        public AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
            FileInputStream fis=new FileInputStream( System.getProperty("user.dir")+ "\\src\\data.properties");
            Properties prop=new Properties();
            prop.load(fis);

            File f = new File("src");
            File fs = new File(f, (String) prop.get(appName));
            DesiredCapabilities cap = new DesiredCapabilities();

            String device= (String) prop.get("device");
            if(device.contains("emulator"))
            {
                StartEmulator();
            }
            cap.setCapability("DeviceName", "device");
            cap.setCapability("platformName", "Android");
            cap.setCapability("automationName","UiAutomator2");
            //cap.setCapability("appPackage","com.touchboarder.android.api.demos");
            cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            return driver;
        }


    //to take screenshot
       public static void getScreenshot(String s) throws IOException {
       File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
    }
}

