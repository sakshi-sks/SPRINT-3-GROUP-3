package com.tnp.service;

import java.util.List;
import java.util.Map;

import com.tnp.entity.AdminLogin;



	public interface service {

		public List<AdminLogin> getAllDetails();
		public AdminLogin save(AdminLogin user);
		public List<AdminLogin> findByUserName(String userName);
		public AdminLogin update(Map<String,String> updateData,int id);
		public void userLogin(Map<String,String> loginData);
	}
	