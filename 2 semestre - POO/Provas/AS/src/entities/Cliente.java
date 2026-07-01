package entities;

import notificacoes.Observer;

public class Cliente implements Observer {

    private String nome;
    private String telefone;
    private String endereco;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[SMS para " + nome + " (" + telefone + ")] Seu pedido #"
                + pedido.getNumero() + " agora esta: " + pedido.getStatus());
    }

    @Override
    public String toString() {
        return nome + " | Tel: " + telefone + " | Endereco: " + endereco;
    }
}
