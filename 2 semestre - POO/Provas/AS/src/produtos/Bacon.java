package produtos;

public class Bacon extends Adicional {

    public Bacon(Produto produto) {
        super(produto);
    }

    @Override
    public String getNome() {
        return produto.getNome() + " + Bacon";
    }

    @Override
    public double getPreco() {
        return produto.getPreco() + 7.0;
    }
}
