package services;

import entities.Genero;
import entities.Livro;

import java.util.ArrayList;

public class LivroService implements CrudInterface<Livro> {

    private final GeneroService generoService;

    public LivroService(GeneroService generoService) {
        this.generoService = generoService;
    }

    @Override
    public void menu() {
        System.out.println("MENU LIVRO\n" +
                "[1] Adicionar\n" +
                "[2] Remover\n" +
                "[3] Listar\n" +
                "[4] Editar\n" +
                "[0] Sair\n");
    }

    @Override
    public void adicionar(ArrayList<Livro> livros) {
        String titulo = IO.readln("Titulo: ");
        int anolancamento = Integer.parseInt(IO.readln("Ano lancamento: "));

        ArrayList<Genero> generos = new ArrayList<>();
        generoService.menu();
        generoService.adicionar(generos);

        livros.add(new Livro(titulo, anolancamento, generos));

        System.out.println("Livro adicionado com sucesso!");
    }

    @Override
    public void listar(ArrayList<Livro> livros) {
        livros.forEach(System.out::println);
    }

    @Override
    public void remover(ArrayList<Livro> livros) {
        int i = Integer.parseInt(IO.readln("Indice que deseja remover: "));

        try {
            livros.remove(i);
            System.out.println("Removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Indice não encontrado!");;
        }

    }

    @Override
    public void editar(ArrayList<Livro> list) {
        int i = Integer.parseInt(IO.readln("Indice que deseja editar: "));

    }

}
