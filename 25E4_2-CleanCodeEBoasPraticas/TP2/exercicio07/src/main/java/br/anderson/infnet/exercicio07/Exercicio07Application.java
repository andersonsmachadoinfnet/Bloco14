package br.anderson.infnet.exercicio07;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio07Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio07Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RelatorioService relatorio = new RelatorioService();
        relatorio.gerarRelatorio("CSV");
        relatorio.gerarRelatorio("JSON");
        relatorio.gerarRelatorio("PDF");

    }
}
