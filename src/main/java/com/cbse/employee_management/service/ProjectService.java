package com.cbse.employee_management.service;

import java.util.List;

import com.cbse.employee_management.model.Project;

public interface ProjectService {
	List<Project> getAllProjects();
	void saveProject(Project project);
	Project getProjectById(long id);
	// void deleteEmployeeById(long id);
}
