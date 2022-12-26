package com.cbse.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbse.employee_management.service.ProjectService;

@Controller
public class ProjectController {
    @Autowired
	private ProjectService projectService;
	
	// display list of projects
	@GetMapping("/projects")
	public String viewProjectPage(Model model) {
		model.addAttribute("listProjects", projectService.getAllProjects());
        return "project";	
	}

}
