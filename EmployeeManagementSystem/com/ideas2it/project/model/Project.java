package com.ideas2it.project.model;

import java.sql.Date;

/**
 * Employee class contains basic details of employee
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN 
 */
public class Project {
    
    private int projectId;
    private String projectName;
    private String projectType;
    private String projectManager;
    private Date projectAssignDate;
    private Date projectLastDate;
	      
    public Project(int projectId, String projectName, String projectType, 
            String projectManager, Date projectAssignDate, 
            Date projectLastDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectManager = projectManager;
        this.projectAssignDate = projectAssignDate;
        this.projectLastDate = projectLastDate;
    }
    
	public Project(String projectName, String projectType, 
            String projectManager, Date projectAssignDate, 
            Date projectLastDate) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectManager = projectManager;
        this.projectAssignDate = projectAssignDate;
        this.projectLastDate = projectLastDate;
    }

    public int getProjectId() {
        return projectId;
    }
	
    public String getProjectName() {                    
        return projectName;
    }
  
    public String getProjectType() {
        return projectType;
    }
  
    public String getProjectManager() {
        return projectManager;
    }

    public Date getProjectAssignDate() {
        return projectAssignDate;
    }
 
    public Date getProjectLastDate() {
        return projectLastDate;
    }
	
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
  
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
 
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public void setProjectAssignDate(Date projectAssignDate) {
        this.projectAssignDate = projectAssignDate;
    }
    
    public void setProjectLastDate(Date projectLastDate) {
        this.projectLastDate = projectLastDate;
    }
}
