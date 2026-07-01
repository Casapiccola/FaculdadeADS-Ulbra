package produtos;

public class QueijoExtra extends Adicional {

    public QueijoExtra(Produto produto) {
        super(produto);
    }

    @Override
    public String getNome() {
        return produto.getNome() + " + Queijo Extra";
    }

    @Override
    public double getPreco() {
        return produto.getPreco() + 5.0;
    }
}
