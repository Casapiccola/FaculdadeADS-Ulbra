import entities.Aviao;
import entities.CompaniaAerea;

void main() {

    ArrayList<CompaniaAerea> companiaAereas = new ArrayList<>();

    int escolha = 0;
    do {
        escolha = menu();

        switch (escolha) {
            case 1:
                adicionarCompaniaAerea(companiaAereas);
                break;
            case 2:
                removerCompaniaAerea(companiaAereas);
                break;
            case 3:
                editarCompaniaAerea(companiaAereas);
                break;
            case 4:
                listarCompanias(companiaAereas);
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
    return Integer.parseInt(IO.readln("MENU COMPANIAS AEREAS\n" +
            "[1] Adicionar\n" +
            "[2] Remover\n" +
            "[3] Editar\n" +
            "[4] Listar\n" +
            "[0] Sair\n\n" +
            "Escolha: "));
}

public Integer menuEditar() {
    return Integer.parseInt(IO.readln("O que deseja editar: \n" +
            "[1] Nome\n" +
            "[2] Descricao\n" +
            "[3] Avioes\n"));
}

public void adicionarCompaniaAerea(ArrayList<CompaniaAerea> companiaAereas) {
    String nome = IO.readln("Digite o nome que deseja adicionar: ");
    String descricao = IO.readln("Digite a descricao que deseja adicionar: ");

    int quantidadeAdicionar = Integer.parseInt(IO.readln("Quantos avioes deseja adicionar? "));

    ArrayList<Aviao> avioes = new ArrayList<>();
    for (int i = 0; i < quantidadeAdicionar; i++) {
        System.out.println("Numero #" + (i + 1));
        String modelo = IO.readln("Modelo: ");
        Float tamanhoTanqueEmLitros = Float.parseFloat(IO.readln("Tamanho do tanque (Litros): "));

        avioes.add(new Aviao(modelo, tamanhoTanqueEmLitros));
    }

    companiaAereas.add(new CompaniaAerea(nome, descricao, avioes));

    System.out.println("Compania aerea adicionado com sucesso");
}

public void removerCompaniaAerea(ArrayList<CompaniaAerea> companiaAereas) {
    int companiaRemover = Integer.parseInt(IO.readln("Digite o indice da compania que deseja remover: "));

    companiaAereas.remove(companiaRemover);
    System.out.println("Removido com sucesso!");
}

public void editarCompaniaAerea(ArrayList<CompaniaAerea> companiaAereas) {
    int companiaEditar = Integer.parseInt(IO.readln("Digite o indice da compania que deseja editar: "));

    int escolha = menuEditar();

    switch (escolha) {
        case 1:
            String novoNome = IO.readln("Digite o novo nome: ");
            companiaAereas.get(companiaEditar).setNome(novoNome);
            System.out.println("Nome editado!");
            break;
        case 2:
            String novaDescricao = IO.readln("Digite a nova descricao: ");
            companiaAereas.get(companiaEditar).setDescricao(novaDescricao);
            System.out.println("Descricao editada!");
            break;
        case 3:

            for (int i = 0; i < companiaAereas.get(companiaEditar).getAvioes().size(); i++) {
                System.out.println("[" + i + "] " + companiaAereas.get(companiaEditar).getAvioes().get(i));
            }

            int aviaoEditar = Integer.parseInt(IO.readln("Escolha o indice do aviao que deseja editar? "));

            String modelo = IO.readln("Novo modelo: ");
            float tamanhoTanqueEmLitros = Float.parseFloat(IO.readln("Novo tamanho do tanque (Litros): : "));

            companiaAereas.get(companiaEditar).getAvioes().remove(aviaoEditar);
            companiaAereas.get(companiaEditar).getAvioes().add(new Aviao(modelo, tamanhoTanqueEmLitros));

            System.out.println("Aviao editado com sucesso!");
            break;
    }
}

public void listarCompanias(ArrayList<CompaniaAerea> companiaAereas) {
    System.out.println("Lista de companias aereas:");
    for (int i = 0; i < companiaAereas.size(); i++) {
        System.out.println("[" + i + "] " + companiaAereas.get(i));
    }
}
