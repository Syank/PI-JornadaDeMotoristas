package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
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
	private String cargo;
	private Integer fk_filiais_id;
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getFk_filiais_id() {
		return fk_filiais_id;
	}
	public void setFk_filiais_id(Integer fk_filiais_id) {
		this.fk_filiais_id = fk_filiais_id;
	}
	
	
	public static int cadastrarMotorista() {
		EntityManager con = new ConnectionFactory().getConnection();
		Funcionario motorista = new Funcionario();
		JornadaTrabalho jornada = new JornadaTrabalho();
		
		motorista.setCpf("12548756923");
		motorista.setFk_filiais_id(1);
		motorista.setNome("Bárbara");
		motorista.setSenha("batatarecheada");
		motorista.setCargo("Motorista");
		
		jornada.setFk_funcionarios_cpf(motorista.getCpf());
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
			con.persist(motorista);
			con.getTransaction().commit();
			
			//Mandando os dados do trabalho do motorista para a tabela de jornadas de trabalho
			con.getTransaction().begin();
			con.persist(jornada);
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