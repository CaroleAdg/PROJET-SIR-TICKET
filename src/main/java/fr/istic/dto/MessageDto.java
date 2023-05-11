package fr.istic.dto;

import java.io.Serializable;

import fr.istic.taa.jaxrs.domain.Message;
import fr.istic.taa.jaxrs.domain.Ticket;

public class MessageDto implements Serializable {
	private String comment;
	private Long id_Ticket;
	private Long userId;
	
	public MessageDto(Message m) {
		this.comment=m.getComment();
		this.id_Ticket= m.getTicket().getId_ticket();
		this.userId= m.getUser().getId_user();
				
		}
	

	public MessageDto() {
		super();
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


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
