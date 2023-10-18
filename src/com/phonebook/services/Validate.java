package com.phonebook.services;

import java.util.Map;

import com.phonebook.exceptions.InvalidNameException;
import com.phonebook.exceptions.InvalidPhoneNumberException;
import com.phonebook.model.Contact;

public class Validate {
	public void validateName(String name) throws InvalidNameException {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("Name cannot be empty or consist of only whitespace.");
        }
		if (!name.matches("^[a-zA-Z\\s]*$")) {
	        throw new InvalidNameException("Name can only contain alphabets (A-Z or a-z).");
	    }
		String[] nameParts = name.split(" ");
	    if (nameParts.length < 2) {
	        throw new InvalidNameException("Name should have a first-name and a last-name.");
	    }
	    if (PhoneBook.getPhoneBook().containsKey(name)) {
	        throw new InvalidNameException("Contact with the same name already exists. Please choose a different name.");
	    }
	}
	
	public void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new InvalidPhoneNumberException("Phone number cannot be empty or consist of only whitespace.");
        }
		if(!phoneNumber.matches("^[\\d]{10}$")) {
			throw new InvalidPhoneNumberException("Number should be of 10 digits");
		}

		for(Map.Entry<String, Contact> entry : PhoneBook.getPhoneBook().entrySet()) {
			if(entry.getValue().getPhoneNumber().equals(phoneNumber)) {
				throw new InvalidPhoneNumberException("Phone number is already associated with another contact.");
			}
		}
		
	}
}
