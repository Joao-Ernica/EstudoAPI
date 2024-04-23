package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // comentario base para o Spring para dizer que essa é a aplicação principal
public class SpringTest {
	public static void main(String[] args) {
		SpringApplication.run(SpringTest.class,args); // inicialização do Spring
	}

	@Bean
	public CommandLineRunner inicializacao(){ //É uma interface usada para indicar que um bean deve ser executado quando estiver contido dentro de uma SpringApplication
		return args -> {
			System.out.println("Hello World");

		};
	}
}
