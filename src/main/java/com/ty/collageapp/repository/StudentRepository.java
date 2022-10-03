package com.ty.collageapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.collageapp.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
