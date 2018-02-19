package repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseManager {
	
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		if(entityManager == null) {
			/*<persistence-unit name="veterinarska-ambulanta" je uhvaceno iz persistence.xml. 
			 * Now you know where it came from.*/
			entityManager = Persistence.createEntityManagerFactory("veterinarska-ambulanta").createEntityManager();
		}
		return entityManager;
	}
	
 

}
