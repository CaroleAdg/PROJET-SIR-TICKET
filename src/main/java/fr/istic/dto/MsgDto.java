package fr.istic.dto;

import java.io.Serializable;

import fr.istic.taa.jaxrs.domain.Message;
import fr.istic.taa.jaxrs.domain.User;

public class MsgDto implements Serializable {
	private Long id_message;
	private String comment;
	private Long id_Ticket;
	private UserDto user;
	
	public MsgDto(Message m) {
		this.id_message=m.getId_message();
		this.comment=m.getComment();
		this.id_Ticket=m.getTicket().getId_ticket();
		this.user = new UserDto(m.getUser());
	}
	
	public MsgDto() {
	
	}

	public Long getId_message() {
		return id_message;
	}
	public void setId_message(Long id_message) {
		this.id_message = id_message;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getId_Ticket() {
		return id_Ticket;
		
	}
	public void setId_Ticket(Long id_Ticket) {
		this.id_Ticket = id_Ticket;
	}
	
	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	
	
}
