package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Tag implements Serializable{
	private Long id_tag;
	private String tag_name;

	public Tag() {
		super();
	}

	public Tag(Long id_tag, String tag_name) {
		this.id_tag = id_tag;
		this.tag_name = tag_name;
	}

	@Id
	@GeneratedValue
	public Long getId_tag() {
		return id_tag;
	}

	public void setId_tag(Long id_tag) {
		this.id_tag = id_tag;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
		
	
}
