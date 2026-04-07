import models.entities.Cliente;

void main() {

    ArrayList<Cliente> clientes = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menu();

        switch (escolha) {
            case 1:
                clientes.add(new Cliente(
                   IO.readln("Digite o nome do cliente: "),
                   IO.readln("Digite o cpf do cliente: "),
                   Double.parseDouble(IO.readln("Digite o saldo do cliente: R$"))
                ));
                break;
            case 2:
                clientes.forEach(System.out::println);
                break;
            case 3:
                String cpfParaRemover = IO.readln("Digite o cpf do cliente que deseja remover: ");
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getCpf().equals(cpfParaRemover)) {
                        clientes.remove(i);
                    }
                }

                // Maneira mais otimizada
                // clientes.removeIf(cpf -> cpf.getCpf().equals(cpfParaRemover));

                break;
            case 4:
                String cpfParaAlterar = IO.readln("Digite o cpf do cliente que deseja alterar: ");
                for (Cliente cliente : clientes) {
                    if (cliente.getCpf().equals(cpfParaAlterar)) {
                        menuAlterarCliente(cliente, cpfParaAlterar);
                    }
                }
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

public void menuAlterarCliente(Cliente cliente, String cpf) {
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
