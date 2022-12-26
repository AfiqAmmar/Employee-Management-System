package com.cbse.employee_management.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void saveProject(Project project) {
		this.projectRepository.save(project);
	}

	@Override
	public Project getProjectById(long id) {
		Optional<Project> optional = projectRepository.findById(id);
		Project project = null;
		if (optional.isPresent()) {
			project = optional.get();
		} else {
			throw new RuntimeException(" Project not found for id :: " + id);
		}
		return project;
	}

}
