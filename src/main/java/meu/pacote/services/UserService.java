package meu.pacote.services;

import meu.pacote.entities.User;
import meu.pacote.repositories.UserRepository;
import meu.pacote.services.exceptions.ResourceNotFoundException;
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

	public User findById(Long id) { //recuperar um usuario pelo ID
		Optional<User> obj = repository.findById(id); //Optional, ela pode conter um valor presente (ou seja, o objeto que você está buscando) ou um valor ausente (que é representado por null
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // se nao puder lançar o get ira lançar uma excepetions
	}

	public User insert(User obj) { //metodo basico para inserir no banco de dados um novo User
		return repository.save(obj);
	}

	public void delete(Long id) {
			repository.deleteById(id); //tras o objeto do banco de dados
	}

	public User update(long id, User obj){ //obter os dados que serão atualizados
		User entity = repository.getReferenceById(id); //prepara o objeto e depois efetuar uma operação com o bando de dados
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) { //atualiza os dados da entity com os novos dados fornecidos pelo obj
		entity.setNome(obj.getNome()); //atualizar o nome do obj
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}


