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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


import com.tnp.entity.AdminLogin;
import com.tnp.repository.LoginRepository;
import com.tnp.service.service;
@CrossOrigin
	@RestController
	@RequestMapping(value = "/changepassword")
	public class controller {
		
		@Autowired
		private service service;
		
		
		
		// user registration
		@PostMapping(value="/registeruser")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> save(@Valid @RequestBody AdminLogin user)
		{
			System.out.println("Registration success");
			AdminLogin users=service.save(user);
			String userName=users.getUserName();
			return new ResponseEntity<String>("user with User Name :"+userName+" added Successfully ",HttpStatus.OK);
			}	
	
		
		
}
			


	