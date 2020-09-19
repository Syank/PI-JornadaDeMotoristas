package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Listas;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String cpf;
	private String nome;
	private String senha;
	private String cargo;
	private int fk_filiais_id;
	
public Funcionario() {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
		this.fk_filiais_id = fk_filiais_id;
		
	}

//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
	
	public JornadaTrabalho cadastrarJornadaTrabalho(String funcionario, int carga_horaria, String turno, boolean seg, boolean ter, boolean qua, boolean qui, boolean sex, boolean sab, boolean dom) {
		
		EntityManager con = new ConnectionFactory().getConnection();
		JornadaTrabalho jornada = new JornadaTrabalho();
		
		jornada.setFk_funcionarios_cpf(funcionario);
		jornada.setCarga_horaria(carga_horaria);
		jornada.setTurno(turno);
		jornada.setSeg(seg);
		jornada.setTer(ter);
		jornada.setQua(qua);
		jornada.setQui(qui);
		jornada.setSex(sex);
		jornada.setSab(sab);
		jornada.setDom(dom);
		
		try {
			//Mandando os dados do trabalho do motorista para a tabela de jornadas de trabalho
			con.getTransaction().begin();
			con.persist(jornada);
			con.getTransaction().commit();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Jornada de trabalho. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
		return jornada;
		
	}
	
	public void cadastrarFuncionario(String nome, String cpf, String senha, String cargo, int filial) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
		this.fk_filiais_id = filial;
		
		
		try {
			
			//Mandando os dados do motorista para a tabela de motoristas
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
			
			if (this.cargo == "motorista") {
				cadastrarJornadaTrabalho(this.cpf, 8, "manhã", true, true, true, true, true, false, false);
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Funcionário. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public Filial cadastrarFilial(String nome, String cidade, String uf) {
		EntityManager con = new ConnectionFactory().getConnection();
		Filial filial = new Filial();
		
		filial.setNome(nome);
		filial.setCidade(cidade);
		filial.setEstado(uf);	
		
		try {
			con.getTransaction().begin();
			con.persist(filial);
			con.getTransaction().commit();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			con.close();
		}
		
		return filial;
		
	}
	
	public void alterarDadosFuncionario(String novoNome, String cpfFuncionario, String novaSenha, String novoCargo, int novaFilial) {
		//lembrando que esse mï¿½todo tï¿½ bem simples ainda. nï¿½o tem verificaï¿½ï¿½o de nada
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.nome = novoNome;
		this.cpf = cpfFuncionario;
		this.senha = novaSenha;
		this.cargo = novoCargo;
		this.fk_filiais_id = novaFilial;
		
		try {
			con.getTransaction().begin();
			con.merge(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public List<Funcionario> consultarTodosFuncionarios(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Funcionario> funcionarios = null;

		try {
			funcionarios = con.createQuery("from Funcionario f").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return funcionarios;
		
	}

	public List<Listas> listarFuncionarios(){
		
		List<Listas> lista = new ArrayList<>();
		
		for (Funcionario f: this.consultarTodosFuncionarios()) {
			
			Listas nome = new Listas(f.cpf, f.nome);
			lista.add(nome);
		}
		
		return lista;
		
		
	}
	
	public Funcionario removerFuncionario(String cpf){
		EntityManager con = new ConnectionFactory().getConnection();

		Funcionario funcionario  = null;

		try {
			funcionario = con.find(model.Funcionario.class, cpf);		

			con.getTransaction().begin();
			con.remove(funcionario);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return funcionario;
	}
	
}