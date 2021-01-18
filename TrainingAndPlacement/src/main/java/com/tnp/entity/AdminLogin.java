package com.tnp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="AdminLogin")
public class AdminLogin {
	@Id
	@GeneratedValue
	@Column(name="Id")
private int id;
	@NotBlank(message="Please enter the user name ... it is mandatory!!")
	@Pattern(regexp="^[A-Z][a-z]{3,15}",message = "Please enter the user name in valid format")
	@Column(name="userName")
private String userName;
	@NotBlank(message="Please enter the password ... it is mandatory!!")
	 @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
	    message = "Please enter the password in a valid format")
	@Column(name="password")
private String password;
public AdminLogin() {
	
}
public AdminLogin(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}



