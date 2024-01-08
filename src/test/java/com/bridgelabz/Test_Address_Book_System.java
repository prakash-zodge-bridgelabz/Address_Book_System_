package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

// Use case 7:
// Ability to ensure there is no Duplicate Entry of the same Person in a particular Address Book
// Duplicate Check is done on Person Name while adding person to Address Book.
// Use Collection Methods to Search Person by Name for Duplicate Entry Override equals method
// to check for Duplicate
// Use Java Streams
public class Test_Address_Book_System {
    ArrayList<Contact> allContacts = new ArrayList<>();
    Contact prakash,nikhil,mrinal,pavan,c;
    @Before
    public void init(){
        prakash = new Contact("Prakash","Zodge","N-5","Aurangabad",
                "Maharashtra","prakash.zodge.bridgelabz@gmail.com",
                "9876543210",431003);
        nikhil = new Contact("Nikhil","Namdev","N-6","Belapur",
                "Maharashtra","nikhil@gmail.com","9988776655",
                431004);
        mrinal = new Contact("Mrinal","Keshav","N-7","Patna",
                "Bihar","mrinal@gmail.com","9998887776",
                431005);
        pavan = new Contact("Pavan","Zore","N-8","Gangapur",
                "Maharashtra","pavan@@gmail.com","9999888876",
                431006);
        allContacts.add(prakash);
        allContacts.add(nikhil);
        allContacts.add(mrinal);
        allContacts.add(pavan);
        c = new Contact();
        c.setAllContacts(allContacts);
    }
    @Test
    public void test_ensureNoDuplicate(){
        Contact himanshu = new Contact("Prakash","Zodge","N-5","Aurangabad",
                "Maharashtra","prakash.zodge.bridgelabz@gmail.com",
                "9876543210",431003);
        String expected = himanshu.first_name+" : Contact is already present in allContacts list";
        String actual = c.addContact(himanshu);
        Assert.assertEquals(expected,actual);
    }
}
