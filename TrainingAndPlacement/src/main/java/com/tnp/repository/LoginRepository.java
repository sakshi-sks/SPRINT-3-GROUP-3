package com.tnp.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tnp.entity.AdminLogin;


@Repository
public interface LoginRepository extends CrudRepository<AdminLogin,Integer> {


	List<AdminLogin> findByUserName(String userName);
}
