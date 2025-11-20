package br.anderson.infnet.exercicio04;

import br.anderson.infnet.exercicio04.core.BibliotecaImpl;
import br.anderson.infnet.exercicio04.core.BibliotecaReport;
import br.anderson.infnet.exercicio04.model.Biblioteca;
import br.anderson.infnet.exercicio04.model.Livro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio04Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio04Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Biblioteca biblioteca = new BibliotecaImpl();
        biblioteca.livro(new Livro("A psicologia financeira","Morgan Housel")).adicionar();
        biblioteca.livro(new Livro("A Metamorfose","Franz Kafka")).adicionar().emprestar();
        biblioteca.livro(new Livro("A coisa de risco","Morgan Housel")).adicionar();

        BibliotecaReport relatorio = new BibliotecaReport(biblioteca);
        relatorio.listar();

        // O comando abaixo gera erro, pois o livro não está disponível!
        biblioteca.livro("A Metamorfose").emprestar();
    }
}
