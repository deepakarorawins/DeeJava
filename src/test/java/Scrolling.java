import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Scrolling {

    private Scrolling(AndroidDriver driver){
        this.driver=driver;
    }

    private AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI GRA-CL10");
        cap.setCapability(MobileCapabilityType.APP, "/Users/darora/git/Reops/WebDriver_Demo/src/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        Scrolling sc = new Scrolling(driver);
        sc.scrollTillViews();
        sc.scrollTillWebView();
        System.out.println(driver.findElement(By.xpath("//android.view.View[@text='Hello World! - 1 Link'")).getText());

        driver.quit();
    }

    private void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        Double scrollHightStart = dimension.getHeight() * 0.5;
        int scrollStart = scrollHightStart.intValue();

        Double scrollHightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = scrollHightEnd.intValue();

        new TouchAction((PerformsTouchActions)driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public List<WebElement> getItemViews(){

        return driver.findElements(By.xpath("//android.widget.TextView[@text='Views']"));
    }

    public List<WebElement> getItemWebView(){
        return driver.findElements(By.xpath("//android.widget.TextView[@text='WebView']"));
    }

    public void scrollTillViews() throws InterruptedException {
        while (getItemViews().isEmpty()){
            scrollDown();
        }
        if(!getItemViews().isEmpty()){
            getItemViews().get(0).click();
        }
        Thread.sleep(4000);
    }

    public void scrollTillWebView() throws InterruptedException {
        while (getItemWebView().isEmpty()){
            scrollDown();
        }

        if(!getItemWebView().isEmpty()){
            getItemWebView().get(0).click();
        }
        Thread.sleep(4000);
    }


}
