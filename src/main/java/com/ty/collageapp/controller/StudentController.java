package com.ty.collageapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.collageapp.dto.ResponseStructure;
import com.ty.collageapp.dto.Student;
import com.ty.collageapp.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "save student", notes = "Input is student object and return student object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}


	@ApiOperation(value = "Get student By Id", notes = "Input is student id and return student object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@ApiOperation(value = "Get All student", notes = "return All student object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent() {
		return studentService.getAllStudent();
	}

	@ApiOperation(value = "delete student By Id", notes = "Input is student id and delete student object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@DeleteMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@ApiOperation(value = "update student", notes = "Input is student object and return student object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
}
