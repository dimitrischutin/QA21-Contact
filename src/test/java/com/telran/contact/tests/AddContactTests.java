package com.telran.contact.tests;

import com.telran.contact.fw.DataProviders;
import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {



    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("kroosss@gm.com")
                    .setPassword("Kroos12345~12"));
        }
    }



    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Karl").setSurName("Adam").setPhone("12345" + i).setEmail("adam" + i + "@gm.com").setAddress("Koblenz").setDescription("torwart"));
        //   click(By.cssSelector(".add_form__2rsm2 button"));
        //Assert contact created
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));

    }

    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String sName, String phone, String email, String add, String des) {

        app.getContact().addNewContact(new Contact().setName(name).setSurName(sName).setPhone(phone).setEmail(email).setAddress(add).setDescription(des));

        app.getContact().removeContact();
        
    }

    @Test(dataProvider = "newContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveCSVTest(Contact contact) throws InterruptedException {

        app.getContact().addNewContact(contact);

        app.getContact().removeContact();
        Thread.sleep(2000);

    }
}