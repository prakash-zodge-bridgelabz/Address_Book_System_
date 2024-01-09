package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Use case 9, test case:
// Ability to view Persons by City or State
// - Maintain Dictionary of City and Person as well as State and Person
// - Use Collection Library to maintain Dictionary
// - Use Java Streams
public class Test_Address_Book_System {
    ArrayList<Contact> allContacts = new ArrayList<>();
    Contact prakash,nikhil,mrinal,pavan,c;
    @Before
    public void init(){
        prakash = new Contact("Prakash","Zodge","N-5","Aurangabad",
                "Maharashtra","prakash.zodge.bridgelabz@gmail.com",
                "9876543210",431003);
        nikhil = new Contact("Nikhil","Namdev","N-6","Aurangabad",
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
        // Create a collection to store persons
        Map<String, Contact> cityPersonMap = new HashMap<>();
        cityPersonMap.put(prakash.getCity(),prakash);
        cityPersonMap.put(nikhil.getCity(),nikhil);
        cityPersonMap.put(mrinal.getCity(),mrinal);
        cityPersonMap.put(pavan.getCity(),pavan);
        c.setCityPersonMap(cityPersonMap);
        Map<String, Contact> statePersonMap = new HashMap<>();
        statePersonMap.put(prakash.getState(),prakash);
        statePersonMap.put(nikhil.getState(),nikhil);
        statePersonMap.put(mrinal.getState(),mrinal);
        statePersonMap.put(pavan.getState(),pavan);
        c.setStatePersonMap(statePersonMap);
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
    // Use case 8, test case:
    // Ability to search Person in a City or State across the multiple AddressBook
    // Search Result can show multiple person in the city or state
    // Use Java Streams
    @Test
    public void test_searchPersonUsingCityOrState(){
        String actual = c.searchPersonUsingCityOrState("Aurangabad");
        String expected = "Contact{First Name ='Prakash', Last Name ='Zodge', Address ='N-5', City ='Aurangabad', State ='Maharashtra', Email ='prakash.zodge.bridgelabz@gmail.com', Phone Number ='9876543210', Zip Code =431003}" +
                "Contact{First Name ='Nikhil', Last Name ='Namdev', Address ='N-6', City ='Aurangabad', State ='Maharashtra', Email ='nikhil@gmail.com', Phone Number ='9988776655', Zip Code =431004}";
        Assert.assertEquals(expected,actual);
    }
    // Use case 9, test case:
    // Ability to view Persons by City or State
    // - Maintain Dictionary of City and Person as well as State and Person
    // - Use Collection Library to maintain Dictionary
    // - Use Java Streams
    @Test
    public void test_personsByCity(){
        List<String> actual = c.viewPersonByCity("Aurangabad");
        List<String> contactNames = new ArrayList<>();
        contactNames.add("Nikhil");
        Assert.assertEquals(contactNames,actual);
    }
    @Test
    public void test_personsByState(){
        List<String> actual = c.viewPersonByState("Maharashtra");
        List<String> contactNames = new ArrayList<>();
        contactNames.add("Pavan");
        contactNames.add("Nikhil");
        Assert.assertEquals(contactNames,actual);
    }
}
