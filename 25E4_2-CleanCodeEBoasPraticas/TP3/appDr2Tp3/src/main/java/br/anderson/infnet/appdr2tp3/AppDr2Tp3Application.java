package br.anderson.infnet.appdr2tp3;

import br.anderson.infnet.appdr2tp3.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class AppDr2Tp3Application  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppDr2Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User usuario = new User("Anderson", "Anderson", "Anderson@gmail.com");
        Project projeto = new Project("TP3", "Projeto do TP3 de Engenharia de Software: Clean Code e Boas Práticas [25E4_2]");
        Sprint sprint = new Sprint(1L, "Sprint TP3", LocalDateTime.of(2025, 12, 12, 0, 0, 0), LocalDateTime.of(2025, 12, 31, 0, 0, 0), null);
        Task tarefa = new Task("TP3", "Fazer o TP3", TarefaStatus.IN_PROGRESS, usuario, 10);

        sprint.adicionarTarefa(tarefa);
        projeto.adicionarSprint(sprint);
        projeto.listarSprints();
        System.out.println("Aplicação executou.");
    }
}
