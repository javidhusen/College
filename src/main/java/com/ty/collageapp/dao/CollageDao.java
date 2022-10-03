package com.ty.collageapp.dao;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.collageapp.dto.Collage;
import com.ty.collageapp.repository.CollageRepository;

@Repository
public class CollageDao {

	@Autowired
	private CollageRepository collageRepository;
	
	public Collage saveCollage(Collage collage) {
		return collageRepository.save(collage);
	}
	
	public Collage getCollageById(int id) {
		Optional<Collage> option=collageRepository.findById(id);
		if(option.isPresent()) {
			return	option.get(); 
		}else {
			return null;
		}
	}
	
	public List<Collage> getAllCollage(){
		return collageRepository.findAll();
	}
}
