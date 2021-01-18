package com.tnp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnp.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
