package com.ty.collegeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.collegeapp.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
