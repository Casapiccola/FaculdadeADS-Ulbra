package services;

import entities.Pedido;
import entities.enums.StatusPedido;
import produtos.Produto;

public class RelatorioService {

    private PedidoService pedidoService;
    private CardapioService cardapioService;

    public RelatorioService(PedidoService pedidoService, CardapioService cardapioService) {
        this.pedidoService = pedidoService;
        this.cardapioService = cardapioService;
    }

    public void menu() {
        System.out.println("\n--- MENU RELATORIOS ---");
        System.out.println("[1] Relatorio geral de pedidos");
        System.out.println("[2] Relatorio de faturamento");
        System.out.println("[3] Relatorio por status");
        System.out.println("[4] Relatorio do cardapio");
        System.out.println("[0] Voltar");
    }

    public void relatorioPedidos() {
        System.out.println("\n===== RELATORIO GERAL DE PEDIDOS =====");
        if (pedidoService.getPedidos().isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }
        for (Pedido pedido : pedidoService.getPedidos()) {
            System.out.println(pedido);
            for (Produto item : pedido.getItens()) {
                System.out.println("    - " + item.getNome() + " (R$ " + item.getPreco() + ")");
            }
        }
    }

    public void relatorioFaturamento() {
        System.out.println("\n===== RELATORIO DE FATURAMENTO =====");
        double total = 0.0;
        for (Pedido pedido : pedidoService.getPedidos()) {
            total = total + pedido.getTotal();
        }
        System.out.println("Total de pedidos: " + pedidoService.getPedidos().size());
        System.out.println("Faturamento total: R$ " + total);
    }

    public void relatorioPorStatus() {
        System.out.println("\n===== RELATORIO POR STATUS =====");
        for (StatusPedido status : StatusPedido.values()) {
            int quantidade = 0;
            for (Pedido pedido : pedidoService.getPedidos()) {
                if (pedido.getStatus() == status) {
                    quantidade++;
                }
            }
            System.out.println(status + ": " + quantidade + " pedido(s)");
        }
    }

    public void relatorioCardapio() {
        System.out.println("\n===== RELATORIO DO CARDAPIO =====");
        for (Produto produto : cardapioService.getProdutos()) {
            System.out.println("- " + produto.getNome() + " (R$ " + produto.getPreco() + ")");
        }
    }

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = Integer.parseInt(IO.readln("Escolha: "));
            switch (opcao) {
                case 1:
                    relatorioPedidos();
                    break;
                case 2:
                    relatorioFaturamento();
                    break;
                case 3:
                    relatorioPorStatus();
                    break;
                case 4:
                    relatorioCardapio();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);
    }
}
