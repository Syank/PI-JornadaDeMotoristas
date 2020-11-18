package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="logs")
public class Logs {
	
	// Declarando as váriaveis
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length=14)
	private String cpf;
	
	@Column(length=50)
	private String nome;
	
	@Column(length=10)
	private String data;
	
	@Column(columnDefinition="TEXT")
	private String registro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	
	
	
	
	
	public void registrarLog(String nome, String cpf, String registro) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		LocalDate hoje = LocalDate.now();
    	int ano = hoje.getYear();
    	int dia = hoje.getDayOfMonth();
    	int mes = hoje.getMonthValue();
    	
    	String diaCerto = "";
    	if (dia >= 1 && dia < 10) {
    		diaCerto = '0' + String.valueOf(dia);
    	}
    	else {
    		diaCerto = String.valueOf(dia);
    	}
    	
    	String data = (diaCerto + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
    	
    	
		this.setNome(nome);
		this.setCpf(cpf);
		this.setData(data);
		this.setRegistro(registro);
		
    	
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao registrar o log. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
	}
	
}
