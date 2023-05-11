package fr.istic.dto;

import fr.istic.taa.jaxrs.domain.Support;

public class SupportDto {
	private Long id_user;
	private String first_name;
	private String last_name;
	
	
	public SupportDto(Support s) {
		
		this.id_user = s.getId_user();
		this.first_name = s.getFirst_name();
		this.last_name = s.getLast_name();
	}
	public SupportDto() {
		
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
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
	
	

}
