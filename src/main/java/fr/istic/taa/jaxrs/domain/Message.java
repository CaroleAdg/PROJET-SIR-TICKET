package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Message implements Serializable{
	private Long id_message;
	private String comment;
	private Ticket ticket;
	private User user;
	

	public Message(Long id_message, String comment) {
		super();
		this.id_message = id_message;
		this.comment = comment;
	}
	
	
	public Message() {
		super();
	}


	@Id
	@GeneratedValue
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
	
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@ManyToOne
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	
}
