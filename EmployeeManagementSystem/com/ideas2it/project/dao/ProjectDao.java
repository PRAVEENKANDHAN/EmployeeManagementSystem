package com.ideas2it.project.dao;

import java.sql.Date;
import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * ProjectDao Interface contains the implementation
 * method signature
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public interface ProjectDao {
	
    /**
     * Inserting the project details
     * @return 1 if project details added successfully
     *         else 0 if project details added failed
     */  
    public int addProjectDetails(Project project);
    
    /**
     * Updating the existing project name
     * @param projectId it contains the projectId
     * @param project it contains projectDetails
     * @return true if project name updated successfully
     *         else false if project name updating failed
     */
    public boolean updateProjectName(int projectId, Project project);
	
    /**
     * Updating the existing project type
     * @param projectId it contains the projectId
     * @param project it contains projectDetails
     * @return true if projectType updated successfully
     *         else false if projectType updating failed
     */
    public boolean updateProjectType(int projectId, Project project);
	
    /**
     * Updating the existing project manager name
     * @param projectId it contains the projectId
     * @param project it contains projectDetails
     * @return true if project manager name updated successfully
     *         else false if project manager name updating failed
     */
    public boolean updateProjectManager(int projectId, Project project);
	
    /**
     * Updating the existing projectAssignDate
     * @param projectId it contains the projectId
     * @param project it contains projectDetails
     * @return true if projectAssignDate updated successfully
     *         else false if projectAssignDate updating failed
     */
    public boolean updateProjectAssignDate(int projectId, Project project);
	
    /**
     * Updating the existing projectLastDate
     * @param projectId it contains the projectId
     * @param project it contains projectDetails
     * @return true if projectLastDate updated successfully
     *         else false if projectLastDate updating failed
     */
    public boolean updateProjectLastDate(int projectId, Project project);
	
    /**
     * Deleting the project details 
     * @param projectId it contains the projectId
     * @return true if project details deleted successfully
     *         false if project details deletion failed
     */		 
    public boolean deleteProjectDetails(int projectId);
	
    /**
     * Getting the project details
     * @param projectId it contains the projectId
     */
    public Project getProjectDetail(int projectId);
	
    /**
     * Getting all the projects details
     */	 
    public List<Project> getProjectDetails();
}  