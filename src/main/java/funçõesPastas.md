
## 1. Entities

As **entidades** são classes que representam as tabelas do banco de dados. Cada instância de uma entidade corresponde a uma linha na tabela.

## 2. Repositories

Os **repositórios** são **interfaces que fornecem métodos para operações de banco de dados**, como criar, ler, atualizar e excluir registros. **Eles trabalham diretamente com as entidades**.
_**interagir com o banco de dados em nome da entidade.**_

## 3. Services

As **classes de serviço** contêm a lógica de negócios da aplicação. Elas usam os repositórios para interagir com o banco de dados. **Os serviços atuam como um intermediário entre os controladores e os repositórios.**

## 4. Controllers (Resources)

Os **controladores** lidam com as solicitações do usuário. **Eles usam os `serviços` para processar essas solicitações e enviar uma resposta ao usuário**.

## 5. Config

A pasta `config` contém classes de configuração que definem beans e outras **configurações específicas da aplicação**, como configurações de banco de dados, segurança, etc.

## Fluxo de uma Solicitação

Aqui está um exemplo de como esses componentes interagem em uma aplicação Spring Boot:

* O usuário envia uma solicitação para a aplicação.
* O controlador recebe essa solicitação.
* O controlador usa a classe de serviço apropriada para processar a solicitação.
* A classe de serviço usa o repositório para interagir com o banco de dados.
* O repositório realiza a operação de banco de dados na entidade correspondente.
* O resultado é retornado ao serviço, que o processa conforme necessário.
* O serviço retorna o resultado ao controlador.
* O controlador envia a resposta ao usuário.
