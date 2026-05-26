package entities;

import java.util.ArrayList;

public class Livro {

    private String titulo;
    private Integer anoLancamento;
    private ArrayList<Genero> generos;

    public Livro() {
    }

    public Livro(String titulo, Integer AnoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = AnoLancamento;
    }

    public Livro(String titulo, Integer AnoLancamento, ArrayList<Genero> generos) {
        this.titulo = titulo;
        this.anoLancamento = AnoLancamento;
        this.generos = generos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getLancamento() {
        return anoLancamento;
    }

    public void setLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", lancamento=" + anoLancamento +
                ", generos=" + generos.toString() +
                '}';
    }
}
