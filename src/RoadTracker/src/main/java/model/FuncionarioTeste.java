package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncionarioTeste {
	
	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Barbara");
		
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("RoadTrackerPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}