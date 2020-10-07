package view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ConnectionFactory;

public class Funcionarios {
	private String cpf;
	private String nome;
	private String cargo;
	
	public Funcionarios(String cpf, String nome, String cargo) {
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public List<Funcionarios> listarFuncionarios() {
		List<Funcionarios> lista = new ArrayList<>();
		for (Funcionarios f: this.consultarTodosFuncionarios()) {
			Funcionarios funcionario = new Funcionarios(f.cpf, f.nome, f.cargo);
			lista.add(funcionario);
		}
		return lista;
	}
	
	public List<Funcionarios> consultarTodosFuncionarios() {
		EntityManager con = new ConnectionFactory().getConnection();
		List<Funcionarios> fs = null;

		try {
			
//			Query query = con.createNativeQuery("select cpf, nome from funcionarios_filiais f union select cpf, nome from motoristas mo");
			Query query = con.createNativeQuery("select cpf, nome from funcionarios_filiais f join motoristas mo where f.filial = mo.filial");
			fs = query.getResultList();

		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return fs;
	}
}
