package application;

import services.CardapioService;
import services.ClienteService;
import services.PedidoService;
import services.RelatorioService;

public class Program {

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        CardapioService cardapioService = new CardapioService();
        PedidoService pedidoService = new PedidoService(clienteService, cardapioService);
        RelatorioService relatorioService = new RelatorioService(pedidoService, cardapioService);

        int opcao;
        do {
            System.out.println("\n===== PLATAFORMA DE PEDIDOS - RESTAURANTE =====");
            System.out.println("[1] Clientes");
            System.out.println("[2] Cardapio");
            System.out.println("[3] Pedidos");
            System.out.println("[4] Relatorios");
            System.out.println("[0] Sair");
            opcao = Integer.parseInt(IO.readln("Escolha uma opcao: "));
            switch (opcao) {
                case 1:
                    clienteService.executar();
                    break;
                case 2:
                    cardapioService.executar();
                    break;
                case 3:
                    pedidoService.executar();
                    break;
                case 4:
                    relatorioService.executar();
                    break;
                case 0:
                    System.out.println("Encerrando... Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);
    }
}
