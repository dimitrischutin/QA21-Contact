package com.telran.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (isLoginTabPresent()) {
            //login not present
            // click on logout button
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test

    public void loginRegisteredUserPositiveTest() {
        //click on logit tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "kroos1245@gm.com");
        //submit Login
        type(By.cssSelector("[placeholder='Password']"), "Kroos12345$");
        // Assert user logedIn
        click(By.xpath("//button[contains(.,'Registration')]"));
        Assert.assertTrue(isSignOutTabPresent());
    }

    @Test

    public void loginRegisteredUserNegativeWithWrongPasswordTest() {
        //click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "kroos1245@gm.com");
        //submit Login
        type(By.cssSelector("[placeholder='Password']"), "Kroos12345");
        // Assert user logedIn
        click(By.xpath("//button[contains(.,'Registration')]"));
        Assert.assertTrue(isAlertPresent());
    }

}
