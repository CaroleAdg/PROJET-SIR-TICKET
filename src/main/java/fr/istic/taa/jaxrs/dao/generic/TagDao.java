package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tag;

public class TagDao extends AbstractJpaDao<Long,Tag> {

	public TagDao() {
		this.setClazz(Tag.class);
	}
}
