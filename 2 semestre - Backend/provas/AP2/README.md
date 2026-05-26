# API de Funcionários

## Tema

Esta API permite gerenciar funcionários.

## Tecnologias utilizadas

- C#
- ASP.NET Core Minimal API
- Entity Framework Core
- SQLite

## Endpoints

| Método | Rota                       | Descrição                   |
| ------ | -------------------------- | --------------------------- |
| GET    | `/`                        | Mensagem inicial            |
| GET    | `/status`                  | Status da API               |
| GET    | `/funcionarios`            | Lista todos os funcionários |
| GET    | `/funcionarios/{id}`       | Busca funcionário por ID    |
| POST   | `/funcionarios`            | Cadastra funcionário        |
| PUT    | `/funcionarios/{id}`       | Atualiza funcionário        |
| DELETE | `/funcionarios/{id}`       | Remove funcionário          |

## Como executar

```bash
dotnet run

---

## Exemplo de JSON

```json
{
  "nome": "Erik Silva",
  "cargo": "Desenvolvedor Backend",
  "salario": 5500,
  "ativo": true,
  "dataAdmissao": "2026-05-19T10:00:00"
}
```

## Vídeo explicativo

Link do vídeo: https://drive.google.com/file/d/1-2LgWyuPXnbzTz9Mk0PKaUMda6kYATNM/view?usp=sharing