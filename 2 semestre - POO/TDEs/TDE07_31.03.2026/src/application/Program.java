void main() {

    ArrayList<String> listaDeNomes = new ArrayList<>();

    do {
        listaDeNomes.add(IO.readln("Digite um nome para adicionar na lista: "));

    } while (Integer.parseInt(IO.readln("Deseja adicionar um novo nome? Digite 1 para continuar: ")) == 1);

    IO.println(listaDeNomes);
}




void main2() {
    ArrayList<String> ListaNomes = new ArrayList<>();
    int escolha = 1;
    while (escolha == 1){
        String nome = IO.readln("Digite um nome: ");
        ListaNomes.add(nome);
        escolha = Integer.parseInt(IO.readln("Você gostaria de adicionar outro nome? Sim = 1: "));
    }

    System.out.println(ListaNomes);
}