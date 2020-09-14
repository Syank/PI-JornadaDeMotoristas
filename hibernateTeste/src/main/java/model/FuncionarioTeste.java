package model;

import javax.persistence.EntityManager;
import connection.ConnectionFactory;

public class FuncionarioTeste {
	
	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("1234567894");
		funcionario.setNome("Bárbara2");
		funcionario.setSenha("precisadecriptografia");
		funcionario.setCargo(1);
		funcionario.setFilial("Minha casa");
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		
		em.close();
	}
	
}