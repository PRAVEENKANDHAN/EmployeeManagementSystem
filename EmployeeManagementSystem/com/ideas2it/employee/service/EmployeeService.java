package com.ideas2it.employee.service;

import java.sql.Date;
import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * EmployeeService Interface contains the method signature
 * for employee operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public interface EmployeeService {
	
    /**
     * Employee details will be passed into
     * the database
     * @param name it contains employee name
     * @param emailId it contains employee emailId
     * @param mobileNumber it contains employee mobileNumber
     * @param city it contains employee city
     * @param dateOfBirth it contains employee dateOfBirth
     * @return 1 if employee details added successfully
     *         else 0 if employee details added failed
     */   
    public int createEmployee(String name, String emailId,
            long mobileNumber,String city, Date dateOfBirth);
	
    /**
     * Employee address will be inserted into
     * the database
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
      	     String district, String state, String country, String addressMode);     

    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param name
     * @return true if employee name updated successfully
     *         else false if employee name updating failed
     */
    public boolean updateName(int employeeId, String name);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param emailId
     * @return true if employee emailId updated successfully
     *         else false if employee emailId updating failed
     */
    public boolean updateEmailId(int employeeId, String emailId);
	
    /**
     * Updating the existing employee details
     * @param employeeId
     * @param mobileNumber
     * @return true if employee mobileNumber updated successfully
     *         else false if employee mobileNumber updating failed
     */
    public boolean updateMobileNumber(int employeeId, long mobileNumber);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param city
     * @return true if employee city updated successfully
     *         else false if employee city updating failed
     */
	 
    public boolean updateCity(int employeeId, String city);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param dateOfBirth
     * @return true if employee dateOfBirth updated successfully
     *         else false if employee dateOfBirth updating failed
     */
	 
    public boolean updateDateOfBirth(int employeeId, Date dateOfBirth);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param doorNumber
     * @return true if employee doorNumber updated successfully
     *         else false if employee city updating failed
     */
    public boolean updateDoorNumber(int employeeId, String doorNumber,
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param streetName
     * @return true if employee streetName updated successfully
     *         else false if employee streetName updating failed
     */
    public boolean updateStreetName(int employeeId, String streetName,
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param district
     * @return true if employee district updated successfully
     *         else false if employee district updating failed
     */
    public boolean updateDistrict(int employeeId, String district, 
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param state
     * @return true if employee state updated successfully
     *         else false if employee state updating failed
     */
    public boolean updateState(int employeeId, String state,
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param country
     * @return true if employee country updated successfully
     *         else false if employee country updating failed
     */
    public boolean updateCountry(int employeeId, String country, 
            String addressMode);
	
    /**
     * Deleting the employee details based on the given employeedId
     * @param employeedId
     * @return true if employee details deleted successfully
     *         false if employee details deletion failed
     */		 
    public boolean deleteEmployee(int employeeId);   
	
    /**
     * Getting the employee details based on the given employeeId
     * @param employeedId
     * @return employee details
     */	 
    public Employee getEmployeeDetail(int employeeId);   
	
    /**
     * Getting the address of an employee 
     * based on the given employeeId
     * @param employeedId
     * @return employee details
     */	 
    public Address getAddressDetail(int employeeId); 
	
    /**
     * Getting all the employee details
     * @return it returns all the employeeDetails
     */	 
    public List<Employee> getEmployeeDetails();   
	
    /**
     * Getting all the address of an employees
     * @return it returns all the employeeDetails
     */
    public List<Address> getAddressDetails();   
	
    /**
     * Validating the emailId
     * @param emailId it contains a validating emailId
     * @return it returns true if it is a valid emailId
     *         false if it is invalid emailId
     */
    public boolean isValidEmailId(String emailId);		
	
    /**
     * Validating the mobileNumber
     * @param mobileNumber it contains a validating mobileNumber
     * @return it returns true if it is a valid mobileNumber
     *         false if it is invalid mobileNumber
     */
    public boolean isValidMobileNumber(String mobileNumber);		
    
    /**
     * Validating the date
     * @param date it contains a validating date
     * @return it returns true if it is a valid date
     *         false if it is invalid date
     */
    public boolean isValidDate(String date);		
}  