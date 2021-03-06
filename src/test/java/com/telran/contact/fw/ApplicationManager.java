package com.telran.contact.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    EventFiringWebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomeHelper home;
    HeaderHelper header;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomeHelper getHome() {
        return home;
    }



    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)){
            driver = new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
        }

        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomeHelper(driver);
        header = new HeaderHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
