package produtos;

public class BordaRecheada extends Adicional {

    public BordaRecheada(Produto produto) {
        super(produto);
    }

    @Override
    public String getNome() {
        return produto.getNome() + " + Borda Recheada";
    }

    @Override
    public double getPreco() {
        return produto.getPreco() + 8.0;
    }
}
