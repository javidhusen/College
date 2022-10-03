package com.ty.collegeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.collegeapp.dto.College;

public interface CollegeRepository extends JpaRepository<College, Integer>{

}
