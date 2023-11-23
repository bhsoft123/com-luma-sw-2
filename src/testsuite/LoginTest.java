package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

@Before
public void setUp(){
    //launch browser and open URL
    openBrowser(baseUrl);
}

@Test
public void userShouldLoginSuccessullyWithValidCredentials(){
    //Find Signin Link Element and click
    driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
    //Find Email Field Element and type valid email address
    driver.findElement(By.id("email")).sendKeys("orangepurple@gmail.com");
    //Find Password Field Element and type valid password
    driver.findElement(By.id("pass")).sendKeys("Orange@purple");
    //Find Sign in button element and click
    driver.findElement(By.id("send2")).click();
    //Compare actual and expected display messages
    String expectedText = "Welcome, Orange Purple!";
    String actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Orange Purple!']")).getText();
    Assert.assertEquals("Error", expectedText,actualText);
}
@Test
public void verifyTheErrorMessageWithInvalidCredentials(){
    //find Sign in link element and click
    driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")).click();
    //Find Email address Field and type Invalid Email address
    driver.findElement(By.id("email")).sendKeys("orangepurple1@gmail.com");
    //Find Password Field element and type Invalid Password
    driver.findElement(By.id("pass")).sendKeys("Orange@purple1");
    //Find Signin Button element and click
    driver.findElement(By.id("send2")).click();
    //Compare actual and expected display messages
    String expectedText1 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later";
    String actualText1 = driver.findElement(By.xpath("//div[text()='The account sign-in was " +
            "incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
    Assert.assertNotEquals("Error",expectedText1,actualText1);
}

@Test
public void userShouldLogoutSuccessfully(){
    //Find Signin link element and click
    driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
    //Find Email field element and type Valid email address
    driver.findElement(By.id("email")).sendKeys("orangepurple@gmail.com");
    //Find Password Field element and type Valid password
    driver.findElement(By.id("pass")).sendKeys("Orange@purple");
    //Find Signin Button element and click
    driver.findElement(By.id("send2")).click();
    String expectedText = "Welcome";
    String actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Orange Purple!']")).getText();
    Assert.assertNotEquals("Error",expectedText,actualText);
    //Find down arrow element and click
    driver.findElement(By.xpath("//button[@type='button']")).click();
    //Find SignOut Link element and click
    driver.findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
    String expectedText1 = "You are signed out";
    String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
    Assert.assertEquals("Error",expectedText1,actualText1);
}
@After
public void tearDown(){
    //close all browsers
    closeBrowser();
}
}
