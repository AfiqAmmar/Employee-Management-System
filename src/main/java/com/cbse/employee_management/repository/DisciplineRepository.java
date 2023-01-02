package com.cbse.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbse.employee_management.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

    List<Discipline> findByEmployeeId(long employeeId);
    
}
