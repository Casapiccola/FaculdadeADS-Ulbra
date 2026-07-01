package services;

import entities.Cliente;

import java.util.ArrayList;

public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
        clientes.add(new Cliente("Joao Silva", "(41) 99999-1111", "Rua das Flores, 100"));
        clientes.add(new Cliente("Maria Souza", "(41) 98888-2222", "Av. Brasil, 250"));
    }

    public void menu() {
        System.out.println("\n--- MENU CLIENTES ---");
        System.out.println("[1] Cadastrar cliente");
        System.out.println("[2] Listar clientes");
        System.out.println("[0] Voltar");
    }

    public void cadastrar() {
        String nome = IO.readln("Nome: ");
        String telefone = IO.readln("Telefone: ");
        String endereco = IO.readln("Endereco: ");
        clientes.add(new Cliente(nome, telefone, endereco));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listar() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\nClientes cadastrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + i + "] " + clientes.get(i));
        }
    }

    public Cliente selecionar() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return null;
        }
        listar();
        int i = Integer.parseInt(IO.readln("Escolha o indice do cliente: "));
        if (i < 0 || i >= clientes.size()) {
            System.out.println("Indice invalido.");
            return null;
        }
        return clientes.get(i);
    }

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = Integer.parseInt(IO.readln("Escolha: "));
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);
    }
}
