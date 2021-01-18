package com.tnp.controller;
	import java.util.List;
    import java.util.Map;


    import javax.validation.Valid;

    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PatchMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.web.bind.annotation.RestController;

    import com.tnp.student.applicationConstants.StudentRegistrationConstants;
    //import com.tnp.exception.DuplicateStudentException;
    import com.tnp.entity.Student;
	import com.tnp.service.StudentService;

	@CrossOrigin
	@RestController
	@RequestMapping(value = "/api/v1/")
	public class StudentController {
		
		@Autowired
		private StudentService service;
		
		// get all students    
		@GetMapping("/students")
		public ResponseEntity<List<Student>> getAllStudent()
	   {
			List<Student> students=service.viewAllStudents();
			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	   }
		
		// student registration
		@PostMapping("/students")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> save(@Valid @RequestBody Student student)
		{
			System.out.println("Registration success");
			Student students=service.save(student);
			String email=students.getEmail();
			return new ResponseEntity<String>("Student with Mail-id :"+email+" added Successfully ",HttpStatus.OK);
			}	
		
		// get student by id 
        @GetMapping("/students/{userId}")
		public ResponseEntity<Student> findById(@PathVariable long userId) {

			return new ResponseEntity<>(service.findStudentByStudentId(userId), HttpStatus.OK);

		}
       
	   //update student details by id
		@PutMapping("/students/{userId}")
		public ResponseEntity<Student> updateStudentById(@Valid @RequestBody Student student) {
			if (service.updateStudentbyId(student) != null)
				return new ResponseEntity<Student>(student, HttpStatus.OK);
			return null;
		}
		/*
		//delete student details
		@DeleteMapping("/students/{userId}")

		public ResponseEntity<String> deleteStudentById(@PathVariable long userId) {
			if (service.deleteStudentById(userId))
				return new ResponseEntity<>(StudentRegistrationConstants.deleteSuccess, HttpStatus.OK);
			return null;

		}*/
		
		
		@PatchMapping(value="students/login")
		public ResponseEntity<String> studentLogin(@RequestBody Map<String,String> loginData)
		{
			service.studentLogin(loginData);
			return new ResponseEntity<String>("...Login Successful...",HttpStatus.OK);
		}
		
	}
			

