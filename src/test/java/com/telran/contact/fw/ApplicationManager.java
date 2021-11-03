package com.telran.contact.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomeHelper getHome() {
        return home;
    }

    WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomeHelper home;
    HeaderHelper header;

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomeHelper(driver);
        header = new HeaderHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
