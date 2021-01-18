package com.tnp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnp.entity.Recruiter;
import com.tnp.repository.RecruiterRepository;

import com.tnp.admin.exception.*;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/viewRecruiters/")
public class AdminRecruiterController {
	
	  @Autowired
	 private RecruiterRepository repo;

		//Getting all students api
		
		@GetMapping("/get_recruiter_list")
		public List<Recruiter> getDetails()
		{
			return (List<Recruiter>) repo.findAll();
		}
		
		// delete recruiter rest api
		
		@DeleteMapping("/get_recruiter_list/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteRecruiter(@PathVariable Long id){
			Recruiter recruiter = repo.findById(id).orElseThrow(() -> 
				new ResourceNotfoundException("No such recruiter found"));
			
			repo.delete(recruiter);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
