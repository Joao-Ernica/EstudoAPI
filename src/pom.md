# Configurar pom.xml

## Configurar Java

**Codigo:**

```
<properties> 
    <!--Define propriedades do projeto-->
    <maven.compiler.source>"18</maven.compiler.source> <!-- Define a versão do Java usada para compilar o código-fonte -->
    <maven.compiler.target>"18</maven.compiler.target>
    <java.version>18</java.version>
     <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> <!-- Define a codificação de caracteres usada para ler e gravar arquivos de origem -->
    </properties>
```

 ### Verificar a versão mais recente

```
java -version
```

## configurar para Spring Boot

**_O Spring Boot já está integrado ao IntelliJ IDEA_**

```<parent> </parent>``` e colocar dentro a seguinte configuração:
<https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent>

que fornece configurações padrão para projetos Spring Boot.

## `<dependencies> </dependencies> `

**Colocar os `<dependency> </dependency>` Dentro** 

*Para Spring e JPA*
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <!-- Dependência do Spring Boot Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Dependência do Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

```

### Integração com H2

**Codigo:** 

```
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

Para verificar a *versão mais recente:* <https://h2database.com/html/download.html>

## Para verificar se esta funcinando <http://localhost:8080/h2-console> 

## Significado dos termos

  O `pom.xml` é uma representação declarativa do seu projeto

1. **`<groupId>`**: Identifica a organização ou grupo proprietário do projeto.
2. **`<artifactId>`**: Nome único para o próprio projeto.
3. **`<version>`**: Versão do projeto.
4. **`<packaging>`**: Tipo de empacotamento (JAR, WAR, POM).
5. **`<dependencies>`**: Lista de bibliotecas externas necessárias.
6. **`<parent>`**: Herda configurações de outro projeto.
7. **`<dependencyManagement>`**: Define versões padrão das dependências.
8. **`<modules>`**: Lista de módulos em projetos multi-módulo.
9. **`<properties>`**: Propriedades do projeto.
10. **`<build>`**: Configurações de construção (plugins, diretórios).
11. **`<reporting>`**: Configurações para relatórios gerados.
12. **`<name>`, `<description>`, `<url>`**: Informações adicionais sobre o projeto.

