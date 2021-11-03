package com.telran.contact.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        System.out.println("Site is opened:" + app.getUser().isElementPresent2(By.cssSelector("div:nth-child(2) > div > div")));

        if (!app.getUser().isLoginTabPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void headerLogoTest() {
        app.getHeader().isLogoPresent();
    }


    @Test
    public void headerTabAboutTest() {
        app.getUser().click(By.xpath("//*[contains(.,'ABOUT')]"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".about_main_2Uv5W")));
    }
}

