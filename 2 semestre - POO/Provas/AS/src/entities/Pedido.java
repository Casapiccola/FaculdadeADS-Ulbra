package entities;

import entities.enums.StatusPedido;
import entities.enums.TipoEntrega;
import notificacoes.Observer;
import pagamentos.Pagamento;
import produtos.Produto;

import java.util.ArrayList;

public class Pedido {

    private int numero;
    private Cliente cliente;
    private ArrayList<Produto> itens = new ArrayList<>();
    private ArrayList<Observer> observadores = new ArrayList<>();

    private StatusPedido status = StatusPedido.RECEBIDO;
    private TipoEntrega entrega = TipoEntrega.RETIRADA;
    private Pagamento pagamento;
    private double descontoPercentual = 0.0;

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        adicionarObservador(cliente);
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(int indice) {
        itens.remove(indice);
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public double getSubtotal() {
        double soma = 0.0;
        for (Produto p : itens) {
            soma = soma + p.getPreco();
        }
        return soma;
    }

    public double getTotal() {
        double total = getSubtotal();
        if (entrega == TipoEntrega.DELIVERY) {
            total = total + 8.0;
        }
        total = total - (total * descontoPercentual / 100.0);
        return total;
    }

    public void aplicarDesconto(double percentual) {
        this.descontoPercentual = percentual;
    }

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.atualizar(this);
        }
    }

    public void avancarStatus() {
        switch (status) {
            case RECEBIDO:
                status = StatusPedido.EM_PREPARO;
                break;
            case EM_PREPARO:
                status = StatusPedido.SAIU_PARA_ENTREGA;
                break;
            case SAIU_PARA_ENTREGA:
                status = StatusPedido.ENTREGUE;
                break;
            default:
                System.out.println("O pedido ja foi ENTREGUE. Nao ha proximo status.");
                return;
        }
        notificarObservadores();
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public TipoEntrega getEntrega() {
        return entrega;
    }

    public void setEntrega(TipoEntrega entrega) {
        this.entrega = entrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }

    @Override
    public String toString() {
        String formaPagamento;
        if (pagamento == null) {
            formaPagamento = "nao definida";
        } else {
            formaPagamento = pagamento.getDescricao();
        }
        return "Pedido #" + numero + " | Cliente: " + cliente.getNome()
                + " | Status: " + status + " | Entrega: " + entrega
                + " | Pagamento: " + formaPagamento + " | Total: R$ " + getTotal();
    }
}
