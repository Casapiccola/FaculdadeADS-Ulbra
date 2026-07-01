package pagamentos;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public void processar(double valor) {
        System.out.println("Pagamento em DINHEIRO no valor de R$ " + valor);
        System.out.println("Tenha o valor em maos na entrega. Lembre de combinar o troco!");
    }

    @Override
    public String getDescricao() {
        return "Dinheiro";
    }
}
