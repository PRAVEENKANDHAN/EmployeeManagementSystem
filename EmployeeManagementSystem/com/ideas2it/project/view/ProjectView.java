package com.ideas2it.project.view; 

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Scanner;

import com.ideas2it.project.controller.ProjectController;
import com.ideas2it.project.model.Project;

/**
 * EmployeeView Class displays the employee details
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class ProjectView {
    ProjectController projectController = new ProjectController();
    Scanner scanner = new Scanner(System.in);

    /**
     * projectOperations method list out the
     * menu options of project entity	 
     */     
    public void projectOperations() {
        System.out.print("*****Project Management System*****");
        String option = "\n\n1-->Create\n2-->UpdateProjectDetails"
                + "\n3-->DeleteProjectDetails\n4--Display>\n5-->DisplayAll"
                + "\n6-->Exit\n\nPlease Enter your choice: ";
        int choice = 0;
        while (6 != choice) {
            System.out.print(option);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: 
                    addProject();
                    break;
                case 2: 
                    updateProjectDetails(getProjectId());
                    break;
                case 3: 
                    deleteProjectDetails(getProjectId());
                    break;
                case 4:
                    displayProjectDetail(getProjectId());
                    break;
                case 5:
                    displayAllProjects();
                    break;
                case 6:
                    System.out.print("Thank you!");
                    break;
                default: 
                    System.out.print("\nPlease enter right choice!"
                            + "\nThank you");
                    choice = 5;
                    break; 
            }
        }
    }

    /**
     * This method adds a project details in a project database
     */
    public void addProject() {
        String projectName, projectManager, projectType;
        int  projectId;
        Date projectAssignDate, projectLastDate;		
        System.out.println("Enter project name: ");
        projectName = scanner.nextLine();
        System.out.println("Enter Project type ");
        projectType = scanner.nextLine();
        System.out.println("Enter project Manager name ");
        projectManager = scanner.nextLine();        
        //scanner.nextLine();
        System.out.println("Enter Project Assign Date(yyyy-MM-dd)");
        projectAssignDate = Date.valueOf(isValidDate());
        System.out.println("Enter Project Last Date(yyyy-MM-dd)");
        projectLastDate = Date.valueOf(isValidDate());
        int id = projectController.addProject(projectName, projectType, 
                projectManager, projectAssignDate, projectLastDate);
        if (0 != id ) {
            System.out.println("Project Details added successfully\n" 
                    + "Your Project Id is " + id);
        } else {
            System.out.println("Project Details adding Failed");
        }
    }
		
    /**
     * Update the existing data based on
     * the given project id
     * @param projectId it contains an projectId
     */
    public void updateProjectDetails(int projectId) { 
        String option = "\n\n1-->ProjectName\n2-->ProjectType\n"
                + "3-->ProjectManager\n4-->ProjectStartingDate\n"
                + "5-->ProjectLastDate\n\nPlease choose the field option " 
                + "to update:";
        System.out.print(option);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                updateProjectName(projectId);
                break;
            case 2: 
                updateProjectType(projectId);
                break;            
            case 3: 
                updateProjectManagerName(projectId);
                break; 
            case 4: 
                updateProjectAssignDate(projectId);
                break;
            case 5: 
                updateProjectLastDate(projectId);
                break;
            default: 
                System.out.println("Please enter right choice");                
                break;
        }
    }
    
    /**
     * Update the existing data based on
     * the given project id
     * @param projectId it contains an projectId
     */
    public void updateProjectName(int projectId) {        
        System.out.println("Enter a Project name:");
        scanner.nextLine();
        String projectName = scanner.nextLine();
        if (projectController.updateProjectName(projectId, 
                projectName)) {
            System.out.println("Updated Successfully");
        } else {
        System.out.println("Updation Failed");
        }
    }
    
    public void updateProjectType(int projectId) {
        System.out.println("Enter a Project Type:");
        scanner.nextLine();
        String projectType = scanner.nextLine();
        if (projectController.updateProjectType(projectId, 
                projectType)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
    
    /**
     * Update the existing data based on
     * the given project id
     * @param projectId it contains an projectId
     */ 
    public void updateProjectManagerName(int projectId) {
        System.out.println("Enter a Project Manager Name:");
        String projectManager = scanner.nextLine();
        scanner.nextLine();
        if (projectController.updateProjectManager(projectId,
                projectManager)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }

    /**
     * Update the existing data based on
     * the given project id
     * @param projectId it contains an projectId
     */
    public void updateProjectAssignDate(int projectId) {
        System.out.println("Enter a project Starting Date:");
        scanner.nextLine();
        Date projectAssignDate = Date.valueOf(scanner.nextLine());
        if (projectController.updateProjectAssignDate(projectId,
                projectAssignDate)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
   
    /**
     * Update the existing data based on
     * the given project id
     * @param projectId it contains an projectId
     */
    public void updateProjectLastDate(int projectId) {
        System.out.println("Enter a project Ending Date:");
        scanner.nextLine();
        Date projectLastDate = Date.valueOf(scanner.nextLine());
        if (projectController.updateProjectLastDate(projectId,
                projectLastDate)) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("Updation Failed");
        }
    }
	
    /**
     * Deleting the project details based on the given
     * projectId
     */
    public void deleteProjectDetails(int projectId) {
        if (projectController.deleteProjectDetails(projectId)) {
            System.out.println("Deleted Successfully");
        } else {
            System.out.println("Deletion failed");
        }
    }   
    
    /**
     * Displaying the project details based on the given
     * projectId
     */
    public void displayProjectDetail(int projectId) { 
        Project project = projectController.getProjectDetail(projectId); 
        if (null != project) {
            System.out.println("ProjectId: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Project Type: " + project.getProjectType());
            System.out.println("ProjectManager Name: " 
                    + project.getProjectManager());
            System.out.println("Project AsssignDate: " 
                    + project.getProjectAssignDate());  
            System.out.println("Project LastDate: " 
                    + project.getProjectLastDate());
        } else {
            System.out.println("No data to display");
        }
    }

    /**
     *  Displaying all the projects details 
     */
    public void displayAllProjects() { 
        List<Project> projectDetails = 
                projectController.getProjectDetails();
        for (Project project : projectDetails) { 
            System.out.println("ProjectId: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Project Type: " + project.getProjectType());
            System.out.println("ProjectManager Name: " 
                + project.getProjectManager());
            System.out.println("Project AsssignDate: " 
                + project.getProjectAssignDate());  
            System.out.println("Project LastDate: " 
                + project.getProjectLastDate());
        }	
    }
	
    /**
     * Validating the date
     * @return it returns the valid date
     */
    private String isValidDate() {
        String date = scanner.nextLine();
        while(! projectController.isValidDate(date)) {
            System.out.println("Please enter correct date");
            date = scanner.nextLine();
            projectController.isValidDate(date);			
        }    
        return date;		
    }

    /**
     * Getting the ProjectId from the user
     * to perform display and deletion operation
     */
    private int getProjectId() {
        System.out.println("Enter your project id:");
        int projectId = scanner.nextInt();
        return projectId;    
    }   	
}