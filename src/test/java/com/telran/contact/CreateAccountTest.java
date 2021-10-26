package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPresend(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //login not present
            // click on logout button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void registrationPositiveTest() {
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresend(By.cssSelector(".login_login__3EHKB")));

        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("kroos12@gm.com");

        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Kroos12345$");

        driver.findElement(By.xpath("//button[contains(.,'Registration')]")).click();
        Assert.assertTrue(isElementPresend(By.xpath("//button[contains(.,'Sign Out')]")));
    }
// click on Login
// fill registration form
// click in Registration button
// check Logout button displayed


}
