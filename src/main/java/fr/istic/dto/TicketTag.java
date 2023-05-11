package fr.istic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.Ticket;

public class TicketTag implements Serializable{
	private Long id_ticket;
	private String label;
	private Long userId;
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	private List<Tag> tags = new ArrayList<Tag>();
	public TicketTag() {
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public TicketTag(Ticket t) {
		this.id_ticket=t.getId_ticket();
		this.label= t.getLabel();
		this.userId= t.getUser().getId_user();
		this.tags = t.getTags();
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
