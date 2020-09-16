package model;

public class Veiculo {
	
	private Integer id_rastreador;
	private String fk_funcionarios_cpf;
	private String placa;
	private String marca_rastreador;
	private String versao_rastreador;
	
	public Integer getId_rastreador() {
		return id_rastreador;
	}
	public void setId_rastreador(Integer id_rastreador) {
		this.id_rastreador = id_rastreador;
	}
	public String getFk_funcionarios_cpf() {
		return fk_funcionarios_cpf;
	}
	public void setFk_funcionarios_cpf(String fk_funcionarios_cpf) {
		this.fk_funcionarios_cpf = fk_funcionarios_cpf;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca_rastreador() {
		return marca_rastreador;
	}
	public void setMarca_rastreador(String marca_rastreador) {
		this.marca_rastreador = marca_rastreador;
	}
	public String getVersao_rastreador() {
		return versao_rastreador;
	}
	public void setVersao_rastreador(String versao_rastreador) {
		this.versao_rastreador = versao_rastreador;
	}

}
