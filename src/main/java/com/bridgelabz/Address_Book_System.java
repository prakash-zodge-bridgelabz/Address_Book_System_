package com.bridgelabz;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Use case 12:
// Ability to sort the entries in the address book by City, State, or Zip
// - Write functions to sort person by City, State or Zip
// - Use Collection Library for Sorting
// - Use Java Streams
class Contact{
    String first_name,last_name,address,city,state,email,phone_number;
    int zip;
    Contact(String first_name,String last_name,String address,String city,
            String state, String email, String phone_number, int zip){
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone_number = phone_number;
        this.zip = zip;
    }
    Contact(){
        //this constructor is created for calling setAllContacts function
    }
    ArrayList<Contact> allContacts = new ArrayList<>();
    void setAllContacts(ArrayList<Contact> allContacts){
        this.allContacts = allContacts;
    }
    //Sorted all contacts by their first name
    String sortedAllContacts(){
        ArrayList<Contact> sortedAllContacts = new ArrayList<>();
        sortedAllContacts = allContacts;
        sortedAllContacts.sort((o1, o2) ->
                o1.getFirst_name().compareTo(o2.getFirst_name()));
        String temp="";
        for(Contact c: sortedAllContacts){
            temp = temp.concat(c.toString());
        }
        return temp;
    }
    // Ability to sort the entries in the address book by City, State, or Zip
    // - Write functions to sort person by City, State or Zip
    String sortedByCity(){
        ArrayList<Contact> sortedAllContacts = new ArrayList<>();
        sortedAllContacts = allContacts;
        sortedAllContacts.sort((o1, o2) ->
                o1.getCity().compareTo(o2.getCity()));
        String temp="";
        for(Contact c: sortedAllContacts){
            temp = temp.concat(c.toString());
        }
        return temp;
    }
    String sortedByState(){
        ArrayList<Contact> sortedAllContacts = new ArrayList<>();
        sortedAllContacts = allContacts;
        sortedAllContacts.sort((o1, o2) ->
                o1.getState().compareTo(o2.getState()));
        String temp="";
        for(Contact c: sortedAllContacts){
            temp = temp.concat(c.toString());
        }
        return temp;
    }
    // Create a collection to store persons
    Map<String, Contact> cityPersonMap = new HashMap<>();
    void setCityPersonMap(Map<String, Contact> cityPersonMap){
        this.cityPersonMap = cityPersonMap;
    }
    Map<String, Contact> statePersonMap = new HashMap<>();
    void setStatePersonMap(Map<String, Contact> statePersonMap){
        this.statePersonMap = statePersonMap;
    }
    // View persons by city
    List<String> viewPersonByCity(String city){
        List<String> contactNames = new ArrayList<>();
        contactNames= cityPersonMap.values().stream()
                .filter(contact -> contact.getCity().equals(city))
                .map(Contact::getFirst_name)
                .collect(Collectors.toList());
        return contactNames;
    }
    // Ability to get number of contact persons i.e. count by City or State
    // - Search Result will show count by city and by state
    int getCountByCity(String city){
        List<String> contactNames = new ArrayList<>();
        contactNames= cityPersonMap.values().stream()
                .filter(contact -> contact.getCity().equals(city))
                .map(Contact::getFirst_name)
                .collect(Collectors.toList());
        int count = 0;
        for(String c: contactNames){
            count++;
        }
        return count;
    }
    int getCountByState(String state){
        List<String> contactNames = new ArrayList<>();
        contactNames= cityPersonMap.values().stream()
                .filter(contact -> contact.getState().equals(state))
                .map(Contact::getFirst_name)
                .collect(Collectors.toList());
        int count = 0;
        for(String c: contactNames){
            count++;
        }
        return count;
    }
    // View persons by state
    List<String>  viewPersonByState(String state){
        List<String> contactNames = new ArrayList<>();
        contactNames= cityPersonMap.values().stream()
                .filter(contact -> contact.getState().equals(state))
                .map(Contact::getFirst_name)
                .collect(Collectors.toList());
        return contactNames;
    }
    // Search person using city or state
    String searchPersonUsingCityOrState(String cityOrState){
        ArrayList<Contact> filteredContacts = new ArrayList<>();
        allContacts.stream()
                .filter(p->p.getCity().equals(cityOrState)
                        | p.getState().equals(cityOrState))
                .forEach(filteredContacts::add);
        String temp="";
        for(Contact c: filteredContacts){
            temp = temp.concat(c.toString());
        }
        System.out.println(temp);
        return temp;
    }
    String addContact(Contact obj){
        Contact tempContact = allContacts.stream()
                .filter(p->p.getFirst_name().equals(obj.first_name))
                .findFirst()
                .orElse(null);
        if(tempContact != null){    //Contact is already present in the allContacts list
            return (tempContact.first_name+" : Contact is already present in allContacts list");
        }
        else{   //Executes when contact not present in the allContacts list
            allContacts.add(obj);
            return (obj.first_name+" : Contact is added successfully...");
        }
    }
    public String getFirst_name() {                 return first_name;              }
    public void setFirst_name(String first_name) {  this.first_name = first_name;   }
    public String getLast_name() {                  return last_name;               }
    public void setLast_name(String last_name) {    this.last_name = last_name;     }
    public String getAddress() {                    return address;                 }
    public void setAddress(String address) {        this.address = address;         }
    public String getCity() {                       return city;                    }
    public void setCity(String city) {              this.city = city;               }
    public String getState() {                      return state;                   }
    public void setState(String state) {            this.state = state;             }
    public String getEmail() {                      return email;                   }
    public void setEmail(String email) {            this.email = email;             }
    public String getPhone_number() {               return phone_number;            }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number;    }
    public int getZip() {                           return zip;                     }
    public void setZip(int zip) {                   this.zip = zip;                 }
    @Override
    public String toString() {
        return "Contact{" +
                "First Name ='" + first_name + '\'' +
                ", Last Name ='" + last_name + '\'' +
                ", Address ='" + address + '\'' +
                ", City ='" + city + '\'' +
                ", State ='" + state + '\'' +
                ", Email ='" + email + '\'' +
                ", Phone Number ='" + phone_number + '\'' +
                ", Zip Code =" + zip +
                '}';
    }
}
public class Address_Book_System {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
    }
}
