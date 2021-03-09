package com.ideas2it.project.dao.impl;

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

import com.ideas2it.project.dao.ProjectDao;
import com.ideas2it.project.model.Project;
import com.ideas2it.singleton.DatabaseConnection;

/**
 * ProjectDaoImplementation Class implements the project operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class ProjectDaoImpl implements ProjectDao {

    /**
     * {@inheritdoc}
     */   
    @Override
    public int addProjectDetails(Project project) { 
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "INSERT INTO project (projectname, projecttype," 
                    + "projectmanager, projectassigndate, projectlastdate)"
                    + "VALUES (?,?,?,?,?)";        
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);               
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setString(3, project.getProjectType());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
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
    public boolean updateProjectName(int projectId, Project project) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE project SET projectname = ?, projecttype = ?," 
                    + "projectmanager = ?, projectassigndate = ?,"
                    + "projectlastdate = ? WHERE projectid = ?");
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectType());
            preparedStatement.setString(3, project.getProjectManager());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
            preparedStatement.setInt(6,projectId);
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
    public boolean updateProjectType(int projectId, Project project) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE project SET projectname = ?, projecttype = ?," 
                    + "projectmanager = ?, projectassigndate = ?,"
                    + "projectlastdate = ? WHERE projectid = ?");
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectType());
            preparedStatement.setString(3, project.getProjectManager());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
            preparedStatement.setInt(6, projectId);
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
    public boolean updateProjectManager(int projectId, Project project) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE project SET projectname = ?, projecttype = ?, " 
                    + "projectmanager = ?, projectassigndate = ?,"
                    + "projectlastdate = ? WHERE projectid = ?");
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectType());
            preparedStatement.setString(3, project.getProjectManager());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
            preparedStatement.setInt(6,projectId);
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
    public boolean updateProjectAssignDate(int projectId, Project project) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE project SET projectname = ?, projecttype = ?," 
                    + "projectmanager = ?, projectassigndate = ?,"
                    + "projectlastdate = ? WHERE projectid = ?");
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectType());
            preparedStatement.setString(3, project.getProjectManager());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
            preparedStatement.setInt(6,projectId);
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
    public boolean updateProjectLastDate(int projectId, Project project) {
        try {			
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE project SET projectname = ?, projecttype = ?," 
                    + "projectmanager = ?, projectassigndate = ?,"
                    + "projectlastdate = ? WHERE projectid = ?");
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectType());
            preparedStatement.setString(3, project.getProjectManager());
            preparedStatement.setDate(4, project.getProjectAssignDate());
            preparedStatement.setDate(5, project.getProjectLastDate());
            preparedStatement.setInt(6,projectId);
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
    public boolean deleteProjectDetails(int projectId) {                  
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String projectSql = "DELETE FROM project WHERE projectid =" 
                    + projectId;
            Statement statement = connection.createStatement();              
            int projectResult = statement.executeUpdate(projectSql);
            if (projectResult > 0) {
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
    public Project getProjectDetail(int projectId) {		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM project WHERE projectid =?";
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sql);               
            preparedStatement.setInt(1,projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {  
                Project project = new Project(resultSet.getInt("projectid"),
                        resultSet.getString("projectname"),
                        resultSet.getString("projecttype"),
                        resultSet.getString("projectmanager"), 
                        resultSet.getDate("projectassigndate"), 
                        resultSet.getDate("projectlastdate"));
                        return project;			
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
    public List<Project> getProjectDetails() {	
        List<Project> projectDetails = new ArrayList<Project>();		
        try {
            DatabaseConnection databaseConnection = 
                    DatabaseConnection.getInstance();
            Connection connection = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM project";
            Statement statement = connection.createStatement();               
            ResultSet resultSet = statement.executeQuery(sql);	
            while(resultSet.next()) {			
                Project project = new Project(resultSet.getInt("projectid"),
                        resultSet.getString("projectname"),
                        resultSet.getString("projecttype"),
                        resultSet.getString("projectmanager"), 
                        resultSet.getDate("projectassigndate"), 
                        resultSet.getDate("projectlastdate"));
                        projectDetails.add(project);
            }   		
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();		
        }
        return projectDetails;
    }
}