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

import view.Veiculos;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	private String placa;
	private String modelo_veiculo;
	private int id_rastreador;
	private String marca_rastreador;
	private String modelo_rastreador;

	@ManyToOne
	@JoinColumn(name = "filiais", nullable = false, foreignKey = @ForeignKey(name = "fk_filiais_id"))
	private Filial filial = new Filial();
	@OneToMany(mappedBy = "veiculo")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	
	
	
	public int getId_rastreador() {
		return id_rastreador;
	}
	public void setId_rastreador(int id_rastreador) {
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
	public Filial getFuncionario() {
		return filial;
	}
	public void setFuncionario(Filial filial) {
		this.filial = filial;
	}
	public String getModelo_veiculo() {
		return modelo_veiculo;
	}
	public void setModelo_veiculo(String modelo_veiculo) {
		this.modelo_veiculo = modelo_veiculo;
	}
	public String getModelo_rastreador() {
		return modelo_rastreador;
	}
	public void setModelo_rastreador(String modelo_rastreador) {
		this.modelo_rastreador = modelo_rastreador;
	}
	
	public void cadastrarVeiculo(String id_rastreador, String placa, String versao, String marca_rastreador){
		int id;
		id = Integer.parseInt(id_rastreador);
		EntityManager con = new ConnectionFactory().getConnection();
		
		
		this.setId_rastreador(id);
		this.setPlaca(placa);
		this.setModelo_rastreador(versao);
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
	
	public void alterarDadosVeiculo(String placa, String marca_rastreador, String versao_rastreador, Integer id_rastreador) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.id_rastreador = id_rastreador;
		this.placa = placa;
		this.modelo_rastreador = versao_rastreador;
		this.marca_rastreador = marca_rastreador;
		
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
	
	public void excluirVeiculo(String placa) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Veiculo veiculo = null;
		
		try {
			veiculo = con.find(model.Veiculo.class, placa);		
			
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
	
	public List<Veiculo> consultarTodosVeiculos(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Veiculo> veiculos = null;
		try {
			veiculos = con.createQuery("from Veiculo v").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return veiculos;
	}
	
	public List<Veiculos> listarVeiculos(){	
		List<Veiculos> lista = new ArrayList<>();
		for (Veiculo vei: this.consultarTodosVeiculos()) {
			Veiculos veiculos = new Veiculos(vei.getId_rastreador(), vei.getPlaca());
			lista.add(veiculos);
		}
		
		return lista;
		
	}
	
	public Veiculo encontrarVeiculo(String placa){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Veiculo veiculo = null;

		try {
			veiculo = con.find(model.Veiculo.class, placa);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return veiculo;
	}
	
}