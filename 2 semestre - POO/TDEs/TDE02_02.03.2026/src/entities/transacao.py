from dataclasses import dataclass
from src.entities.categoria import Categoria

@dataclass
class Transacao:
    descricao: str
    valor: float
    categoria: Categoria