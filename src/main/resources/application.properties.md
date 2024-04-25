# Configurações do Spring Boot

## Console H2

`spring.h2.console.enabled=true` habilita o console H2, permitindo que você acesse e interaja com o banco de dados H2 através de uma interface web.

`spring.h2.console.path=/h2-console` define o caminho para o console H2. Você pode acessar o console H2 em `http://localhost:8080/h2-console` se estiver rodando localmente.

## Spring JPA

`spring.jpa.properties.hibernate.show-sql=true` faz o Spring JPA exibir as consultas SQL no console.

`spring.jpa.hibernate.ddl-auto=update` permite que o Hibernate crie, atualize ou exclua automaticamente as tabelas do banco de dados de acordo com os objetos de entidade.

`spring.jpa.properties.hibernate.format_sql=true` formata as consultas SQL exibidas para facilitar a leitura.
