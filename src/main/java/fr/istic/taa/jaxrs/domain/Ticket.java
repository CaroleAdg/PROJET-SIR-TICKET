package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;


@Entity
public class Ticket implements Serializable {
	private Long id_ticket;
	private String label;
	private User user;
	private List<Message> messages = new ArrayList<Message>();
	private List<Tag> tags = new ArrayList<Tag>();
	private List<Support> support=new ArrayList<Support>();
	
	public Ticket(Long id_ticket, String label) {
		this.id_ticket = id_ticket;
		this.label = label;
	}
	
	public Ticket() {
		
	}

	@Id
	@GeneratedValue
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

	
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	@ManyToMany(mappedBy="tickets")
	public List<Support> getSupport() {
		return support;
	}

	public void setSupport(List<Support> support) {
		this.support = support;
	}
	
	@ManyToMany
	@JoinTable(
			name="ticket_tag",
			joinColumns=@JoinColumn(name="id_ticket"),
			inverseJoinColumns=@JoinColumn(name="ticket_id")
			)
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	
	

	
	
	
	
	
}
