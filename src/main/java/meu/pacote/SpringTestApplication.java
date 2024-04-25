package meu.pacote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // comentario base para o Spring para dizer que essa é a aplicação principal
public class SpringTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class,args); // inicialização do Spring
	}
}
