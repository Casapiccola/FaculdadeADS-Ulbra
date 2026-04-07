package models.entities;

public class Cliente {

    private String nome;
    private String cpf;
    private Double saldo;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Dados cliente: "
                + nome
                + " | "
                + cpf
                + " | "
                + String.format("%.2f", saldo);
    }
}
