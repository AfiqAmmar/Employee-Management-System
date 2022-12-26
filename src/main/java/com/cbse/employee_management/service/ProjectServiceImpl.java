package com.cbse.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbse.employee_management.model.Project;
import com.cbse.employee_management.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

}
