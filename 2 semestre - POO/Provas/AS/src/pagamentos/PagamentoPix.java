package pagamentos;

public class PagamentoPix implements Pagamento {

    @Override
    public void processar(double valor) {
        System.out.println("Pagamento via PIX no valor de R$ " + valor);
        System.out.println("QR Code gerado... Pagamento aprovado na hora!");
    }

    @Override
    public String getDescricao() {
        return "PIX";
    }
}
