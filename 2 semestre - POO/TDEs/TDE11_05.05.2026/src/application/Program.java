import entities.Cliente;
import entities.Endereco;

import javax.swing.*;

void main() {
    ArrayList<Cliente> clientes = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menuCliente();

        switch (escolha) {
            case 1:
                adicionarCliente(clientes);
                break;
            case 2:
                removerCliente(clientes);
                break;
            case 3:
                listarClientes(clientes);
                break;
            case 4:
                editarCliente(clientes);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Digite uma opção valida!\n");
                break;
        }

    } while (escolha != 0);
}

public int menuCliente() {
    return Integer.parseInt(IO.readln("MENU CLIENTE: \n" +
            "[1] Adicionar cliente \n" +
            "[2] Remover cliente \n" +
            "[3] Listar clientes \n" +
            "[4] Editar clientes \n" +
            "[0] Sair \n" +
            "\nEscolha: "));
}

public void listarClientes(ArrayList<Cliente> clientes) {
    for (int i = 0; i < clientes.size(); i++) {
        System.out.println("[" + i + "] " + clientes);
    }
}

public void adicionarCliente(ArrayList<Cliente> clientes) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String nome = IO.readln("Digite o nome do cliente: ");
    String cpf = IO.readln("Digite o cpf do cliente: ");
    LocalDate dataNascimento = LocalDate.parse(IO.readln("Digite a data de nasicmento do cliente (dd/mm/yyy): "), fmt);

    ArrayList<Endereco> enderecos = new ArrayList<>();
    menuEndereco(enderecos);

    clientes.add(new Cliente(nome, cpf, dataNascimento, enderecos));

    System.out.println("Cliente adicionado com sucesso!\n");
}

public void removerCliente(ArrayList<Cliente> clientes) {
    int indiceRemover = Integer.parseInt(IO.readln("Qual indice deseja remover? "));

    int encontrado = 0;
    for (int i = 0; i < clientes.size(); i++) {
        if (i == indiceRemover) {
            clientes.remove(i);
            encontrado++;
        }
    }

    if (encontrado == 0) {
        System.out.println("Cliente nao encontrado.");
    }
    else {
        System.out.println("Cliente removido com sucesso!\n");
    }
}

public void editarCliente(ArrayList<Cliente> clientes) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    int indiceEditar = Integer.parseInt(IO.readln("Qual indice deseja editar? "));

    int encontrado = 0;
    for (int i = 0; i < clientes.size(); i++) {
        if (i == indiceEditar) {
            int escolha = menuEditarCliente();

            switch (escolha) {
                case 1:
                    String novoNome = IO.readln("Digite o novo nome: ");
                    clientes.get(i).setNome(novoNome);
                    System.out.println("Nome editado!\n");
                    break;
                case 2:
                    String novoCpf = IO.readln("Digite o novo email: ");
                    clientes.get(i).setCpf(novoCpf);
                    System.out.println("Email editado!\n");
                    break;
                case 3:
                    LocalDate novaDataNascimento = LocalDate.parse(IO.readln("Digite a nova data de nasicmento (dd/mm/yyy): "), fmt);
                    clientes.get(i).setDataNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento editada!\n");
                case 4:
                    menuEndereco(clientes.get(i).getEnderecos());
                    break;
            }

            encontrado++;
            break;
        }
    }

    if (encontrado == 0) {
        System.out.println("Cliente não encontrado.");
    }

}

public Integer menuEditarCliente() {
    return Integer.parseInt(IO.readln("O que deseja editar: \n" +
            "[1] Nome\n" +
            "[2] Cpf\n" +
            "[3] Data de nascimento\n" +
            "[4] Enderecos\n"));
}



public void menuEndereco(ArrayList<Endereco> enderecos) {
    int escolha = 0;
    do {
        escolha = Integer.parseInt(IO.readln("MENU ENDERECO: \n" +
                "[1] Adicionar endereco \n" +
                "[2] Remover endereco \n" +
                "[3] Listar endereco \n" +
                "[4] Editar endereco \n" +
                "[0] Voltar \n" +
                "\nEscolha: "));

        switch (escolha) {
            case 1:
                adicionarEndereco(enderecos);
                break;
            case 2:
                removerEndereco(enderecos);
                break;
            case 3:
                listarEndereco(enderecos);
                break;
            case 4:
                editarEndereco(enderecos);
                break;
            case 0:
                System.out.println("Voltando...\n");
                break;
            default:
                System.out.println("Digite uma opção valida!\n");
                break;
        }


    } while (escolha != 0);
}

public void listarEndereco(ArrayList<Endereco> enderecos) {
    for (int i = 0; i < enderecos.size(); i++) {
        System.out.println("[" + i + "] " + enderecos);
    }
}

public void adicionarEndereco(ArrayList<Endereco> enderecos) {
    String logradouro = IO.readln("Logradouro: ");
    String bairro = IO.readln("Bairro: ");
    String cidade = IO.readln("Cidade: ");
    String cep = IO.readln("Cep: ");
    String descricao = IO.readln("Descricao: ");

    enderecos.add(new Endereco(logradouro, bairro, cidade, cep, descricao));

    System.out.println("Endereco adicionado com sucesso\n");
}

public void removerEndereco(ArrayList<Endereco> enderecos) {
    int indiceRemover = Integer.parseInt(IO.readln("Qual indice deseja remover? "));

    int encontrado = 0;
    for (int i = 0; i < enderecos.size(); i++) {
        if (i == indiceRemover) {
            enderecos.remove(i);
            encontrado++;
        }
    }

    if (encontrado == 0) {
        System.out.println("Endereco nao encontrado.");
    }
    else {
        System.out.println("Endereco removido com sucesso!\n");
    }
}

public void editarEndereco(ArrayList<Endereco> enderecos) {
    int indiceEditar = Integer.parseInt(IO.readln("Qual indice deseja editar? "));

    int encontrado = 0;
    for (int i = 0; i < enderecos.size(); i++) {
        if (i == indiceEditar) {
            int escolha = Integer.parseInt(IO.readln("O que deseja editar: \n" +
                    "[1] logradouro \n" +
                    "[2] bairro \n" +
                    "[3] cidade \n" +
                    "[4] cep \n" +
                    "[5] descricao \n" +
                    "Escolha: "));

            switch (escolha) {
                case 1:
                    String novoLogradouro = IO.readln("Novo logradouro: ");
                    enderecos.get(i).setLogradouro(novoLogradouro);
                    break;
                case 2:
                    String novoBairro = IO.readln("Novo bairro: ");
                    enderecos.get(i).setLogradouro(novoBairro);
                    break;
                case 3:
                    String novaCidade = IO.readln("Nova cidade: ");
                    enderecos.get(i).setCidade(novaCidade);
                    break;
                case 4:
                    String novoCep = IO.readln("Novo cep: ");
                    enderecos.get(i).setCep(novoCep);
                    break;
                case 5:
                    String novaDescricao = IO.readln("Nova descricao: ");
                    enderecos.get(i).setDescricao(novaDescricao);
                    break;
                default:
                    System.out.println("Digite uma opcao valida!");
                    break;
            }

            encontrado++;
            break;
        }
    }

    if (encontrado == 0) {
        System.out.println("Endereco não encontrado.");
    }
    else {
        System.out.println("Endereco editado com sucesso!\n");
    }
}


