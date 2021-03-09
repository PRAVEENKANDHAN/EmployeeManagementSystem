package com.ideas2it.employee.model;

import java.util.Date;

/**
 * Employee class contains basic details of employee
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN 
 */
public class Address {
    
    private int id;
    private String addressMode;
    private String doorNumber;
    private String streetName;
    private String district;
    private String state;
    private String country;
	      
    public Address(int id, String doorNumber, String streetName, 
            String district, String state, String country,
            String addressMode) {
        this.id = id;
        this.doorNumber = doorNumber;
        this.streetName = streetName;
        this.district = district;
        this.state = state;
        this.country = country;
        this.addressMode =addressMode;
    }
    
    public int getId() {
        return id;
    }
	
    public String getDoorNumber() {                    
        return doorNumber;
    }
  
    public String getStreetName() {
        return streetName;
    }
  
    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }
 
    public String getCountry() {
        return country;
    }
	
    public String getAddressMode() {
        return addressMode;
    }
	
    public void setId(int id) {
        this.id = id;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }
  
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
 
    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
	
    public void setAddress(String addressMode) {
        this.addressMode = addressMode;
    }
}
