package com.cbse.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbse.employee_management.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
