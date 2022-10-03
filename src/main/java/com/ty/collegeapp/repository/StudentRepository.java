package com.ty.collegeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.collegeapp.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
