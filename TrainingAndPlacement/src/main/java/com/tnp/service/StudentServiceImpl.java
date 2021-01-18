package com.tnp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.dao.DataIntegrityViolationException;
import com.tnp.student.exception.InputException;
import com.tnp.student.exception.ResourceNotFoundException;
import com.tnp.student.exception.DuplicateStudentException;
import com.tnp.student.applicationConstants.StudentRegistrationConstants;
import com.tnp.student.exception.StudentNotFoundException;
import com.tnp.service.StudentService;
import com.tnp.repository.StudentRepository;
import com.tnp.entity.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;


	@Override
	public List<Student> viewAllStudents() {
		List<Student> listOfStudents = repository.findAll();
		if(listOfStudents.isEmpty())
			throw new StudentNotFoundException(StudentRegistrationConstants.studentNotFound);
		else
			return listOfStudents;
	}
	public Student save(Student student) {
		Optional<Student> optionalStudent = repository.findById(student.getUserId());
		if (optionalStudent.isPresent()) {
			throw new DuplicateStudentException(StudentRegistrationConstants.studentAlreadyExists);
		} else {

			return repository.save(student);
		}

	}

	public Student findStudentByStudentId(long userId) {
		Optional<Student>studentById=repository.findById(userId);
		if(studentById.isPresent())
			return studentById.get();
		else throw new StudentNotFoundException(StudentRegistrationConstants.studentNotFound);

	}
	
	@Override
	public Student updateStudentbyId(Student student) {
		Optional<Student> optionalStudent =repository.findById(student.getUserId());
		if(optionalStudent.isPresent()) {
			repository.save(student);
			return student;
		}
		else {
			throw new StudentNotFoundException(StudentRegistrationConstants.studentNotFound);
		}
	}
	/*
	@Override
	public boolean deleteStudentById( long userId) {
		Optional<Student> studentById=repository.findById(userId);
		if(studentById.isPresent()) {
			repository.deleteById(userId);
			return true;
		}
		else {
			throw new StudentNotFoundException(StudentRegistrationConstants.studentNotFound);
		}
		
	}*/



	
	public void studentLogin(Map<String,String> loginData)
	{
		String email=loginData.get("email");
		String password=loginData.get("password");
		Boolean found= false;
		if(email==null)
		 {
			 throw new InputException("Please enter mail id");
		 }
		List<Student> students=(List<Student>)repository.findAll();
		for(Student student : students)
		{
			if((student.getEmail().equals(email)) && (student.getPassword().equals(password)))
			{
				found=true;
				break;
			}
		}
		if(found==false)
		{
			throw new ResourceNotFoundException("Login Failed,please check the details you have entered and try again");
		}
	}
	}



