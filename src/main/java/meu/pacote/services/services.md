# Services em Spring Boot

Em uma aplicação Spring Boot, a pasta `services` contém as **classes de serviço**.

## O que são classes de serviço?

As classes de serviço são responsáveis por lidar com a **lógica de negócios** da aplicação. Elas atuam como um intermediário entre os controladores e os repositórios.

- **Controladores**: Lidam com as solicitações do usuário.
- **Repositórios**: Interagem com o banco de dados.

quando um **controlador recebe uma solicitação** do usuário, ele **chama um método em uma classe de serviço**. **A classe de serviço usa uma classe de repositório para realizar a operação necessária no banco de dados**.
**O resultado é então retornado ao controlador**, que envia uma resposta ao usuário.
