package view;

import model.Funcionario;

public class Testes {

	public static void main (String[] args) {
		// Tem que corrigir os argumentos
		
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.cadastrarFilial("Filial Bárbara S.A. São José dos Campos", "São José dos Campos", "SP");
		
		funcionario.cadastrarFuncionario("Rafael Furtado", "0123456789", "rafael123", "adm", 2);
		funcionario.cadastrarFuncionario("Bárbara Port", "4862451305", "barbara123", "adm", 2);
		funcionario.cadastrarFuncionario("Giovanni Alves", "1452369874", "giovanni123", "adm", 2);
		funcionario.cadastrarFuncionario("Ana Carolina", "9874563210", "carol123", "adm", 2);
		funcionario.cadastrarFuncionario("Ana Clara", "3571598024", "ana123", "adm", 2);
		funcionario.cadastrarFuncionario("Anna Yukimi", "1597530017", "yukimi123", "adm", 2);
		
//		funcionario.alterarDadosFuncionario("Cecília Oliveira", "45832145692", "barbara147", "adm", 2); //não pode mudar o cpf, senão não encontra o registro

//		funcionario.listarFuncionarios();
		
//		funcionario.removerFuncionario("1010101010");


		
	}
	
}
