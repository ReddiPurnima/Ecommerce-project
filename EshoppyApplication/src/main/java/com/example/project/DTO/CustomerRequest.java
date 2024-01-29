package com.example.project.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerRequest {
	@Id
	private Long id;
	@NotNull(message = "username mus be entered")
	private String name;
	@Email(message = "enter correct email")
	private String email;
	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "enter valid mobnum")
	private String mobile;
	@Pattern(regexp ="[A-Z]{1}[a-z]{1}[0-9]{1}",message = "enter valid password")
	private String password;
	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequest(@NotNull String name, @Email String email,
			@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "enter valid mobnum") String mobile,
			@Pattern(regexp = "[A-Z]{1}[a-z]{1}[0-9]{1}", message = "enter valid password") String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
