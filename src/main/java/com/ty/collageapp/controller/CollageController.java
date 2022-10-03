package com.ty.collageapp.controller;

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

import com.ty.collageapp.dto.Collage;
import com.ty.collageapp.dto.ResponseStructure;
import com.ty.collageapp.service.CollageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/collages")
public class CollageController {

	@Autowired
	private CollageService collageService;

	@ApiOperation(value = "save collage", notes = "Input is collage object and returns collage object")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Collage>> saveCollage(@RequestBody Collage collage) {
		return collageService.saveCollage(collage);
	}

	@ApiOperation(value = "Update collage", notes="Input is Collage object and output is Collage object")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@PutMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<Collage>> updateCollage(@RequestBody Collage collage) {
		return collageService.updateCollage(collage);
	}

	@ApiOperation(value = "Get collage By Id", notes="Input is Collage id and output is Collage object")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<Collage>> getCollageById(@PathVariable int id) {
		return collageService.getCollageById(id);
	}

	@ApiOperation(value = "Get all collages")
	@ApiResponses(value = {@ApiResponse(code=200, message="SUCCESS"), @ApiResponse(code=404, message="NOT FOUND")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<List<Collage>>> getAllCollage() {
		return collageService.getAllCollage();
	}

}
