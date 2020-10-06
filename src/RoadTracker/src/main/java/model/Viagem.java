package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="viagens")
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String inicio;
	private String fim;
	private String total;
	private String destino;
	private String carga;
	private String situacao;
	
	//muitas viagens possuem um funcionário
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
	private Funcionario funcionario = new Funcionario();
	
	//uma viagem possui um ou mais status
	@OneToMany(mappedBy = "viagem") //nome do campo na tabela filha
	private List<Status> status = new ArrayList<Status>();
	
	//uma ou muitas viagens correspondem a um veículo
	@ManyToOne
	@JoinColumn(name = "veiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_veiculos_placa")) //coluna da tabela pai
	private Veiculo veiculo = new Veiculo();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	private void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	private Funcionario getFuncionario() {
		return funcionario;
	}
	private void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	private Veiculo getVeiculo() {
		return veiculo;
	}
	
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
	
	
	public void cadastrarViagem(String inicio, String origem, String destino, String cpfFuncionario, String placaVeiculo) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setInicio(inicio);
		this.setDestino(destino);
		
		funcionario.setCpf(cpfFuncionario);
		this.setFuncionario(funcionario);
		
		veiculo.setPlaca(placaVeiculo);
		this.setVeiculo(veiculo);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao cadastrar a viagem. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	

	public void alterarDadosViagem(String novoInicio, String novaOrigem, String novoDestino, String novoCpfFuncionario, String novoVeiculo, int idViagem) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setInicio(novoInicio);
		this.setDestino(novoDestino);
		
		funcionario.setCpf(novoCpfFuncionario);
		this.setFuncionario(funcionario);
		
		veiculo.setPlaca(novoVeiculo);
		this.setVeiculo(veiculo);
		
		try {
			con.getTransaction().begin();
			
			
			Query query = con.createQuery("update Viagem set inicio = :novoInicio, origem = :novaOrigem, destino = :novoDestino, funcionario = :novoFuncionario, veiculo = :novoVeiculo where id = :idViagem");
			query.setParameter("novoInicio", novoInicio);
			query.setParameter("novaOrigem", novaOrigem);
			query.setParameter("novoDestino", novoDestino);
			query.setParameter("novoFuncionario", this.getFuncionario());
			query.setParameter("novoVeiculo", this.getVeiculo());
			query.setParameter("idViagem", idViagem);
			query.executeUpdate();
			
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da viagem: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public void excluirViagem(Integer id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Viagem viagem = null;
		
		try {
			viagem = con.find(model.Viagem.class, id);		
			
			con.getTransaction().begin();
			con.remove(viagem);
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
	
	public List<Viagem> consultarTodasViagens(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Viagem> viagens = null;
		try {
			viagens = con.createQuery("from Viagem v").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return viagens;
	}
	
	public List<Viagem> listarViagens(){	
		List<Viagem> lista = new ArrayList<>();
		
		for (Viagem v: this.consultarTodasViagens()) {
			Viagem viagens = new Viagem();
			
			viagens.setFuncionario(v.getFuncionario());
			viagens.setDestino(v.getDestino());
			viagens.setInicio(v.getInicio());
			
			lista.add(viagens);
		}
		
		return lista;
		
	}
	
	public Viagem encontrarViagem(int id){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Viagem viagem = null;

		try {
			viagem = con.find(model.Viagem.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return viagem;
	}
	

}
