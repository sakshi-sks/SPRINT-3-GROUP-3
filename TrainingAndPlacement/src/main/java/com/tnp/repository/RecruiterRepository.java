package com.tnp.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tnp.entity.Recruiter;

	@Repository
	public interface RecruiterRepository extends CrudRepository<Recruiter,Long> {
		
		List<Recruiter> findByMail(String mail);
		
		
		
	}



