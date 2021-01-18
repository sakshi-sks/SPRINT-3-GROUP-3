package com.tnp.service;


	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	//import org.springframework.beans.factory.annotation.Qualifier;
	//import org.springframework.dao.DataIntegrityViolationException;
	//import org.springframework.stereotype.Component;
	import org.springframework.stereotype.Service;
	import org.springframework.util.StringUtils;

	import com.tnp.entity.Recruiter;
	//import com.recruiter.entity.Student;
	//import com.recruiter.exception.InputException;
	//import com.recruiter.exception.ResourceNotFoundException;
	import com.tnp.repository.RecruiterRepository;


	@Service
	public class RecruiterServiceImpl implements RecruiterService
	{
		
	@Autowired
	private RecruiterRepository repo;

	public List<Recruiter> getAllRecruiters()
	{
		List<Recruiter> recruiters=(List<Recruiter>) repo.findAll();
		return recruiters;
	}
	public List<Recruiter> findByMail(String mail){
		List<Recruiter> recruiter=(List<Recruiter>) repo.findByMail(mail);
		return recruiter;
	}


	public Recruiter update(Map<String,String> updateData,long id)
	{
		String updatedUsername=updateData.get("username");
		String updatedPassword=updateData.get("password");
		String updatedMail=updateData.get("mail");
		String updatedAnnualPackage=updateData.get("annualPackage");
		String updatedEligibilityCriteria=updateData.get("eligibilityCriteria");
		String updatedJobProfile=updateData.get("jobProfile");
		String updatedDepartment=updateData.get("department");
		
		return repo.findById(id).map(recruiters->
		{
			if(!StringUtils.isEmpty(updatedUsername))
			{	
				recruiters.setUsername(updatedUsername);
			}
			if(!StringUtils.isEmpty(updatedPassword))
			{	
				recruiters.setPassword(updatedPassword);
			}
			if(!StringUtils.isEmpty(updatedMail))
			{	
				recruiters.setMail(updatedMail);
			}
			if(!StringUtils.isEmpty(updatedEligibilityCriteria))
			{	
				recruiters.setEligibilityCriteria(updatedEligibilityCriteria);
			}
			if(!StringUtils.isEmpty(updatedAnnualPackage))
			{	
				recruiters.setAnnualPackage(updatedAnnualPackage);
			}
			if(!StringUtils.isEmpty(updatedJobProfile))
			{
				recruiters.setJobProfile(updatedJobProfile);
			}
			if(!StringUtils.isEmpty(updatedDepartment))
			{
				recruiters.setDepartment(updatedDepartment);
			}
			repo.save(recruiters);
			return recruiters;
		}).orElseThrow();	
	}



	public boolean recruiterLogin(String mail,String password)
	{
		Boolean found= false;
		if(mail==null)
		{
			System.out.println("Please enter mail id");
		}
		List<Recruiter> recruiters=(List<Recruiter>)repo.findAll();
		for(Recruiter recruiter : recruiters)
		{
			if((recruiter.getMail().equals(mail)) && (recruiter.getPassword().equals(password)))
			{
				found=true;
				break;
			}
		}
		return found;
	}



	public Recruiter register(Recruiter recruiter)
	{
	  return repo.save(recruiter);

	}

	}