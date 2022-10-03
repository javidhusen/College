package com.ty.collegeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.collegeapp.dto.College;
import com.ty.collegeapp.dto.ResponseStructure;
import com.ty.collegeapp.service.CollegeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	private CollegeService collageService;

	@ApiOperation(value = "save collage", notes = "Input is collage object and returns collage object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<College>> saveCollage(@RequestBody College collage) {
		return collageService.saveCollage(collage);
	}

	@ApiOperation(value = "Update collage", notes="Input is Collage object and output is Collage object")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@PutMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<College>> updateCollage(@RequestBody College collage) {
		return collageService.updateCollage(collage);
	}

	@ApiOperation(value = "Get collage By Id", notes="Input is Collage id and output is Collage object")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<College>> getCollageById(@PathVariable int id) {
		return collageService.getCollageById(id);
	}

	@ApiOperation(value = "Get all collages")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<List<College>>> getAllCollage() {
		return collageService.getAllCollage();
	}

}
