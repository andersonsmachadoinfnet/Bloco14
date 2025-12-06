package br.anderson.infnet.appdr1tp2.exercicio04;

public class CustomerService {
    public boolean registerCustomer(Customer customer) {
        if (customer.getAge() < Constantes.IDADE_MIN || customer.getAge() > Constantes.IDADE_MAX) {
            return false; // Idade inválida
        }

        if (!customer.getEmail().matches("^[\\w-.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            return false; // E-mail inválido
        } return true; // Cadastro bem-sucedido
    }

    public boolean updateCustomer(Customer customer, String newName, String newEmail, int newAge) {
        if (!customer.isActive()) {
            return false; // Cliente inativo não pode ser atualizado
        }
        customer.setName(newName);
        customer.setEmail(newEmail);
        customer.setAge(newAge);
        return true;
    }

    public boolean deleteCustomer(Customer customer) {
        if (!customer.isActive()) {
            return false; // Cliente inativo não pode ser excluído
        }
        return true;
    }

}
