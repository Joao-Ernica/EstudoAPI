# Jakarta Persistence API (novo nome do JPA)

A linha `import jakarta.persistence.Entity;` é usada para importar a anotação `@Entity` da Jakarta Persistence API.

A anotação `@Entity` é usada para declarar que uma classe é uma entidade. Uma entidade é um objeto de domínio de persistência leve.
Normalmente, uma entidade representa uma tabela em um banco de dados relacional, e cada instância de uma entidade corresponde a uma linha nessa tabela.

### Uma Entity é uma classe mapeada para uma tabela do banco de dados
#### Quando se cria uma entidade por padrão se cria uma tabela com o mesmo nome no banco de dados 
É possivel mudar o nome da tabela com: ```@Table(name = "novo_nome")```

#### A classe de entidade deve seguir alguns requisitos:
* A classe deve ser anotada com a anotação `jakarta.persistence.Entity`.
* A classe deve ter um construtor público ou protegido sem parâmetros.
* A classe não deve ser declarada final.
* Nenhum método ou variável de instância persistente deve ser declarado final.
* Se uma instância de entidade for passada por valor como um objeto desanexado, como através da interface de negócios remota de um bean de sessão,
a classe deve implementar a interface Serializable.

#### Os campos ou propriedades persistentes devem ser dos seguintes tipos de linguagem Java:
1. Tipos primitivos Java
2. java.lang.String
3. Outros tipos serializáveis, incluindo:
    - Wrappers de tipos primitivos Java
    - java.math.BigInteger
    - java.math.BigDecimal
    - java.util.Date
    - java.util.Calendar
    - java.sql.Date
    - java.sql.Time
    - java.sql.TimeStamp
    - Tipos enumerados
    - Outras entidades e/ou coleções de entidades
    - Classes incorporáveis

## Outras dicas:

```@GeneratedValue(strategy = GenerationType.IDENTITY)``` cria um numero sequencial para a tabela do banco de dados


