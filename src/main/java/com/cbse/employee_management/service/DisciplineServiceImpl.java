package com.cbse.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbse.employee_management.model.Discipline;
import com.cbse.employee_management.repository.DisciplineRepository;

@Service
public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
	private DisciplineRepository disciplineRepository;

	@Override
	public List<Discipline> getAllDisciplines() {
		return disciplineRepository.findAll();
	}

	@Override
	public void saveDiscipline(Discipline discipline) {
		this.disciplineRepository.save(discipline);
		
	}

	@Override
	public List<Discipline> getDisciplineByEmployeeId(long id) {
		return disciplineRepository.findByEmployeeId(id);
	}

	@Override
	public void deleteDisciplineById(long id) {
		this.disciplineRepository.deleteById(id);
	}
}
