package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

@Before
    public void setUp(){
        //Launch the browser and open the URL
        openBrowser(baseUrl);
}

@Test
    public void verifyThatSignInPageDisplay(){
        //find create new account link
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        //verify the text
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).getText();
        System.out.println(actualText);
        Assert.assertNotEquals("Error", expectedText,actualText);
}
@Test
    public void userShouldRegisterAccountSuccessfully(){
        //find Register account element
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        //find firstname element and provide the firstname
        driver.findElement(By.id("firstname")).sendKeys("Orange");
        //find lastname element and provide the lastname
        driver.findElement(By.id("lastname")).sendKeys("Purple");

        //generate random email address for repeat tests
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        //find email address field element and send random email addresses
        driver.findElement(By.id("email_address")).sendKeys("orangepurple"+randomInt+"@gmail.com");

        //find password field element and send password
        driver.findElement(By.id("password")).sendKeys("Orange@purple");
        driver.findElement(By.id("password-confirmation")).sendKeys("Orange@purple");
        //find create an account element link and click
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        //compare actual and expected link names
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[normalize-space()='Thank you for registering with Main Website Store.']")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Error",expectedText,actualText);
        //find down arrow link element and click
        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        //find signout element and click
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        //compare actual and expected messages
        String exptectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        System.out.println(actualText1);
        Assert.assertEquals("Error", exptectedText1,actualText1);
}
@After
    public void tearDown(){
        //close all browsers
        closeBrowser();
}
}

