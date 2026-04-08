// Versão melhorada da TDE 09_07.04.2026

import models.entities.Cliente;

void main() {

    ArrayList<Cliente> clientes = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menu();

        switch (escolha) {
            case 1:
                adicionarCliente(clientes);
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

public int menu() {
    return Integer.parseInt(IO.readln("---MENU---\n" +
            "[1] Adicionar novo cliente\n" +
            "[2] Listar clientes\n" +
            "[3] Remover cliente\n" +
            "[4] Editar cliente\n" +
            "[0] Sair\n\n" +
            "Escolha: "));
}

public void adicionarCliente(ArrayList<Cliente> clientes) {
    clientes.add(new Cliente(
            IO.readln("Digite o nome do cliente: "),
            IO.readln("Digite o cpf do cliente: "),
            0.0
    ));
}

public void listarClientes(ArrayList<Cliente> clientes) {
    clientes.forEach(System.out::println);
}

public void removerCliente(ArrayList<Cliente> clientes) {
    String cpfParaRemover = IO.readln("Digite o cpf do cliente que deseja remover: ");
    for (int i = 0; i < clientes.size(); i++) {
        if (clientes.get(i).getCpf().equals(cpfParaRemover)) {
            clientes.remove(i);
        }
    }
}

public void editarCliente(ArrayList<Cliente> clientes) {
    String cpfParaAlterar = IO.readln("Digite o cpf do cliente que deseja alterar: ");

    for (Cliente cliente : clientes) {
        if (cliente.getCpf().equals(cpfParaAlterar)) {

            int alteracao = Integer.parseInt(IO.readln("[1] Nome\n" +
                    "[2] Cpf\n" +
                    "[3] Saldo\n" +
                    "Escolha: "));

            switch (alteracao) {
                case 1:
                    cliente.setNome(IO.readln("Novo nome: "));
                    break;
                case 2:
                    cliente.setCpf(IO.readln("Novo cpf: "));
                    break;
                case 3:
                    cliente.setSaldo(Double.parseDouble(IO.readln("Novo saldo: R$")));
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        }

    }

}
