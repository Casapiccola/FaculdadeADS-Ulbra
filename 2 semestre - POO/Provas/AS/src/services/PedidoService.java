package services;

import entities.Cliente;
import entities.Pedido;
import entities.enums.TipoEntrega;
import notificacoes.PainelCozinha;
import pagamentos.Pagamento;
import pagamentos.PagamentoCartao;
import pagamentos.PagamentoDinheiro;
import pagamentos.PagamentoPix;
import produtos.Bacon;
import produtos.BordaRecheada;
import produtos.Produto;
import produtos.QueijoExtra;

import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ClienteService clienteService;
    private CardapioService cardapioService;

    private PainelCozinha painelCozinha = new PainelCozinha();

    public PedidoService(ClienteService clienteService, CardapioService cardapioService) {
        this.clienteService = clienteService;
        this.cardapioService = cardapioService;
    }

    public void menu() {
        System.out.println("\n--- MENU PEDIDOS ---");
        System.out.println("[1] Criar pedido");
        System.out.println("[2] Adicionar item ao pedido");
        System.out.println("[3] Remover item do pedido");
        System.out.println("[4] Escolher pagamento e entrega");
        System.out.println("[5] Aplicar desconto / promocao");
        System.out.println("[6] Avancar status do pedido");
        System.out.println("[7] Listar pedidos");
        System.out.println("[0] Voltar");
    }

    public void criarPedido() {
        Cliente cliente = clienteService.selecionar();
        if (cliente == null) {
            return;
        }
        Pedido pedido = new Pedido(pedidos.size() + 1, cliente);
        pedido.adicionarObservador(painelCozinha);
        pedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getNumero() + " criado para " + cliente.getNome() + ".");
    }

    public void adicionarItem() {
        Pedido pedido = selecionarPedido();
        if (pedido == null) {
            return;
        }
        Produto produto = cardapioService.selecionar();
        if (produto == null) {
            return;
        }
        produto = escolherAdicionais(produto);
        pedido.adicionarItem(produto);
        System.out.println("Item adicionado: " + produto.getNome() + " (R$ " + produto.getPreco() + ")");
    }

    private Produto escolherAdicionais(Produto produto) {
        int opcao;
        do {
            System.out.println("\nADICIONAIS:");
            System.out.println("[1] Borda Recheada (+R$ 8,00)");
            System.out.println("[2] Queijo Extra (+R$ 5,00)");
            System.out.println("[3] Bacon (+R$ 7,00)");
            System.out.println("[0] Finalizar item");
            opcao = Integer.parseInt(IO.readln("Escolha: "));
            switch (opcao) {
                case 1:
                    produto = new BordaRecheada(produto);
                    break;
                case 2:
                    produto = new QueijoExtra(produto);
                    break;
                case 3:
                    produto = new Bacon(produto);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);
        return produto;
    }

    public void removerItem() {
        Pedido pedido = selecionarPedido();
        if (pedido == null) {
            return;
        }
        if (pedido.getItens().isEmpty()) {
            System.out.println("Este pedido nao possui itens.");
            return;
        }
        for (int i = 0; i < pedido.getItens().size(); i++) {
            Produto p = pedido.getItens().get(i);
            System.out.println("[" + i + "] " + p.getNome() + " (R$ " + p.getPreco() + ")");
        }
        int i = Integer.parseInt(IO.readln("Indice do item para remover: "));
        try {
            pedido.removerItem(i);
            System.out.println("Item removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Indice invalido.");
        }
    }

    public void escolherPagamentoEntrega() {
        Pedido pedido = selecionarPedido();
        if (pedido == null) {
            return;
        }

        System.out.println("\nFORMA DE ENTREGA:");
        System.out.println("[1] Retirada no balcao");
        System.out.println("[2] Delivery (+R$ 8,00)");
        int e = Integer.parseInt(IO.readln("Escolha: "));
        if (e == 2) {
            pedido.setEntrega(TipoEntrega.DELIVERY);
        } else {
            pedido.setEntrega(TipoEntrega.RETIRADA);
        }

        System.out.println("\nFORMA DE PAGAMENTO:");
        System.out.println("[1] PIX");
        System.out.println("[2] Cartao");
        System.out.println("[3] Dinheiro");
        int p = Integer.parseInt(IO.readln("Escolha: "));
        Pagamento pagamento;
        if (p == 2) {
            pagamento = new PagamentoCartao();
        } else if (p == 3) {
            pagamento = new PagamentoDinheiro();
        } else {
            pagamento = new PagamentoPix();
        }
        pedido.setPagamento(pagamento);

        System.out.println("Forma de pagamento definida: " + pagamento.getDescricao());
        System.out.println("Total a pagar: R$ " + pedido.getTotal());
        pagamento.processar(pedido.getTotal());
    }

    public void aplicarDesconto() {
        Pedido pedido = selecionarPedido();
        if (pedido == null) {
            return;
        }
        double percentual = Double.parseDouble(IO.readln("Percentual de desconto (ex: 10): "));
        pedido.aplicarDesconto(percentual);
        System.out.println("Desconto aplicado. Novo total: R$ " + pedido.getTotal());
    }

    public void avancarStatus() {
        Pedido pedido = selecionarPedido();
        if (pedido == null) {
            return;
        }
        System.out.println(">>> Avancando status do pedido #" + pedido.getNumero() + " <<<");
        pedido.avancarStatus();
    }

    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido criado.");
            return;
        }
        System.out.println("\nPedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            for (Produto item : pedido.getItens()) {
                System.out.println("    - " + item.getNome() + " (R$ " + item.getPreco() + ")");
            }
        }
    }

    private Pedido selecionarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido criado.");
            return null;
        }
        for (Pedido pedido : pedidos) {
            System.out.println("[#" + pedido.getNumero() + "] " + pedido.getCliente().getNome()
                    + " | Status: " + pedido.getStatus() + " | Total: R$ " + pedido.getTotal());
        }
        int num = Integer.parseInt(IO.readln("Numero do pedido: "));
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == num) {
                return pedido;
            }
        }
        System.out.println("Pedido nao encontrado.");
        return null;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = Integer.parseInt(IO.readln("Escolha: "));
            switch (opcao) {
                case 1:
                    criarPedido();
                    break;
                case 2:
                    adicionarItem();
                    break;
                case 3:
                    removerItem();
                    break;
                case 4:
                    escolherPagamentoEntrega();
                    break;
                case 5:
                    aplicarDesconto();
                    break;
                case 6:
                    avancarStatus();
                    break;
                case 7:
                    listar();
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
