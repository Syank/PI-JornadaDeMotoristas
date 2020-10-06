package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Testes {

	public static void main(String[] args) {
		
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(df.format(hoje));
	}

}
