package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String cpf;
	private String nome;
	private String senha;
	private String cargo;
	private int fk_filiais_id;
	
public Funcionario(String cpf, String nome, String senha, String cargo, String k_filiais_id) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
		this.fk_filiais_id = fk_filiais_id;
		
		this.cadastrarMotorista();
	}

//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
	

	
	public void cadastrarMotorista() {

		EntityManager con = new ConnectionFactory().getConnection();
		//Funcionario motorista = new Funcionario();
		JornadaTrabalho jornada = new JornadaTrabalho();
		
		
		jornada.setFk_funcionarios_cpf(this.cpf);
		jornada.setCarga_horaria(8);
		jornada.setTurno("Noite");
		jornada.setSeg(true);
		jornada.setTer(true);
		jornada.setQua(true);
		jornada.setQui(true);
		jornada.setSex(true);
		jornada.setSab(true);
		jornada.setDom(false);
		
		try {
			
			//Mandando os dados do motorista para a tabela de motoristas
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
			
			//Mandando os dados do trabalho do motorista para a tabela de jornadas de trabalho
			con.getTransaction().begin();
			con.persist(jornada);
			con.getTransaction().commit();
			
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "O motorista já existe. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
		
	}
	
	public void cadastrarFilial() {
		EntityManager con = new ConnectionFactory().getConnection();
		Filial filial = new Filial();
		
		filial.setNome("Filial Caçapava");
		filial.setCidade("Caçapava");
		filial.setEstado("SP");	
		
		try {
			con.getTransaction().begin();
			con.persist(filial);
			con.getTransaction().commit();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			con.close();
		}
		
	}
	
	public void alterarSenhaMotorista(String novaSenha) {
		//lembrando que esse método tá bem simples ainda. não tem verificação de nada
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.senha = novaSenha;
		
		try {
			con.getTransaction().begin();
			con.refresh(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		

		
	}
	
}