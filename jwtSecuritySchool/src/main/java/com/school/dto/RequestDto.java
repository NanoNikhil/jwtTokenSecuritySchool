package com.school.dto;

public class RequestDto {

	private String name;
	private String mobile;
	private String mail;
	private String section;
	private String username;
	private String password;
	private String roles;
	public RequestDto() {
		super();
	}

	public RequestDto(String name, String mobile, String mail, String section, String username, String password,
			String roles) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.mail = mail;
		this.section = section;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
