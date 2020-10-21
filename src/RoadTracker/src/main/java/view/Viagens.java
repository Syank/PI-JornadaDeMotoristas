package view;

public class Viagens {
	private int id;
	private String destino;
	private String motorista;
	private String carga;
	private String prazo;
	private String situacao;
	
	public Viagens(int id, String empresaDestino, String motorista, String carga, String prazo, String situacao) {
		this.id = id;
		this.destino = empresaDestino;
		this.motorista = motorista;
		this.carga = carga;
		this.prazo = prazo;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String empresaDestino) {
		this.destino = empresaDestino;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
