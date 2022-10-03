package com.ty.collageapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.collageapp.dao.StudentDao;
import com.ty.collageapp.dto.ResponseStructure;
import com.ty.collageapp.dto.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		ResponseStructure<Student> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(studentDao.saveStudent(student));
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> getStudentById(int id){
		ResponseStructure<Student> responseStructure=new ResponseStructure<>();
		Student student = studentDao.getStudentById(id);
		if(student!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(student);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else{
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent(){
		ResponseStructure<List<Student>> responseStructure=new ResponseStructure<>();
		List<Student> student=studentDao.getAllStudent();
		if(student.size()>0) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(student);
			return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteStudent(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		Student student2=studentDao.getStudentById(id);
		if(student2!=null) {
			studentDao.deleteStudent(student2);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted SuccessFully");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student){
		ResponseStructure<Student> responseStructure=new ResponseStructure<>();
		Student student2=studentDao.getStudentById(student.getId());
		if(student2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(studentDao.saveStudent(student));
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
}
