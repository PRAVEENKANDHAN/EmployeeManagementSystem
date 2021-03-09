package com.ideas2it.employee.model;

import java.sql.Date;

/**
 * Employee class contains basic details of employee
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN 
 */
public class Employee {
    
    private int id;
    private String name;
    private String emailId;
    private String city;
    private long mobileNumber;
    private Date dateOfBirth;
	      
    public Employee(int id, String name, String emailId, long mobileNumber,
            String city, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }
	
    public Employee(String name, String emailId, long mobileNumber,String city,
            Date dateOfBirth) {
        this.name = name;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }
    
    public int getId() {
        return id;
    }
	
    public String getName() {                    
        return name;
    }
  
    public String getEmailId() {
        return emailId;
    }
  
    public long getMobileNumber() {
        return mobileNumber;
    }

    public String getCity() {
        return city;
    }
 
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
	
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
 
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
