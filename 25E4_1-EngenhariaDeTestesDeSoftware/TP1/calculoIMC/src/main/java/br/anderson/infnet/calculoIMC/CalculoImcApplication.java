package br.anderson.infnet.calculoIMC;

import br.anderson.infnet.calculoIMC.core.CalculoIMC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculoImcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CalculoImcApplication.class, args);

		String versao = "1.0";
		CalculoIMC calculoIMC = new CalculoIMC();
		calculoIMC.programaIMC(versao);
	}

}
