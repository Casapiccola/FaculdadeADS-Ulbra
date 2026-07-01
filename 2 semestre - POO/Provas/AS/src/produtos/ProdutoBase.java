package produtos;

public class ProdutoBase implements Produto {

    private String nome;
    private double preco;

    public ProdutoBase(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + preco + ")";
    }
}
