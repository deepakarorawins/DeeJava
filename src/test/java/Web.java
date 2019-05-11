import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Web {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/darora/git/Reops/DeeJava/src/test/resources/drivers/chromedriver");


        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
        WebDriver driver = new ChromeDriver(chromeOptions);




        driver.get("https://onekeystaging.milwaukeetool.com/");

        Thread.sleep(5000);
        driver.findElement(By.name("email")).sendKeys("deemet@mailinator.com");
        driver.findElement(By.name("password")).sendKeys("miP4cvma");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/darora/git/Reops/DeeJava/screenshots/1.png"));

        driver.findElement(By.name("submit")).click();

        Thread.sleep(5000);
        File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src2, new File("/Users/darora/git/Reops/DeeJava/screenshots/2.png"));

        Thread.sleep(5000);

        System.out.println("Trying to check ADD ITEM");
        String lbl="";
        try{
            lbl = driver.findElement(By.xpath("//a[@ui-sref='add-options_123']")).getText();
        }catch(Exception e){
            File src3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src3, new File("/Users/darora/git/Reops/DeeJava/screenshots/3.png"));
        }




        System.out.println(lbl);







        driver.close();
        driver.quit();

    }
}
