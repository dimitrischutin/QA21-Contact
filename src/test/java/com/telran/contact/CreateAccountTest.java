package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (isLoginTabPresent()) {
            //login not present
            // click on logout button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void registrationPositiveTest() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        type(By.cssSelector("[placeholder='Email']"), "kroos1254@gm.com");

        type(By.cssSelector("[placeholder='Password']"), "Kroos12345$");

        click(By.xpath("//button[contains(.,'Registration')]"));
        Assert.assertTrue(isSignOutTabPresent());
    }


}
