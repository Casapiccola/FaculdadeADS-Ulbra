import entities.Contato;
import entities.Telefone;

void main() {

    ArrayList<Contato> contatos = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menu();

        switch (escolha) {
            case 1:
                adicionarContato(contatos);
                break;
            case 2:
                removerContato(contatos);
                break;
            case 3:
                editarContato(contatos);
                break;
            case 4:
                listarContatos(contatos);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Digite uma opcao valida!");
                break;
        }

    } while (escolha != 0);

}

public int menu() {
    return Integer.parseInt(IO.readln("[1] Adicionar\n" +
            "[2] Remover\n" +
            "[3] Editar\n" +
            "[4] Listar\n" +
            "[0] Sair\n\n" +
            "Escolha: "));
}

public Integer menuEditar() {
    return Integer.parseInt(IO.readln("O que deseja editar: \n" +
            "[1] Nome\n" +
            "[2] Email\n" +
            "[3] Telefones\n"));
}

public void adicionarContato(ArrayList<Contato> contatos) {
    String nome = IO.readln("Digite o nome que deseja adicionar: ");
    String email = IO.readln("Digite o email que deseja adicionar: ");

    int quantidadeAdicionar = Integer.parseInt(IO.readln("Quantos contatos deseja adicionar? "));

    ArrayList<Telefone> telefones = new ArrayList<>();
    for (int i = 0; i < quantidadeAdicionar; i++) {
        System.out.println("Numero #" + (i + 1));
        int codArea = Integer.parseInt(IO.readln("Codigo de area: "));
        String numero = IO.readln("Numero: ");
        String descricao = IO.readln("Descricao: ");

        telefones.add(new Telefone(codArea, numero, descricao));
    }

    contatos.add(new Contato(nome, email, telefones));

    System.out.println("Contato adicionado com sucesso");
}

public void removerContato(ArrayList<Contato> contatos) {
    String contatoRemover = IO.readln("Digite o nome do contato que deseja remover: ");

    int encontrado = 0;
    for (int i = 0; i < contatos.size(); i++) {
        if (contatoRemover.toLowerCase().equals(contatos.get(i).getNome().toLowerCase())) {
            contatos.remove(i);
            encontrado++;
            System.out.println("Removido com sucesso!");
            break;
        }
    }

    if (encontrado == 0) {
        System.out.println("Contato não encontrado.");
    }
}

public void editarContato(ArrayList<Contato> contatos) {
    String nomeEditar = IO.readln("Digite o nome do contato para editar: ");

    int encontrado = 0;
    for (int i = 0; i < contatos.size(); i++) {
        if (nomeEditar.toLowerCase().equals(contatos.get(i).getNome().toLowerCase())) {

            int escolha = menuEditar();

            switch (escolha) {
                case 1:
                    String novoNome = IO.readln("Digite o novo nome: ");
                    contatos.get(i).setNome(novoNome);
                    System.out.println("Nome editado!");
                    break;
                case 2:
                    String novoEmail = IO.readln("Digite o novo email: ");
                    contatos.get(i).setEmail(novoEmail);
                    System.out.println("Email editado!");
                    break;
                case 3:

                    System.out.println(contatos.get(i).getTelefones());
                    String contatoEditar = IO.readln("Qual contato deseja editar? ");

                    for (int j = 0; j < contatos.get(i).getTelefones().size(); j++) {
                        if (contatoEditar.equals(contatos.get(i).getTelefones().get(j).getNumero())) {
                            int codArea = Integer.parseInt(IO.readln("Digite o novo codigo de area: "));
                            String numero = IO.readln("Digite o novo número: ");
                            String descricao = IO.readln("Nova descricao: ");

                            contatos.get(i).getTelefones().remove(j);
                            contatos.get(i).getTelefones().add(new Telefone(codArea, numero, descricao));

                            System.out.println("Contato editado com sucesso!");
                        }
                    }
                    break;
            }

            encontrado++;
            break;
        }
    }

    if (encontrado == 0) {
        System.out.println("Contato não encontrado.");
    }
}

public void listarContatos(ArrayList<Contato> contatos) {
    System.out.println("Lista de contatos:");
    for (int i = 0; i < contatos.size(); i++) {
        System.out.println(contatos.get(i));
    }
}


