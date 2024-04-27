package meu.pacote.services;

import meu.pacote.entities.User;
import meu.pacote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired // cria automaticamente uma instancia
	private UserRepository repository; //dependencia

	public List<User> findALL() { //serviço repassando um repositório para o controlador
		return repository.findAll(); //metodo para mostrar todos os usuarios
	}

	public User finById(Long id) { //recuperar um usuario pelo ID

		Optional<User> obj = repository.findById(id); //Optional, ela pode conter um valor presente (ou seja, o objeto que você está buscando) ou um valor ausente (que é representado por null
		return obj.get();
	}
}


