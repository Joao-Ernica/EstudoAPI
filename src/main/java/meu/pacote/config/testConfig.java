package meu.pacote.config;


import lombok.SneakyThrows;

import meu.pacote.entities.*;
import meu.pacote.entities.enums.OrderStatus;
import meu.pacote.repositories.*;
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

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	@SneakyThrows // ocultar exceções verificadas
	public void run(String... args) /*throws Exception*/ { // sem a anotação SneakyThrows

		var cat1 = Category.builder()
				.id(null)
				.nome("Teste")
				.build();
		var cat2 = Category.builder()
				.id(null)
				.nome("Books")
				.build();
		var cat3 = Category.builder()
				.id(null)
				.nome("Computers")
				.build();


		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2); //dentro das categorias do produto p1 esta a categoria cat2
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		var u1 = User.builder()
				.id(null)
				.nome("maria")
				.email("maria@gmail.com")
				.senha("123456")
				.telefone("988888888")
				.build();

		var u2 = User.builder()
				.id(null)
				.nome("Alex")
				.email("alex@gmail.com")
				.senha("123456")
				.telefone("988888888")
				.build();
		
		var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.ENTREGUE, u2);
		var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u1);

		userRepository.saveAll(Arrays.asList(u1, u2)); //percorre a lista e coloca os usuarios no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		var oi1 = OrderItem //o OrderItem 1 é do pedido 1, do produto 2 com o preço do produto 1
				.builder()
				.order(o2)
				.product(p3)
				.quantity(2)
				.price(p3.getValor())
				.build();
		var oi2 = OrderItem
				.builder()
				.order(o1)
				.product(p3)
				.quantity(1)
				.price(p3.getValor())
				.build();
		var oi3 = OrderItem
				.builder()
				.order(o3)
				.product(p5)
				.quantity(2)
				.price(p5.getValor())
				.build();
		var oi4 = OrderItem
				.builder()
				.order(o1)
				.product(p1)
				.quantity(2)
				.price(p1.getValor())
				.build();

//		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getValor());
//		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getValor()); //o OrderItem 1 é do pedido 1, do produto 2 com o preço do produto 1

		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

		var pay1 = Payment
				.builder()
				.id(null)
				.moment(Instant.parse("2019-06-20T21:53:07Z"))
				.order(o1)
				.build();
		o1.setPayment(pay1);

		orderRepository.save(o1); //save é para apenas um item, saveAll geralmente usado em lista

		//salvar os usuarios no banco de dados
	}
}
