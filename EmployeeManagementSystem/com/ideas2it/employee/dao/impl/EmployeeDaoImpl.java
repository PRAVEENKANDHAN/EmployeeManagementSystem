package com.ideas2it.employee.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.singleton.DatabaseConnection;

/**
 * EmployeeDaoImplementation Class implements the employee operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * {@inheritdoc}
     */   
    @Override
    public int createEmployee(Employee employee) { 
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "INSERT INTO employee (name, emailid," 
                    + "mobilenumber, city,dateofbirth)"
		    + "VALUES (?,?,?,?,?)";        
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);               
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmailId());
            preparedStatement.setLong(3, employee.getMobileNumber());
            preparedStatement.setString(4, employee.getCity());
            preparedStatement.setDate(5, employee.getDateOfBirth());
            int row = preparedStatement.executeUpdate();
            if (0 != row) {
                ResultSet reslultset = preparedStatement.getGeneratedKeys();
                if (reslultset.next()) {
                    return reslultset.getInt(1);
                }
            } else {
                return 0;
            }
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();
        }    
        return 0;
    }

    /**
     * {@inheritdoc}
     */   
    @Override
    public boolean createAddress(Address address) {
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "INSERT INTO address (id, doorNumber," 
                    + "streetName, district, state, country, addressmode)"
                    + "VALUES (?,?,?,?,?,?,?)";        
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql);
            preparedStatement.setInt(1, address.getId());  			
            preparedStatement.setString(2, address.getDoorNumber());
            preparedStatement.setString(3, address.getStreetName());
            preparedStatement.setString(4, address.getDistrict());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setString(6, address.getCountry());
            preparedStatement.setString(7, address.getAddressMode());
            int row = preparedStatement.executeUpdate();
            if (0 != row) {
                return true;					
            } else {
                return false;
            }
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();
        }    
        return false;
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateEmployee(int id, Employee employee) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE employee SET name = ?, emailid = ?," 
                    + "mobilenumber = ?, city = ?, dateofbirth = ?"
                    + "WHERE id = ?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmailId());
            preparedStatement.setLong(3, employee.getMobileNumber());
            preparedStatement.setString(4, employee.getCity());
            preparedStatement.setDate(5, employee.getDateOfBirth());
            preparedStatement.setInt(6,id);
            int row = preparedStatement.executeUpdate();
            if (1 == row) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace(); 
        }    
            return false;
	}
    
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateAddress(int id, Address address) {
        try {			
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE address SET doornumber = ?, streetname = ?," 
                    + "district = ?, state = ?, country = ?"
                    + "WHERE id = ? AND addressMode = ?");
            preparedStatement.setString(1, address.getDoorNumber());
            preparedStatement.setString(2, address.getStreetName());
            preparedStatement.setString(3, address.getDistrict());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getCountry());
            preparedStatement.setInt(6, id);
            preparedStatement.setString(7,address.getAddressMode());
            int row = preparedStatement.executeUpdate();
            if (1 == row) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();
            return false;
        }    
    }

    /**
     * {@inheritdoc}
     */ 
    @Override
    public boolean deleteEmployee(int employeeId) {                  
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String addressSql = "DELETE FROM address WHERE id = ?";	
            PreparedStatement preparedStatement = connection.prepareStatement
                    (addressSql);         
            preparedStatement.setInt(1,employeeId);	
            int addressResult = preparedStatement.executeUpdate();
            String employeeSql = "DELETE FROM employee WHERE id = ?";
            preparedStatement = connection.prepareStatement(employeeSql);         
            preparedStatement.setInt(1,employeeId);	
            int employeeResult = preparedStatement.executeUpdate(); 			
            if (employeeResult > 0 && addressResult > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {    
            System.out.println(e);
            e.printStackTrace();
            return false; 
        }  
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public Employee getEmployeeDetail(int employeeId) {		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM employee WHERE id =?";
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql);               
            preparedStatement.setInt(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {  
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("emailid"),
                        resultSet.getLong("mobilenumber"), 
                        resultSet.getString("city"), 
                        resultSet.getDate("dateOfbirth"));
                        return employee;			
            }            
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();		
        }
        return null;
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public Address getAddressDetail(int employeeId) {		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM address WHERE id =?";
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql);               
            preparedStatement.setInt(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {  
            Address address = new Address(resultSet.getInt("id"),				    
                    resultSet.getString("doorNumber"),
                    resultSet.getString("streetName"),
                    resultSet.getString("district"), 
                    resultSet.getString("state"), 
                    resultSet.getString("country"),
                    resultSet.getString("addressmode"));
                    return address;			
            }            
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();		
        }
        return null;
    }
	
    /**
     * {@inheritdoc
     */
    @Override
    public List<Employee> getEmployeeDetails() {	
        List<Employee> employeeDetails = new ArrayList<Employee>();		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM employee";
            Statement statement = connection.createStatement();               
            ResultSet resultSet = statement.executeQuery(sql);			           
            while(resultSet.next()) {
                Employee employee = new Employee(resultSet.
                        getInt("id"),resultSet.getString("name"),
                        resultSet.getString("emailid"), 
                        resultSet.getLong("mobilenumber"), 
                        resultSet.getString("city"), 
                        resultSet.getDate("dateofbirth"));     
                        employeeDetails.add(employee);
            }			
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();		
        }
        return employeeDetails;
    }
	
    /**
     * {@inheritdoc
     */
    @Override
    public List<Address> getAddressDetails() {	
        List<Address> addressDetails = new ArrayList<Address>();		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM address";
            Statement statement = connection.createStatement();               
            ResultSet resultSet = statement.executeQuery(sql);			           
            while(resultSet.next()) {
                Address address = new Address(resultSet.getInt("id"),
                        resultSet.getString("doornumber"),
                        resultSet.getString("streetname"), 
                        resultSet.getString("district"), 
                        resultSet.getString("state"), 
                        resultSet.getString("country"),  
                        resultSet.getString("addressmode"));						
                        addressDetails.add(address);
            }			
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();		
        }
        return addressDetails;
    }
}