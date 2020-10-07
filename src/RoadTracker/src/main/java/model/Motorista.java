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
import view.Listas;

@Entity
@Table(name = "motoristas")
public class Motorista {
	@Id
	private String cpf;
	
	private String nome;
	private String email;
	private String senha;
	private String salario;
	private String cargaHoraria;
	private String turno;
	private int idFilial;
	private boolean seg;
	private boolean ter;
	private boolean qua;
	private boolean qui;
	private boolean sex;
	private boolean sab;
	private boolean dom;
	
	// Mapeamento
	@ManyToOne
	@JoinColumn(name = "filiais", nullable = false, foreignKey = @ForeignKey(name = "fk_filiais_id"))
	private Filial filial = new Filial();
	@OneToMany(mappedBy = "funcionario")
	private List<Aviso> avisos = new ArrayList<Aviso>();
	@OneToMany(mappedBy = "funcionario")
	private List<Status> status = new ArrayList<Status>();
	@OneToMany(mappedBy = "funcionario")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	
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
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isSeg() {
		return seg;
	}
	public void setSeg(boolean seg) {
		this.seg = seg;
	}
	public boolean isTer() {
		return ter;
	}
	public void setTer(boolean ter) {
		this.ter = ter;
	}
	public boolean isQua() {
		return qua;
	}
	public void setQua(boolean qua) {
		this.qua = qua;
	}
	public boolean isQui() {
		return qui;
	}
	public void setQui(boolean qui) {
		this.qui = qui;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean isSab() {
		return sab;
	}
	public void setSab(boolean sab) {
		this.sab = sab;
	}
	public boolean isDom() {
		return dom;
	}
	public void setDom(boolean dom) {
		this.dom = dom;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public List<Aviso> getAvisos() {
		return avisos;
	}
	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}
	public List<Status> getStatus() {
		return status;
	}
	public void setStatus(List<Status> status) {
		this.status = status;
	}
	public List<Viagem> getViagens() {
		return viagens;
	}
	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public int getIdFilial() {
		return idFilial;
	}
	public void setIdFilial(int idFilial) {
		this.idFilial = idFilial;
	}
	
	
	
	
	// Métodos
	public void cadastrarMotorista(String cpf, String nome, String email, String senha, String salario, String cargaHoraria, int idFilial,
			String turno, boolean seg, boolean ter, boolean qua, boolean qui, boolean sex, boolean sab, boolean dom) {

		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setCargaHoraria(cargaHoraria);
		this.setIdFilial(idFilial);
		this.setTurno(turno);
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
		
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao cadastrar o motorista. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		

	}

	public void alterarDadosMotorista(String cpf, String nome, String email, String senha, String salario, String cargaHoraria, int idFilial,
			String turno, boolean seg, boolean ter, boolean qua, boolean qui, boolean sex, boolean sab, boolean dom) {
		
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setCargaHoraria(cargaHoraria);
		this.setIdFilial(idFilial);
		this.setTurno(turno);
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
		
		EntityManager con = new ConnectionFactory().getConnection();
		
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
	public Motorista excluirMotorista() {
		EntityManager con = new ConnectionFactory().getConnection();

		Motorista motorista = null;

		try {
			motorista = con.find(model.Motorista.class, cpf);		

			con.getTransaction().begin();
			con.remove(motorista);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return motorista;
	}
	
	public List<Listas> listarMotoristas() {
		List<Listas> lista = new ArrayList<>();
		for (Motorista m: this.consultarTodosMotoristas()) {
			Listas nome = new Listas(m.cpf, m.nome);
			lista.add(nome);
		}
		return lista;
	}
	public List<Motorista> consultarTodosMotoristas() {
		EntityManager con = new ConnectionFactory().getConnection();
		List<Motorista> motorista = null;

		try {
			motorista = con.createQuery("from Motorista m").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return motorista;
	}
	
	public Motorista encontrarMotorista() {
		EntityManager con = new ConnectionFactory().getConnection();

		Motorista motorista  = null;

		try {
			motorista = con.find(model.Motorista.class, cpf);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return motorista;
	}
}
