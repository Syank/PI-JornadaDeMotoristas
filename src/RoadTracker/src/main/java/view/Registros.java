package view;

public class Registros {
	private String nome;
	private String cpf;
	private String data;
	private String mensagem;
	private int id;

	public Registros(String nome, String cpf, String data, String mensagem, int id) {
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.mensagem = mensagem;
		this.setId(id);
	}
	
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
