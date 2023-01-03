package com.cbse.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbse.employee_management.model.Employee;
import com.cbse.employee_management.model.Project;
import com.cbse.employee_management.service.EmployeeService;
import com.cbse.employee_management.service.ProjectService;

@Controller
public class ProjectController {
    @Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;
	
	// display list of projects
	@GetMapping("/projects")
	public String viewProjectPage(Model model) {
		model.addAttribute("listProjects", projectService.getAllProjects());
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "project";	
	}

	@GetMapping("/showNewProjectForm")
	public String showNewProjectForm(Model model) {
		// create model attribute to bind form data
		Project project = new Project();
		model.addAttribute("project", project);
		return "new_project";
	}
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("employee") Project project) {
		// save project to database
		projectService.saveProject(project);
		return "redirect:projects";
	}
	
	@GetMapping("/showFormForUpdateProject/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get project from the service
		Project project = projectService.getProjectById(id);
		
		// set project as a model attribute to pre-populate the form
		model.addAttribute("project", project);
		
		return "update_project";
	}

	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable (value = "id") long id) {
		
		// call delete projects method
		List<Employee> employees = employeeService.getEmployeeByProjectId(id);
		Project project = projectService.getProjectById(15);
		for(int i=0; i<employees.size(); i++){
			employees.get(i).setProject(project);
		} 
		this.projectService.deleteProjectById(id);
		return "redirect:/projects";
	}

}
