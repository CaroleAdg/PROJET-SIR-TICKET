package fr.istic.dto;

import java.io.Serializable;

import fr.istic.taa.jaxrs.domain.Ticket;

public class TicketDto implements Serializable{
	private Long id_ticket;
	private String label;
	private Long userId;
	private Long tagId;
	public TicketDto() {
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public TicketDto(Ticket t) {
		this.id_ticket=t.getId_ticket();
		this.label= t.getLabel();
		this.userId= t.getUser().getId_user();
	}
	public Long getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(Long id_ticket) {
		this.id_ticket = id_ticket;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
