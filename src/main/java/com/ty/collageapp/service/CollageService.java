package com.ty.collageapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.collageapp.dao.CollageDao;
import com.ty.collageapp.dto.Collage;
import com.ty.collageapp.dto.ResponseStructure;

@Service
public class CollageService {

	@Autowired
	private CollageDao collageDao;
	
	public ResponseEntity<ResponseStructure<Collage>> saveCollage(Collage collage){
		ResponseStructure<Collage> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(collageDao.saveCollage(collage));
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Collage>> getCollageById(int id){
		ResponseStructure<Collage> responseStructure=new ResponseStructure<>();
		Collage collage=collageDao.getCollageById(id);
		if(collage!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(collage);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Collage>>> getAllCollage(){
		ResponseStructure<List<Collage>> responseStructure=new ResponseStructure<>();
		List<Collage> collage=collageDao.getAllCollage();
		if(collage!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(collage);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Collage>> updateCollage(Collage collage){
		ResponseStructure<Collage> responseStructure=new ResponseStructure<>();
		Collage collage2=collageDao.getCollageById(collage.getId());
		if(collage2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(collageDao.saveCollage(collage));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
}
