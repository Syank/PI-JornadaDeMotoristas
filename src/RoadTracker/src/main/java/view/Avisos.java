package view;


public class Avisos {
	
	private String tituloAviso;
	private String funcDestino;
	private String dataAviso;
	private int id;
	
	public Avisos(String tituloAviso, String funcDestino, String dataAviso) {
		this.setTituloAviso(tituloAviso);
		this.setFuncDestino(funcDestino);
		this.setDataAviso(dataAviso);
	}
	
	public String getTituloAviso() {
		return tituloAviso;
	}

	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}

	public String getFuncDestino() {
		return funcDestino;
	}

	public void setFuncDestino(String funcDestino) {
		this.funcDestino = funcDestino;
	}

	public String getDataAviso() {
		return dataAviso;
	}

	public void setDataAviso(String dataAviso) {
		this.dataAviso = dataAviso;
	}
	
	@Override
	public String toString() {
		return getFuncDestino();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
