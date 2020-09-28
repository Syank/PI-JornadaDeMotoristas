package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="viagens")
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String inicio;
	private String fim;
	private String total;
	
	//muitas viagens possuem um funcionário
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
	private Funcionario funcionario = new Funcionario();
	
	//uma viagem possui um ou mais status
	@OneToMany(mappedBy = "viagem") //nome do campo na tabela filha
	private List<Status> status = new ArrayList<Status>();
	
	//uma ou muitas viagens correspondem a um veículo
	@ManyToOne
	@JoinColumn(name = "veiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_veiculos_id_rastreador")) //coluna da tabela pai
	private Veiculo veiculo = new Veiculo();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
