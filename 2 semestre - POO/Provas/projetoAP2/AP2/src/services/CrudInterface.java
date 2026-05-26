package services;

import java.util.ArrayList;

public interface CrudInterface<T> {

    void menu();
    void adicionar(ArrayList<T> list);
    void listar(ArrayList<T> list);
    void remover(ArrayList<T> list);
    void editar(ArrayList<T> list);

}
