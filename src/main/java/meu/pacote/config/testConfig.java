package meu.pacote.config;

import meu.pacote.entities.User;
import meu.pacote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // falar que é uma classe de configuração
@Profile("test") //especificar que é uma configuração para test
public class testConfig implements CommandLineRunner { // exeecutar quando o programa for iniciado

	@Autowired//injeção de dependencia do Spring boot
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); //ID null porque sera gerado pelo banco de dados
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1,u2)); //percorre a lista e coloca os usuarios no banco de dados

		//salvar os usuarios no banco de dados
	}
}
