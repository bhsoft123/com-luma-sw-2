package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome";
    public static WebDriver driver;

public void openBrowser(String baseUrl){
    //launch the browser
    if(browser.equalsIgnoreCase("Chrome")){
        driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("Edge")){
        driver = new EdgeDriver();
    } else if (browser.equalsIgnoreCase("Firefox")){
        driver = new FirefoxDriver();
    } else {
        System.out.println("Wrong Browser Entry");
    }
    //open the URL
    driver.get(baseUrl);
    //Maximize the window
    driver.manage().window().maximize();
    //provide implicit wait
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public void closeBrowser(){
    //closign the browser
    driver.quit();
}
}
