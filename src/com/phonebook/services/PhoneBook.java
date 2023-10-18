package com.phonebook.services;

import java.util.*;
import com.phonebook.model.Contact;
import com.phonebook.exceptions.*;

public class PhoneBook {
	private static Map<String,Contact> phoneBook = new HashMap<>();
	
	public static Map<String, Contact> getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(Map<String, Contact> phoneBook) {
		PhoneBook.phoneBook = phoneBook;
	}

	
	//ADD CONTACTS
	
	public void addContact() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println(" ");
			System.out.print("Enter name: ");
			String name = sc.nextLine().toLowerCase();
			Validate val = new Validate();
			val.validateName(name);		       			
			System.out.print("Enter phone number: ");
			String phoneNumber = sc.nextLine();
			val.validatePhoneNumber(phoneNumber);
			
			Contact newContact = new Contact(name,phoneNumber);
			phoneBook.put(name, newContact);
			System.out.println("New Contact added : "+newContact);
			
		}
		catch(InvalidNameException e) {
			System.out.println("Error - " + e.getMessage());
		}
		catch(InvalidPhoneNumberException e) {
			System.out.println("Error - " + e.getMessage());
		}

	}
	
	// SEARCH CONTACT BY NAME
	
	public void searchContactByName(String findName) {
		Contact contact = phoneBook.get(findName);
		System.out.println("Contact found: "+ contact); 
	}
	
	// SEARCH CONTACT BY PHONE NUMBER
	
	public void searchContactByPhoneNumber(String findPhoneNumber) {
		boolean found=false;
		Contact matchedContact=null;
		for(Map.Entry<String, Contact> entry : phoneBook.entrySet()) {
			matchedContact = entry.getValue();
			if(matchedContact.getPhoneNumber().equals(findPhoneNumber)) {
				found=true; 
			}
		}
		if(found==true)
			System.out.println("Contact found: "+ matchedContact);
		else
			System.out.println("Contact not found !");
	}
	
	// UPDATE NAME
	
	public void updateName(String name,String newName) {
		try {
			Validate val = new Validate();
			val.validateName(newName);
			
			if(phoneBook.containsKey(name)) {
				Contact contact = phoneBook.get(name);
				String phoneNumber = contact.getPhoneNumber();
	            phoneBook.remove(name);
	            Contact updatedContact = new Contact(newName,phoneNumber);
	            phoneBook.put(newName, updatedContact);
				System.out.println("Name Updated:" + updatedContact);
			}
			else {
				System.out.println("Contact not found");
			}
		}
		catch(InvalidNameException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// UPDATE PHONE NUMBER
	
	public void updatePhoneNumber(String name,String newPhoneNumber) {
		try {
			Validate val = new Validate();
			val.validatePhoneNumber(newPhoneNumber);
			
			if(phoneBook.containsKey(name)) {
				Contact contact = phoneBook.get(name);
				contact.setPhoneNumber(newPhoneNumber);
				System.out.println("PhoneNumber Updated: "+contact);
			}
			else {
				System.out.println("Contact not found");
			}
		}
		catch(InvalidPhoneNumberException e) {
			System.out.println("Error - " + e.getMessage());
		}
		
	}
	
	// DELETE CONTACT
	
	public void deleteContact(String name) {
		if (phoneBook.containsKey(name)) {
            Contact contact = phoneBook.get(name);
            phoneBook.remove(name);
            System.out.println("Contact deleted: " + contact);
        } 
		else 
            System.out.println("Contact not found.");
	}
	
	// DISPLAY ALL CONTACTS
	
	public void displayContacts() {
		for(Map.Entry<String, Contact> entry : phoneBook.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
