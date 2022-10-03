package com.ty.collegeapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.collegeapp.dto.Branch;
import com.ty.collegeapp.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional != null) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<Branch> getAllBranch(){
		return branchRepository.findAll();
	}
	
	public void deleteBranch(Branch branch) {
		branchRepository.delete(branch);
	}
}
