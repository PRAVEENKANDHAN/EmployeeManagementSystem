package com.ideas2it.project.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.dao.impl.ProjectDaoImpl;
import com.ideas2it.project.dao.ProjectDao;
import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;

/**
 * ProjectService Class performs create,
 * update, display and delete operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN
 */
public class ProjectServiceImpl implements ProjectService {
    ProjectDao projectDao = new ProjectDaoImpl();

    /**
     * {@inheritdoc}
     */   
    @Override
    public int addProject(String projectName, String projectType, 
            String projectManager, Date projectAssignDate, 
            Date projectLastDate) {
        return projectDao.addProject(new Project(projectName, 
                projectType, projectManager, projectAssignDate, 
                projectLastDate));
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateProjectName(int projectId, String projectName) {
        Project project = projectDao.getProjectDetail(projectId);
        project.setProjectName(projectName);
        return projectDao.updateProject(projectId, project);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean updateProjectType(int projectId, String projectType) {
        Project project = projectDao.getProjectDetail(projectId);
        project.setProjectType(projectType);
        return projectDao.updateProject(projectId, project);
    }

    /**
     * {@inheritdoc}
     */   
    @Override	 
    public boolean updateProjectManager(int projectId, String projectManager) {
        Project project = projectDao.getProjectDetail(projectId);
        project.setProjectManager(projectManager);
        return projectDao.updateProject(projectId, project);
    }

    /**
     * {@inheritdoc}
     */
    @Override 
    public boolean updateProjectAssignDate(int projectId, 
            Date projectAssignDate) {
        Project project = projectDao.getProjectDetail(projectId);
        project.setProjectAssignDate(projectAssignDate);
        return projectDao.updateProject(projectId, project);
    }

    /**
     * {@inheritdoc}
     */
    @Override 
    public boolean updateProjectLastDate(int projectId, Date projectLastDate) {
        Project project = projectDao.getProjectDetail(projectId);
        project.setProjectLastDate(projectLastDate);
        return projectDao.updateProject(projectId, project);
    }
    	
    /**
     * {@inheritdoc}
     */
    @Override 
    public boolean deleteProjectDetails(int projectId) {           
        return projectDao.deleteProjectDetails(projectId);  
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public Project getProjectDetail(int projectId) {
        return projectDao.getProjectDetail(projectId);
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public List<Project> getProjectDetails() {
        return projectDao.getProjectDetails();
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
      