package model;

public class Viagem {
	
	private Integer id;
	private String fk_funcionarios_id;
	private Integer fk_veiculos_id_rastreador;
	private String inicio;
	private String fim;
	private String total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFk_funcionarios_id() {
		return fk_funcionarios_id;
	}
	public void setFk_funcionarios_id(String fk_funcionarios_id) {
		this.fk_funcionarios_id = fk_funcionarios_id;
	}
	public Integer getFk_veiculos_id_rastreador() {
		return fk_veiculos_id_rastreador;
	}
	public void setFk_veiculos_id_rastreador(Integer fk_veiculos_id_rastreador) {
		this.fk_veiculos_id_rastreador = fk_veiculos_id_rastreador;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
