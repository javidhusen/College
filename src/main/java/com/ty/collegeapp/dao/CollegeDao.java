package com.ty.collegeapp.dao;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.collegeapp.dto.College;
import com.ty.collegeapp.repository.CollegeRepository;

@Repository
public class CollegeDao {

	@Autowired
	private CollegeRepository collageRepository;
	
	public College saveCollage(College collage) {
		return collageRepository.save(collage);
	}
	
	public College getCollageById(int id) {
		Optional<College> option=collageRepository.findById(id);
		if(option.isPresent()) {
			return	option.get(); 
		}else {
			return null;
		}
	}
	
	public List<College> getAllCollage(){
		return collageRepository.findAll();
	}
}
