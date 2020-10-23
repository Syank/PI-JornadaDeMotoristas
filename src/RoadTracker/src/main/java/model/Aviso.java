package model;

import java.time.LocalDate;
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
import javax.persistence.Table;
import javax.swing.JOptionPane;
import view.Avisos;

@Entity
@Table(name="avisos")
public class Aviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String mensagem;
	private boolean resolvido;
	private String data;
	private String nomenclatura;
	
	//um ou mais avisos correspondem a um funcionario
//	@ManyToOne
//	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
//	private Funcionario funcionario = new Funcionario();
	
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
	public boolean isResolvido() {
		return resolvido;
	}
	public String getNomenclatura() {
		return nomenclatura;
	}
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	
	public void cadastrarAviso(String funcionario_destino, String cpfMotorista, String mensagem) {
			EntityManager con = new ConnectionFactory().getConnection();
			
			Motorista motorista = new Motorista();
				
			LocalDate hoje = LocalDate.now();
	    	int ano = hoje.getYear();
	    	int dia = hoje.getDayOfMonth();
	    	int mes = hoje.getMonthValue();
	    	String data = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
			this.setData(data);
			
			this.setMensagem(mensagem);
			this.setResolvido(false); // não vou mandar uma coisa já resolvida
			
// 			String nomenclatura = "";
//			if (pneu.isSelected()) {
//				nomenclatura = nomenclatura + "PF";
//			
//			}
//			e assim vai...
			
			this.setNomenclatura("TST01"); // teste 1. isso precisa ver de acordo com as checkboxes da interface
			
			motorista.setCpf(cpfMotorista);
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
			Avisos aviso = new Avisos();
			aviso.setMotorista(a.getMotorista());
			aviso.setDataAviso(a.getData());
			aviso.setId(a.getId());
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
