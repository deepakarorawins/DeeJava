import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IOSRealDevice {
    public  static void main(String[] args) throws MalformedURLException, InterruptedException {
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


        String xpath = "//XCUIElementTypeStaticText[@name='Max Speed Low (1)']/following-sibling::XCUIElementTypeSlider";

        MobileElement me = (MobileElement)driver.findElement(By.xpath(xpath));
        int seekBarPercent = 50;
        Dimension screen = driver.manage().window().getSize();
        org.openqa.selenium.Point loc = me.getLocation();
        Dimension dim = me.getSize();
        int knobSize = dim.height;
        int halfKnobSize = dim.height / 2;
        int start = loc.x;
        int end = dim.width + halfKnobSize;
        int y = loc.y;

        TouchAction touchAction = new TouchAction(driver);
        // Move it will the end
        touchAction
                .press(PointOption.point(start, y))
                .moveTo(PointOption.point(end, y))
                .release()
                .perform();

        Thread.sleep(3000);

        // Move it seekBarPercent
        int moveTo = Math.round(end * (seekBarPercent));
        touchAction
                .longPress(PointOption.point(start, y))
                .moveTo(PointOption
                        .point(moveTo, y))
                .release()
                .perform();


























       /* //DeleteAllModes
        List<MobileElement> listOfModes = new ArrayList<MobileElement>();
        String xpath = "//XCUIElementTypeTable/XCUIElementTypeCell";
       int numOfModes=driver.findElements(By.xpath(xpath)).size();

        for(int i=0;i<numOfModes;i++) {
            listOfModes=driver.findElements(By.xpath(xpath));
            if(listOfModes.size()>0)
               System.out.println( listOfModes.get(0).findElement(By.xpath("XCUIElementTypeStaticText[2]")).getText());
              //  (//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText)[2]

            listOfModes.get(0).click();

            //click(logger, deleteBtn, "Delete Button", screen+" delete popup", 'Y');
        }*/




       /* MobileElement lblServiceDate = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name='30 Seconds']"));
        lblServiceDate.click();*/








        //driver.close();
        driver.quit();


    }


}
