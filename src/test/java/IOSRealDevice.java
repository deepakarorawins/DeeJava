import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IOSRealDevice {
    public  static void main(String[] args) throws MalformedURLException {
        // File app = new File("/Users/darora/git/Reops/DeeJava/src/test/resources/stage/OpenLink.ipa");
        System.out.println("!!! Appium must be already started manually !!!");
        System.out.println("Assuming app has already been installed.");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "12.2");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("udid", "auto");
        capabilities.setCapability("bundleId", "com.milwaukeetool.mymilwaukee");
        //capabilities.setCapability("xcodeOrgId", "<your org id>");
        //capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        //capabilities.setCapability("updatedWDABundleId", "<bundle id in scope of provisioning profile>");
        //capabilities.setCapability("useNewWDA", "true");

        IOSDriver driver  = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("!!! IOSDriver has been initialized !!!");
        System.out.println("!!! Please First manually navigate to the desired screen before proceeding further !!!");


        MobileElement lblServiceDate = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='service_days_remaining_label']"));
        lblServiceDate.click();








        //driver.close();
        driver.quit();


    }
}
