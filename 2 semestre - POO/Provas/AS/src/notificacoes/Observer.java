package notificacoes;

import entities.Pedido;

public interface Observer {

    void atualizar(Pedido pedido);
}
