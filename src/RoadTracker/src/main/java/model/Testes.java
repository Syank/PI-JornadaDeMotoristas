package model;

public class Testes {

	public static void main(String[] args) {
		Viagem viagem = new Viagem();
		
//		viagem.cadastrarViagem("12:50:12 19/07/2020", "Caçapava - SP", "Piracicaba - SP", "12345678901", "AMS2020");
//		System.out.println("Cadastrou!");
		
		viagem.alterarDadosViagem("13:30:00 19/07/2020", "São José dos Campos - SP", "Piracicaba - SP", "12345678901", "AMS2021", 106);
		System.out.println("Alterou!");
	}

}
