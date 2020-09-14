package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
	
	@Id
	private String cpf;
	private String nome;
	private String senha;
	private Integer cargo;
	private String filial;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}
	
	public static int cadastrarMotorista() {
		EntityManager con = new ConnectionFactory().getConnection();
		Motorista motorista = new Motorista();
		
		motorista.setCpf("12345678903");
		motorista.setCarga_horaria("8");
		/* motorista.setDias_trabalho(); */
		motorista.setFk_id_filial(1);
		motorista.setNome("Bárbara");
		motorista.setSenha("batatarecheada");
		motorista.setTurno("tarde");
		
		try {
			con.getTransaction().begin();
			con.persist(motorista);
			con.getTransaction().commit();
			
			con.close();
			return 1;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "O motorista já existe. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return 0;
	}
	
	public static int cadastrarFilial() {
		EntityManager con = new ConnectionFactory().getConnection();
		Filial filial = new Filial();
		
		filial.setNome("Filial Caçapava");
		filial.setCidade("Caçapava");
		filial.setEstado("SP");	
		
		try {
			con.getTransaction().begin();
			con.persist(filial);
			con.getTransaction().commit();
			
			con.close();
			return 1;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return 0;
	}
	
}