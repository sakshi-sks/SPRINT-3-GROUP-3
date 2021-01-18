package com.tnp.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="recruiters")
public class Recruiter 
{
	@Id
	@GeneratedValue
	@Column(name="Recruiter_Id")
	private long id;

	@NotBlank(message="Name can't be empty!!")
	//@Pattern(regexp="^[A-Z][a-z]{3,15}",message = "length must be in between 3 to 15")
	@Column(name="Recruiter_Name")
	private String username;


	@NotBlank(message="Enter password!!")
	@Column(name = "Recruiter_Password")
	//@Pattern(regexp="^(?=.\\d)(?=.[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$",message = "Enter the password containing at least one digit,one uppercase letter,one lowercase letter,special symbol,no whitespace,atleast upto 8 places")
	private String password;

	@NotBlank(message="Email_Id is mandatory!!")
	@Column(name = "Recruiter_Email",unique = true)
	//@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
	private String mail;

	@NotBlank(message="Campany_Name can't be empty!!!")
	//@Pattern(regexp="^[A-Z][a-z]{3,15}",message = "length must be in between 3 to 15")
	@Column(name="Recruiter_Company")
	private String company;
	//@NotBlank(message=" job profile can't be empty!!")
	private String jobProfile;
	//@NotBlank(message=" Eligibility Criteria can't be empty!!")
	private String eligibilityCriteria;
	//@NotBlank(message=" annual Package can't be empty!!")
	private String  annualPackage;
	//@NotBlank(message=" department can't be empty!!")
	private String department;
	public Recruiter(long id, String username,
			String password,
			String mail,
			String company, String jobProfile,
			String eligibilityCriteria, String annualPackage, String department) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.company = company;
		this.jobProfile = jobProfile;
		this.eligibilityCriteria = eligibilityCriteria;
		this.annualPackage = annualPackage;
		this.department = department;
	}
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getMail() {
		return mail;
	}
	public String getCompany() {
		return company;
	}
	public String getJobProfile() {
		return jobProfile;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public String getAnnualPackage() {
		return annualPackage;
	}
	public String getDepartment() {
		return department;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public void setAnnualPackage(String annualPackage) {
		this.annualPackage = annualPackage;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", username=" + username + ", password=" + password + ", mail=" + mail
				+ ", company=" + company + ", jobProfile=" + jobProfile + ", eligibilityCriteria=" + eligibilityCriteria
				+ ", annualPackage=" + annualPackage + ", department=" + department + "]";
	}
	public Recruiter() {
		super();
	}

}