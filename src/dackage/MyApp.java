package dackage;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Veterinar;
import repositories.DatabaseManager;
import repositories.VeterinarRepository;

public class MyApp {
	public static void main(String[] args) {
		EntityManager em = new DatabaseManager().getEntityManager();
		VeterinarRepository veterinarRepository = new VeterinarRepository(em);
		// veterinarRepository.getAll().forEach( System.out::println);

		for (Veterinar vet : veterinarRepository.getAll()) {
			System.out.println(vet.toString());
		}

		// URADI DELETE I UPDATE
		/* Wont work if this is not in transation */
		/*
		 * Veterinar v = new Veterinar(); v.setIme("JPAIme");
		 * v.setPrezime("JPAPrezime"); v.setTelefon("091283");
		 * em.getTransaction().begin(); em.persist(v); em.getTransaction().commit();
		 */

		Veterinar vet = new Veterinar();
		vet = veterinarRepository.getVetById(8);
		System.out.println(vet.toString());

		System.out.println("NAMED QUERY:");
		TypedQuery<Veterinar> namedQuery = em.createNamedQuery("Veterinar.findByName", Veterinar.class);
		namedQuery.setParameter("ime", "%Vladica");
		namedQuery.getResultList().forEach(System.out::println);

		System.out.println("CRITERIA QUERY:START");
		CriteriaQuery<Veterinar> criteriaQuery = em.getCriteriaBuilder().createQuery(Veterinar.class);
		// em.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		Root<Veterinar> veterinarRoot = criteriaQuery.from(Veterinar.class);
		// criteriaQuery.from(Veterinar.class);
		// CriteriaQuery<Veterinar> criteriaQuery = new CriteriaBuilde
		criteriaQuery = criteriaQuery.select(veterinarRoot);
		em.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		System.out.println("CRITERIA QUERY:END");

		/* Update veterinar */
		System.out.println("Update:Start");
		em.getTransaction().begin();
		Veterinar vetZaUpdate = (Veterinar) em.find(Veterinar.class, 1);
		vetZaUpdate.setIme("UpdatovanoIme");
		em.persist(vetZaUpdate);
		em.getTransaction().commit();
		vet = veterinarRepository.getVetById(1);
		System.out.println(vet.toString());
		System.out.println("Update:End");

		/* Delete veterinar */
		Veterinar vetZaBrisanje = (Veterinar) em.find(Veterinar.class, 16); // change id(the number 16 in this case) to
																			// delete a different veterinar
		em.getTransaction().begin();
		em.remove(vetZaBrisanje);
		em.getTransaction().commit();
		vet = veterinarRepository.getVetById(16);// error should pop up, not found or something like that when ran a
													// second time.
		/*
		 * It did, fcking awesome, I am starting to think before i ctrl+f11: Exception
		 * in thread "main" java.lang.IllegalArgumentException: attempt to create delete
		 * event with null entity
		 */
	}

}
