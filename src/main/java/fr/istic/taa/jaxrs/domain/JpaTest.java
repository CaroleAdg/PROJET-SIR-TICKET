package fr.istic.taa.jaxrs.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		User user = new User();
		user.setFirst_name("Durand");
		user.setLast_name("BILL");
		manager.persist(user);
		

		User user1 = new User();
		user1.setFirst_name("Jean");
		user1.setLast_name("DOSSOU");
		manager.persist(user1);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
