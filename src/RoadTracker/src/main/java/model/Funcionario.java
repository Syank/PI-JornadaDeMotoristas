package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	
	//um funcionario possui um ou mais status
	@OneToMany(mappedBy = "funcionario") //nome do campo na tabela filha
	private List<Status> status = new ArrayList<Status>();
	
	//um funcionario possui um ou mais veiculos
	@OneToMany(mappedBy = "funcionario") //nome do campo na tabela filha
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	//um funcionario possui um ou mais viagens
	@OneToMany(mappedBy = "funcionario") //nome do campo na tabela filha
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}