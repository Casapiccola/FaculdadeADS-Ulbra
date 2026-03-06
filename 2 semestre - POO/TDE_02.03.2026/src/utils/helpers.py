from src.entities.categoria import Categoria
from src.entities.transacao import Transacao

lista_categorias = []
lista_transacoes = []

def cadastrar_categorias(nome):
    categoria = Categoria(nome=nome)
    lista_categorias.append(categoria)
    return categoria

def cadastrar_transacoes(descricao, valor, categoria):
    lista_transacoes.append(Transacao(descricao=descricao, valor=valor, categoria=categoria))

def saldo_total():
    total = 0
    for t in lista_transacoes:
        total += t.valor
    return total