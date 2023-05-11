package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.*;


public class TicketDao extends AbstractJpaDao<Long,Ticket> {
	
	public TicketDao() {
		this.setClazz(Ticket.class);
	}

}
