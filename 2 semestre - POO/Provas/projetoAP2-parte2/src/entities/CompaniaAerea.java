package entities;

import java.util.ArrayList;

public class CompaniaAerea {

    private String nome;
    private String descricao;

    private ArrayList<Aviao> avioes = new ArrayList<>();

    public CompaniaAerea() {}

    public CompaniaAerea(String nome, String descricao, ArrayList<Aviao> avioes) {
        this.nome = nome;
        this.descricao = descricao;
        this.avioes = avioes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Aviao> getAvioes() {
        return avioes;
    }

    public void setAvioes(ArrayList<Aviao> avioes) {
        this.avioes = avioes;
    }

    @Override
    public String toString() {
        return "CompaniaAerea{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", avioes=" + avioes.toString() +
                '}';
    }
}
