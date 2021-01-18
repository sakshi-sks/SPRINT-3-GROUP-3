package com.tnp.controller;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tnp.entity.AdminLogin;

import com.tnp.exception.resourcenotfoundexception;
import com.tnp.repository.LoginRepository;
import com.tnp.service.serviceimpl;
import com.tnp.service.service;

@CrossOrigin
@RestController 
@RequestMapping(value="/api/v1")
public class ForgotPasswordController
 {
@Autowired
private AdminServiceImpl service;
@Autowired
private LoginRepository repo;
@RequestMapping(value = "/user/{id}")
public ResponseEntity findByUserName(@PathVariable String userName) 
{  
	List<AdminLogin> user = service.findByUserName(userName);
	
	 if(user.isEmpty()) {
		 throw new ResourceNotFoundException("User id not found : "+userName );
   }
	return  ResponseEntity.ok(user);
}	




//  update recruiter details by id
@PatchMapping(value = "/updateuser/{id}")
public AdminLogin update(@Valid @RequestBody Map<String,String> updateData,@PathVariable int id)
{	
	AdminLogin user =service.update(updateData, id);
    
    return user;
}

}
	



	


