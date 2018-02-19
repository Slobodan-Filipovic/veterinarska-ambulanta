package dackage;

import javax.persistence.EntityManager;

import model.Veterinar;
import repositories.DatabaseManager;
import repositories.VeterinarRepository;

public class MyApp {
	public static void main(String[] args) {
		EntityManager em = new DatabaseManager().getEntityManager();
		VeterinarRepository veterinarRepository = new VeterinarRepository(em);
		//veterinarRepository.getAll().forEach( System.out::println);
		
		for(Veterinar vet: veterinarRepository.getAll()) {
			System.out.println(vet.toString());
		}
		

		
		/*Wont work if this is not in transation*/
		Veterinar v = new Veterinar();
		v.setIme("JPAIme");
		v.setPrezime("JPAPrezime");
		v.setTelefon("091283");
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		
		
		Veterinar vet = new Veterinar();
		vet = veterinarRepository.getVetById(8);
		System.out.println(vet.toString());
		
		
	}

}
