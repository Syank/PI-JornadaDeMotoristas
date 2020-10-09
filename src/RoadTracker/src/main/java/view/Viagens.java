package view;

public class Viagens {
	private int id;
	private String empresaDestino;
	private String motorista;
	
	public Viagens(int id, String empresaDestino, String motorista) {
		super();
		this.id = id;
		this.empresaDestino = empresaDestino;
		this.motorista = motorista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresaDestino() {
		return empresaDestino;
	}

	public void setEmpresaDestino(String empresaDestino) {
		this.empresaDestino = empresaDestino;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
}
