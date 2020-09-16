package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jornada_trabalho")
public class JornadaTrabalho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String fk_funcionarios_cpf;
	private String turno;
	private Integer carga_horaria;
	private boolean seg;
	private boolean ter;
	private boolean qua;
	private boolean qui;
	private boolean sex;
	private boolean sab;
	private boolean dom;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFk_funcionarios_cpf() {
		return fk_funcionarios_cpf;
	}
	public void setFk_funcionarios_cpf(String fk_funcionarios_cpf) {
		this.fk_funcionarios_cpf = fk_funcionarios_cpf;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Integer getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public boolean isSeg() {
		return seg;
	}
	public void setSeg(boolean seg) {
		this.seg = seg;
	}
	public boolean isTer() {
		return ter;
	}
	public void setTer(boolean ter) {
		this.ter = ter;
	}
	public boolean isQua() {
		return qua;
	}
	public void setQua(boolean qua) {
		this.qua = qua;
	}
	public boolean isQui() {
		return qui;
	}
	public void setQui(boolean qui) {
		this.qui = qui;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean isSab() {
		return sab;
	}
	public void setSab(boolean sab) {
		this.sab = sab;
	}
	public boolean isDom() {
		return dom;
	}
	public void setDom(boolean dom) {
		this.dom = dom;
	}

}
