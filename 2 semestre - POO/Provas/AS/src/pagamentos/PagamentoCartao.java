package pagamentos;

public class PagamentoCartao implements Pagamento {

    @Override
    public void processar(double valor) {
        System.out.println("Pagamento via CARTAO no valor de R$ " + valor);
        System.out.println("Aproxime ou insira o cartao... Transacao autorizada!");
    }

    @Override
    public String getDescricao() {
        return "Cartao";
    }
}
