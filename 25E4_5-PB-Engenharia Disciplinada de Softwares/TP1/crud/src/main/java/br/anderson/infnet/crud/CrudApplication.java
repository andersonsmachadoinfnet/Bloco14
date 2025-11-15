package br.anderson.infnet.crud;


import br.anderson.infnet.crud.core.MenuPrincipal;
import br.anderson.infnet.crud.service.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	private final ClienteService clienteService;

	public CrudApplication(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuPrincipal menu = new MenuPrincipal(this.clienteService);
		//menu.apresenta();
	}
}
