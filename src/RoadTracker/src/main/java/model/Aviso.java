package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Avisos;

@Entity
@Table(name="avisos")
public class Aviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String tipo;
	private String funcionario_destino;
	private String mensagem;
	private boolean visualizado;
	private String data;
	
	//um ou mais avisos correspondem a um funcionario
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
	private Funcionario funcionario = new Funcionario();
	
	//um ou mais avisos correspondem a um funcionario
	@ManyToOne
	@JoinColumn(name = "motorista", nullable = false, foreignKey = @ForeignKey(name = "fk_motoristas_cpf")) //coluna da tabela pai
	private Motorista motorista = new Motorista();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFuncionario_destino() {
		return funcionario_destino;
	}
	public void setFuncionario_destino(String funcionario_destino) {
		this.funcionario_destino = funcionario_destino;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isVisualizado() {
		return visualizado;
	}
	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public void cadastrarAviso(String tipo, String funcionario_destino, String mensagem, String motorista_origem) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("dd/MM/yyyy");
		
		this.setData(df.format(hoje));
		this.setMensagem(mensagem);
		this.setTipo(tipo);
		this.setVisualizado(false);
		
		funcionario.setCpf(funcionario_destino);
		this.setFuncionario(funcionario);
		
		motorista.setCpf(motorista_origem);
		this.setMotorista(motorista);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao enviar o aviso. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public List<Aviso> consultarTodosAvisos(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Aviso> avisos = null;
		try {
			avisos = con.createQuery("from Aviso a").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return avisos;
	}
	
	public List<Avisos> listarAvisos(){	
		List<Avisos> lista = new ArrayList<>();
		for (Aviso a: this.consultarTodosAvisos()) {
			Avisos aviso = new Avisos(a.getMensagem(), a.getFuncionario_destino(), getData());
			lista.add(aviso);
		}
		
		return lista;
		
	}
	
	public Aviso encontrarAviso(int id){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Aviso aviso = null;

		try {
			aviso = con.find(model.Aviso.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return aviso;
	}
	
}
