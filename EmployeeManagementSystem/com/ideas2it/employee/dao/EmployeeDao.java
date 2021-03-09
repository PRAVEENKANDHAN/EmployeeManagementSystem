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
     * @return true if employee details updated successfully
     *         else false if employee name updating failed
     */
    public boolean updateEmployee(int employeeId, Employee employee);

    /**
     * Updating the existing employee address
     * @return true if employee details updated successfully
     *         else false if employee name updating failed
     */
    public boolean updateAddress(int employeeId, Address address);
		
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