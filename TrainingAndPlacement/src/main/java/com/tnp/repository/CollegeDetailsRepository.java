package com.tnp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnp.entity.CollegeDetails;

@Repository
public interface CollegeDetailsRepository extends JpaRepository<CollegeDetails, Long> {

}
