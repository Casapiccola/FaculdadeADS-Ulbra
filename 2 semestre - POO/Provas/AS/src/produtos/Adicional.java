package produtos;

public abstract class Adicional implements Produto {

    protected Produto produto;

    public Adicional(Produto produto) {
        this.produto = produto;
    }
}
