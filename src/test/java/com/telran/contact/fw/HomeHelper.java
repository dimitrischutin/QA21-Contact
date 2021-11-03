package com.telran.contact.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends HelperBase {

    public HomeHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2) > div > div")).size() > 0;
    }
}
