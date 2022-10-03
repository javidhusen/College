package com.ty.collegeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.collegeapp.dao.BranchDao;
import com.ty.collegeapp.dto.Branch;
import com.ty.collegeapp.dto.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.getBranchById(id);
		if (branch != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.getBranchById(id);
		if (branch != null) {
			branchDao.deleteBranch(branch);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("Deleted Successfully");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}

	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
		List<Branch> branchs=branchDao.getAllBranch();
		if(branchs.size()>0) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.OK);
		}else {
		return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(Branch branch){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		Branch branch2=branchDao.getBranchById(branch.getId());
		if(branch2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branchDao.saveBranch(branch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
}
