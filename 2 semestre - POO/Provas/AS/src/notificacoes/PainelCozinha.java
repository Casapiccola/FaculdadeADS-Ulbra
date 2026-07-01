package notificacoes;

import entities.Pedido;

public class PainelCozinha implements Observer {

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[PAINEL COZINHA] Pedido #" + pedido.getNumero()
                + " -> " + pedido.getStatus());
    }
}
