 package com.tnp.controller;



import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tnp.entity.Recruiter;

import com.tnp.recruiter.exception.*;
import com.tnp.repository.RecruiterRepository;
import com.tnp.service.RecruiterServiceImpl;

@CrossOrigin
@RestController 
@RequestMapping(value="/api/v1")
public class RecruiterController
  {
@Autowired
private RecruiterServiceImpl service;

 @Autowired
 private RecruiterRepository repo;


// get all recruiters    
@GetMapping(value="/getallrecruiters")
public ResponseEntity<List<Recruiter>> getAllRecruiters()
{
	List<Recruiter> recruiters=service.getAllRecruiters();
	return new ResponseEntity<List<Recruiter>>(recruiters,HttpStatus.OK);	
}




// recruiter registration
@PostMapping(value="/recruiter")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<String> save(@Valid @RequestBody Recruiter recruiter)
{
	Recruiter recruiters=service.register(recruiter);
	String mail=recruiters.getMail();
	return new ResponseEntity<String>("Recruiter With mail  :"+mail+" Registered Successfully ",HttpStatus.OK);	
}




// get recruiter details by email id
@GetMapping(value = "/recruiters/{mail}")
public ResponseEntity findByMail(@PathVariable String mail) 
{  
	List<Recruiter> recruiter = service.findByMail(mail);
	
	 if(recruiter.isEmpty()) {
		 throw new ResourceNotFoundException("Email id not found : "+mail );
    }
	return  ResponseEntity.ok(recruiter);
}	




//   update recruiter details by id
@PatchMapping(value = "/recruiters/{id}")
public Recruiter update(@Valid @RequestBody Map<String,String> updateData,@PathVariable long id)
{	
     Recruiter recruiter =service.update(updateData, id);
     
     return recruiter;
}



//login 
//login 
@PostMapping(value="/recruiters/login")
public ResponseEntity<String> recruiterLogin(@RequestBody Recruiter recruiter)
{
	if(service.recruiterLogin(recruiter.getMail(), recruiter.getPassword()))
	{
		return new ResponseEntity<String>("Login Successful)",HttpStatus.OK);
	}
	else
	{
		throw new ResourceNotFoundException("Invalid Email Id or Password,please check your details and try again");
	}

}
	
}


	


