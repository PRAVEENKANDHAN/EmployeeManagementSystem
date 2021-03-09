package com.ideas2it.employee.view; 

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Scanner;

import com.ideas2it.employee.controller.EmployeeController;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * EmployeeView Class displays the employee details
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class EmployeeView {
    EmployeeController employeeController = new EmployeeController();
    Scanner scanner = new Scanner(System.in);

    /**
     * employeeOperations method performs basic employee operations
     */     
    public void employeeOperations() {
        System.out.print("*****Employee Management System*****");
        String option = "\n\n1-->Create\n2-->UpdateEmployee"
                + "\n3-->UpdatePermanentAddress\n4-->UpdateTemporaryAddress"
                + "\n5-->Delete\n6-->Display\n7-->DisplayAll\n8-->Exit\n\n"
                + "Please Enter your choice: ";
        int choice = 0;
        while (8 != choice) {
            System.out.print(option);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: 
                    createEmployee();
                    break;
                case 2: 
                    updateEmployee(getEmployeeId());
                    break;
                case 3: 
                    updatePermanentAddress(getEmployeeId(),"Permanent");
                    break;
                case 4: 
                    updateTemporaryAddress(getEmployeeId(),"Temporary");
                    break;
                case 5: 
                    deleteEmployee(getEmployeeId());
                    break;
                case 6:
                    displayEmployee(getEmployeeId());
                    break;
                case 7:
                    displayAllEmployees();
                    break;	
                case 8:
                    System.out.print("Thank you!");
                    break;
                default: 
                    System.out.print("\nPlease enter right choice!\nThank you");
                    choice = 8;
                    break; 
            }
        }
    }

    /**
     * Create method adds a user detail in employee database
     */
    public void createEmployee() {
        String name, emailId, city;
        long mobileNumber; 
        System.out.println("Enter name ");
        name = scanner.nextLine();
        System.out.println("Enter emailId ");
        emailId = isValidEmailId();
        System.out.println("Enter mobileNumber ");
        mobileNumber = Long.parseLong(isValidMobileNumber());
        //scanner.nextLine();
        System.out.println("Enter city ");
        city = scanner.nextLine();
        System.out.println("Enter date of birth(yyyy-MM-dd)");
        Date dateOfBirth = Date.valueOf(isValidDate());
        int id = employeeController.createEmployee(name, emailId, mobileNumber,
       	        city, dateOfBirth);
        System.out.println("Enter your Permanent Address");
        boolean permanentAddress = createAddress(id, "Permanent");
        System.out.println("Enter your Temporary Address");
        boolean temporaryAddress = createAddress(id, "Temporary");
        if (0 != id && (permanentAddress && temporaryAddress)) {
            System.out.println("Employee Details added successfully\n" + 
                "Your employeeId is " + id);
        } else {
            System.out.println("Employee Details adding Failed");
        }
    }
    
    /**
     * Create address method adds a user address in a employee database
     * @param id it contains employee id
     * @param address mode it contains either permanent or temporary address
     */
    boolean createAddress(int id, String addressMode) {
        String doorNumber, streetName, district, state, country;
       	System.out.println("Enter doorNumber ");
        doorNumber = scanner.nextLine();
        System.out.println("Enter streetName ");
        streetName = scanner.nextLine();
        System.out.println("Enter district ");
        district = scanner.nextLine();
        System.out.println("Enter state ");
        state = scanner.nextLine();
        System.out.println("Enter country ");
        country = scanner.nextLine();	
        return employeeController.createAddress(id, doorNumber, streetName,
                district, state, country, addressMode);
    }				
    		
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */
    public void updateEmployee(int employeeId) { 
        String option = "\n\n1-->name\n2-->emailId\n3-->mobileNumber"
                + "\n4-->city\n5-->dateOfBirth\n\nPlease choose the field "
                + "option to update:";
        System.out.print(option);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                updateName(employeeId);
                break;
            case 2: 
                updateEmailId(employeeId);
                break;            
            case 3: 
                updateMobileNumber(employeeId);
                break; 
            case 4: 
                updateCity(employeeId);
                break;
            case 5: 
                updateDateOfBirth(employeeId);
                break; 
            default: 
                System.out.println("Please enter right choice");                
                break;
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */ 
    public void updateName(int employeeId) {
        System.out.println("Enter a name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (employeeController.updateName(employeeId, name)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    } 
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */
    public void updateEmailId(int employeeId) {
        System.out.println("Enter a emailid:");
        scanner.nextLine();
        String emailId = scanner.nextLine();
        if (employeeController.updateEmailId(employeeId, 
                emailId)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }

    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */
    public void updateMobileNumber(int employeeId) {
        System.out.println("Enter a mobileno:");
        long mobileNumber = scanner.nextLong();
        scanner.nextLine();
        if (employeeController.updateMobileNumber(employeeId,
                mobileNumber)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */    
    public void updateCity(int employeeId) {
        System.out.println("Enter a city:");
        scanner.nextLine();
        String city = scanner.nextLine();
        if (employeeController.updateCity(employeeId, city)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
     
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     */      
    public void updateDateOfBirth(int employeeId) {
        System.out.println("Enter a dateOfBirth(yyyy-MM-dd)");
        scanner.nextLine();
        Date dateOfBirth = Date.valueOf(scanner.nextLine());
        if (employeeController.updateDateOfBirth(employeeId,
                dateOfBirth)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */
    public void updatePermanentAddress(int employeeId, String addressMode) { 
        String option = "\n\n1-->doorNumber\n2-->streetName"
                + "\n3-->district\n4-->state\n5-->country\n\nPlease choose the"
                + " field option to update:";
        System.out.print(option);
        int choice = scanner.nextInt();
        switch (choice) {		
            case 1: 
                updateDoorNumber(employeeId, addressMode);
                break;
            case 2: 
                updateStreetName(employeeId, addressMode);
                break;
            case 3: 
                updateDistrict(employeeId, addressMode);
                break;
            case 4: 
                updateState(employeeId, addressMode);
                break;
            case 5: 
                updateCountry(employeeId, addressMode);
                break;
            default: 
                System.out.println("Please enter right choice");                
                break;
        }          
    }

    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */
    public void updateDoorNumber(int employeeId, String addressMode) {
        System.out.println("Enter a doorNumber:");
        scanner.nextLine();
        String doorNumber = scanner.nextLine();
        if (employeeController.updateDoorNumber(employeeId, 
                doorNumber, addressMode)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }            

    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */
    public void updateStreetName(int employeeId, String addressMode) {
        System.out.println("Enter a streetName:");
        scanner.nextLine();
        String streetName = scanner.nextLine();
        if (employeeController.updateStreetName(employeeId,
                streetName, addressMode)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */
    public void updateDistrict(int employeeId, String addressMode) {
        System.out.println("Enter a district:");
        scanner.nextLine();
        String district = scanner.nextLine();
        if (employeeController.updateDistrict(employeeId, 
                district, addressMode)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */  
    public void updateState(int employeeId, String addressMode) {
        System.out.println("Enter a state:");
        scanner.nextLine();
        String state = scanner.nextLine();
        if (employeeController.updateState(employeeId, state, 
                addressMode)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a permanent address
     */
    public void updateCountry(int employeeId, String addressMode) {
        System.out.println("Enter a country:");
        scanner.nextLine();
        String country = scanner.nextLine();
        if (employeeController.updateCountry(employeeId, country, 
                addressMode)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }

    /**
     * Update the existing data based on
     * the given employee id
     * @param employeeId it contains an employeeId
     * @param addressMode it contains a temporary address
     */
    public void updateTemporaryAddress(int employeeId, String addressMode) { 
        String option = "\n\n1-->doorNumber\n2-->streetName"
                + "\n3-->district\n4-->state\n5-->country\n\nPlease choose the"
                + " field option to update:";
        System.out.print(option);
        int choice = scanner.nextInt();
        switch (choice) {		
            case 1: 
                updateDoorNumber(employeeId, addressMode);
                break;
            case 2: 
                updateStreetName(employeeId, addressMode);
                break;
            case 3: 
                updateDistrict(employeeId, addressMode);
                break;
            case 4: 
                updateState(employeeId, addressMode);
                break;
            case 5: 
                updateCountry(employeeId, addressMode);
                break;
            default: 
                System.out.println("Please enter right choice");                
                break;
        }          
    }
    	
    /**
     * Deleting the employee details based on the given
     * employeedId
     */
    public void deleteEmployee(int employeeId) {
        if (employeeController.deleteEmployee(employeeId)) {
            System.out.println("Deleted Successfully");
        } else {
            System.out.println("Deletion failed");
        }
    }   
    
    /**
     *  Displaying the employee details based on the given
     *  employeedId
     */
    public void displayEmployee(int employeeId) { 
        Employee employee = employeeController.getEmployeeDetail(employeeId); 
        Address address = employeeController.getAddress(employeeId);
        if (null != employee && null != address) {
            System.out.println("Id: " +employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("EmailID: " + employee.getEmailId());
            System.out.println("MobileNumber: " + employee.getMobileNumber());
            System.out.println("City: " + employee.getCity());  
            System.out.println("DateOfBirth: " + employee.getDateOfBirth());
            System.out.println("doorNumber: " + address.getDoorNumber());
            System.out.println("streetName: " + address.getStreetName());
            System.out.println("district: " + address.getDistrict());
            System.out.println("state: " + address.getState());  
            System.out.println("country: " + address.getCountry());
            System.out.println("addressMode: " + address.getAddressMode());			
        } else {
            System.out.println("No data to display");
        }
    }

    /**
     *  Displaying all the employees details 
     */
    public void displayAllEmployees() { 
        List<Employee> employeeDetails = 
                employeeController.getEmployeeDetails();
        List<Address> addressDetails = 
                employeeController.getAddressDetails();
        for (Employee employee : employeeDetails) { 
            System.out.println("Id: " +employee.getId());
            System.out.println("Name:" + employee.getName());	
            System.out.println("EmailID:" + employee.getEmailId());	
            System.out.println("MobileNumber:" + employee.getMobileNumber());	
            System.out.println("City:" + employee.getCity());	
            System.out.println("DateOfBirth:" + employee.getDateOfBirth());
        }	
        for (Address address : addressDetails) {
            System.out.println("doorNumber: " + address.getDoorNumber());
            System.out.println("streetName: " + address.getStreetName());
            System.out.println("district: " + address.getDistrict());
            System.out.println("state: " + address.getState());  
            System.out.println("country: " + address.getCountry());
            System.out.println("addressMode: "+ address.getAddressMode());
        }
    }
	
    /**
     * Getting the EmployeeId from the user
     * to perform display and deletion operation
     */
    private int getEmployeeId() {
        System.out.println("Enter your employee id:");
        int employeeId = scanner.nextInt();
        return employeeId;    
    }
	
    /**
     * Validating the emailId 
     * @return it returns the valid emailId
     */
    private String isValidEmailId() {
        String emailId = scanner.nextLine();
        while(! employeeController.isValidEmailId(emailId)) {
            System.out.println("Please enter correct emailId");
            emailId = scanner.nextLine();
            employeeController.isValidEmailId(emailId);
        }   	
        return emailId;	
    }

    /**
     * Validating the mobileNumber
     * @return it returns the valid mobileNumber
     */
    private String isValidMobileNumber() {
        String mobileNumber = scanner.nextLine();       
        while(! employeeController.isValidMobileNumber(mobileNumber)) {
            System.out.println("Please enter correct mobileNumber");
            mobileNumber = scanner.nextLine();
            employeeController.isValidMobileNumber(mobileNumber);
        }
        return mobileNumber;
    }
	
    /**
     * Validating the date
     * @return it returns the valid date
     */
    private String isValidDate() {
        String date = scanner.nextLine();
        while(! employeeController.isValidDate(date)) {
            System.out.println("Please enter correct date");
            date = scanner.nextLine();
            employeeController.isValidDate(date);			
        }    
        return date;		
    }
}