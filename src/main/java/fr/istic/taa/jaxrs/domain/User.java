package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="type", discriminatorType=DiscriminatorType.STRING)
public class User implements Serializable {
	
	
	private Long id_user;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	@Column(name="type", insertable = false, updatable = false)
	private String type;
	
	private List<Message> messages = new ArrayList<>(); 
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	@Id
	@GeneratedValue
	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
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
	
	
	@Column(name="type", insertable = false, updatable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User() {
		
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
