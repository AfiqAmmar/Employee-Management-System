package com.cbse.employee_management.service;

import java.util.List;

import com.cbse.employee_management.model.Discipline;

public interface DisciplineService {
	List<Discipline> getAllDisciplines();
	void saveDiscipline(Discipline discipline);
	List<Discipline> getDisciplineByEmployeeId(long id);
	Discipline getDisciplineById(long id);
	void deleteDisciplineById(long id);
}
