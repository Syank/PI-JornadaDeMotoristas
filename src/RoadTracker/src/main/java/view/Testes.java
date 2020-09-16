package view;

import model.Funcionario;

public class Testes {

	public static void main (String[] args) {
		Funcionario funcionario = new Funcionario();
		
		/*funcionario.cadastrarFilial();*/
		funcionario = funcionario.cadastrarMotorista();
		
		System.out.println("CPF: "+funcionario.getCpf());
		System.out.println("Nome: "+funcionario.getNome());
		System.out.println("Senha antiga: "+funcionario.getSenha());
		funcionario = funcionario.alterarSenhaMotorista();
		System.out.println("Senha nova: "+funcionario.getSenha());
		
	}
	
}
