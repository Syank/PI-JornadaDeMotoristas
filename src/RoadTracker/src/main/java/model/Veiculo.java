package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	private Integer id_rastreador;
	private String placa;
	private String marca_rastreador;
	private String versao_rastreador;
	
	//um ou mais funcionarios possuem um veículo
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
	private Funcionario funcionario = new Funcionario();
	
	//um veiculo possui uma ou mais viagens
	@OneToMany(mappedBy = "veiculo")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	public Integer getId_rastreador() {
		return id_rastreador;
	}
	public void setId_rastreador(Integer id_rastreador) {
		this.id_rastreador = id_rastreador;
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
