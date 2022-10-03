package com.ty.collegeapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.collegeapp.dto.Student;
import com.ty.collegeapp.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(int id) {
		Optional<Student> optional= studentRepository.findById(id);
		if(optional!=null) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public boolean deleteStudent(Student student) {
		studentRepository.delete(student);
		return true;
	}
	
}
