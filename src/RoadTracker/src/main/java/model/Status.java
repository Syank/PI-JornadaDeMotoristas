package model;

public class Status {

	private Integer id;
	private Integer fk_viagens_id;
	private String fk_funcionarios_cpf;
	private String tipo;
	private String inicio;
	private String fim;
	private String total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFk_viagens_id() {
		return fk_viagens_id;
	}
	public void setFk_viagens_id(Integer fk_viagens_id) {
		this.fk_viagens_id = fk_viagens_id;
	}
	public String getFk_funcionarios_cpf() {
		return fk_funcionarios_cpf;
	}
	public void setFk_funcionarios_cpf(String fk_funcionarios_cpf) {
		this.fk_funcionarios_cpf = fk_funcionarios_cpf;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
