package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Filiais;

@Entity
@Table(name="filiais")
public class Filial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	/* @Column(name="id_filial") */
	private Integer id;
	private String nome;
	private String cidade;
	private String estado;
	private String cnpj;
	private String rntrc;
	
	//uma filial possui um ou mais funcionarios
	@OneToMany(mappedBy = "filial") //nome do campo na tabela filha
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRntrc() {
		return rntrc;
	}
	public void setRntrc(String rntrc) {
		this.rntrc = rntrc;
	}
	
	public void cadastrarFilial(String nome, String cidade, String estado) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setNome(nome);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao cadastrar a filial. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public void alterarDadosFilial(String novoNome, String novaCidade, String novoEstado, Integer id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.id = id;
		this.cidade = novaCidade;
		this.estado = novoEstado;
		this.nome = novoNome;
		
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
	
	public void excluirFilial(Integer id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Filial filial = null;
		
		try {
			filial = con.find(model.Filial.class, id);		
			
			con.getTransaction().begin();
			con.remove(filial);
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
	
	public List<Filial> consultarTodasFiliais(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Filial> filiais = null;
		try {
			filiais = con.createQuery("from Filial f").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return filiais;
	}
	
	public List<Filiais> listarFiliais(){	
		List<Filiais> lista = new ArrayList<>();
		for (Filial f: this.consultarTodasFiliais()) {
			Filiais filiais = new Filiais(f.getId(), f.getNome(), f.getEstado());
			lista.add(filiais);
		}
		
		return lista;
		
	}
	
	public Filial encontrarFilial(int id){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Filial filial = null;

		try {
			filial = con.find(model.Filial.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return filial;
	}
	
}
