package com.cbse.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbse.employee_management.model.Discipline;
import com.cbse.employee_management.model.Employee;
import com.cbse.employee_management.service.EmployeeService;
import com.cbse.employee_management.service.ProjectService;
import com.cbse.employee_management.service.DisciplineService;

@Controller
public class DisciplineController {
    @Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DisciplineService disciplineService;

	@GetMapping("/showDisciplinary/{id}")
	public String showDisciplinary(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		// set discipline as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		model.addAttribute("listDisciplines", disciplineService.getDisciplineByEmployeeId(id));
		
		return "disciplinary";
	}
	
	@GetMapping("/showNewDisciplineForm/{id}")
	public String showNewDisciplineForm(@PathVariable ( value = "id") long id, Model model) {
		// create model attribute to bind form data
		Discipline discipline = new Discipline();

		model.addAttribute("id", id);
		model.addAttribute("discipline", discipline);
		return "new_discipline";
	}

	@PostMapping("/saveDiscipline/{id}")
	public String saveDiscipline(@PathVariable ( value = "id") long id, @ModelAttribute("discipline") Discipline discipline) {
		// save discipline to database
		Employee employee = employeeService.getEmployeeById(id);
		discipline.setEmployee(employee);
		disciplineService.saveDiscipline(discipline);
		return "redirect:/showDisciplinary/"+id;
	}

	@GetMapping("/deleteDiscipline/{id}")
	public String deleteDiscipline(@PathVariable (value = "id") long id) {
		
		// call delete discipline method
		Discipline discipline = disciplineService.getDisciplineById(id);
		Employee employee = discipline.getEmployee();
		long employee_id = employee.getId(); 
		this.disciplineService.deleteDisciplineById(id);
		return "redirect:/showDisciplinary/"+ employee_id;
	}
	
}
