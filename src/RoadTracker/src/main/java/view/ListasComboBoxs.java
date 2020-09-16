package view;

public class ListasComboBoxs {
	
	private int id;
	private String cargo;
	
	public ListasComboBoxs(int id, String cargo) {
		this.id = id;
		this.cargo = cargo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return getCargo();
	}
	
	
}
