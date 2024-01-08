package com.bridgelabz;

import java.util.ArrayList;

// Use case 7:
// Ability to ensure there is no Duplicate Entry of the same Person in a particular Address Book
// Duplicate Check is done on Person Name while adding person to Address Book.
// Use Collection Methods to Search Person by Name for Duplicate Entry Override equals method
// to check for Duplicate
// Use Java Streams
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
