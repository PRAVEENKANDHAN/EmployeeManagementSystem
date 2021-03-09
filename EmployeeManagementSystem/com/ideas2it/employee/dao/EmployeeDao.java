package com.ideas2it.employee.dao;

import java.sql.Date;
import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * EmployeeDao Interface contains the implementation
 * method signature
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public interface EmployeeDao {
	
    /**
     * Employee details will be inserted 
     * into the database
     * @param name it contains employee name
     * @param emailId it contains employee emailId
     * @param mobileNumber it contains employee mobileNumber
     * @param city it contains employee city
     * @param dateOfBirth it contains employee dateOfBirth
     */
    public int createEmployee(Employee employee);
    
    /**
     * Employee address will be inserted into 
     * the database
     * @return true if employee details added successfully
     *         else false if employee details added failed
     */
    public boolean createAddress(Address address);     

    /**
     * Updating the existing employee details 
     * @return true if employee name updated successfully
     *         else false if employee name updating failed
     */
    public boolean updateName(int employeeId, Employee employee);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param emailId
     * @return true if employee emailId updated successfully
     *         else false if employee emailId updating failed
     */
    public boolean updateEmailId(int employeeId, Employee employee);
	
    /**
     * Updating the existing employee details
     * @param employeeId
     * @param mobileNumber
     * @return true if employee mobileNumber updated successfully
     *         else false if employee mobileNumber updating failed
     */
    public boolean updateMobileNumber(int employeeId, Employee employee);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param city
     * @return true if employee city updated successfully
     *         else false if employee city updating failed
     */
	 
    public boolean updateCity(int employeeId, Employee employee);
	
    /**
     * Updating the existing employee details 
     * @param employeeId
     * @param dateOfBirth
     * @return true if employee dateOfBirth updated successfully
     *         else false if employee dateOfBirth updating failed
     */
	 
    public boolean updateDateOfBirth(int employeeId, Employee employee);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param doorNumber
     * @return true if employee doorNumber updated successfully
     *         else false if employee city updating failed
     */
    public boolean updateDoorNumber(int employeeId, Address address, 
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param streetName
     * @return true if employee streetName updated successfully
     *         else false if employee streetName updating failed
     */
    public boolean updateStreetName(int employeeId, Address address, 
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param district
     * @return true if employee district updated successfully
     *         else false if employee district updating failed
     */
    public boolean updateDistrict(int employeeId, Address address, 
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param state
     * @return true if employee state updated successfully
     *         else false if employee state updating failed
     */
    public boolean updateState(int employeeId, Address address, 
            String addressMode);
	
    /**
     * Updating the existing employee details 
     * @param employeeId it contains the employeeId
     * @param country
     * @return true if employee country updated successfully
     *         else false if employee country updating failed
     */
    public boolean updateCountry(int employeeId, Address address,
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
}  