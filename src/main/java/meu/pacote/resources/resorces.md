## Diferença entre os resorces

### Recursos da Aplicação

No contexto de uma **aplicação Java Spring**, a pasta `resources` é um **local comum para armazenar arquivos que são usados pela aplicação**, mas que não são código-fonte.
Isso pode incluir arquivos de configuração **(como `application.properties` ou `application.yml`), arquivos HTML, arquivos CSS, arquivos JavaScript, imagens, etc.**

### Recursos RESTful

No contexto de uma **API RESTful**, um "recurso" é **qualquer objeto que a API possa retornar**. Por exemplo, se você tiver uma API para um blog, você pode ter recursos para `Post`, `Comment`, `User`, etc.
**Cada um desses recursos teria seu próprio controlador** (por exemplo, `PostController`, `CommentController`, `UserController`), que seria responsável por lidar com todas as solicitações HTTP relacionadas a esse recurso.


## O que são Recursos?

Em uma aplicação web, um **Recurso** é uma entidade que pode ser acessada através de uma URL. Pode ser qualquer coisa - uma página da web, uma imagem, um arquivo de vídeo, um registro de banco de dados, etc.

## Por que usar Recursos?

Recursos são a base da arquitetura RESTful (Representational State Transfer). Eles permitem que a aplicação web seja escalável e fácil de manter.

## O que geralmente fica na pasta de Recursos?

A pasta de Recursos geralmente contém:

1. **Controladores de Recursos**: São classes que lidam com as solicitações HTTP para um recurso específico. 
**Eles podem ter métodos para lidar com operações CRUD (Criar, Ler, Atualizar, Deletar).**

2. **Arquivos de Recursos**: São arquivos estáticos (como imagens, CSS, JavaScript) que são servidos diretamente ao cliente.

## Exemplo em Java com Spring MVC

Em Java, especialmente ao usar o Spring MVC, você pode ver algo como `@RestController`. Aqui está o que significa:

- `@RestController`: Esta é uma anotação que indica que a classe é um controlador de recurso. 
Ela pode ter métodos para lidar com diferentes solicitações HTTP, como GET, POST, PUT, DELETE, etc.

Portanto, `@RestController` é usado para criar um controlador de recurso que pode lidar com solicitações HTTP para um recurso específico.
