package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="motoristas")
public class Motorista {
	
	@Id
	private String cpf;
	private String nome;
	private String senha;
	private String carga_horaria;
	private String turno;
	private Integer fk_id_filial;
//	private String[] dias_trabalho = new String[7];
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getFk_id_filial() {
		return fk_id_filial;
	}

	public void setFk_id_filial(Integer fk_id_filial) {
		this.fk_id_filial = fk_id_filial;
	}

	/*
	 * public String[] getDias_trabalho() { return dias_trabalho; }
	 * 
	 * public void setDias_trabalho(String[] dias_trabalho) { this.dias_trabalho =
	 * dias_trabalho; }
	 */
	
}
