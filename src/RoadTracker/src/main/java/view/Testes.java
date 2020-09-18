package view;

import model.Funcionario;

public class Testes {

	public static void main (String[] args) {
		Funcionario funcionario = new Funcionario("0000557789", "Rafael", "abacate", "Motorista", "3");
		

		funcionario.alterarSenhaMotorista("abc");
		System.out.println("Senha trocada");

		
		
		
		
	}
	
}
