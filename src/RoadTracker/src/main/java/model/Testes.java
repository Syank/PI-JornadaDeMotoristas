package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Testes {

	public static void main(String[] args) {	
		LocalDate hoje = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse("10/10/2020", formatter);
		
		System.out.println(hoje.compareTo(localDate));
		System.out.println(localDate.compareTo(hoje));
		
		System.out.println(hoje.minusDays(100).getDayOfMonth());
		System.out.println(hoje.minusDays(100));
		
		System.out.println(localDate.until(hoje, ChronoUnit.DAYS));
	}
}
