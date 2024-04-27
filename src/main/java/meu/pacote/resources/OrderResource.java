package meu.pacote.resources;

import meu.pacote.entities.Order;
import meu.pacote.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
// Significa que essa classe vai ser responsável por pegar as informações que vêm de uma solicitação da web
@RequestMapping(value = "/Orders")
// nome da solicitaçao do web, quando for chamada essa solicitaçao vai vir para essa classe
public class OrderResource {

	@Autowired
	private OrderService OrderService;

	@GetMapping // sempre que alguém acessa o URL “/usuarios” ira usar o "getUsuarios"
	public ResponseEntity<List<Order>> findALL() { //ResponseEntity<Order> é um tipo especial do Spring que permite retornar dados junto com informações de status HTTP
		// <Order> uma classe que representa um usuário em seu sistema
		List<Order> list = OrderService.findALL();
		return ResponseEntity.ok().body(list); //  ResponseEntity.ok() retorna com sucesso a resposta, .body(u) retorna o corpo da resposta o usuario u
	}

	@GetMapping(value = "/{id}")// quando colocar /Orders/1 colocara a pessoa com id 1
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		try {
			Order obj = OrderService.findById(id);
			return ResponseEntity.ok().body(obj);
		} catch (NoSuchElementException e) {
			return
					null;

		}
	}

}
