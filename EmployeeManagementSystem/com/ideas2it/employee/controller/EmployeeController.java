package com.ideas2it.employee.controller; 

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employee.view.EmployeeView;

/**
 * EmployeeController Class peforms the basic operations of employee
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class EmployeeController {        
    EmployeeService employeeService = new EmployeeServiceImpl();
    
    /**
     * Inserting the employee details
     * @param name it contains employee name
     * @param emailId it contains employee emailId
     * @param mobileNumber it contains employee mobileNumber
     * @param city it contains employee city
     * @param dateOfBirth it contains employee dateofbirth
     * @return 1 if employee details added successfully
     *         else 0 if employee details added failed
     */
    public int createEmployee(String name, String emailId, long mobileNumber,
            String city, Date dateOfBirth) {
        return employeeService.createEmployee(name, emailId,mobileNumber,
                city, dateOfBirth);
    }
	
    /**
     * Inserting employee address
     * @param id it contains employeeId
     * @param doorNumber it contains employee doorNumber
     * @param streetName it contains employee streetName
     * @param district it contains employee district
     * @param state it contains employee state
     * @param country it contains employee country
     * @return true if employee details added successfully
     *         else false if employee details added failed
     */
    public boolean createAddress(int id, String doorNumber, String streetName,
     	      String district, String state, String country, 
              String addressMode) {
        return employeeService.createAddress(id, doorNumber, 
		    streetName, district, state, country, addressMode);
    }
	
    /**
     * Updating the existing employee name
     * @param employeeId it contains the employeeId
     * @param name it contains employeeName
     * @return true if employee name updated successfully
     *         else false if employee name updating failed
     */
    public boolean updateName(int employeeId, String name) {
        return employeeService.updateName(employeeId, name);
    }

    /**
     * Updating the existing employee emailId
     * @param employeeId it contains the employeeId
     * @param emailId
     * @return true if employee emailId updated successfully
     *         else false if employee emailId updating failed
     */
    public boolean updateEmailId(int employeeId, String emailId) {
        return employeeService.updateEmailId(employeeId, emailId);
    }

    /**
     * Updating the existing employee mobileNumber 
     * @param employeeId it contains the employeeId
     * @param mobileNumber
     * @return true if employee mobileNumber updated successfully
     *         else false if employee mobileNumber updating failed
     */ 
    public boolean updateMobileNumber(int employeeId, long mobileNumber) {
        return employeeService.updateMobileNumber(employeeId, mobileNumber);
    }

    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param city
     * @return true if employee city updated successfully
     *         else false if employee city updating failed
     */
    public boolean updateCity(int employeeId, String city) {
        return employeeService.updateCity(employeeId, city);
    }

    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param dateOfBirth
     * @return true if employee dateOfBirth updated successfully
     *         else false if employee dateOfBirth updating failed
     */
    public boolean updateDateOfBirth(int employeeId, Date dateOfBirth) {
        return employeeService.updateDateOfBirth(employeeId,
                dateOfBirth);
    }
 
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param doorNumber
     * @return true if employee doorNumber updated successfully
     *         else false if employee city updating failed
     */
    public boolean updateDoorNumber(int employeeId, String doorNumber, 
            String addressMode) {
        return employeeService.updateDoorNumber(employeeId, doorNumber, 
                addressMode);
    } 
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param streetName
     * @return true if employee streetName updated successfully
     *         else false if employee streetName updating failed
     */
    public boolean updateStreetName(int employeeId, String streetName, 
            String addressMode) {
        return employeeService.updateStreetName(employeeId, streetName, 
                addressMode);
    }
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param district
     * @return true if employee district updated successfully
     *         else false if employee district updating failed
     */
    public boolean updateDistrict(int employeeId, String district, 
            String addressMode) {
        return employeeService.updateDistrict(employeeId, district, 
                addressMode);
    }
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param state
     * @return true if employee state updated successfully
     *         else false if employee state updating failed
     */
    public boolean updateState(int employeeId, String state, 
            String addressMode) {
        return employeeService.updateState(employeeId, state, addressMode);
    }
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param country
     * @return true if employee country updated successfully
     *         else false if employee country updating failed
     */
    public boolean updateCountry(int employeeId, String country, 
            String addressMode) {
        return employeeService.updateCountry(employeeId, country, addressMode);
    }
	
    /**
     * Deleting the employee details 
     * @param employeeId it contains the employeeId
     * @return true if employee details deleted successfully
     *         false if employee details deletion failed
     */
    public boolean deleteEmployee(int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    /**
     * Getting the employee details
     * @param employeeId it contains the employeeId
     */
    public Employee getEmployeeDetail(int employeeId) {
        return employeeService.getEmployeeDetail(employeeId);          
    }   
	
    /**
     * Getting the address details of an employee
     * @param employeeId it contains the employeeId
     */
    public Address getAddress(int employeeId) {
        return employeeService.getAddressDetail(employeeId);          
    }
	
    /**
     * Getting all the employee details
     */
    public List<Employee> getEmployeeDetails() {
        return employeeService.getEmployeeDetails();          
    }
	
    /**
     * Getting all the address details
     */
    public List<Address> getAddressDetails() {
        return employeeService.getAddressDetails();          
    }
	
    /**
     * Validating the emailId
     * @param emailId it contains a validating emailId
     * @return it returns true if it is a valid emailId
     *         false if it is invalid emailId
     */
    public boolean isValidEmailId(String emailId) {
        return employeeService.isValidEmailId(emailId); 
    }
	
    /**
     * Validating the mobileNumber
     * @param mobileNumber it contains a validating mobileNumber
     * @return it returns true if it is a valid mobileNumber
     *         false if it is invalid mobileNumber
     */
    public boolean isValidMobileNumber(String mobileNumber) {
        return employeeService.isValidMobileNumber(mobileNumber); 
    }
	
    /**
     * Validating the date
     * @param date it contains a validating date
     * @return it returns true if it is a valid date
     *         false if it is invalid date
     */
    public boolean isValidDate(String date) {
        return employeeService.isValidDate(date); 
    }	
}   

