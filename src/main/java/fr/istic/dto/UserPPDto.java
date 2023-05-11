package fr.istic.dto;

import fr.istic.taa.jaxrs.domain.User;

public class UserPPDto {
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	
	public UserPPDto() {
		
	}

	public UserPPDto(String first_name, String last_name, String email, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	public UserPPDto(User u) {
		this.first_name  = u.getFirst_name();
		this.last_name= u.getLast_name();
		this.email = u.getEmail();
		this.password = u.getPassword();
		}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	
	
	
}
