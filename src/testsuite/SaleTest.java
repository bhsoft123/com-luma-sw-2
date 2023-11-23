package testsuite;

//List of WebElements and display the list

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        //Find Sale element on Top menu bar and click
        driver.findElement(By.xpath("//span[normalize-space()='Sale']")).click();
        //Find Jackets link Element and click
        driver.findElement(By.xpath("//ul[@class='items']//a[contains(text(),'Jackets')]")).click();
        //Compare actual and expected texts for Jackets
        String expectedText = "Jackets";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Error",expectedText,actualText1);

        //Find number of items per page element and print total number
        List<WebElement> numberOfDisplayedItems = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println("Total: " +numberOfDisplayedItems.size());
        //Find each items displayed element and print each item
        List<WebElement> linkeditems = driver.findElements(By.tagName("ol"));
        System.out.println("total number of items:" +linkeditems.size());
        for( WebElement link : linkeditems){
           System.out.println("linked text: "+link.getText());
        }
        //Verify expected and actual number of items displayed per page
        int exptectedNumberOfItems = 12;
        int actualNumberOfItems = numberOfDisplayedItems.size();
        Assert.assertEquals("Error", exptectedNumberOfItems,actualNumberOfItems);
    }

    @After
    public void tearDown(){
        //Close all browsers
        closeBrowser();
    }
}
