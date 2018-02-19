package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Veterinar;

public class VeterinarRepository {
	private EntityManager em;
	
	public VeterinarRepository(EntityManager em) {
		this.em = em;
		
	}
	
	public List<Veterinar> getAll(){
		TypedQuery<Veterinar> query = em.createQuery("SELECT v FROM Veterinar v", Veterinar.class);
		 return query.getResultList();
	}
	
	public Veterinar getVetById(int id) {
		 Veterinar vet = em.find(Veterinar.class, id);
		 return vet;
	}

}
