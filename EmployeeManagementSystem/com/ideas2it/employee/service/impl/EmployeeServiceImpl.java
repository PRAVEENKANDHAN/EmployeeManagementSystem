package com.ideas2it.employee.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Scanner;

import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

/**
 * EmployeeService Class performs create,
 * update, display and delete operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    /**
     * {@inheritdoc}
     */   
    @Override
    public int createEmployee(String name, String emailId, long mobileNumber, 
            String city, Date dateOfBirth) {
        return employeeDao.createEmployee(new Employee(name, emailId,
                mobileNumber, city, dateOfBirth));
    }

    /**
     * {@inheritdoc}
     */   
    @Override
    public boolean createAddress(int id, String doorNumber, String streetName,
            String district, String state, String country, 
            String addressMode){
        return employeeDao.createAddress(new Address(id, doorNumber, 
                streetName, district, state, country, addressMode));
    }
    	
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateName(int employeeId, String name) {
        Employee employee = employeeDao.getEmployeeDetail(employeeId);
        employee.setName(name);
        return employeeDao.updateEmployee(employeeId, employee);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateEmailId(int employeeId, String emailId) {
        Employee employee = employeeDao.getEmployeeDetail(employeeId);
        employee.setEmailId(emailId);
        return employeeDao.updateEmployee(employeeId, employee);
    }

    /**
     * {@inheritdoc}
     */   
    @Override	 
    public boolean updateMobileNumber(int employeeId, long mobileNumber) {
        Employee employee = employeeDao.getEmployeeDetail(employeeId);
        employee.setMobileNumber(mobileNumber);
        return employeeDao.updateEmployee(employeeId, employee);
    }

    /**
     * {@inheritdoc}
     */
    @Override 
    public boolean updateCity(int employeeId, String city) {
        Employee employee = employeeDao.getEmployeeDetail(employeeId);
        employee.setCity(city);
        return employeeDao.updateEmployee(employeeId, employee);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateDateOfBirth(int employeeId, Date dateOfBirth) {
        Employee employee = employeeDao.getEmployeeDetail(employeeId);
        employee.setDateOfBirth(dateOfBirth);
        return employeeDao.updateEmployee(employeeId, employee); 
    } 
    
    /**
     * {@inheritdoc}
     */
    public boolean updateDoorNumber(int employeeId, String doorNumber,
            String addressMode) {
        Address address = employeeDao.getAddressDetail(employeeId);
        address.setDoorNumber(doorNumber);
        return employeeDao.updateAddress(employeeId, address);
    } 
	
    /**
     * {@inheritdoc}
     */
    public boolean updateStreetName(int employeeId, String streetName, 
            String addressMode) {
        Address address = employeeDao.getAddressDetail(employeeId);
        address.setStreetName(streetName);
        return employeeDao.updateAddress(employeeId, address);
    }
	
    /**
     * {@inheritdoc}
     */
    public boolean updateDistrict(int employeeId, String district, 
            String addressMode) {
        Address address = employeeDao.getAddressDetail(employeeId);
        address.setDistrict(district);
        return employeeDao.updateAddress(employeeId, address);
    }
	
    /**
     * {@inheritdoc}
     */
    public boolean updateState(int employeeId, String state, 
            String addressMode) {
        Address address = employeeDao.getAddressDetail(employeeId);
        address.setState(state);
        return employeeDao.updateAddress(employeeId, address);
    }
	
    /**
     * {@inheritdoc}
     */
    public boolean updateCountry(int employeeId, String country, 
            String addressMode) {
        Address address = employeeDao.getAddressDetail(employeeId);
        address.setCountry(country);
        return employeeDao.updateAddress(employeeId, address);
    }	
		  	
    /**
     * {@inheritdoc}
     */
    @Override 
    public boolean deleteEmployee(int employeeId) {           
        return employeeDao.deleteEmployee(employeeId);  
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public Employee getEmployeeDetail(int employeeId) {
        return employeeDao.getEmployeeDetail(employeeId);
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public Address getAddressDetail(int employeeId) {
        return employeeDao.getAddressDetail(employeeId);
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public List<Employee> getEmployeeDetails() {
        return employeeDao.getEmployeeDetails();
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public List<Address> getAddressDetails() {
        return employeeDao.getAddressDetails();
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isValidEmailId(String emailId) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." 
                + "[a-zA-Z0-9_+&*-]+)*@"  
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"  
                + "A-Z]{2,7}$";                               
        Pattern patttern = Pattern.compile(emailRegex); 
        if((patttern.matcher(emailId).matches())) {
            return true;
        }			
        return false;		
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
	public boolean isValidMobileNumber(String mobileNumber) {
        Pattern patttern = Pattern.compile("^[1-9][0-9]{9}");
        Matcher matcher = patttern.matcher(mobileNumber);
        if((patttern.matcher(mobileNumber).matches())) {
            return true;
        }			
        return false;		
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
	public boolean isValidDate(String date) {
        String regex = "^([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
        if(date.matches(regex)) {
            return true;
        }			
        return false;		
    }
}
      