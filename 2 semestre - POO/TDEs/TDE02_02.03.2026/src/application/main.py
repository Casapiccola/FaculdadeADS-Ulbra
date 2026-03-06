from src.utils.helpers import cadastrar_categorias, cadastrar_transacoes, saldo_total

categoria_lazer = cadastrar_categorias("Cinema")
categoria_contas = cadastrar_categorias("Conta de luz")
categoria_investimentos = cadastrar_categorias("Bolsa de valores")
categoria_entradas = cadastrar_categorias("Salario")

cadastrar_transacoes(
    descricao="Investimento na Americanas",
    valor=-400.0,
    categoria=categoria_investimentos
)
cadastrar_transacoes(
    descricao="Filme de terror",
    valor=-75.0,
    categoria=categoria_lazer
)
cadastrar_transacoes(
    descricao="Salario do mês",
    valor=2000.0,
    categoria=categoria_entradas
)
cadastrar_transacoes(
    descricao="Conta fixa de luz",
    valor=-120,
    categoria=categoria_contas
)

print(f"Saldo total: ", saldo_total())