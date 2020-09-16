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
	
	public Funcionario cadastrarMotorista() {
		EntityManager con = new ConnectionFactory().getConnection();
		Funcionario motorista = new Funcionario();
		JornadaTrabalho jornada = new JornadaTrabalho();
		
		//dentro do set é onde deve ter o getText(). cuidado com o campo da filial e da carga horária porque são Integer
		motorista.setCpf("1254875621");
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
			
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "O motorista já existe. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
		return motorista;
		
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
	
	public Funcionario alterarSenhaMotorista() {
		//lembrando que esse método tá bem simples ainda. não tem verificação de nada
		EntityManager con = new ConnectionFactory().getConnection();
		Funcionario motorista = new Funcionario();

		motorista.setCargo(this.cargo);
		motorista.setCpf(this.cpf);
		motorista.setFk_filiais_id(this.fk_filiais_id);
		motorista.setNome(this.nome);
		motorista.setSenha("123batata"); //pegar senha do TextField
		try {
			con.getTransaction().begin();
			con.merge(motorista);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
		return motorista;
		
	}
	
}