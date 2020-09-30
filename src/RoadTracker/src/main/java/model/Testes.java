package model;


public class Testes {

	public static void main(String[] args) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.cadastrarVeiculo("QUUYER4", "SDW-484", "A58EF4", "HiTech", "12345678900");
		
		veiculo.excluirVeiculo("QUUYER4");
		
	}

}
