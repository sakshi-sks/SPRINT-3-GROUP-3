package com.tnp.entity;	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="student")
public class Student 
{
	
	
    @Id
    @Column(name="Student_Id")
	private long userId;

    @NotBlank(message="Name can't be empty!!")
    @Pattern(regexp="^[A-Z][a-z]{3,15}",message = "length must be in between 3 to 15,one uppercase,one lowercase letter")
    @Column(name="First_Name")
	private String firstName;
    
    @NotBlank(message="Name can't be empty!!")
    @Pattern(regexp="^[A-Z][a-z]{3,15}",message = "length must be in between 3 to 15,one uppercase,one lowercase letter")
    @Column(name="Last_Name")
	private String lastName;
    
   
    @Column(name="Branch_Name")
    private String branch;
    private String dob;
    
    @Column(name = "Contact_No")
    //@NotNull(message="Enter Mobile_No")
    //@Pattern(regexp="/^(0|[+91]{3})?[7-9][0-9]{9}$/", message= "enter a correct mobile no")
    private long mobileNo;
    
    @NotBlank(message="Email_Id is mandatory!!")
    @Column(name = "Student_Email")
    @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
	private String email;

    @NotBlank(message="Enter password!!")
    @Column(name = "Student_Password")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
    message = "Enter the password containing at least one digit,one uppercase letter,one lowercase letter,special symbol,no whitespace,atleast upto 8 places")
	private String password;
    private String passwordConfirmation;
    
    @Column(name="SSC_Percentage")
    private double ssc;
    
    @Column(name="HSC_Percentage")
    private double hsc;
    
    @Column(name="Degree_Percentage")
    private double degree;
    
    public Student()
    {
    	
    }
	
	
	
	public Student(long userId,
			@NotBlank(message = "Name can't be empty!!") @Pattern(regexp = "^[A-Z][a-z]{3,15}", message = "length must be in between 3 to 15,one uppercase,one lowercase letter") String firstName,
			@NotBlank(message = "Name can't be empty!!") @Pattern(regexp = "^[A-Z][a-z]{3,15}", message = "length must be in between 3 to 15,one uppercase,one lowercase letter") String lastName,
			@NotBlank(message = "Branch can't be empty!!") @Pattern(regexp = "^[A-Z][a-z]{2,15}", message = "length must be in between 2 to 15,one uppercase,one lowercase letter") String branch,
			String dob, long mobileNo,
			@NotBlank(message = "Email_Id is mandatory!!") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format") String email,
			@NotBlank(message = "Enter password!!") @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", message = "Enter the password containing at least one digit,one uppercase letter,one lowercase letter,special symbol,no whitespace,atleast upto 8 places") String password,
			String passwordConfirmation, double ssc, double hsc, double degree) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.ssc = ssc;
		this.hsc = hsc;
		this.degree = degree;
	}
	
	



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public double getSsc() {
		return ssc;
	}



	public void setSsc(double ssc) {
		this.ssc = ssc;
	}



	public double getHsc() {
		return hsc;
	}



	public void setHsc(double hsc) {
		this.hsc = hsc;
	}



	public double getDegree() {
		return degree;
	}



	public void setDegree(double degree) {
		this.degree = degree;
	}



	@Override
	public String toString() {
		return "Student [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", branch="
				+ branch + ", dob=" + dob + ", mobileNo=" + mobileNo + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", ssc=" + ssc + ", hsc=" + hsc + ", degree="
				+ degree + "]";
	}
	
}
