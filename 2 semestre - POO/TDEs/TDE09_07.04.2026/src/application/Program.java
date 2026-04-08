// Codigo mais proximo do que o Saraiva passou em aula
// Codigo melhorado está no TDE08_31.03.2026

import models.entities.Cliente;

void main() {

    ArrayList<Cliente> clientes = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menu();

        switch (escolha) {
            case 1:
                salvarCliente(clientes);
                break;
            case 2:
                listarClientes(clientes);
                break;
            case 3:
                removerCliente(clientes);
                break;
            case 4:
                editarCliente(clientes);
                break;
            case 0:
                IO.println("Saindo...");
                break;
            default:
                IO.println("Digite uma opção válida!");
                continue;
        }

    } while (escolha != 0);

}

public void salvarCliente(ArrayList<Cliente> clientes) {
    String nome = IO.readln("Digite o nome do cliente: ");
    String cpf = IO.readln("Digite o cpf do cliente: ");
    float saldo = 0f;

    clientes.add(new Cliente(nome, cpf, saldo));
    System.out.println("Cliente salvo com sucesso!\n");
}

public void listarClientes(ArrayList<Cliente> clientes) {
    for (int i = 0; i < clientes.size(); i++) {
        System.out.println(clientes.get(i));
    }
}

public void removerCliente(ArrayList<Cliente> clientes) {
    String cpfParaRemover = IO.readln("Digite o cpf do cliente que deseja remover: ");

    boolean encontrou = false;
    for (int i = 0; i < clientes.size(); i++) {
        if (cpfParaRemover.equals(clientes.get(i).cpf)) {
            clientes.remove(i);
            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println("Cliente não encontrado!");
    }
    else {
        System.out.println("Cliente removido com sucesso!");
    }

}

public void editarCliente(ArrayList<Cliente> clientes) {
    String cpfParaEditar = IO.readln("Digite o cpf do cliente que deseja editar: ");
    for (int i = 0; i < clientes.size(); i++) {
        if (cpfParaEditar.equals(clientes.get(i).cpf)) {
            clientes.get(i).cpf = IO.readln("Novo CPF: ");
            clientes.get(i).nome = IO.readln("Novo nome: ");
            clientes.get(i).saldo = Float.parseFloat(IO.readln("Novo saldo: "));
        }
    }
}

public int menu() {
    return Integer.parseInt(IO.readln("---MENU---\n" +
            "[1] Adicionar novo cliente\n" +
            "[2] Listar clientes\n" +
            "[3] Remover cliente\n" +
            "[4] Editar cliente\n" +
            "[0] Sair\n\n" +
            "Escolha: "));
}

