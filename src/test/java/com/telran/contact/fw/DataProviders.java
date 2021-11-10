package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newContact() throws FileNotFoundException {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "0896665544", "kann@gm.com", "Munich", "Manager"});
        list.add(new Object[]{"Oliver", "Kan", "0896665511", "kanna@gm.com", "Munich", "Manager"});
        list.add(new Object[]{"Oliver", "Kan", "0896665522", "kannb@gm.com", "Munich", "Manager"});

        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> newContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();


        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/Contacts.csv")));
        String line = reader.readLine();

        while (line!=null){

            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setSurName(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.listIterator();
    }
}
