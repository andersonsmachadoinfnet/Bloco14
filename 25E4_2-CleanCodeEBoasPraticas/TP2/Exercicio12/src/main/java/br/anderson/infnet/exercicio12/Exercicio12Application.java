package br.anderson.infnet.exercicio12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio12Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        NotificacaoService notificacaoService = new NotificacaoService();
        notificacaoService.enviarNotificacao(TipoNotificacao.EMAIL);
    }
}
