package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.istic.taa.jaxrs.domain.Message;


public class MessageDao extends AbstractJpaDao<Long,Message>{

	public MessageDao() {
		this.setClazz(Message.class);
	}
	public List<Message> findTicketMessages(Long id) {
		TypedQuery<Message> query = entityManager.createQuery("Select m from Message as m JOIN m.ticket as t where t.id = :id" , Message.class);
		return query.setParameter("id", id).getResultList();
		}
}
