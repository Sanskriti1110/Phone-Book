package com.phonebook.tester;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.phonebook.exceptions.InvalidNameException;
import com.phonebook.exceptions.InvalidPhoneNumberException;
import com.phonebook.services.PhoneBook;
import com.phonebook.services.Validate;

public class Menu {
	
public static void main(String[] args) throws InvalidNameException, InvalidPhoneNumberException {
		
		PhoneBook pb = new PhoneBook();
        Scanner sc = new Scanner(System.in);

        while (true) {
        	System.out.println(" ");
            System.out.println("PhoneBook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.print("Enter your choice: ");
            
            int choice = 0;
            try {
            	choice = sc.nextInt();
                sc.nextLine();
            }
            catch(InputMismatchException e) {
            	System.out.println("Invalid input. Please enter a valid choice (a number)");
            	sc.nextLine();
            	continue;
            }      
            
            switch (choice) {
                case 1:
                	pb.addContact();
                    break;
                    
                case 2:
                	System.out.println(" ");
                	System.out.println("1. Search Contact By Name");
                	System.out.println("2. Search Contact By PhoneNumber");
                	System.out.println(" ");
                	System.out.print("Enter your choice: ");  
                	
                	int option1 = 0;

                	try {
                    	option1 = sc.nextInt();
                        sc.nextLine();
                    }
                    catch(InputMismatchException e) {
                    	System.out.println("Invalid input. Please enter a valid choice (a number)");
                    	sc.nextLine();
                    	continue;
                    }    
                    
                    switch (option1) {
                    case 1:
                    	System.out.println(" ");
                    	System.out.print("Enter name to search: ");
                    	String findName = sc.nextLine().toLowerCase();
                    	pb.searchContactByName(findName);
                    	break;
                    	
                    case 2:
                    	System.out.println(" ");
                    	System.out.print("Enter phoneNumber to search: ");
                    	String findPhoneNumber = sc.nextLine();
                    	pb.searchContactByPhoneNumber(findPhoneNumber);
                    	break;
                    	
                    default:
                    	System.out.println(" ");
                        System.out.println("Invalid choice. Please try again.");
                        break;                 
                    } 
                    break;
                    
                case 3:
                	System.out.println(" ");
                	System.out.println("1. Update Name");
                	System.out.println("2. Update Phone Number");
                	System.out.println(" ");
                	System.out.print("Enter your choice: ");
                	
                	int option2 = 0;

                	try {
                    	option2 = sc.nextInt();
                        sc.nextLine();
                    }
                    catch(InputMismatchException e) {
                    	System.out.println("Invalid input. Please enter a valid choice (a number)");
                    	sc.nextLine();
                    	continue;
                    }    
                    
                    switch (option2) {
                    case 1:
                    	System.out.println(" ");
                    	System.out.print("Enter Name of the contact you want to update: ");
                        String oldName = sc.nextLine().toLowerCase();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                    	pb.updateName(oldName,newName);
                    	break;
                    	
                    case 2:
                    	System.out.println(" ");
                    	System.out.print("Enter Name of the contact whose number you want to update: ");
                        String name2 = sc.nextLine().toLowerCase();
                    	System.out.print("Enter New Phone Number: ");
                    	String newPhoneNumber = sc.nextLine();
                    	pb.updatePhoneNumber(name2, newPhoneNumber);
                    	break;
                    	
                    default:
                    	System.out.println(" ");
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }    
                    break;
                    
                case 4:
                	System.out.println(" ");
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    pb.deleteContact(deleteName);
                    break;
                    
                case 5:
                	pb.displayContacts();
                	break;
                    
                case 6:
                	System.out.println(" ");
                    System.out.println("Exiting PhoneBook");
                    System.exit(0);
                    break;
                    
                default:
                	System.out.println(" ");
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
	}
}
