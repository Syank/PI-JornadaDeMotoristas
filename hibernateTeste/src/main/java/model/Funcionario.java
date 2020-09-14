package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
	
	@Id
	private String cpf;
	private String nome;
	private String senha;
	private Integer cargo;
	private String filial;
	
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
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}
}