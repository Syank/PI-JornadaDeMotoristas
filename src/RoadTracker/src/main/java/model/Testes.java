package model;

import java.time.LocalDate;

public class Testes {

	public static void main(String[] args) {	
	//Aviso avisos = new Aviso();
	//avisos.cadastrarAviso("novo aviso!", "00000000000", "mensagem de teste do aviso", "45893797833");
	//não se esqueça que tanto o user de destino quanto o de origem devem existir!!!!!!!!!!!!!
	
	//avisos.cadastrarAviso("00000000000", "Testando o sistema de avisos", "01234567890");
	
	//avisos.cadastrarAviso("01234567890", "00000000000", "Testando o sistema de avisos");
	
	String a = "10/20/30";
	String desmontado[] = a.split("/");
	
	System.out.println(desmontado);
	System.out.println(desmontado[2]);
	System.out.println(LocalDate.now().getYear());
	System.out.println(LocalDate.now().getMonthValue());
	System.out.println(LocalDate.now().getDayOfMonth());
	}

}
