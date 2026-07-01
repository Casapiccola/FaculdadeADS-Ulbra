package services;

import produtos.Produto;
import produtos.ProdutoBase;

import java.util.ArrayList;

public class CardapioService {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public CardapioService() {
        produtos.add(new ProdutoBase("Pizza Calabresa", 40.0));
        produtos.add(new ProdutoBase("Pizza Margherita", 38.0));
        produtos.add(new ProdutoBase("Hamburguer", 25.0));
        produtos.add(new ProdutoBase("Refrigerante", 7.0));
    }

    public void menu() {
        System.out.println("\n--- MENU CARDAPIO ---");
        System.out.println("[1] Cadastrar produto");
        System.out.println("[2] Listar produtos");
        System.out.println("[0] Voltar");
    }

    public void cadastrar() {
        String nome = IO.readln("Nome do produto: ");
        double preco = Double.parseDouble(IO.readln("Preco: "));
        produtos.add(new ProdutoBase(nome, preco));
        System.out.println("Produto adicionado ao cardapio!");
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Cardapio vazio.");
            return;
        }
        System.out.println("\nCardapio:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("[" + i + "] " + produtos.get(i));
        }
    }

    public Produto selecionar() {
        if (produtos.isEmpty()) {
            System.out.println("Cardapio vazio.");
            return null;
        }
        listar();
        int i = Integer.parseInt(IO.readln("Escolha o indice do produto: "));
        if (i < 0 || i >= produtos.size()) {
            System.out.println("Indice invalido.");
            return null;
        }
        return produtos.get(i);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = Integer.parseInt(IO.readln("Escolha: "));
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
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
