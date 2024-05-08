# Tratamento de Exceções no Spring

## @ControllerAdvice

A anotação `@ControllerAdvice` é uma especialização da anotação `@Component` do Spring,
que permite o tratamento de exceções em toda a aplicação em um único componente de tratamento global. 
Pode ser vista como um interceptador de exceções lançadas por métodos anotados com `@RequestMapping` e similares.

## services.exceptions.ResourceNotFoundException

**Esta classe é usada para sinalizar que um recurso solicitado não foi encontrado.** Por exemplo,
se você estiver tentando buscar um registro no banco de dados usando um ID e esse ID não existir,
você pode lançar uma `ResourceNotFoundException`.

## resources.exceptions.StandardError

**Esta é uma classe de erro genérica a partir da qual outros tipos de erros são geralmente derivados.** 
Ela serve como a classe base para a maioria das exceções. Quando você cria suas próprias classes de exceção personalizadas,
geralmente é uma boa prática fazê-las herdar de `StandardError` ou uma de suas subclasses.

## resources.exceptions.ResourceExceptionHandler

**Esta classe é responsável por lidar com as exceções lançadas em sua aplicação**.
Ela usa as anotações `@ControllerAdvice` e `@ExceptionHandler` para capturar exceções lançadas em qualquer lugar da aplicação e fornecer uma resposta de erro apropriada.
Por exemplo, se uma `ResourceNotFoundException` for lançada, o `ResourceExceptionHandler` pode capturá-la e retornar uma resposta HTTP 404 com uma mensagem de erro personalizada.
