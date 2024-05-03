
`@component` registra a classe como componente do Spring

`@repositor`e`@service` registros especializados

ex:
```
@Service
public class UserService {
```

## lombok

<https://mmarcosab.medium.com/usando-anota%C3%A7%C3%B5es-do-lombok-em-java-com-springboot-ecbec69234a9>

### Anotações

`@Getter e @Setter`: Essas anotações são usadas para gerar automaticamente os métodos getter e setter para os campos de uma classe.

`@Data:` Combina @ToString, @EqualsAndHashCode, @Getter, @Setter e @RequiredArgsConstructor em uma única anotação.

`@NoArgsConstructor`, @RequiredArgsConstructor e @AllArgsConstructor: Essas anotações são usadas para gerar construtores sem argumentos, com argumentos obrigatórios e com todos os argumentos, respectivamente.

`@Builder:` Esta anotação é usada para implementar o padrão Builder para a construção de objetos.

`@SneakyThrows:` Esta anotação permite que você ignore a verificação de exceções do compilador Java.

`@Slf4j:` Esta anotação é usada para fornecer um log de aplicativo SLF4J.

`@Cleanup:` Esta anotação é usada para garantir que um recurso seja fechado após o uso para evitar vazamentos de memória.

`@Delegate:` Esta anotação pode ser usada para delegar a implementação de uma interface ou classe para outro campo ou método.

`@Value:` Esta anotação é a versão imutável de @Data; tudo que é gerado é private e final.

`@With:` Esta anotação é usada para gerar métodos “with” (métodos que criam uma nova instância com algumas propriedades alteradas) para campos não finais.

## Project created
**Checklist:**
*  Spring Initializr
* o Maven
* o Java 17
* o Packing JAR
* o Dependencies: Spring Web

## User entity and resource
**Basic entity checklist:**
*  Basic attributes
*  Associations (instantiate collections)
*  Constructors
*  Getters & Setters (collections: only get)
*  hashCode & equals
*  Serializable

## H2 database, test profile, JPA
**Checklist:**
*  JPA & H2 dependencies
*  application.properties
*  application-test.properties
*  Entity: JPA mapping

  ## JPA repository, dependency injection, database seeding
  **Checklist:**
*    UserRepository extends JPARepository<User, Long>
*    Configuration class for "test" profile
*    @Autowired UserRepository
*    Instantiate objects in memory
*    Persist objects 