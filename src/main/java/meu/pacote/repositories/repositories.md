
## O # Repositórios

Repositórios são uma parte do padrão de design Repository Pattern. Eles ajudam a comunicar com o banco de dados de maneira abstrata.

## Por que usar Repositórios?

Para centralizar todas as consultas do banco de dados em um único local. Isso torna o código mais limpo e fácil de manter.

## O que fica na pasta de Repositórios?

1. **Interfaces de Repositório**: Definições de todas as operações que você pode realizar em uma entidade.
2. **Implementações de Repositório**: Código que realmente interage com o banco de dados.
3. **Classes de Especificação**: Usadas para encapsular consultas complexas.

## Exemplo em Java com Spring Data JPA

`JpaRepository<User, Long>` é um repositório para a entidade `User` com o ID do tipo `Long`. Você pode usar esta interface para realizar operações de banco de dados na tabela `User`.
