package models.entities;

public class Cliente {
    public String nome;
    public String cpf;
    public Float saldo;

    public Cliente() {}

    public Cliente(String nome, String cpf, Float saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
