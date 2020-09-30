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
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	private String id_rastreador;
	private String placa;
	private String marca_rastreador;
	private String versao_rastreador;
	
	//um ou mais funcionarios possuem um veículo
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
	private Funcionario funcionario = new Funcionario();
	
	//um veiculo possui uma ou mais viagens
	@OneToMany(mappedBy = "veiculo")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	public String getId_rastreador() {
		return id_rastreador;
	}
	public void setId_rastreador(String id_rastreador) {
		this.id_rastreador = id_rastreador;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca_rastreador() {
		return marca_rastreador;
	}
	public void setMarca_rastreador(String marca_rastreador) {
		this.marca_rastreador = marca_rastreador;
	}
	public String getVersao_rastreador() {
		return versao_rastreador;
	}
	public void setVersao_rastreador(String versao_rastreador) {
		this.versao_rastreador = versao_rastreador;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void cadastrarVeiculo(String id_rastreador, String placa, String versao, String marca_rastreador, String cpf_funcionario){
		EntityManager con = new ConnectionFactory().getConnection();
		
		funcionario.setCpf(cpf_funcionario);
	
		this.setFuncionario(funcionario);
		this.setId_rastreador(id_rastreador);
		this.setPlaca(placa);
		this.setVersao_rastreador(versao);
		this.setMarca_rastreador(marca_rastreador);

		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
	}
	
	public void excluirVeiculo(String id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Veiculo veiculo = null;
		
		try {
			veiculo = con.find(model.Veiculo.class, id);		
			
			con.getTransaction().begin();
			con.remove(veiculo);
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