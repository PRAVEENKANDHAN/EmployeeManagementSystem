package com.ideas2it.project.controller; 

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.impl.ProjectServiceImpl;
import com.ideas2it.project.service.ProjectService;
import com.ideas2it.project.view.ProjectView;

/**
 * EmployeeController Class peforms the basic operations of employee
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class ProjectController {        
    ProjectService projectService = new ProjectServiceImpl();
    
    /**
     * Inserting the project details
     * @param projectName it contains project name
     * @param projectType it contains type of the project
     * @param projectManager it contains projectManager name
     * @param projectAssignDate it contains project starting date
     * @param projectLastDate it contains deadline of the project
     * @return 1 if project details added successfully
     *         else 0 if project details added failed
     */
    public int addProjectDetails(String projectName, String projectType, 
            String projectManager, Date projectAssignDate, 
            Date projectLastDate) {
        return projectService.addProjectDetails(projectName, projectType, 
            projectManager, projectAssignDate, projectLastDate);
    }
	
    /**
     * Updating the existing project name
     * @param projectId it contains the projectId
     * @param projectName it contains the projectName
     * @return true if project name updated successfully
     *         else false if project name updating failed
     */
    public boolean updateProjectName(int projectId, String projectName) {
        return projectService.updateProjectName(projectId, projectName);
    }

    /**
     * Updating the existing project type
     * @param projectId it contains the projectId
     * @param projectType it contains projectType
     * @return true if projectType updated successfully
     *         else false if projectType updating failed
     */
    public boolean updateProjectType(int projectId, String projectType) {
        return projectService.updateProjectType(projectId, projectType);
    }
	
    /**
     * Updating the existing project manager name
     * @param projectId it contains the projectId
     * @param projectManagerName it contains project manager name
     * @return true if project manager name updated successfully
     *         else false if project manager name updating failed
     */
    public boolean updateProjectManager(int projectId, String projectManager) {
        return projectService.updateProjectManager(projectId, projectManager);
    }

    /**
     * Updating the existing projectAssignDate
     * @param projectId it contains the projectId
     * @param projectAssignDate it contains projectAssignDate
     * @return true if projectAssignDate updated successfully
     *         else false if projectAssignDate updating failed
     */ 
    public boolean updateProjectAssignDate(int projectId, 
            Date projectAssignDate) {
        return projectService.updateProjectAssignDate(projectId, 
                projectAssignDate);
    }

    /**
     * Updating the existing projectLastDate
     * @param projectId it contains the projectId
     * @param projectLastDate it contains projectAssignDate
     * @return true if projectLastDate updated successfully
     *         else false if projectLastDate updating failed
     */ 
    public boolean updateProjectLastDate(int projectId, 
            Date projectLastDate) {
        return projectService.updateProjectLastDate(projectId, 
                projectLastDate);
    }
	
    /**
     * Deleting the project details 
     * @param projectId it contains the projectId
     * @return true if project details deleted successfully
     *         false if project details deletion failed
     */
    public boolean deleteProjectDetails(int projectId) {
        return projectService.deleteProjectDetails(projectId);
    }

    /**
     * Getting the project details
     * @param projectId it contains the projectId
     */
    public Project getProjectDetail(int projectId) {
        return projectService.getProjectDetail(projectId);          
    }   
	
    /**
     * Getting all the projects details
     */
    public List<Project> getProjectDetails() {
        return projectService.getProjectDetails();          
    }
	
    /**
     * Validating the date
     * @param date it contains a validating date
     * @return it returns true if it is a valid date
     *         false if it is invalid date
     */
    public boolean isValidDate(String date) {
        return projectService.isValidDate(date); 
    }		
}   

