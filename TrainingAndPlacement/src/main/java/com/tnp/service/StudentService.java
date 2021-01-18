package com.tnp.service;
import java.util.List;
import java.util.Map;

import com.tnp.entity.Student;

public interface StudentService {
	

			public List<Student> viewAllStudents();
			public Student save(Student student);
			public Student findStudentByStudentId(long userId);
			public Student updateStudentbyId(Student student);
			//public boolean deleteStudentById( long userId);
			public void studentLogin(Map<String,String> loginData);
			
		}




