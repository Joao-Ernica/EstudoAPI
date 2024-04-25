# Pasta Config

A pasta `config` contém arquivos de configuração que definem configurações para a aplicação.

## O que geralmente fica na pasta Config?

A pasta `config` pode conter:

1. **Arquivos de Configuração**: Como `application.properties` ou `application.yml` em uma aplicação Spring Boot. 
Estes arquivos podem conter configurações como a URL do banco de dados, nome de usuário, senha, configurações de hibernate, etc.

2. **Arquivos de Segurança**: Como certificados SSL, chaves privadas, etc.

3. **Arquivos de Configuração de Ambiente**: Você pode ter diferentes arquivos de configuração para diferentes ambientes (desenvolvimento, teste, produção, etc.)

**informações sensíveis, como senhas ou chaves de API, geralmente não devem ser armazenadas diretamente nesses arquivos de configuração**. 
Em vez disso, é uma prática comum referenciar variáveis de ambiente ou usar algum tipo de serviço de segredos.

