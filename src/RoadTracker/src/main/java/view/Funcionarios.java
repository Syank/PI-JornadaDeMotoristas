package view;


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
	
	
	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getNome();
	}
}
