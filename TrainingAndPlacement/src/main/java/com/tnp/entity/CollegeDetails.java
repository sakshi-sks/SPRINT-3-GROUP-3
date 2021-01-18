package com.tnp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;


@Entity
@Table(name="college_details")
public class CollegeDetails{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="college_id")
	private long cid;
	
	@Column(name="name")
	private String cname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pin_code")
	private long pin;
	
//	@NotBlank(message = "Please provide contact Number")
//	@Pattern(regexp="^[6-9][0-9]{9}$", message="Please provide a valid contact Number")
	@Column(name="contact_no")
	private String ccontactNo;
	
//	@NotBlank(message = "Please provide an email ID")
//	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email ID")
	@Column(name="email_id")
	private String cemailId;
	
	
	// All Argument Constructors
	
		public CollegeDetails(String ccontactNo,String cemailId,String cname,String address,long pin)
		{
			super();
			this.cemailId = cemailId;
			this.ccontactNo = ccontactNo;
			this.cname=cname;
			this.address=address;
			this.pin=pin;
		}
		
		
		// No argument Constructor
		
		public CollegeDetails() {
			super();
		}


		// setter methods
		
		public void setCemailId(String cemailId) {
			this.cemailId = cemailId;
		}
		public void setCcontactNo(String ccontactNo) {
			this.ccontactNo = ccontactNo;
		}
		public void setCid(long cid){
			this.cid=cid;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setPin(long pin) {
			this.pin = pin;
		}


		
		
		//getter methods
		
		public String getCemailId() {
			return cemailId;
		}
		public String getCname() {
			return cname;
		}
		public String getAddress() {
			return address;
		}
		public long getPin() {
			return pin;
		}
		public String getCcontactNo() {
			return ccontactNo;
		}
		public long getCid(){
			return cid;
		}
		

		
		
}