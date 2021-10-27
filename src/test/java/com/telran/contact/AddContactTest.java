package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignOutTabPresent()) {

            click(By.xpath("//a[contains(.,'LOGIN')]"));
            Assert.assertTrue(isLoginRegistrationFormPresent());
            //fill Login form
            type(By.cssSelector("[placeholder='Email']"), "kroos1245@gm.com");
            //submit Login
            type(By.cssSelector("[placeholder='Password']"), "Kroos12345$");
            // Assert user logedIn
            click(By.xpath("//button[contains(.,'Login')]"));
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        // click on tab Add
        click(By.cssSelector("a:nth-child(5)"));
        pause(1000);
        // fill all fields
        type(By.cssSelector("[placeholder='Name']"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        type(By.cssSelector("input:nth-child(3)"), "123456");
        type(By.cssSelector("input:nth-child(4)"), "adam" + i + "@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "torwart");
        // click on the save button

        click(By.cssSelector(".add_form__2rsm2 button"));4
        // Assert contact created


    }

}