package services;

import entities.Genero;

import java.util.ArrayList;

public class GeneroService implements CrudInterface<Genero> {


    @Override
    public void menu() {
        System.out.println("MENU GENERO\n" +
                "[1] Adicionar\n" +
                "[2] Remover\n" +
                "[3] Listar\n" +
                "[4] Editar\n" +
                "[0] Sair\n");
    }

    @Override
    public void adicionar(ArrayList<Genero> generos) {
        String descricao = IO.readln("Descricao: ");
        String tag = IO.readln("Tag: ");

        generos.add(new Genero(descricao, tag));
    }

    @Override
    public void listar(ArrayList<Genero> list) {

    }

    @Override
    public void remover(ArrayList<Genero> list) {

    }

    @Override
    public void editar(ArrayList<Genero> list) {

    }
}
