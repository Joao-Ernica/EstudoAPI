
`@component` registra a classe como componente do Spring

`@repositor`e`@service` registros especializados

ex:
```
@Service
public class UserService {
```

## lombok

<https://mmarcosab.medium.com/usando-anota%C3%A7%C3%B5es-do-lombok-em-java-com-springboot-ecbec69234a9>

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