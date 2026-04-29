package entities;

import java.util.ArrayList;

public class Contato {

    private String nome;
    private String email;

    private ArrayList<Telefone> telefones = new ArrayList<>();

    public Contato() {}

    public Contato(String nome, String email, ArrayList<Telefone> telefones) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefones=" + telefones.toString() +
                '}';
    }
}
