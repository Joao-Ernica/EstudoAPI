package meu.pacote.services;

import meu.pacote.entities.Order;
import meu.pacote.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	@Autowired // cria automaticamente uma instancia
	private OrderRepository repository; //dependencia

	public List<Order> findALL() { //serviço repassando um repositório para o controlador
		return repository.findAll(); //metodo para mostrar todos os usuarios
	}

	public Order findById(Long id) { //recuperar um usuario pelo ID
		Optional<Order> obj = repository.findById(id); //Optional, ela pode conter um valor presente (ou seja, o objeto que você está buscando) ou um valor ausente (que é representado por null
		return obj.get();
	}
}


