package fr.istic.dto;

public class TicketPPDto {
	private String label;
	private Long userId;
	private Long tagId;
	
	public TicketPPDto(String label, Long userId, Long tagId) {
		
		this.label = label;
		this.userId = userId;
		this.tagId = tagId;
	}

	public TicketPPDto() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
	
	
}
