package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Cargos;
import view.Funcionarios;

@Entity
@Table(name="funcionarios_filiais")
public class Funcionario {
	
	@Id
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
	
	//um ou mais funcionários correspondem a uma filial
	@ManyToOne
	@JoinColumn(name = "filial", nullable = false, foreignKey = @ForeignKey(name = "fk_filiais_id")) //coluna da tabela pai
	private Filial filial = new Filial();
	
	//um funcionario possui um ou mais avisos
	@OneToMany(mappedBy = "funcionario") //nome do campo na tabela filha
	private List<Aviso> avisos = new ArrayList<Aviso>();
	

	
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public boolean cadastrarFuncionario(String nome, String cpf, String senha, String cargo, int filial_func, String email) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSenha(senha);
		this.setCargo(cargo);
		this.setEmail(email);
		
		filial.setId(filial_func);
		this.setFilial(filial);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			con.getTransaction().rollback();
			con.close();
			return false;
		}
		finally {
			con.close();
		}
		
		return true;
	}
	
	public void alterarDadosFuncionario(String novoNome, String cpfFuncionario, String novaSenha, String novoCargo, int novaFilial, String novoEmail) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.nome = novoNome;
		this.cpf = cpfFuncionario;
		this.senha = novaSenha;
		this.cargo = novoCargo;
		this.email = novoEmail;
		
		filial.setId(novaFilial);
		this.setFilial(filial);
		
		try {
			con.getTransaction().begin();
			con.merge(this);
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
	
	public List<Funcionario> consultarTodosFuncionarios(){
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		List<Funcionario> funcionarios = null;

		try {
			funcionarios = con.createQuery("from Funcionario f").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return funcionarios;
		
	}

	
	public List<Funcionarios> listarFuncionarios(){
		List<Funcionarios> lista = new ArrayList<>();
		for (Funcionario f: this.consultarTodosFuncionarios()) {
			Funcionarios nomeF = new Funcionarios(f.getCpf(), f.getNome(), f.getCargo());
			nomeF.setCpf(f.getCpf());
			nomeF.setNome(f.getNome());
			nomeF.setCargo(f.getCargo());
			lista.add(nomeF);
		}
		
		return lista;
	}
	
	public List<Cargos> listarCargos(){
		
		List<Cargos> cargos = new ArrayList<>();
		
		Cargos cargo1 = new Cargos(1, "Motorista");
		cargos.add(cargo1);
		Cargos cargo2 = new Cargos(2, "Supervisor");
		cargos.add(cargo2);
		Cargos cargo3 = new Cargos(3, "Administrador");
		cargos.add(cargo3);
		
		return cargos;
	}
	
	public Funcionario removerFuncionario(String cpf){
		EntityManager con = new ConnectionFactory().getConnection();

		Funcionario funcionario = null;

		try {
			funcionario = con.find(model.Funcionario.class, cpf);		

			con.getTransaction().begin();
			con.remove(funcionario);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return funcionario;
	}
	
	public Funcionario encontrarFuncionario(String cpf){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Funcionario funcionario  = null;

		try {
			funcionario = con.find(model.Funcionario.class, cpf);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return funcionario;
	}
	
	public String verificarLogin(String email){
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		List<Funcionarios> list = new ArrayList<>();
		
		String cpf = "";
		
		try {
			// Precisa da query personalizada aqui para retornar o cpf correspondente ao email e depois chamar a função de encontrar funcionário
			Query query = con.createNativeQuery("select cpf from funcionarios_filiais where email = :email");
			query.setParameter("email", email);

			list = query.getResultList();

			cpf = list.toString();
			
			if(cpf.length() > 3) {
				cpf = cpf.substring(1, 12);
			}else {
				cpf = "Não encontrado";
			}
					
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return cpf;
	}
	
}
