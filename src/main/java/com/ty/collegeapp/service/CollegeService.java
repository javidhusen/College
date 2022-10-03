package com.ty.collegeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.collegeapp.dao.CollegeDao;
import com.ty.collegeapp.dto.College;
import com.ty.collegeapp.dto.ResponseStructure;

@Service
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	
	public ResponseEntity<ResponseStructure<College>> saveCollage(College college){
		ResponseStructure<College> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(collegeDao.saveCollage(college));
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<College>> getCollageById(int id){
		ResponseStructure<College> responseStructure=new ResponseStructure<>();
		College college=collegeDao.getCollageById(id);
		if(college!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(college);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<College>>> getAllCollage(){
		ResponseStructure<List<College>> responseStructure=new ResponseStructure<>();
		List<College> college=collegeDao.getAllCollage();
		if(college!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(college);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<College>> updateCollage(College college){
		ResponseStructure<College> responseStructure=new ResponseStructure<>();
		College college2=collegeDao.getCollageById(college.getId());
		if(college2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(collegeDao.saveCollage(college));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
}
