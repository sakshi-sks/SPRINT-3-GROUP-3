package com.tnp.service;

	import java.util.List;
	import java.util.Map;

   import com.tnp.entity.Recruiter;
	

	public interface RecruiterService {
		public Recruiter register(Recruiter recruiter);
		public List<Recruiter> getAllRecruiters();
		public List<Recruiter> findByMail(String mail);
		public Recruiter update(Map<String,String> updateData,long id);
		
		public boolean recruiterLogin(String mail,String password);

	}


