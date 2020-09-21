package view;

public class Filiais {
	private int id;
	private String nome;
	
	public Filiais(int id, String nome) {
		this.id = id;
		this.nome = nome;	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getNome();
	}
}
