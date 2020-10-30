package model;

import java.time.LocalDate;
import java.util.Date;

public class Testes {

	public static void main(String[] args) {	
		//Aviso avisos = new Aviso();
		//avisos.cadastrarAviso("novo aviso!", "00000000000", "mensagem de teste do aviso", "45893797833");
		//não se esqueça que tanto o user de destino quanto o de origem devem existir!!!!!!!!!!!!!
		
		//avisos.cadastrarAviso("00000000000", "Testando o sistema de avisos", "01234567890");
		
		//avisos.cadastrarAviso("01234567890", "00000000000", "Testando o sistema de avisos");
		
/* 		String a = "10/20/30";
		String desmontado[] = a.split("/");
		
		System.out.println(desmontado);
		System.out.println(desmontado[2]);
		System.out.println(LocalDate.now().getYear());
		System.out.println(LocalDate.now().getMonthValue());
		System.out.println(LocalDate.now().getDayOfMonth());
	
		Date dia = new Date();
		int hora = dia.getHours();
		int minutos = dia.getMinutes();
		int segundos = dia.getSeconds();

*/			
		String texto[] = "asdasd: 00:00:00".split(":");
//		String data = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
		System.out.println(texto.length);
	
		
	//	Aviso aviso = new Aviso();
		
	//	aviso.solicitarCadastro("00000000000", "Solicito o cadastro do motorista a seguir:\n- João da Silva\n- CPF: 123");
	
	}
}
