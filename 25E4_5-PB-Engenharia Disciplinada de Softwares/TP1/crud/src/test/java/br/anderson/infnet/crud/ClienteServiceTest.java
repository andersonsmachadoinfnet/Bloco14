package br.anderson.infnet.crud;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class ClienteServiceTest {
    private ClienteService clienteService;

    @Autowired
    public ClienteServiceTest(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Test
    @DisplayName("Testa gravação do registro")
    @Transactional
    public void testaSalvar() {
        Cliente cliente = new Cliente();
        cliente.setId(18);
        cliente.setNome("UmNome Qualquer");

        cliente = clienteService.incluir(cliente);
        Assertions.assertNotNull(cliente.getId());
        Assertions.assertTrue(cliente.getId() > 0);
    }

    @Test
    @DisplayName("Testa leitura do registro")
    @Transactional
    public void testaAlterar() {
        Cliente cliente = clienteService.ler(1);
        cliente.setNome("UmNome Qualquer");
        cliente = clienteService.incluir(cliente);
        Cliente cliente2 = clienteService.ler(1);
        Assertions.assertEquals(cliente.getNome(), cliente2.getNome());
    }

    @Test
    @DisplayName("Teste deletar")
    @Transactional
    public void testaExcluir() {
        Cliente cliente = clienteService.ler(1);
        clienteService.excluir(cliente);
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> clienteService.ler(1)
        );
    }

}
