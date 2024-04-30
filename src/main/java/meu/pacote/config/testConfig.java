package meu.pacote.config;


import lombok.SneakyThrows;
import meu.pacote.entities.Order;
import meu.pacote.entities.User;
import meu.pacote.entities.enums.OrderStatus;
import meu.pacote.repositories.OrderRepository;
import meu.pacote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.time.Instant;
import java.util.Arrays;

@Configuration // falar que é uma classe de configuração
@Profile("test") //especificar que é uma configuração para test
public class testConfig implements CommandLineRunner { // exeecutar quando o programa for iniciado

	@Autowired//injeção de dependencia do Spring boot
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	@SneakyThrows // ocultar exceções verificadas
	public void run(String... args) /*throws Exception*/ { // sem a anotação SneakyThrows

		var u1 = User.builder()
				.id(null)
				.nome("maria")
				.email( "maria@gmail.com")
				.senha( "123456")
				.telefone("988888888")
				.build();

		var u2 = User.builder()
				.id(null)
				.nome("Alex")
				.email( "alex@gmail.com")
				.senha( "123456")
				.telefone("988888888")
				.build();


		var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.ENTREGUE, u2);
		var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.AGUARDANDO_PAGAMENTO, u1);

		userRepository.saveAll(Arrays.asList(u1,u2)); //percorre a lista e coloca os usuarios no banco de dados
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

		//salvar os usuarios no banco de dados
	}
}
