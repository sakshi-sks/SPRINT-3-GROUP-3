package com.tnp.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
//import org.springframework.dao.DataIntegrityViolationException;



import com.tnp.exception.admin.ResourceNotFoundException;
import com.tnp.repository.LoginRepository;
import com.tnp.entity.AdminLogin;


@Service
public class serviceimpl implements service {

	@Autowired
	private LoginRepository repository;

	public List<AdminLogin> getAllDetails() 
	{
		List<AdminLogin> users = (List<AdminLogin>) repository.findAll();

		return users;
	}

	public AdminLogin save(AdminLogin user)
	{
		return repository.save(user);
	}
	
	public List<AdminLogin> findByUserName(String userName)
	{
		List<AdminLogin> users=(List<AdminLogin>) repository.findByUserName(userName);
		return users;
		
	}
	
	public AdminLogin update(Map<String,String> updateData, int id)
	{
		String updatedUserName=updateData.get("username");
		String updatedPassword=updateData.get("password");
		
		return repository.findById(id).map(users->
		{
			if(!StringUtils.isEmpty(updatedUserName))
			{
				users.setUserName(updatedUserName);
			
			}
			if(!StringUtils.isEmpty(updatedPassword))
			{
				users.setPassword(updatedPassword);
			
			}
			
			repository.save(users);
			return users;
		}).orElseThrow();
			
		}
	
	public void userLogin(Map<String,String> loginData)
	{
		String userName=loginData.get("username");
		String password=loginData.get("password");
		Boolean found= false;
		if(userName==null)
		 {
			 throw new resourcenotfoundexception("Please enter mail id");
		 }
		List<AdminLogin> users=(List<AdminLogin>)repository.findAll();
		for(AdminLogin user : users)
		{
			if((user.getUserName().equals(userName)) && (user.getPassword().equals(password)))
			{
				found=true;
				break;
			}
		}
		if(found==false)
		{
			throw new resourcenotfoundexception("Login Failed,please check the details you have entered and try again");
		}
	}

//	@Override
//	public List<password> findByUserName(String userName) {
//
//
//		return null;
//	}
	public AdminLogin save1(AdminLogin user)
	{
	  return repository.save(user);

	}
	}


