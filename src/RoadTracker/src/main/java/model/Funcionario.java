package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	
<<<<<<< Updated upstream
	
=======
>>>>>>> Stashed changes
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String cpf;
	private String nome;
	private String senha;
	private String cargo;
	private int fk_filiais_id;
	
public Funcionario(String cpf, String nome, String senha, String cargo, int k_filiais_id) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
		this.fk_filiais_id = fk_filiais_id;
		
		this.cadastrarMotorista();
	}

//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
	
	
<<<<<<< Updated upstream
	public Funcionario cadastrarMotorista() {
=======
	
	public int cadastrarMotorista() {
>>>>>>> Stashed changes
		EntityManager con = new ConnectionFactory().getConnection();
		//Funcionario motorista = new Funcionario();
		JornadaTrabalho jornada = new JornadaTrabalho();
		
<<<<<<< Updated upstream
		//dentro do set é onde deve ter o getText(). cuidado com o campo da filial e da carga horária porque são Integer
		motorista.setCpf("1254875621");
		motorista.setFk_filiais_id(1);
		motorista.setNome("Bárbara");
		motorista.setSenha("batatarecheada");
		motorista.setCargo("Motorista");
=======
		//motorista.setCpf(this.cpf);
		//motorista.setFk_filiais_id(1);
		//motorista.setNome("Bárbara");
		//motorista.setSenha("batatarecheada");
		//motorista.setCargo("Motorista");
>>>>>>> Stashed changes
		
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